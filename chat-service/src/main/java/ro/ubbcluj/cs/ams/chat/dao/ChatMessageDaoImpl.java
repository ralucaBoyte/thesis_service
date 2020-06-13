package ro.ubbcluj.cs.ams.chat.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jooq.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.ubbcluj.cs.ams.chat.dto.ChatMessageDTO;
import ro.ubbcluj.cs.ams.subject.chat.Tables;
import ro.ubbcluj.cs.ams.subject.chat.tables.records.ChatMessageRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ChatMessageDaoImpl implements ChatMessageDao {

    @Autowired
    private DSLContext dsl;

    private final Logger logger = LogManager.getLogger(ChatMessageDaoImpl.class);


    @Override
    public List<ChatMessageRecord> findAllChatMessages() {
        logger.info("+++++++++++ Get all messages ++++++++++++++++");

            List<ChatMessageRecord> messageRecords = new ArrayList<>();
            ChatMessageRecord messageRecord = dsl.selectFrom(Tables.CHAT_MESSAGE)
                    .where(Tables.CHAT_MESSAGE.ID.eq(1)).fetchOne();
            messageRecords.add(messageRecord);

            return messageRecords;
    }

//    @Override
//    public List<ChatMessageRecord> customChatResponse(String username) {
//
//        List<ChatMessageRecord> chat_messages = dsl
//                                                .selectFrom(Tables.CHAT_MESSAGE)
//                                                .where(Tables.CHAT_MESSAGE.SENDER.eq(username))
//                                                .or(Tables.CHAT_MESSAGE.RECEIVER.eq(username))
//                                                //.groupBy(Tables.CHAT_MESSAGE.SENDER)
//                                                .orderBy(Tables.CHAT_MESSAGE.RECEIVER)
//                                                .fetch();
//
//
//        return chat_messages;
//    }

    @Override
    public Map<Integer, Result<ChatMessageRecord>> custom(String username) {
        Map<Integer, Result<ChatMessageRecord>> group1 = dsl
                .selectFrom(Tables.CHAT_MESSAGE)
                .where(Tables.CHAT_MESSAGE.SENDER.eq(username).or(Tables.CHAT_MESSAGE.RECEIVER.eq(username)))
                .fetch()
                .intoGroups(Tables.CHAT_MESSAGE.CONVERSATION_ID);


        logger.info("++++++++++++++++++CHAT MESSAGES DAO ++++++++++++++");

        return group1;
    }

    @Override
    public Integer addNewMessage(ChatMessageDTO chatMessageDTO) {
        Integer messageAdded = dsl.insertInto(Tables.CHAT_MESSAGE, Tables.CHAT_MESSAGE.SENDER,
                Tables.CHAT_MESSAGE.RECEIVER, Tables.CHAT_MESSAGE.CONTENT, Tables.CHAT_MESSAGE.CONVERSATION_ID)
                .values(chatMessageDTO.getSender(), chatMessageDTO.getReceiver(), chatMessageDTO.getContent(), chatMessageDTO.getConversationId())
                .execute();
        return messageAdded;
    }

    @Override
    public Record1<Integer> addConversation(String sender, String receiver) {
        Record1<Integer> exists = dsl
                .insertInto(Tables.CONVERSATION, Tables.CONVERSATION.USERNAME1, Tables.CONVERSATION.USERNAME2)
                .values(sender, receiver)
                .returningResult(Tables.CONVERSATION.ID)
                .fetchOne();


        return exists;
    }
}
