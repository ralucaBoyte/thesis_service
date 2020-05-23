package ro.ubbcluj.cs.ams.chat.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import ro.ubbcluj.cs.ams.chat.dao.ChatMessageDao;
import ro.ubbcluj.cs.ams.chat.dao.ChatUserDao;
import ro.ubbcluj.cs.ams.chat.dto.ChatMessageDTO;
import ro.ubbcluj.cs.ams.chat.dto.ChatMessageMapper;
import ro.ubbcluj.cs.ams.chat.dto.ChatUserDTO;
import ro.ubbcluj.cs.ams.chat.dto.CustomChatMessagesDTO;
import ro.ubbcluj.cs.ams.subject.chat.tables.records.ChatMessageRecord;
import ro.ubbcluj.cs.ams.subject.chat.tables.records.ChatUserRecord;

import java.util.*;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service{

    private final Logger logger = LogManager.getLogger(ServiceImpl.class);

    @Autowired
    private ChatMessageDao chatMessageDao;

    @Autowired
    private ChatUserDao chatUserDao;

    @Autowired
    private ChatMessageMapper chatMessageMapper;


    @Override
    public List<ChatMessageDTO> findAllMessages() {

        logger.info("========== LOGGING get all messages ==========");

        List<ChatMessageRecord> messages = chatMessageDao.findAllChatMessages();

        logger.info("+++++++++++++++ Successfully found all messages +++++++++++++++++ ");

        return chatMessageMapper.chatMessageRecordsToChatMessages(messages);

    }

//    @Override
//    public List<ChatUserDTO> findAllUsers() {
//        logger.info("========== LOGGING get all users ==========");
//
//        List<ChatUserRecord> users = chatUserDao.findAllUsers();
//
//        logger.info("+++++++++++++++ Successfully found all messages +++++++++++++++++ ");
//
//        return chatMessageMapper.chatUserRecordsToChatUsers(users);
//    }

//    @Override
//    public List<CustomChatMessagesDTO> findAllCustomUserChat(String username) {
//        logger.info("========== LOGGING get all users ==========");
//
//        List<ChatMessageRecord> records = chatMessageDao.customChatResponse(username);
//
//        logger.info("+++++++++++++++ Successfully found all custom chats +++++++++++++++++ ");
//
//        return chatMessageMapper.chatMessagesToCutomChatMessages(records);
//    }
//
//    @Override
//    public List<List<ChatMessageDTO>> custom(String username) {
//        logger.info("========== LOGGING CUSTOM ==========");
//
//        Map<Integer, Result<ChatMessageRecord>> records = chatMessageDao.custom(username);
//
//        logger.info("+++++++++++++++ Successfully found all custom chats +++++++++++++++++ ");
//
//        Map<Integer, List<ChatMessageDTO>> customMessages = new HashMap<>();
//
//        List<List<ChatMessageDTO>> customMessagesList = new ArrayList<>();
//
//        for (Map.Entry<Integer, Result<ChatMessageRecord>> entry : records.entrySet()) {
//            List<ChatMessageDTO> chatMessages = new ArrayList<>();
//            for (ChatMessageRecord messageRecord : entry.getValue()) {
//                chatMessages.add(chatMessageMapper.chatMessageRecordToChatMessage(messageRecord));
//            }
//            customMessagesList.add(chatMessages);
//
//        }
//
//        return customMessagesList;
//    }

    @Override
    public Map<Integer, List<ChatMessageDTO>> getChatMessagesForUser(String username) {
        logger.info("========== LOGGING CUSTOM ==========");

        Map<Integer, Result<ChatMessageRecord>> records = chatMessageDao.custom(username);

        logger.info("+++++++++++++++ Successfully found all custom chats +++++++++++++++++ ");

        Map<Integer, List<ChatMessageDTO>> customMessages = new HashMap<>();

        //List<List<ChatMessageDTO>> customMessagesList = new ArrayList<>();

        for (Map.Entry<Integer, Result<ChatMessageRecord>> entry : records.entrySet()) {
            List<ChatMessageDTO> chatMessages = new ArrayList<>();
            for (ChatMessageRecord messageRecord : entry.getValue()) {
                chatMessages.add(chatMessageMapper.chatMessageRecordToChatMessage(messageRecord));
                customMessages.put(messageRecord.getConversationId(), chatMessages);
            }
            //customMessagesList.add(chatMessages);

        }

        return customMessages;
    }

    @Override
    public Integer addNewChatMessage(ChatMessageDTO chatMessageDTO) {
        logger.info("========== LOGGING ADD NEW CHAT MESSAGE ==========");

        Integer messageAdded = chatMessageDao.addNewMessage(chatMessageDTO);
        return messageAdded;
    }
}
