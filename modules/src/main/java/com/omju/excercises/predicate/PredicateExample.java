package com.omju.excercises.predicate;

import com.omju.excercises.mutableInmutable.PersonInmutable;
import java.util.function.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * Example class for a Predicate package.
 */
public class PredicateExample {
    public static void main(String[] args) {
        // Predicate Interface implementation through an anonymous class.
        List<String> emails = new ArrayList<>();
        emails.add("omarmju@mail.com");
        emails.add("omauri.guitar09@mail.com");
        emails.add("omarmju906p@mail.com");
        PersonInmutable personInmutable = new PersonInmutable(12345, "Omar Juarez", emails);

        Predicate<PersonInmutable> hasEmails = new Predicate<PersonInmutable>() {
            @Override
            public boolean test(PersonInmutable personInmutable) {
                return !personInmutable.getEmails().isEmpty();
            }
        };

        System.out.println("The person " + personInmutable.getFullName() + " has emails? "  + hasEmails.test(personInmutable));


        // Predicate Interface implementation through a lambda function.
        PersonInmutable personInmutable1 = new PersonInmutable(987654, "Danny Zam", new ArrayList<>());
        Predicate<PersonInmutable> hasEmails1 = person -> !person.getEmails().isEmpty();
        System.out.println("The person " + personInmutable1.getFullName() + " has emails? " + hasEmails1.test(personInmutable1));
    }
}