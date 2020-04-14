package org.rjae.patterns.usecustommocks;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileUtilsTests {
    @Test
    void deleteFileMustReturnFalseWhenFileDoesNotExist() {
        assertFalse(new FileUtils().deleteFile(new MockFile("42", false)));
    }

    @Test
    void deleteFileMustReturnTrueWhenFileExists() {
        assertTrue(new FileUtils().deleteFile(new MockFile("42", true)));
    }

    private class MockFile extends File {
        Boolean itsExists;

        public MockFile(String pathname, Boolean exists) {
            super(pathname);
            itsExists = exists;
        }

        @Override
        public boolean delete() {
            return itsExists;
        }
    }
}
