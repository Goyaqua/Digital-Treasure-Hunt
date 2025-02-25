package domain;

import data.FileIO;
import java.util.ArrayList;

// Scoreboard class to store scores and update the score file
public class Scoreboard {
    // Attributes
    private ArrayList<Score> scores;
    private FileIO file;

    // Constructor
    //this constructor creates a new arraylist for scores and
    //a new fileio object to use file operations
    public Scoreboard() {
        scores = new ArrayList<>();
        file = new FileIO();
    }

    // Method to add a score to arraylist scores
    public void addScore(Score score) {
        this.scores.add(new Score(score));
    }

    // Method to convert scores to a arraylist of strings
    // to update the file with the new scores
    private ArrayList<String> convertScoresToStringList() {
        ArrayList<String> contentList = new ArrayList<>();
        for (int i = 0; i < scores.size(); i++) {
            contentList.add("After " + i + "." + " move: "+ scores.get(i).toString());
        }
        return contentList;
    }

    // Method to update the score file
    // this method writes the scores arraylist that became string to the file
    // using the writeStringListToFile method from fileio class
    public void writeScoreFile() {
        ArrayList<String> scoreList = convertScoresToStringList();
        file.writeStringListToFile(scoreList);
    }

    // Method to print scores to the console using scores arraylist
    public void printScores() {
        System.out.println("Scores:");
        for (int i = 0; i < scores.size(); i++) {
            System.out.println("Score after " + i + ". " + " move: "+ scores.get(i).toString());
        }
    }
    
    // Getters and Setters of scores arraylist
    public ArrayList<Score> getScores() {
        return scores = new ArrayList<>(scores);
    }

    public void setScores(ArrayList<Score> scores) {
        this.scores = new ArrayList<>(scores);
    }

}

