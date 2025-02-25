package domain.map_items;

import domain.MapPosition;

public class Coin extends Booster {

    private int effectPoints;

    // No-argument constructor
    public Coin() {
        super(new MapPosition(0, 0, true), "C", false);
        this.effectPoints = 5;
    }

    // Full-argument constructor
    public Coin(MapPosition position) {
        super(position, "C", false);
        this.effectPoints = 5;
    }

    // Copy constructor
    public Coin(Coin other) {
        super(new MapPosition(other.getPosition()), other.getSymbol(), other.isTraced());
        this.effectPoints = other.effectPoints;
    }

    //interaction method for coin
    @Override
    public void interaction(Player player){
        player.setScore(player.getScore().getPoint() + effectPoints);
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
        return "Coin [position=" + getPosition().toString() + ", effectPoints=" + effectPoints + ", symbol=" + this.getSymbol() + "]";
    }

    // equals method
    public boolean equals(Coin other) {
        if (other == null) return false;
        return this.getPosition().equals(other.getPosition()) && this.effectPoints == other.effectPoints && this.getSymbol().equals(other.getSymbol());
    }
}

