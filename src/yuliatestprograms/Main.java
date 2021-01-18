package yuliatestprograms;

import java.io.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {

    }

    public static void copyDirectory(File sourceDirectory, File destDirectory) {

        if (!destDirectory.exists()) {
            destDirectory.mkdir();
            System.out.println("Directory " + destDirectory.getAbsolutePath()
                    + " has been created");
        }

        String sourceFiles [] = sourceDirectory.list();

        for (String file: sourceFiles) {
        File sourceFile = new File(sourceDirectory, file);
        File destFile = new File(destDirectory, file);

            if (sourceFile.isDirectory()) {
                copyDirectory(sourceFile, destFile);
            }
            else copyFile(sourceFile, destFile);
        }


    }


    public static void copyFile(File source, File destination) {
        try (InputStream sourceStream = new FileInputStream(source);
             OutputStream destStream = new FileOutputStream(destination);
        ) {
            byte[] buffer = new byte[1024];
            int count = 0;
            while ((count = sourceStream.read(buffer)) > 0) {
                destStream.write(buffer, 0, count);
            }
            System.out.println("File " + source.getAbsolutePath()
                    + " was copied to " + destination.getAbsolutePath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

