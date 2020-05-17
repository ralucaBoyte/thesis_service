/*
 * This file is generated by jOOQ.
 */
package ro.ubbcluj.cs.ams.auth.model.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;

import ro.ubbcluj.cs.ams.auth.model.tables.UserKeyphrase;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserKeyphraseRecord extends UpdatableRecordImpl<UserKeyphraseRecord> implements Record4<Integer, String, String, String> {

    private static final long serialVersionUID = -156755316;

    /**
     * Setter for <code>public.user_keyphrase.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.user_keyphrase.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.user_keyphrase.username</code>.
     */
    public void setUsername(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.user_keyphrase.username</code>.
     */
    public String getUsername() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.user_keyphrase.keyphrase</code>.
     */
    public void setKeyphrase(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.user_keyphrase.keyphrase</code>.
     */
    public String getKeyphrase() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.user_keyphrase.message</code>.
     */
    public void setMessage(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.user_keyphrase.message</code>.
     */
    public String getMessage() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, String, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Integer, String, String, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return UserKeyphrase.USER_KEYPHRASE.ID;
    }

    @Override
    public Field<String> field2() {
        return UserKeyphrase.USER_KEYPHRASE.USERNAME;
    }

    @Override
    public Field<String> field3() {
        return UserKeyphrase.USER_KEYPHRASE.KEYPHRASE;
    }

    @Override
    public Field<String> field4() {
        return UserKeyphrase.USER_KEYPHRASE.MESSAGE;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getUsername();
    }

    @Override
    public String component3() {
        return getKeyphrase();
    }

    @Override
    public String component4() {
        return getMessage();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getUsername();
    }

    @Override
    public String value3() {
        return getKeyphrase();
    }

    @Override
    public String value4() {
        return getMessage();
    }

    @Override
    public UserKeyphraseRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public UserKeyphraseRecord value2(String value) {
        setUsername(value);
        return this;
    }

    @Override
    public UserKeyphraseRecord value3(String value) {
        setKeyphrase(value);
        return this;
    }

    @Override
    public UserKeyphraseRecord value4(String value) {
        setMessage(value);
        return this;
    }

    @Override
    public UserKeyphraseRecord values(Integer value1, String value2, String value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserKeyphraseRecord
     */
    public UserKeyphraseRecord() {
        super(UserKeyphrase.USER_KEYPHRASE);
    }

    /**
     * Create a detached, initialised UserKeyphraseRecord
     */
    public UserKeyphraseRecord(Integer id, String username, String keyphrase, String message) {
        super(UserKeyphrase.USER_KEYPHRASE);

        set(0, id);
        set(1, username);
        set(2, keyphrase);
        set(3, message);
    }
}
