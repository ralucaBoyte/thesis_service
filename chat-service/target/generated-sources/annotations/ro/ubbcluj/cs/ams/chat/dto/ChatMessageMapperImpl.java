package ro.ubbcluj.cs.ams.chat.dto;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import ro.ubbcluj.cs.ams.chat.dto.ChatMessageDTO.ChatMessageDTOBuilder;
import ro.ubbcluj.cs.ams.chat.dto.ChatUserDTO.ChatUserDTOBuilder;
import ro.ubbcluj.cs.ams.chat.dto.CustomChatMessagesDTO.CustomChatMessagesDTOBuilder;
import ro.ubbcluj.cs.ams.subject.chat.tables.records.ChatMessageRecord;
import ro.ubbcluj.cs.ams.subject.chat.tables.records.ChatUserRecord;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-17T11:17:28+0300",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 10.0.2 (Oracle Corporation)"
)
@Component
public class ChatMessageMapperImpl implements ChatMessageMapper {

    @Override
    public ChatMessageDTO chatMessageRecordToChatMessage(ChatMessageRecord messageRecord) {
        if ( messageRecord == null ) {
            return null;
        }

        ChatMessageDTOBuilder chatMessageDTO = ChatMessageDTO.builder();

        chatMessageDTO.sender( messageRecord.getSender() );
        chatMessageDTO.receiver( messageRecord.getReceiver() );
        chatMessageDTO.content( messageRecord.getContent() );

        return chatMessageDTO.build();
    }

    @Override
    public List<ChatMessageDTO> chatMessageRecordsToChatMessages(List<ChatMessageRecord> messageRecords) {
        if ( messageRecords == null ) {
            return null;
        }

        List<ChatMessageDTO> list = new ArrayList<ChatMessageDTO>( messageRecords.size() );
        for ( ChatMessageRecord chatMessageRecord : messageRecords ) {
            list.add( chatMessageRecordToChatMessage( chatMessageRecord ) );
        }

        return list;
    }

    @Override
    public ChatUserDTO chatUserRecordToChatUser(ChatUserRecord userRecord) {
        if ( userRecord == null ) {
            return null;
        }

        ChatUserDTOBuilder chatUserDTO = ChatUserDTO.builder();

        chatUserDTO.username( userRecord.getUsername() );

        return chatUserDTO.build();
    }

    @Override
    public List<ChatUserDTO> chatUserRecordsToChatUsers(List<ChatUserRecord> userRecords) {
        if ( userRecords == null ) {
            return null;
        }

        List<ChatUserDTO> list = new ArrayList<ChatUserDTO>( userRecords.size() );
        for ( ChatUserRecord chatUserRecord : userRecords ) {
            list.add( chatUserRecordToChatUser( chatUserRecord ) );
        }

        return list;
    }

    @Override
    public List<CustomChatMessagesDTO> chatMessagesToCutomChatMessages(List<ChatMessageRecord> customChatMessages) {
        if ( customChatMessages == null ) {
            return null;
        }

        List<CustomChatMessagesDTO> list = new ArrayList<CustomChatMessagesDTO>( customChatMessages.size() );
        for ( ChatMessageRecord chatMessageRecord : customChatMessages ) {
            list.add( chatMessageRecordToCustomChatMessagesDTO( chatMessageRecord ) );
        }

        return list;
    }

    protected CustomChatMessagesDTO chatMessageRecordToCustomChatMessagesDTO(ChatMessageRecord chatMessageRecord) {
        if ( chatMessageRecord == null ) {
            return null;
        }

        CustomChatMessagesDTOBuilder customChatMessagesDTO = CustomChatMessagesDTO.builder();

        customChatMessagesDTO.sender( chatMessageRecord.getSender() );
        customChatMessagesDTO.receiver( chatMessageRecord.getReceiver() );
        customChatMessagesDTO.content( chatMessageRecord.getContent() );

        return customChatMessagesDTO.build();
    }
}
