package ro.ubbcluj.cs.ams.auth.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.codec.binary.Base64;
import org.cryptonode.jncryptor.AES256JNCryptor;
import org.cryptonode.jncryptor.CryptorException;
import org.cryptonode.jncryptor.JNCryptor;
import org.jooq.Record;
import org.jooq.tools.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.ModelAndView;
import ro.ubbcluj.cs.ams.auth.config.AuthConfiguration;
import ro.ubbcluj.cs.ams.auth.dto.*;
import ro.ubbcluj.cs.ams.auth.service.Service;
import ro.ubbcluj.cs.ams.auth.service.UserDetailsServiceImpl;
import ro.ubbcluj.cs.ams.auth.service.exception.AuthExceptionType;
import ro.ubbcluj.cs.ams.auth.service.exception.AuthServiceException;
import ro.ubbcluj.cs.ams.auth.service.exception.ErrorResponse;
import ro.ubbcluj.cs.ams.auth.service.exception.ReviewExceptionType;
import ro.ubbcluj.cs.ams.auth.utils.EncryptionUtils;
import ro.ubbcluj.cs.ams.auth.utils.RSAUtils;

import javax.validation.Valid;
import java.nio.charset.StandardCharsets;
import java.security.Principal;
import java.security.PrivateKey;
import java.util.List;

@RestController
public class AuthController {

    @Autowired
    Service service;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthConfiguration authProps;

    @Autowired
    private WebClient.Builder webClientBuilder;

    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    @GetMapping("/current")
    public Principal getUser(Principal principal) {
        return principal;
    }


    @RequestMapping(value = "/login",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            params = {"username", "password"}
    )
    public ResponseEntity<OAuth2AccessToken> login(@Valid UserDto userDto, BindingResult result) {

        logger.info("---------------- LOAD BY USERNAME CONTROLLER --------------------");
        UserDetails userDetails = userDetailsService.loadUserByUsername(userDto.getUsername());
        String role = userDetailsService.findRoleByUsername(userDetails);
        logger.info("==========ROLE========", role);


        if (role.equals("STUDENT")) {
            //========================PUBLIC KEY FOR MOBILE USERS========================

            if(userDto.getMessage() != null && userDto.getKeyphrase()!=null) {

                JNCryptor cryptor = new AES256JNCryptor();
                String password = userDto.getKeyphrase();

                //CHECK IF THERE EXISTS A KEYPHRASE FOR A GIVEN USER
                Integer exists = service.existsUserKeyphraseForGivenUser(userDto.getUsername());

                if(exists != 0) {
                    //USER HAS LOGGED IN BEFORE
                    //CHECK IF HE HASN'T CHANGED HIS DEVICE BY DECRYPTING MESSAGE RECEIVED WITH
                    //KEYPHRASE FROM DB. IF
                    logger.info("====USER====", userDto.getUsername(), "====HAS PREVIOUSLY LOGGED IN FROM A MOBILE DEVICE====");
                    UserKeyphraseResponse userKeyphraseResponse = service.getUserKeyphrase(userDto.getUsername());

                    logger.info(userKeyphraseResponse.getMessage(), userKeyphraseResponse.getKeyphrase());

                    try {
                        byte[] ciphertext = cryptor.decryptData(Base64.decodeBase64(userDto.getMessage()), password.toCharArray());
                        byte[] keyPhraseFromDb = cryptor.decryptData(Base64.decodeBase64(userKeyphraseResponse.getMessage()), password.toCharArray());
                        logger.info("=========== DECRYPTED MESSAGE LOOK LIKE THIS ===========");
                        String decryptedValue = new String(ciphertext, StandardCharsets.UTF_8);
                        String initialKeyphraseForUser = new String(keyPhraseFromDb, StandardCharsets.UTF_8);

                        logger.info(decryptedValue);

                        if(decryptedValue.equals(initialKeyphraseForUser)){
                            logger.info("THE 2 VALUES MATCH EACH OTHER! YOU CAN NOW RECEIVE A TOKEN!");
                        }

                        else{
                            logger.info("THE 2 VALUES DON'T MATCH EACHOTHER! YOU TRIED TO LOGIN FROM ANOTHER DEVICE BEFORE");
                            throw new AuthServiceException("You previously logged from a different device!", AuthExceptionType.PREVIOUSLY_LOGGED_FROM_ANOTHER_DEVICE, HttpStatus.UNAUTHORIZED);
                        }
                    } catch (CryptorException e) {
                        throw new AuthServiceException("You previously logged from a different device!", AuthExceptionType.PREVIOUSLY_LOGGED_FROM_ANOTHER_DEVICE, HttpStatus.UNAUTHORIZED);
                    }
                }
                else{
                    //USER LOGS IN FOR THE FIRST TIME
                    //CHECK IF HE/SHE TRIES TO LOG IN FROM A COLLEAGUE'S PHONE (IF THE PUBLIC KEY/KEYPHRASE HE IS USING ALREADY EXISTS)
                    //TODO: ADD MESSSAGE AND KEYPHRASE
                    Integer existsKeyphrase = service.checkIfKeyphraseIsAlreadyUsed(userDto.getKeyphrase());
                    if(existsKeyphrase == 0) {
                        logger.info("====USER====", userDto.getUsername(), "====HAS NEVER LOGGED IN FROM A MOBILE DEVICE====");
                        Integer added = service.saveUserKeyphrase(userDto);
                        logger.info("======New user keyphrase record added", added);
                    }
                    else{
                        throw new AuthServiceException("You are trying to login from a colleague's phone!", AuthExceptionType.LOGIN_NOT_ALLOWED_FROM_COLLEAGUES_DEVICE, HttpStatus.UNAUTHORIZED);
                    }
                }

            }
            else{
                throw new AuthServiceException("A student can only login from a mobile device!", AuthExceptionType.LOGIN_ONLY_FROM_MOBILE_DEVICE_FOR_STUDENT, HttpStatus.UNAUTHORIZED);
            }
            //============================================================================
        }

        logger.info("==========login==========");
        logger.info("===========username: {}==========", userDto.getUsername());
        logger.info("===========password: {}==========", userDto.getPassword());

        if (result.hasErrors()) {
            logger.error("==========login failed==========");
            logger.error("Unexpected data!");
            throw new AuthServiceException("Invalid credentials!", AuthExceptionType.INVALID_CREDENTIALS, HttpStatus.UNAUTHORIZED);
        }


        MultiValueMap<String, String> bodyParams = new LinkedMultiValueMap<>();
        bodyParams.add("grant_type", "password");
        bodyParams.add("username", userDto.getUsername());
        bodyParams.add("password", userDto.getPassword());

        String auth = authProps.getUser() + ":" + authProps.getPass();
        byte[] encodedAuth = Base64.encodeBase64(
                auth.getBytes());
        String authHeader = "Basic " + new String(encodedAuth);

        try {
            OAuth2AccessToken accessToken = webClientBuilder
                    .build()
                    .post()
                    .uri("http://authentication-server/authentication/oauth/token")
                    .header("Authorization", authHeader)
                    .body(BodyInserters.fromValue(bodyParams))
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(OAuth2AccessToken.class)
                    .block();
            logger.info("==========login successful==========");
            return new ResponseEntity<>(accessToken, HttpStatus.OK);
        }
        catch(Exception e){
            throw new AuthServiceException("Invalid credentials!", AuthExceptionType.INVALID_CREDENTIALS, HttpStatus.UNAUTHORIZED);
        }
    }

    @ApiOperation(value = "Get all reviews")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = ReviewExceptionType.class),
            @ApiResponse(code = 400, message = "ERROR", response = ReviewExceptionType.class),
    })
    @RequestMapping(value = "/reviews", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReviewResponse>> getAllReviews(Principal principal) {

        logger.info("+++++++++ LOGGING get all reviews+++++++++");

        logger.info(principal.getName());
        List<ReviewResponse> reviewResponses = service.findAllReviewsForProfessor(principal.getName());
        logger.info("+++++++++SUCCESSFUL LOGGING get all reviews+++++++++");

        return new ResponseEntity<>(reviewResponses, HttpStatus.OK);


    }

    @ApiOperation(value = "Add review")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = ReviewExceptionType.class),
            @ApiResponse(code = 400, message = "ERROR", response = ReviewExceptionType.class),
    })
    @RequestMapping(value = "/reviews", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReviewExceptionType> addReview(Principal principal, @RequestBody ReviewAddedDto reviewAddedDto, BindingResult result) {


        logger.info("+++++++++ LOGGING add review+++++++++");

        logger.info(principal.getName());
        Integer reviewAdded = service.addReviewForProfessor(reviewAddedDto, principal.getName());

        if(reviewAdded != 0) {
            logger.info("+++++++++SUCCESSFUL ADDED REVIEW+++++++++");
            return new ResponseEntity<>(ReviewExceptionType.REVIEW_ADDED_SUCCESFULLY, HttpStatus.OK);
        }
        logger.info("+++++++++ERROR ADDING REVIEW+++++++++");
        return new ResponseEntity<>(ReviewExceptionType.DUPLICATE_REVIEW, HttpStatus.BAD_REQUEST);


    }

    @ApiOperation(value = "Get professors")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = ReviewExceptionType.class),
            @ApiResponse(code = 400, message = "ERROR", response = ReviewExceptionType.class),
    })
    @RequestMapping(value = "/professors", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProfessorResponse>> getProfessors() {

        logger.info("+++++++++ LOGGING get all professors+++++++++");

        //logger.info(principal.getName());
        List<ProfessorResponse> professors = service.getAllProfessor();
        return new ResponseEntity<>(professors, HttpStatus.OK);

    }

    @ApiOperation(value = "Exists user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = ReviewExceptionType.class),
            @ApiResponse(code = 400, message = "ERROR", response = ReviewExceptionType.class),
    })
    @RequestMapping(value = "/exists-user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JSONObject> existsUser(Principal principal, @Valid UserRequest userRequest) {

        logger.info("+++++++++ LOGGING exists user+++++++++");
        Integer existsUsername = service.existsUser(userRequest.getUsername());
        JSONObject exists = new JSONObject();
        exists.put("exists", existsUsername);

        return new ResponseEntity<>(exists, HttpStatus.OK);

    }

    @ExceptionHandler({AuthServiceException.class})
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleException(AuthServiceException exception) {

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setAuthExceptionType(exception.getType());
        logger.error("+++++++++LOGGING handleException+++++++++");
        logger.error(exception.getMessage());
        logger.error("+++++++++END LOGGING handleException+++++++++");
        return new ResponseEntity<ErrorResponse>(errorResponse, exception.getHttpStatus());
        //return new ResponseEntity<ErrorResponse>(exception.getMessage(), new HttpHeaders(), exception.getHttpStatus());
    }
}
