package org.rjae.antipatterns.multipleresponsibility;

import java.util.UUID;

public class User {
    private final String itsFirstName;
    private final String itsLastName;
    private final String itsEmailAddress;
    private final UUID itsId;

    public User(String firstName, String lastName, String emailAddress) {
        this(firstName, lastName, emailAddress, null);
    }

    public User(String firstName, String lastName, String emailAddress, UUID id) {
        if (firstName == null || firstName.isBlank())
            throw new IllegalArgumentException("firstName");
        if (lastName == null || lastName.isBlank())
            throw new IllegalArgumentException("lastName");
        // BUG: emailAddress allows whitespace.
        // How did this happen? Someone forgot to change this validation.
        // This is an example of misplaced responsibilities.
        if (emailAddress == null || emailAddress.isEmpty())
            throw new IllegalArgumentException("emailAddress");
        itsFirstName = firstName;
        itsLastName = lastName;
        itsEmailAddress = emailAddress;
        itsId = id == null ? UUID.randomUUID() : id;
    }

    public String getFirstName() {
        return itsFirstName;
    }

    public String getLastName() {
        return itsLastName;
    }

    public String getEmailAddress() {
        return itsEmailAddress;
    }

    public UUID getId() {
        return itsId;
    }
}
