package com.omju.excercises.mutableInmutable;

import java.util.ArrayList;
import java.util.List;

public final class PersonInmutable {
    private final int id;
    private final String fullName;
    private final List<String> emails;

    public PersonInmutable(int id, String fullName, List<String> emails) {
        this.id = id;
        this.fullName = fullName;
        this.emails = emails;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public List<String> getEmails() {
        return new ArrayList<>(emails);
    }

    @Override
    public String toString() {
        return "PersonInmutable{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", emails=" + emails +
                '}';
    }
}
