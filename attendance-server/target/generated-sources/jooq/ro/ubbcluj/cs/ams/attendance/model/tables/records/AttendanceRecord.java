/*
 * This file is generated by jOOQ.
 */
package ro.ubbcluj.cs.ams.attendance.model.tables.records;


import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;

import ro.ubbcluj.cs.ams.attendance.model.tables.Attendance;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AttendanceRecord extends UpdatableRecordImpl<AttendanceRecord> implements Record4<Integer, String, LocalDateTime, Integer> {

    private static final long serialVersionUID = 1752447115;

    /**
     * Setter for <code>public.attendance.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.attendance.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.attendance.student_id</code>.
     */
    public void setStudentId(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.attendance.student_id</code>.
     */
    public String getStudentId() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.attendance.created_at</code>.
     */
    public void setCreatedAt(LocalDateTime value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.attendance.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>public.attendance.attendance_info_id</code>.
     */
    public void setAttendanceInfoId(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.attendance.attendance_info_id</code>.
     */
    public Integer getAttendanceInfoId() {
        return (Integer) get(3);
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
    public Row4<Integer, String, LocalDateTime, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Integer, String, LocalDateTime, Integer> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Attendance.ATTENDANCE.ID;
    }

    @Override
    public Field<String> field2() {
        return Attendance.ATTENDANCE.STUDENT_ID;
    }

    @Override
    public Field<LocalDateTime> field3() {
        return Attendance.ATTENDANCE.CREATED_AT;
    }

    @Override
    public Field<Integer> field4() {
        return Attendance.ATTENDANCE.ATTENDANCE_INFO_ID;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getStudentId();
    }

    @Override
    public LocalDateTime component3() {
        return getCreatedAt();
    }

    @Override
    public Integer component4() {
        return getAttendanceInfoId();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getStudentId();
    }

    @Override
    public LocalDateTime value3() {
        return getCreatedAt();
    }

    @Override
    public Integer value4() {
        return getAttendanceInfoId();
    }

    @Override
    public AttendanceRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public AttendanceRecord value2(String value) {
        setStudentId(value);
        return this;
    }

    @Override
    public AttendanceRecord value3(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public AttendanceRecord value4(Integer value) {
        setAttendanceInfoId(value);
        return this;
    }

    @Override
    public AttendanceRecord values(Integer value1, String value2, LocalDateTime value3, Integer value4) {
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
     * Create a detached AttendanceRecord
     */
    public AttendanceRecord() {
        super(Attendance.ATTENDANCE);
    }

    /**
     * Create a detached, initialised AttendanceRecord
     */
    public AttendanceRecord(Integer id, String studentId, LocalDateTime createdAt, Integer attendanceInfoId) {
        super(Attendance.ATTENDANCE);

        set(0, id);
        set(1, studentId);
        set(2, createdAt);
        set(3, attendanceInfoId);
    }
}
