package org.rjae.patterns.singleresponsibility;

import java.util.Objects;

public class StringBase {
    private final String itsValue;
    private final boolean itsCased;

    public StringBase(String value, boolean trimmed, boolean cased) {
        itsValue = value == null || !trimmed ? value : value.trim();
        itsCased = cased;
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof StringBase && equals((StringBase) other);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    public String getValue() {
        return itsValue;
    }

    protected boolean isCased() {
        return itsCased;
    }

    protected boolean equals(StringBase other) {
        if (other == null)
            return false;
        if (getValue() == null && other.getValue() == null)
            return true;
        if (getValue() == null || isCased() || other.isCased())
            return Objects.equals(getValue(), other.getValue());
        return getValue().equalsIgnoreCase(other.getValue());
    }
}

