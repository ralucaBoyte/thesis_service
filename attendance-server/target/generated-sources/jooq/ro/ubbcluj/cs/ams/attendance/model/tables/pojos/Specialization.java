/*
 * This file is generated by jOOQ.
 */
package ro.ubbcluj.cs.ams.attendance.model.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Specialization implements Serializable {

    private static final long serialVersionUID = 1792699147;

    private Integer id;
    private String  name;
    private String  language;

    public Specialization() {}

    public Specialization(Specialization value) {
        this.id = value.id;
        this.name = value.name;
        this.language = value.language;
    }

    public Specialization(
        Integer id,
        String  name,
        String  language
    ) {
        this.id = id;
        this.name = name;
        this.language = language;
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

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Specialization (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(language);

        sb.append(")");
        return sb.toString();
    }
}
