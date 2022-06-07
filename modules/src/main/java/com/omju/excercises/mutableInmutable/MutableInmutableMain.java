package com.omju.excercises.mutableInmutable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MutableInmutableMain {
    public static void main(String[] args) {
        try {
            PersonMutable personMutable = new PersonMutable();
            personMutable.setId(12345);
            personMutable.setFullName("Omar Juarez");

            List<String> emails = new LinkedList<>();
            emails.add("omarmju@mail.com");
            personMutable.setEmails(emails);

            // Clean all existent mails and add new mails.
            System.out.println(personMutable.toString());
            badIntentionalMethod(personMutable);
            System.out.println(personMutable.toString());

            System.out.println(personMutable.toString());
            badMethod(personMutable);
            System.out.println(personMutable.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void badIntentionalMethod(PersonMutable personMutable) {
        List<String> emails = personMutable.getEmails();
        emails.clear();
        emails.add("some_spammy_mail@mail.com");
    }

    private static void badMethod(PersonMutable personMutable) {
        List<String> emails = new ArrayList<>();
        emails.add("spammy_mail@mail.com");
        personMutable.setEmails(emails);
    }
}
