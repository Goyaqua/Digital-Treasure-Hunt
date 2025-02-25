package data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileIO {
    private String filePath;

    // No-argument constructor
    public FileIO() { //we can use this constructor on scoreboard class
        this.filePath = "score.txt";
    }

    // Full-argument constructor
    public FileIO(String filePath) {
        this.filePath = filePath;
    }

    // Copy constructor
    public FileIO(FileIO other) {
        this.filePath = other.filePath;
    }

    // Method to create a new file if it doesn't exist
    public boolean createFile() {   //we can use this method on scoreboard class
        File file = new File(filePath);
        try {
            if (file.createNewFile()) {
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            System.err.println("Error creating file: " + e.getMessage());
            return false;
        }
    }


    public void writeStringListToFile(ArrayList<String> contentList) {
        try (FileWriter writer = new FileWriter(filePath)) { // Overwrite mode
            for (String content : contentList) {
                writer.write(content + System.lineSeparator()); // Write each entry on a new line
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Getter and Setter
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    // toString method
    @Override
    public String toString() {
        return "FileIO{" +
                "filePath='" + filePath + '\'' +
                '}';
    }
}