package ro.ubbcluj.cs.ams.chat.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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


            //List<ChatMessageRecord> messageRecords = dsl.select().from(Tables.CHAT_MESSAGE).fetch();

            List<ChatMessageRecord> messageRecords = new ArrayList<>();
            ChatMessageRecord messageRecord = dsl.selectFrom(Tables.CHAT_MESSAGE)
                    .where(Tables.CHAT_MESSAGE.ID.eq(1)).fetchOne();
            messageRecords.add(messageRecord);

            return messageRecords;
    }

    @Override
    public List<ChatMessageRecord> customChatResponse(String username) {

        List<ChatMessageRecord> chat_messages = dsl
                                                .selectFrom(Tables.CHAT_MESSAGE)
                                                .where(Tables.CHAT_MESSAGE.SENDER.eq(username))
                                                .or(Tables.CHAT_MESSAGE.RECEIVER.eq(username))
                                                //.groupBy(Tables.CHAT_MESSAGE.SENDER)
                                                .orderBy(Tables.CHAT_MESSAGE.RECEIVER)
                                                .fetch();
        //CustomChatMessagesDTO

        return chat_messages;
    }

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
}
