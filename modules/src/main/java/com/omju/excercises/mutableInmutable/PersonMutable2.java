package com.omju.excercises.mutableInmutable;

import java.util.List;

public class PersonMutable2 {
    private int id;
    private String fullName;
    private List<String> emails;

    public PersonMutable2(List<String> emails) {
        this.emails = emails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getEmails() {
        return emails;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "MutableInmutableMain {" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", emails=" + emails +
                '}';
    }
}
