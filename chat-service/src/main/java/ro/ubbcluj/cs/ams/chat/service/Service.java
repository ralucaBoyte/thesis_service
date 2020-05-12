package ro.ubbcluj.cs.ams.chat.service;

import org.jooq.Record;
import org.jooq.Result;
import ro.ubbcluj.cs.ams.chat.dto.ChatMessageDTO;
import ro.ubbcluj.cs.ams.chat.dto.ChatUserDTO;
import ro.ubbcluj.cs.ams.chat.dto.CustomChatMessagesDTO;
import ro.ubbcluj.cs.ams.subject.chat.tables.records.ChatMessageRecord;

import java.util.List;
import java.util.Map;

public interface Service {

    List<ChatMessageDTO> findAllMessages();

    List<ChatUserDTO> findAllUsers();

    List<CustomChatMessagesDTO> findAllCustomUserChat(String username);

    List<List<ChatMessageDTO>> custom(String username);
   // List<>
}
