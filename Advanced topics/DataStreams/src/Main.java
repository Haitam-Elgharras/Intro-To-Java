import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("############## File class ##############");
        // current path
        File file = new File("testDir");

        // check if it exists
        System.out.println("Exists: " + file.exists());

        // check if it is a directory
        System.out.println("Is directory: " + file.isDirectory());

        // get it's absolute path
        System.out.println("Absolute path: " + file.getAbsolutePath());

        // get its name
        System.out.println("Name: " + file.getName());

        System.out.println("############## List files as File objects ##############");
        // get subdirectories
        // we use the method reference here, and it accepts a file filter
        // it returns a list of file objects
        File[] subDirectories = file.listFiles(File::isDirectory);

        assert subDirectories != null;
        for (File subDirectory : subDirectories) {
            System.out.println("Subdirectory: " + subDirectory.getName());
        }

        System.out.println("############## List files as String ##############");
        // list all files and dirs in the testDir directory as a string
        String[] files = file.list();
        for (String f : files) {
            // using regex to match files that contains . in the name
            if (f.matches(".*\\..*"))
                System.out.println("File: " + f);
            else
                System.out.println("Directory: " + f);
        }

        System.out.println("############## Create new file or directory ##############");
        // create a new file
       try {
           File newFile = new File("testDir/newFile.txt");
           Files.createFile(newFile.toPath());
           System.out.println("File created"+newFile.getName());
       } catch (IOException e) {
           System.out.println("File already exists");
       }
       // or (but the first one is better)
        try {
            File newFile = new File("testDir/newFile.txt");
            if(newFile.createNewFile())
                System.out.println("File created"+newFile.getName());
            else
                System.out.println("File already exists");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("############## Delete a file ##############");
        // delete a file
        File myObj = new File("testDir/newFile.txt");
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }

        System.out.println("############## Write to a file: FileWriter ##############");
        // overwrite the existing content of the file.
        try(
                FileWriter myWriter = new FileWriter("testDir/test.txt")
        ) {
            myWriter.write("Files in Java might be tricky, but it is fun enough!");
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("############## Read from a file FileReader ##############");
        // use scanner to read from a file
        try {
            File myFile = new File("testDir/test.txt");
            Scanner myReader = new Scanner(myFile);
            System.out.println("Scanner: ");
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        // using FileReader
        try (
                FileReader fr = new FileReader("testDir/test.txt");
        ) {
            System.out.println("FileReader: ");
            int i;
            while ((i=fr.read()) != -1)
                System.out.print((char) i);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("############## Write to a file BufferedWriter ##############");
        // overwrite the existing content of the file.
        try (
                FileWriter fw=new FileWriter("testDir/test.txt");
                BufferedWriter writer = new BufferedWriter(fw);
        ) {
            writer.write("Files in Java might be tricky, but it is fun enough!");
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("############## Read from a file BufferedReader ##############");

        try (
                FileReader fr = new FileReader("testDir/test.txt");
                BufferedReader reader = new BufferedReader(fr);
        ) {
            System.out.println("BufferedReader: ");
            String line;
            while ((line = reader.readLine()) != null)
                System.out.println(line);

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        System.out.println("############## BufferedOutputStream and BufferedInputStream ##############");
        // BufferedOutputStream: writes an array of bytes to the underlying output stream.
        // BufferedInputStream: reads an array of bytes from the underlying input stream.
        String sourceFilePath = "testDir/test.txt";
        String destinationFilePath = "testDir/test2.txt";

        try (
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFilePath));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFilePath))
        ) {
            byte[] buffer = new byte[4096]; // You can adjust the buffer size as needed

            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) // Read until EOF
                bos.write(buffer, 0, bytesRead);

            System.out.println("File copied successfully!");
        } catch (IOException e) {
            System.err.println("An error occurred during file copy: " + e.getMessage());
        }
    }
}