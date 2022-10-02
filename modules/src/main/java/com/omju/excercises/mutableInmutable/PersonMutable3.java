package com.omju.excercises.mutableInmutable;

import java.util.List;

public class PersonMutable3 {
    private int id;
    private String fullName;
    private final List<String> emails;

    public PersonMutable3(List<String> emails) {
        this.emails = emails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<String> getEmails() {
        return emails;
    }

    @Override
    public String toString() {
        return "PersonMutable3{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", emails=" + emails +
                '}';
    }
}
