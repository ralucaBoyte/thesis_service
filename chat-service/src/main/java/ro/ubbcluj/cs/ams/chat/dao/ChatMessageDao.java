package ro.ubbcluj.cs.ams.chat.dao;

import org.jooq.Record;
import org.jooq.Result;
import ro.ubbcluj.cs.ams.subject.chat.tables.records.ChatMessageRecord;

import java.util.List;
import java.util.Map;

public interface ChatMessageDao {
    List<ChatMessageRecord> findAllChatMessages();
    List<ChatMessageRecord> customChatResponse(String username);

    Map<Integer, Result<ChatMessageRecord>> custom(String username);
}
