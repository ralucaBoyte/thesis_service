/*
 * This file is generated by jOOQ.
 */
package ro.ubbcluj.cs.ams.auth.model.tables.records;


import org.jooq.Field;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.TableRecordImpl;

import ro.ubbcluj.cs.ams.auth.model.tables.OauthAccessToken;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class OauthAccessTokenRecord extends TableRecordImpl<OauthAccessTokenRecord> implements Record7<String, byte[], String, String, String, byte[], String> {

    private static final long serialVersionUID = -397404354;

    /**
     * Setter for <code>public.oauth_access_token.token_id</code>.
     */
    public void setTokenId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.oauth_access_token.token_id</code>.
     */
    public String getTokenId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.oauth_access_token.token</code>.
     */
    public void setToken(byte[] value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.oauth_access_token.token</code>.
     */
    public byte[] getToken() {
        return (byte[]) get(1);
    }

    /**
     * Setter for <code>public.oauth_access_token.authentication_id</code>.
     */
    public void setAuthenticationId(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.oauth_access_token.authentication_id</code>.
     */
    public String getAuthenticationId() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.oauth_access_token.user_name</code>.
     */
    public void setUserName(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.oauth_access_token.user_name</code>.
     */
    public String getUserName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.oauth_access_token.client_id</code>.
     */
    public void setClientId(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.oauth_access_token.client_id</code>.
     */
    public String getClientId() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.oauth_access_token.authentication</code>.
     */
    public void setAuthentication(byte[] value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.oauth_access_token.authentication</code>.
     */
    public byte[] getAuthentication() {
        return (byte[]) get(5);
    }

    /**
     * Setter for <code>public.oauth_access_token.refresh_token</code>.
     */
    public void setRefreshToken(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.oauth_access_token.refresh_token</code>.
     */
    public String getRefreshToken() {
        return (String) get(6);
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row7<String, byte[], String, String, String, byte[], String> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    @Override
    public Row7<String, byte[], String, String, String, byte[], String> valuesRow() {
        return (Row7) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return OauthAccessToken.OAUTH_ACCESS_TOKEN.TOKEN_ID;
    }

    @Override
    public Field<byte[]> field2() {
        return OauthAccessToken.OAUTH_ACCESS_TOKEN.TOKEN;
    }

    @Override
    public Field<String> field3() {
        return OauthAccessToken.OAUTH_ACCESS_TOKEN.AUTHENTICATION_ID;
    }

    @Override
    public Field<String> field4() {
        return OauthAccessToken.OAUTH_ACCESS_TOKEN.USER_NAME;
    }

    @Override
    public Field<String> field5() {
        return OauthAccessToken.OAUTH_ACCESS_TOKEN.CLIENT_ID;
    }

    @Override
    public Field<byte[]> field6() {
        return OauthAccessToken.OAUTH_ACCESS_TOKEN.AUTHENTICATION;
    }

    @Override
    public Field<String> field7() {
        return OauthAccessToken.OAUTH_ACCESS_TOKEN.REFRESH_TOKEN;
    }

    @Override
    public String component1() {
        return getTokenId();
    }

    @Override
    public byte[] component2() {
        return getToken();
    }

    @Override
    public String component3() {
        return getAuthenticationId();
    }

    @Override
    public String component4() {
        return getUserName();
    }

    @Override
    public String component5() {
        return getClientId();
    }

    @Override
    public byte[] component6() {
        return getAuthentication();
    }

    @Override
    public String component7() {
        return getRefreshToken();
    }

    @Override
    public String value1() {
        return getTokenId();
    }

    @Override
    public byte[] value2() {
        return getToken();
    }

    @Override
    public String value3() {
        return getAuthenticationId();
    }

    @Override
    public String value4() {
        return getUserName();
    }

    @Override
    public String value5() {
        return getClientId();
    }

    @Override
    public byte[] value6() {
        return getAuthentication();
    }

    @Override
    public String value7() {
        return getRefreshToken();
    }

    @Override
    public OauthAccessTokenRecord value1(String value) {
        setTokenId(value);
        return this;
    }

    @Override
    public OauthAccessTokenRecord value2(byte[] value) {
        setToken(value);
        return this;
    }

    @Override
    public OauthAccessTokenRecord value3(String value) {
        setAuthenticationId(value);
        return this;
    }

    @Override
    public OauthAccessTokenRecord value4(String value) {
        setUserName(value);
        return this;
    }

    @Override
    public OauthAccessTokenRecord value5(String value) {
        setClientId(value);
        return this;
    }

    @Override
    public OauthAccessTokenRecord value6(byte[] value) {
        setAuthentication(value);
        return this;
    }

    @Override
    public OauthAccessTokenRecord value7(String value) {
        setRefreshToken(value);
        return this;
    }

    @Override
    public OauthAccessTokenRecord values(String value1, byte[] value2, String value3, String value4, String value5, byte[] value6, String value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached OauthAccessTokenRecord
     */
    public OauthAccessTokenRecord() {
        super(OauthAccessToken.OAUTH_ACCESS_TOKEN);
    }

    /**
     * Create a detached, initialised OauthAccessTokenRecord
     */
    public OauthAccessTokenRecord(String tokenId, byte[] token, String authenticationId, String userName, String clientId, byte[] authentication, String refreshToken) {
        super(OauthAccessToken.OAUTH_ACCESS_TOKEN);

        set(0, tokenId);
        set(1, token);
        set(2, authenticationId);
        set(3, userName);
        set(4, clientId);
        set(5, authentication);
        set(6, refreshToken);
    }
}
