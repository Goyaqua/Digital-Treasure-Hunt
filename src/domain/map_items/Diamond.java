package domain.map_items;

import domain.MapPosition;

public class Diamond extends Booster {

    private int effectPoints;

     // No-argument constructor
    public Diamond() {
        super(new MapPosition(0, 0, true), "D", false);
        this.effectPoints = 10;
    }

    // Full-argument constructor
    public Diamond(MapPosition position) {
        super(position, "D", false);
        this.effectPoints = 10;
    }

    // Copy constructor
    public Diamond(Diamond other) {
        super(new MapPosition(other.getPosition()), other.getSymbol(), other.isTraced());
        this.effectPoints = other.effectPoints;
    }

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
        return "Diamond [position=" + getPosition().toString() + ", effectPoints=" + effectPoints + ", symbol=" + this.getSymbol() + "]";
    }

    // equals method
    public boolean equals(Diamond other) {
        if (other == null) return false;
        return this.getPosition().equals(other.getPosition()) && this.effectPoints == other.effectPoints && this.getSymbol().equals(other.getSymbol());
    }

}

