package org.rjae.antipatterns.usemockingframeworks;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class FileUtilsTests {
    @Test
    void deleteFileMustReturnFalseWhenFileDoesNotExist() {
        File mockFile = mock(File.class);
        Mockito.when(mockFile.delete()).thenReturn(false);
        assertFalse(new FileUtils().deleteFile(mockFile));
    }

    @Test
    void deleteFileMustReturnTrueWhenFileExists() {
        File mockFile = mock(File.class);
        Mockito.when(mockFile.delete()).thenReturn(true);
        assertTrue(new FileUtils().deleteFile(mockFile));
    }
}
