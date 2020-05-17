/*
 * This file is generated by jOOQ.
 */
package ro.ubbcluj.cs.ams.auth.model.tables;


import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import ro.ubbcluj.cs.ams.auth.model.Keys;
import ro.ubbcluj.cs.ams.auth.model.Public;
import ro.ubbcluj.cs.ams.auth.model.tables.records.RoleUserRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RoleUser extends TableImpl<RoleUserRecord> {

    private static final long serialVersionUID = 2083377895;

    /**
     * The reference instance of <code>public.role_user</code>
     */
    public static final RoleUser ROLE_USER = new RoleUser();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RoleUserRecord> getRecordType() {
        return RoleUserRecord.class;
    }

    /**
     * The column <code>public.role_user.role_id</code>.
     */
    public final TableField<RoleUserRecord, Integer> ROLE_ID = createField(DSL.name("role_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('role_user_role_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.role_user.user_id</code>.
     */
    public final TableField<RoleUserRecord, Integer> USER_ID = createField(DSL.name("user_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('role_user_user_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * Create a <code>public.role_user</code> table reference
     */
    public RoleUser() {
        this(DSL.name("role_user"), null);
    }

    /**
     * Create an aliased <code>public.role_user</code> table reference
     */
    public RoleUser(String alias) {
        this(DSL.name(alias), ROLE_USER);
    }

    /**
     * Create an aliased <code>public.role_user</code> table reference
     */
    public RoleUser(Name alias) {
        this(alias, ROLE_USER);
    }

    private RoleUser(Name alias, Table<RoleUserRecord> aliased) {
        this(alias, aliased, null);
    }

    private RoleUser(Name alias, Table<RoleUserRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> RoleUser(Table<O> child, ForeignKey<O, RoleUserRecord> key) {
        super(child, key, ROLE_USER);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<RoleUserRecord, Integer> getIdentity() {
        return Keys.IDENTITY_ROLE_USER;
    }

    @Override
    public UniqueKey<RoleUserRecord> getPrimaryKey() {
        return Keys.PK_ROLE_USER;
    }

    @Override
    public List<UniqueKey<RoleUserRecord>> getKeys() {
        return Arrays.<UniqueKey<RoleUserRecord>>asList(Keys.PK_ROLE_USER);
    }

    @Override
    public List<ForeignKey<RoleUserRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<RoleUserRecord, ?>>asList(Keys.ROLE_USER__FK1_ROLE_USER, Keys.ROLE_USER__FK2_ROLE_USER);
    }

    public Role role() {
        return new Role(this, Keys.ROLE_USER__FK1_ROLE_USER);
    }

    public OauthUser oauthUser() {
        return new OauthUser(this, Keys.ROLE_USER__FK2_ROLE_USER);
    }

    @Override
    public RoleUser as(String alias) {
        return new RoleUser(DSL.name(alias), this);
    }

    @Override
    public RoleUser as(Name alias) {
        return new RoleUser(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RoleUser rename(String name) {
        return new RoleUser(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RoleUser rename(Name name) {
        return new RoleUser(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, Integer> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
