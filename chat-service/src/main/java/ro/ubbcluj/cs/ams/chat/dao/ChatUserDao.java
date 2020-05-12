package ro.ubbcluj.cs.ams.chat.dao;

import ro.ubbcluj.cs.ams.subject.chat.tables.records.ChatMessageRecord;
import ro.ubbcluj.cs.ams.subject.chat.tables.records.ChatUserRecord;

import java.util.List;

public interface ChatUserDao {
    List<ChatUserRecord> findAllUsers();
}
