/*
 * This file is generated by jOOQ.
 */
package ro.ubbcluj.cs.ams.auth.model.tables;


import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import ro.ubbcluj.cs.ams.auth.model.Public;
import ro.ubbcluj.cs.ams.auth.model.tables.records.OauthApprovalsRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class OauthApprovals extends TableImpl<OauthApprovalsRecord> {

    private static final long serialVersionUID = -1198255496;

    /**
     * The reference instance of <code>public.oauth_approvals</code>
     */
    public static final OauthApprovals OAUTH_APPROVALS = new OauthApprovals();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<OauthApprovalsRecord> getRecordType() {
        return OauthApprovalsRecord.class;
    }

    /**
     * The column <code>public.oauth_approvals.user_id</code>.
     */
    public final TableField<OauthApprovalsRecord, String> USER_ID = createField(DSL.name("user_id"), org.jooq.impl.SQLDataType.VARCHAR(256), this, "");

    /**
     * The column <code>public.oauth_approvals.client_id</code>.
     */
    public final TableField<OauthApprovalsRecord, String> CLIENT_ID = createField(DSL.name("client_id"), org.jooq.impl.SQLDataType.VARCHAR(256), this, "");

    /**
     * The column <code>public.oauth_approvals.scope</code>.
     */
    public final TableField<OauthApprovalsRecord, String> SCOPE = createField(DSL.name("scope"), org.jooq.impl.SQLDataType.VARCHAR(256), this, "");

    /**
     * The column <code>public.oauth_approvals.status</code>.
     */
    public final TableField<OauthApprovalsRecord, String> STATUS = createField(DSL.name("status"), org.jooq.impl.SQLDataType.VARCHAR(10), this, "");

    /**
     * The column <code>public.oauth_approvals.expires_at</code>.
     */
    public final TableField<OauthApprovalsRecord, LocalDateTime> EXPIRES_AT = createField(DSL.name("expires_at"), org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * The column <code>public.oauth_approvals.last_modified_at</code>.
     */
    public final TableField<OauthApprovalsRecord, LocalDateTime> LAST_MODIFIED_AT = createField(DSL.name("last_modified_at"), org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * Create a <code>public.oauth_approvals</code> table reference
     */
    public OauthApprovals() {
        this(DSL.name("oauth_approvals"), null);
    }

    /**
     * Create an aliased <code>public.oauth_approvals</code> table reference
     */
    public OauthApprovals(String alias) {
        this(DSL.name(alias), OAUTH_APPROVALS);
    }

    /**
     * Create an aliased <code>public.oauth_approvals</code> table reference
     */
    public OauthApprovals(Name alias) {
        this(alias, OAUTH_APPROVALS);
    }

    private OauthApprovals(Name alias, Table<OauthApprovalsRecord> aliased) {
        this(alias, aliased, null);
    }

    private OauthApprovals(Name alias, Table<OauthApprovalsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> OauthApprovals(Table<O> child, ForeignKey<O, OauthApprovalsRecord> key) {
        super(child, key, OAUTH_APPROVALS);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public OauthApprovals as(String alias) {
        return new OauthApprovals(DSL.name(alias), this);
    }

    @Override
    public OauthApprovals as(Name alias) {
        return new OauthApprovals(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public OauthApprovals rename(String name) {
        return new OauthApprovals(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public OauthApprovals rename(Name name) {
        return new OauthApprovals(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<String, String, String, String, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}
