package com.omju.excercises.mutableInmutable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MutableInmutableMain {
    public static void main(String[] args) {
        try {
            /**
             * Example 1 for a mutable object.
             */
            PersonMutable personMutable = new PersonMutable();
            personMutable.setFullName("Omar Juarez");
            personMutable.setId(12345);

            List<String> emails = new LinkedList<>();
            emails.add("omarmju@mail.com");
            personMutable.setEmails(emails);

            // Clean all existent mails and add new mails.
            System.out.println(personMutable.toString());
            badMethod(personMutable);
            System.out.println(personMutable.toString());

            /**
             * Example 2 for a mutable object.
             */
            List<String> emails2 = new ArrayList<>();
            emails2.add("nanamavis@mail.com");

            PersonMutable2 personMutable2 = new PersonMutable2(emails2);
            personMutable2.setFullName("Nany Zam");
            personMutable2.setId(98765);

            System.out.println(personMutable2.toString());
            badIntentionalMethod(personMutable2);
            System.out.println(personMutable2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void badMethod(PersonMutable personMutable) {
        List<String> emails = new ArrayList<>();
        emails.add("spammy_mail@mail.com");
        personMutable.setEmails(emails);
    }

    private static void badIntentionalMethod(PersonMutable2 personMutable2) {
        List<String> emails = personMutable2.getEmails();
        emails.clear();
        emails.add("some_spammy_mail_2@mail.com");
    }
}
