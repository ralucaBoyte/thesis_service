package ro.ubbcluj.cs.ams.chat.dto;

import org.jooq.Result;
import org.mapstruct.Mapper;
import ro.ubbcluj.cs.ams.subject.chat.tables.records.ChatMessageRecord;
import ro.ubbcluj.cs.ams.subject.chat.tables.records.ChatUserRecord;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Mapper(componentModel = "spring")
public interface ChatMessageMapper {

    ChatMessageDTO chatMessageRecordToChatMessage(ChatMessageRecord messageRecord);
    List<ChatMessageDTO> chatMessageRecordsToChatMessages(List<ChatMessageRecord> messageRecords);

    ChatUserDTO chatUserRecordToChatUser(ChatUserRecord userRecord);
    List<ChatUserDTO> chatUserRecordsToChatUsers(List<ChatUserRecord> userRecords);

    List<CustomChatMessagesDTO> chatMessagesToCutomChatMessages(List<ChatMessageRecord> customChatMessages);

    }
