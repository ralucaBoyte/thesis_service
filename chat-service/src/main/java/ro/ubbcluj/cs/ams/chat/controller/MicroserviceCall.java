package ro.ubbcluj.cs.ams.chat.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import ro.ubbcluj.cs.ams.chat.dto.ProfessorResponse;
import ro.ubbcluj.cs.ams.chat.service.exception.ChatException;
import ro.ubbcluj.cs.ams.chat.service.exception.ChatServiceException;

import java.util.List;
import java.util.Objects;

@Component
public class MicroserviceCall {

    @Autowired
    private WebClient.Builder webClientBuilder;

    private final Logger logger = LogManager.getLogger(MicroserviceCall.class);


    public List<ProfessorResponse> getAllUsers() {

        logger.info("Logging get all users for our chat microservice");
        logger.info("Call authentication-server microservice");
        List<ProfessorResponse> professors = null;
        try {
            String path = "http://localhost:8084/authentication/professors";
            professors = webClientBuilder
                    .build()
                    .get()
                    .uri(path)
                    .retrieve()
                    .bodyToMono(List.class)
                    .block();
            if (Objects.isNull(professors)) {
                throw new ChatServiceException("Couldn't find users\n", ChatException.USERS_NOT_FOUND, HttpStatus.NOT_FOUND);
            }
        } catch (WebClientResponseException e) {
            logger.error("getUsers: call to subject authentication-server failed");
            handleWebClientResponseException(e,
                    "Couldn't find users\n",
                    ChatException.USERS_NOT_FOUND);
        }
        return professors;
    }

    private void handleWebClientResponseException(WebClientResponseException e, String message, ChatException type) {

        loggingWebClientResponseException(e);
        if (e.getStatusCode() != HttpStatus.NOT_FOUND) {
            throw new ChatServiceException(e.getMessage(), ChatException.USERS_NOT_FOUND, HttpStatus.BAD_GATEWAY);
        }
        throw new ChatServiceException(message, type, HttpStatus.NOT_FOUND);
    }

    private void loggingWebClientResponseException(WebClientResponseException e) {

        logger.error("========== ERROR LOGGING ==========");
        logger.error("Message: {}", e.getMessage());
        logger.error("Status: {} ", e.getStatusCode());
        logger.error("Code: {} ", e.getStatusCode().value());
        logger.error("========== FINAL ERROR LOGGING ==========");
    }
}
