package com.omju.excercises.mutableInmutable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MutableInmutableMain {
    public static void main(String[] args) {
        try {
            /*
              Example 1 for a mutable object.
             */
            PersonMutable personMutable = new PersonMutable();
            personMutable.setFullName("Omar Juarez");
            personMutable.setId(12345);

            List<String> emails = new LinkedList<>();
            emails.add("omarmju@mail.com");
            personMutable.setEmails(emails);

            // Clean all existent mails and add new mails.
            System.out.println(personMutable);
            badMethod(personMutable);
            System.out.println(personMutable);

            /*
              Example 2 for a mutable object.
             */
            List<String> emails2 = new ArrayList<>();
            emails2.add("nanamavis@mail.com");

            PersonMutable2 personMutable2 = new PersonMutable2(emails2);
            personMutable2.setFullName("Nany Zam");
            personMutable2.setId(98765);

            System.out.println(personMutable2);
            badIntentionalMethod(personMutable2);
            System.out.println(personMutable2);

            /*
            Example 3 for a mutable object.
             */
            List<String> emails3 = new ArrayList<>();
            emails3.add("some_email@mail.com");

            PersonMutable3 personMutable3 = new PersonMutable3(emails3);
            personMutable3.setFullName("Some name");
            personMutable3.setId(45698);

            System.out.println(personMutable3);
            badMutableFinalEmails(personMutable3);
            System.out.println(personMutable3);

            /*
            Example for a inmutable object.
             */
            List<String> emailsInmutable = new ArrayList<>();
            emailsInmutable.add("some_inmutable_email@email.com");
            PersonInmutable personInmutable = new PersonInmutable(95454, "Person Inmutable", emailsInmutable);

            System.out.println(personInmutable);
            badIntentionalMethodP2(personInmutable);
            System.out.println(personInmutable);
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

    private static void badIntentionalMethodP2(PersonInmutable personInmutable2) {
        List<String> emails = personInmutable2.getEmails();
        emails.clear();
        emails.add("some_spammy_mail_2@mail.com");
    }

    private static void badMutableFinalEmails(PersonMutable3 personMutable3) {
        List<String> spammyEmails = new ArrayList<>();
        spammyEmails.add("spammy_email1@mail.com");
        spammyEmails.add("spammy_email2@mail.com");
        spammyEmails.add("spammy_email3@mail.com");
        spammyEmails.add("spammy_email4@mail.com");

        List<String> emails = personMutable3.getEmails();
        emails.clear();

        emails.addAll(spammyEmails);
    }
}
