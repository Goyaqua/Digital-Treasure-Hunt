package domain;

public class MapPosition {
    private int x;
    private int y;
    private boolean occupied;
    private boolean traced;

    // No-argument constructor
    public MapPosition() {
        this.x = 0;
        this.y = 0;
        this.occupied = false;
    }

    // Full-argument constructor
    public MapPosition(int x, int y, boolean occupied) {
        this.x = x;
        this.y = y;
        this.occupied = occupied;
    }

    // Copy constructor
    public MapPosition(MapPosition other) {
        this.x = other.x;
        this.y = other.y;
        this.occupied = other.occupied;
    }

    // Getters and Setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}
