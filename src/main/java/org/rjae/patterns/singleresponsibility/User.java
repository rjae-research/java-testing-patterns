package org.rjae.patterns.singleresponsibility;

import java.util.UUID;

import static java.util.Objects.requireNonNull;

public class User {
    private final NonEmptyString itsFirstName;
    private final NonEmptyString itsLastName;
    private final EmailAddress itsEmailAddress;
    private final UUID itsId;

    public User(NonEmptyString firstName, NonEmptyString lastName, EmailAddress emailAddress) {
        this(firstName, lastName, emailAddress, null);
    }

    public User(NonEmptyString firstName, NonEmptyString lastName, EmailAddress emailAddress, UUID id) {
        itsFirstName = requireNonNull(firstName);
        itsLastName = requireNonNull(lastName);
        itsEmailAddress = requireNonNull(emailAddress);
        itsId = id == null ? UUID.randomUUID() : id;
    }

    public NonEmptyString getFirstName() {
        return itsFirstName;
    }

    public NonEmptyString getLastName() {
        return itsLastName;
    }

    public EmailAddress getEmailAddress() {
        return itsEmailAddress;
    }

    public UUID getId() {
        return itsId;
    }
}
