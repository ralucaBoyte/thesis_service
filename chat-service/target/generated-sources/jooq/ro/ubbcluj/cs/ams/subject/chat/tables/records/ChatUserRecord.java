/*
 * This file is generated by jOOQ.
 */
package ro.ubbcluj.cs.ams.subject.chat.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;

import ro.ubbcluj.cs.ams.subject.chat.tables.ChatUser;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ChatUserRecord extends UpdatableRecordImpl<ChatUserRecord> implements Record2<String, String> {

    private static final long serialVersionUID = -314671869;

    /**
     * Setter for <code>public.chat_user.username</code>.
     */
    public void setUsername(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.chat_user.username</code>.
     */
    public String getUsername() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.chat_user.email</code>.
     */
    public void setEmail(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.chat_user.email</code>.
     */
    public String getEmail() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<String, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return ChatUser.CHAT_USER.USERNAME;
    }

    @Override
    public Field<String> field2() {
        return ChatUser.CHAT_USER.EMAIL;
    }

    @Override
    public String component1() {
        return getUsername();
    }

    @Override
    public String component2() {
        return getEmail();
    }

    @Override
    public String value1() {
        return getUsername();
    }

    @Override
    public String value2() {
        return getEmail();
    }

    @Override
    public ChatUserRecord value1(String value) {
        setUsername(value);
        return this;
    }

    @Override
    public ChatUserRecord value2(String value) {
        setEmail(value);
        return this;
    }

    @Override
    public ChatUserRecord values(String value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ChatUserRecord
     */
    public ChatUserRecord() {
        super(ChatUser.CHAT_USER);
    }

    /**
     * Create a detached, initialised ChatUserRecord
     */
    public ChatUserRecord(String username, String email) {
        super(ChatUser.CHAT_USER);

        set(0, username);
        set(1, email);
    }
}
