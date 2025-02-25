package domain.map_items;

import domain.MapPosition;
import java.util.ArrayList;

public class Booster extends MapItem {

    private ArrayList<MapItem> items;

    // No-argument constructor
    public Booster() {
        super(new MapPosition(0, 0, true), "O", false);
        this.items = new ArrayList<>();
    }

    // Full-argument constructor
    public Booster(MapPosition position, String symbol, boolean traced) {
        super(position, symbol, traced);
        this.items = new ArrayList<>();
    }

    public Booster(MapPosition position) {
        super(position, "O", false);
        this.items = new ArrayList<>();
    }

    // Copy constructor
    public Booster(Booster other) {
        super(new MapPosition(other.getPosition()), other.getSymbol(), other.isTraced());
        this.setItems(other.getItems());
    }

    //overriding the interaction method for booster arraylist
    @Override
    public void interaction(Player player) {
        for (MapItem item : items) {
            item.interaction(player);
        }
    }

    // Getters and Setters
    public ArrayList<MapItem> getItems() {
        ArrayList<MapItem> deepCopy = new ArrayList<>();
        for (MapItem item : this.items) {
            deepCopy.add(new MapItem(item));
        }
        return deepCopy;
    }

    public void setItems(ArrayList<MapItem> items) {
        ArrayList<MapItem> deepCopy = new ArrayList<>();
        for (MapItem item : items) {
            deepCopy.add(new MapItem(item));
        }
        this.items = deepCopy;
    }

    // toString method
    // ITEM STRING PROBLEMİ
    @Override
    public String toString() {
        return "Booster{" +
                "symbol='" + this.getSymbol() + '\'' +
                ", items=" + items +
                ", position=" + getPosition().toString() +
                '}';
    }

    // equals method
    public boolean equals(Booster other) {
        if (other == null) return false;
        return this.getPosition().equals(other.getPosition()) && this.items.equals(other.items) && this.getSymbol().equals(other.getSymbol());
    }
}

