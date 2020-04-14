package org.rjae.patterns.singleresponsibility;

public class EmailAddress extends NonEmptyString {
    public EmailAddress(String value) {
        super(value);
        if (getValue().indexOf('@') == -1) {
            throw new IllegalArgumentException(String.format("%s is not a valid email address", value));
        }
    }
}
