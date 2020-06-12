package ro.ubbcluj.cs.ams.chat.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import ro.ubbcluj.cs.ams.chat.dto.ChatMessageDTO;
import ro.ubbcluj.cs.ams.chat.dto.ChatUserDTO;
import ro.ubbcluj.cs.ams.chat.service.Service;

@Controller
public class ChatController {

    private final Logger logger = LogManager.getLogger(ChatController.class);

    @Autowired
    Service service;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/sendPrivateMessage")
    //@SendTo("/queue/reply")
    public void sendPrivateMessage(@Payload ChatMessageDTO chatMessage) {

        logger.info("New message from " + chatMessage.getSender() + " to " + chatMessage.getReceiver());
        simpMessagingTemplate.convertAndSendToUser(
                chatMessage.getReceiver(), "/reply", chatMessage);
        Integer newChatMessage = service.addNewChatMessage(chatMessage);
        logger.info("New chat message added: " + chatMessage);
    }

    @MessageMapping("/addPrivateUser")
    @SendTo("/queue/reply")
    public ChatUserDTO addPrivateUser(@Payload ChatUserDTO chatUserDTO,
                                      SimpMessageHeaderAccessor headerAccessor) {
        // Add user in web socket session
        logger.info("New user added in conversation " + chatUserDTO.getUsername());
        logger.info("----------------------------------------------------------");
        logger.info("----------------------------------------------------------");
        logger.info("----------------------------------------------------------");
        headerAccessor.getSessionAttributes().put("private-username", chatUserDTO.getUsername());
        return chatUserDTO;
    }
}