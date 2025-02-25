package domain.map_items;

import domain.MapPosition;

public class Mushroom extends Breaker {

    private int effectPoints;

    // No-argument constructor
    public Mushroom() {
        super(new MapPosition(0, 0, true), "M", false);
        this.effectPoints = -20;
    }

    // Full-argument constructor
    public Mushroom(MapPosition position) {
        super(position, "M", false);
        this.effectPoints = -20;
    }

    // Copy constructor
    public Mushroom(Mushroom other) {
        super(new MapPosition(other.getPosition()), other.getSymbol(), other.isTraced());
        this.effectPoints = other.effectPoints;
    }

    @Override
    public void interaction(Player player){
        if (player.getScore().getPoint() < effectPoints) {
            player.setScore(0);
        } else {
            player.setScore(player.getScore().getPoint() + effectPoints);
        }
    }

    // Getter for effectPoints
    public int getEffectPoints() {
        return effectPoints;
    }

    // Setter for effectPoints
    public void setEffectPoints(int effectPoints) {
        this.effectPoints = effectPoints;
    }

    // toString method
    @Override
    public String toString() {
        return "Mushroom [position=" + getPosition().toString() + ", effectPoints=" + effectPoints + ", symbol=" + this.getSymbol() + "]";
    }

    public boolean equals(Mushroom other) {
        if (other == null) return false;
        return this.getPosition().equals(other.getPosition()) && this.effectPoints == other.effectPoints && this.getSymbol().equals(other.getSymbol());
    }
}

