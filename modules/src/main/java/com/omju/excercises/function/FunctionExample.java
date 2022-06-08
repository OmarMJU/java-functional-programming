package com.omju.excercises.function;

import com.omju.excercises.mutableInmutable.PersonInmutable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        List<String> emails = new ArrayList<>();
        emails.add("omarmju@mail.com");
        emails.add("omauri.guitar09@mail.com");
        emails.add("omarmju906p@mail.com");
        PersonInmutable personInmutable = new PersonInmutable(123458, "Omar Juarez", emails);

        // Function interface implementation through an anonymous class.
        Function<PersonInmutable, List<String>> getEmailsList = new Function<PersonInmutable, List<String>>() {
            @Override
            public List<String> apply(PersonInmutable personInmutable) {
                if (personInmutable.getId() == 123456) {
                    return personInmutable.getEmails();
                }

                return null;
            }
        };

        // Function interface implementation through a lambda function.
        Function<PersonInmutable, List<String>> getEmailsListLambda = personInmutable1 -> {
            if (personInmutable1.getId() == 123456) {
                return personInmutable1.getEmails();
            }

            return null;
        };

        System.out.println(getEmailsList.apply(personInmutable));
        System.out.println(getEmailsListLambda.apply(personInmutable));
    }
}