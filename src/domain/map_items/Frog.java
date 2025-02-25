package domain.map_items;

import domain.MapPosition;

public class Frog extends Breaker {

    private int effectLives;

    // No-argument constructor
    public Frog() {
        super(new MapPosition(0, 0, true), "F", false);
        this.effectLives = -1;
    }

    // Full-argument constructor
    public Frog(MapPosition position) {
        super(position, "F", false);
        this.effectLives = -1;
    }

    // Copy constructor
    public Frog(Frog other) {
        super(new MapPosition(other.getPosition()), other.getSymbol(), other.isTraced());
        this.effectLives = other.effectLives;
    }

    @Override
    public void interaction(Player player){
        if (player.getLives() < effectLives) {
            player.setLives(0);
        } else {
            player.setLives(player.getLives() + effectLives);
        }
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
        return "Frog [position=" + getPosition().toString() + ", effectLives=" + effectLives + ", symbol=" + this.getSymbol() + "]";
    }

    // equals method
    public boolean equals(Frog other) {
        if (other == null) return false;
        return this.getPosition().equals(other.getPosition()) && this.effectLives == other.effectLives && this.getSymbol().equals(other.getSymbol());
    }

}

