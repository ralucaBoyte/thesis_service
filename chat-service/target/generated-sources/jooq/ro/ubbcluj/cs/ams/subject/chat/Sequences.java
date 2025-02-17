/*
 * This file is generated by jOOQ.
 */
package ro.ubbcluj.cs.ams.subject.chat;


import org.jooq.Sequence;
import org.jooq.impl.Internal;


/**
 * Convenience access to all sequences in public
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

    /**
     * The sequence <code>public.chat_message_conversation_id_seq</code>
     */
    public static final Sequence<Integer> CHAT_MESSAGE_CONVERSATION_ID_SEQ = Internal.createSequence("chat_message_conversation_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.INTEGER.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.chat_message_id_seq</code>
     */
    public static final Sequence<Integer> CHAT_MESSAGE_ID_SEQ = Internal.createSequence("chat_message_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.INTEGER.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.conversation_id_seq</code>
     */
    public static final Sequence<Integer> CONVERSATION_ID_SEQ = Internal.createSequence("conversation_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.INTEGER.nullable(false), null, null, null, null, false, null);
}
