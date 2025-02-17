/*
 * This file is generated by jOOQ.
 */
package ro.ubbcluj.cs.ams.attendance.model.tables;


import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import ro.ubbcluj.cs.ams.attendance.model.Keys;
import ro.ubbcluj.cs.ams.attendance.model.Public;
import ro.ubbcluj.cs.ams.attendance.model.tables.records.SpecializationRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Specialization extends TableImpl<SpecializationRecord> {

    private static final long serialVersionUID = -1016482523;

    /**
     * The reference instance of <code>public.specialization</code>
     */
    public static final Specialization SPECIALIZATION = new Specialization();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SpecializationRecord> getRecordType() {
        return SpecializationRecord.class;
    }

    /**
     * The column <code>public.specialization.id</code>.
     */
    public final TableField<SpecializationRecord, Integer> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('specialization_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.specialization.name</code>.
     */
    public final TableField<SpecializationRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR(256), this, "");

    /**
     * The column <code>public.specialization.language</code>.
     */
    public final TableField<SpecializationRecord, String> LANGUAGE = createField(DSL.name("language"), org.jooq.impl.SQLDataType.VARCHAR(256), this, "");

    /**
     * Create a <code>public.specialization</code> table reference
     */
    public Specialization() {
        this(DSL.name("specialization"), null);
    }

    /**
     * Create an aliased <code>public.specialization</code> table reference
     */
    public Specialization(String alias) {
        this(DSL.name(alias), SPECIALIZATION);
    }

    /**
     * Create an aliased <code>public.specialization</code> table reference
     */
    public Specialization(Name alias) {
        this(alias, SPECIALIZATION);
    }

    private Specialization(Name alias, Table<SpecializationRecord> aliased) {
        this(alias, aliased, null);
    }

    private Specialization(Name alias, Table<SpecializationRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> Specialization(Table<O> child, ForeignKey<O, SpecializationRecord> key) {
        super(child, key, SPECIALIZATION);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<SpecializationRecord, Integer> getIdentity() {
        return Keys.IDENTITY_SPECIALIZATION;
    }

    @Override
    public UniqueKey<SpecializationRecord> getPrimaryKey() {
        return Keys.PK_SPECIALIZATION_ID;
    }

    @Override
    public List<UniqueKey<SpecializationRecord>> getKeys() {
        return Arrays.<UniqueKey<SpecializationRecord>>asList(Keys.PK_SPECIALIZATION_ID);
    }

    @Override
    public Specialization as(String alias) {
        return new Specialization(DSL.name(alias), this);
    }

    @Override
    public Specialization as(Name alias) {
        return new Specialization(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Specialization rename(String name) {
        return new Specialization(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Specialization rename(Name name) {
        return new Specialization(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}
