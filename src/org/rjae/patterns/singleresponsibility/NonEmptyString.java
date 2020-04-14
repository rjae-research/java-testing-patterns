package org.rjae.patterns.singleresponsibility;

public class NonEmptyString extends StringBase {
    public NonEmptyString(String value) {
        this(value, true);
    }

    public NonEmptyString(String value, boolean trimmed) {
        this(value, trimmed, true);
    }

    public NonEmptyString(String value, boolean trimmed, boolean cased) {
        super(value, trimmed, cased);
        if (getValue() == null || getValue().length() == 0) {
            throw new IllegalArgumentException("value cannot be null");
        }
    }
}

