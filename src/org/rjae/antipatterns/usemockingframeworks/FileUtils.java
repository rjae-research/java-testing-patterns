package org.rjae.antipatterns.usemockingframeworks;

import java.io.File;

public class FileUtils {
    public boolean deleteFile(File file) {
        return file.delete();
    }
}
