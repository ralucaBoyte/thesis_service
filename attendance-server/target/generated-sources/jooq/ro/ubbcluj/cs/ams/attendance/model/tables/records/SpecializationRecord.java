/*
 * This file is generated by jOOQ.
 */
package ro.ubbcluj.cs.ams.attendance.model.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;

import ro.ubbcluj.cs.ams.attendance.model.tables.Specialization;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SpecializationRecord extends UpdatableRecordImpl<SpecializationRecord> implements Record3<Integer, String, String> {

    private static final long serialVersionUID = -745061312;

    /**
     * Setter for <code>public.specialization.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.specialization.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.specialization.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.specialization.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.specialization.language</code>.
     */
    public void setLanguage(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.specialization.language</code>.
     */
    public String getLanguage() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Integer, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Specialization.SPECIALIZATION.ID;
    }

    @Override
    public Field<String> field2() {
        return Specialization.SPECIALIZATION.NAME;
    }

    @Override
    public Field<String> field3() {
        return Specialization.SPECIALIZATION.LANGUAGE;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public String component3() {
        return getLanguage();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public String value3() {
        return getLanguage();
    }

    @Override
    public SpecializationRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public SpecializationRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public SpecializationRecord value3(String value) {
        setLanguage(value);
        return this;
    }

    @Override
    public SpecializationRecord values(Integer value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SpecializationRecord
     */
    public SpecializationRecord() {
        super(Specialization.SPECIALIZATION);
    }

    /**
     * Create a detached, initialised SpecializationRecord
     */
    public SpecializationRecord(Integer id, String name, String language) {
        super(Specialization.SPECIALIZATION);

        set(0, id);
        set(1, name);
        set(2, language);
    }
}
