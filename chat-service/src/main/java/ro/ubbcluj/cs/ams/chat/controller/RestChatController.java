package ro.ubbcluj.cs.ams.chat.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import ro.ubbcluj.cs.ams.chat.dto.ChatMessageDTO;
import ro.ubbcluj.cs.ams.chat.dto.ChatUserDTO;
import ro.ubbcluj.cs.ams.chat.dto.CustomChatMessagesDTO;
import ro.ubbcluj.cs.ams.chat.dto.ProfessorResponse;
import ro.ubbcluj.cs.ams.chat.model.User;
import ro.ubbcluj.cs.ams.chat.service.Service;
import ro.ubbcluj.cs.ams.subject.chat.tables.records.ChatMessageRecord;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("")
public class RestChatController {

    private final Logger logger = LogManager.getLogger(RestChatController.class);
    @Autowired
    private Service service;

    @Autowired
    private MicroserviceCall microserviceCall;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @ApiOperation(value = "Find all messages")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = List.class),
    })
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ChatMessageDTO>> findAllMessages() {

        logger.info("+++++++++LOGGING FIND ALL MESSAGES+++++++++");

        List<ChatMessageDTO> messages = service.findAllMessages();
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @ApiOperation(value = "Find all users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = List.class),
    })
    @RequestMapping(value = "users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProfessorResponse>> findAllUsers() {

        logger.info("+++++++++LOGGING FIND ALL USERS+++++++++");
        List<ProfessorResponse> professors = microserviceCall.getAllUsers();
        logger.info("MICROSERVICE CALL AUTHENTICATION-SERVER");


        //logger.info(professors);
        //List<ChatUserDTO> messages = service.findAllUsers();
        return new ResponseEntity<>(professors, HttpStatus.OK);
    }


//    @ApiOperation(value = "Find all custom user chat")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "SUCCESS", response = List.class),
//    })
//    @RequestMapping(value = "custom",
//            method = RequestMethod.POST,
//            produces = MediaType.APPLICATION_JSON_VALUE
//    )
//    public ResponseEntity<List<CustomChatMessagesDTO>> findAllCustomChat(@RequestBody User user) {
//
//        logger.info("+++++++++LOGGING FIND ALL CUSTOM CHAT +++++++++");
//
//
//        List<CustomChatMessagesDTO> records = service.findAllCustomUserChat(user.getUsername());
//
//
//        return new ResponseEntity<>(records, HttpStatus.OK);
//    }
//
//    @ApiOperation(value = "Find all custom user chat")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "SUCCESS", response = List.class),
//    })
//    @RequestMapping(value = "custom2",
//            method = RequestMethod.POST,
//            produces = MediaType.APPLICATION_JSON_VALUE
//    )
//    public ResponseEntity<List<List<ChatMessageDTO>>> custom(@RequestBody User user) {
//
//        logger.info("+++++++++CUSTOM +++++++++");
//
//        List<List<ChatMessageDTO>> records = service.custom(user.getUsername());
//        return new ResponseEntity<>(records, HttpStatus.OK);
//    }

    @ApiOperation(value = "Find all custom user chats")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = List.class),
    })
    @RequestMapping(value = "messages",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Map<Integer, List<ChatMessageDTO>>> custom3(@RequestBody User user) {

        logger.info("+++++++++CUSTOM +++++++++");

        Map<Integer, List<ChatMessageDTO>> records = service.getChatMessagesForUser(user.getUsername());
        return new ResponseEntity<>(records, HttpStatus.OK);
    }


}
