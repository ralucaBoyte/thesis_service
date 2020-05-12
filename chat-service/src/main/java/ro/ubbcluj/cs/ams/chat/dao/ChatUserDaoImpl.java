package ro.ubbcluj.cs.ams.chat.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.ubbcluj.cs.ams.subject.chat.Tables;
import ro.ubbcluj.cs.ams.subject.chat.tables.records.ChatMessageRecord;
import ro.ubbcluj.cs.ams.subject.chat.tables.records.ChatUserRecord;

import java.util.ArrayList;
import java.util.List;


@Component
public class ChatUserDaoImpl implements ChatUserDao {

    @Autowired
    private DSLContext dsl;

    private final Logger logger = LogManager.getLogger(ChatMessageDaoImpl.class);

    @Override
    public List<ChatUserRecord> findAllUsers() {
        logger.info("+++++++++++ Get all users ++++++++++++++++");


        //List<ChatMessageRecord> messageRecords = dsl.select().from(Tables.CHAT_MESSAGE).fetch();

        List<ChatUserRecord> records = dsl.selectFrom(Tables.CHAT_USER).fetch();
        return records;


    }
}
