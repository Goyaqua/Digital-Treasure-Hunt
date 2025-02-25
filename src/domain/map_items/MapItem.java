package domain.map_items;

import domain.MapPosition;

public class MapItem {

    private String symbol;
    private MapPosition position;
    private boolean isTraced;

    // No-argument constructor
    public MapItem() {
        this.symbol = "_";
        this.position = new MapPosition(0, 0, false);
        this.isTraced = false;
    }

    // Full-argument constructor
    public MapItem(MapPosition position, String symbol, boolean isTraced) {
        this.setPosition(position);
        this.symbol = symbol;
        this.isTraced = isTraced;
    }

    // Copy constructor
    public MapItem(MapItem other) {
        this.setPosition(other.getPosition());
        this.symbol = other.symbol;
        this.isTraced = other.isTraced;
    }

    public void interaction(Player player) {
        player.setScore(player.getScore().getPoint());
    }

    public boolean checkOccupancy() {
        return this.position.isOccupied();
    }

    // Getters and Setters
    // it is not a deep copy because we use the exact MapPostition object somewhere else
    public MapPosition getPosition() {
        return this.position;
    }

    // it is not a deep copy because we use the exact MapPostition object somewhere else
    public void setPosition(MapPosition position) {
        this.position = position;
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean isTraced() {
        return isTraced;
    }

    public void setTraced(boolean traced) {
        isTraced = traced;
    }

    @Override
    public String toString() {
        return "MapItem{" +
        "position=" + position.toString() + ", symbol='" + symbol + '\'' +
        '}';
    }

    // equals method
    public boolean equals(MapItem other) {
        if (other == null) return false;
        return this.position.equals(other.position) && this.symbol.equals(other.symbol) && this.getClass().equals(other.getClass());
    }
}

