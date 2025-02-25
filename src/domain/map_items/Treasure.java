package domain.map_items;

import domain.MapPosition;

public class Treasure extends Booster {

    private int effectLives;

    // No-argument constructor
    public Treasure() {
        super(new MapPosition(0, 0, true), "T", false);
        this.effectLives = 1;
    }

    // Full-argument constructor
    public Treasure(MapPosition position) {
        super(position, "T", false);
        this.effectLives = 1;
    }

    // Copy constructor
    public Treasure(Treasure other) {
        super(new MapPosition(other.getPosition()), other.getSymbol(), other.isTraced());
        this.effectLives = other.effectLives;
    }

    @Override
    public void interaction(Player player){
        player.setLives(player.getLives() + effectLives);
    }

    // Getter for effectLives
    public int getEffectLives() {
        return effectLives;
    }

    // Setter for effectLives
    public void setEffectLives(int effectLives) {
        this.effectLives = effectLives;
    }

    // toString method
    @Override
    public String toString() {
        return "Treasure [position=" + getPosition().toString() + ", effectLives=" + effectLives + ", symbol=" + this.getSymbol() + "]";
    }

    public boolean equals(Treasure other) {
        if (other == null) return false;
        return this.getPosition().equals(other.getPosition()) && this.effectLives == other.effectLives && this.getSymbol().equals(other.getSymbol());
    }
}

