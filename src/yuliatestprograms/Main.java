package yuliatestprograms;

import java.io.*;

public class Main {

    public static void main(String[] args) {

    }

    public static void copyDirectory(String source, String destination) {
        File sourceDirectory = new File(source);
        File destDirectory = new File(destination);

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

