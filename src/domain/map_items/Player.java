package domain.map_items;

import domain.Map;
import domain.MapPosition;
import domain.Score;
import java.util.Random;

public class Player extends MapItem {

    private Score score;
    private int lives;

    // No-argument constructor
    public Player() {
        super(new MapPosition(0, 0, false), "P", true);
        this.score = new Score(100);
        this.lives = 2;
    }

    // Full-argument constructor
    public Player(MapPosition position) {
        super(position, "P", true);
        this.score.setPoint(100);
        this.lives = 2;
    }

    // Copy constructor
    public Player(Player other) {
        super(new MapPosition(other.getPosition()), other.getSymbol(), other.isTraced());
        this.score = new Score(other.getScore());
        this.lives = other.lives;
    }

    // Method to move the player
    public void movePlayer(Map map) {
        int x = generateRandomAndUntracedCoordinates(map)[0];
        int y = generateRandomAndUntracedCoordinates(map)[1];
        this.getPosition().setX(x);
        this.getPosition().setY(y);
        map.getMapItem(x,y).setTraced(true);
        System.out.println("Player moved to " + x + ", " + y);
    }

    // Method to generate random coordinates
    private int[] generateRandomAndUntracedCoordinates(Map map) {
        Random random = new Random();
        int x = random.nextInt(20);
        int y = random.nextInt(20);
        while (map.getMapItem(x,y).isTraced()) {
            x = random.nextInt(20);
            y = random.nextInt(20);
        }
        return new int[]{x, y};
    }

    // Getters and Setters
    // It is not a deep copy because we use the exact same score object somewhere else
    public Score getScore() {
        return this.score;
    }
    
    public void setScore(int points) {
        this.score.setPoint(points);
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        if (lives < 0) {
            this.lives = 0;
        } else {
            this.lives = lives;
        }
    }

    // toString method
    @Override
    public String toString() {
        return "Player [position=" + getPosition().toString() + ", points=" + getScore().toString() + ", lives=" + lives + ", symbol=" + this.getSymbol() + "]";
    }

    // equals method
    public boolean equals(Player other) {
        if (other == null) return false;
        return this.getPosition().equals(other.getPosition()) && this.score.equals(other.getScore()) && this.lives == other.lives && this.getSymbol().equals(other.getSymbol());
    }
}

