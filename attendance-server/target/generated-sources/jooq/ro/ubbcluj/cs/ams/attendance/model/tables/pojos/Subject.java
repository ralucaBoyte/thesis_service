/*
 * This file is generated by jOOQ.
 */
package ro.ubbcluj.cs.ams.attendance.model.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Subject implements Serializable {

    private static final long serialVersionUID = -853215886;

    private Integer id;
    private String  name;
    private Integer credits;
    private Integer year;
    private Integer specializationId;

    public Subject() {}

    public Subject(Subject value) {
        this.id = value.id;
        this.name = value.name;
        this.credits = value.credits;
        this.year = value.year;
        this.specializationId = value.specializationId;
    }

    public Subject(
        Integer id,
        String  name,
        Integer credits,
        Integer year,
        Integer specializationId
    ) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.year = year;
        this.specializationId = specializationId;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCredits() {
        return this.credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Integer getYear() {
        return this.year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getSpecializationId() {
        return this.specializationId;
    }

    public void setSpecializationId(Integer specializationId) {
        this.specializationId = specializationId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Subject (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(credits);
        sb.append(", ").append(year);
        sb.append(", ").append(specializationId);

        sb.append(")");
        return sb.toString();
    }
}
