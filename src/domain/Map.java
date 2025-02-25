package domain;

import domain.map_items.*;
import java.util.ArrayList;
import java.util.Random;

public class Map {
    private ArrayList<ArrayList<MapItem>> map;

    // No-argument constructor
    public Map() {
        this.map = createEmptyMap();
        createAndAddMapItems();
    }

    // Full-argument constructor
    public Map(ArrayList<ArrayList<MapItem>> map) {
        this.setMap(map);
    }

    // Copy constructor
    public Map(Map other) {
        this.map = new ArrayList<>();
        for (ArrayList<MapItem> row : other.map) {
            ArrayList<MapItem> newRow = new ArrayList<>(row.size());
            for (MapItem item : row) {
                newRow.add(item);
            }
            this.map.add(newRow);
        }
    }

    // Method to create a map
    // We use it to initialize the map with MapItems
    private ArrayList<ArrayList<MapItem>> createEmptyMap() {
        ArrayList<ArrayList<MapItem>> newMap = new ArrayList<>(20);
        for (int i = 0; i < 20; i++) {
            ArrayList<MapItem> row = new ArrayList<>(20);
            for (int j = 0; j < 20; j++) {
                row.add(new MapItem(new MapPosition(i, j, false),"_", false));
            }
            newMap.add(row);
        }
        return newMap;
    }

    // Method to create and add MapItems to the map
    private void createAndAddMapItems(){

        //create and add 1 Booster
        int x= generateRandomAndUnoccupiedCoordinates()[0];
        int y = generateRandomAndUnoccupiedCoordinates()[1];
        Booster booster = new Booster(getMapPosition(x, y));
        addMapItem(booster, x, y);
        ArrayList<MapItem> boosterArray = new ArrayList<>();
        boosterArray.add(new Diamond(new MapPosition(x,y,false)));
        boosterArray.add(new Coin(new MapPosition(x,y,false)));
        boosterArray.add(new Treasure(new MapPosition(x,y,false)));
        booster.setItems(boosterArray);
        
        
        //create and add 1 Breaker
        x = generateRandomAndUnoccupiedCoordinates()[0];
        y = generateRandomAndUnoccupiedCoordinates()[1];
        Breaker breaker = new Breaker(getMapPosition(x, y));
        addMapItem(breaker, x, y);
        ArrayList<MapItem> breakerArray = new ArrayList<>();
        breakerArray.add(new Frog(new MapPosition(x,y,false)));
        breakerArray.add(new Mushroom(new MapPosition(x,y,false)));
        breaker.setItems(breakerArray);

        // create and add 10 Coins
        for (int i = 0; i < 10; i++) {
            x = generateRandomAndUnoccupiedCoordinates()[0];
            y = generateRandomAndUnoccupiedCoordinates()[1];
            addMapItem(new Coin(getMapPosition(x, y)), x, y);
        }

        // create and add 5 Diamonds
        for (int i = 0; i < 5; i++) {
            x = generateRandomAndUnoccupiedCoordinates()[0];
            y = generateRandomAndUnoccupiedCoordinates()[1];
            addMapItem(new Diamond(getMapPosition(x, y)), x, y);
        }

        // create and add 2 Treasures
        for (int i = 0; i < 2; i++) {
            x = generateRandomAndUnoccupiedCoordinates()[0];
            y = generateRandomAndUnoccupiedCoordinates()[1];
            addMapItem(new Treasure(getMapPosition(x, y)), x, y);
        }

        // create and add 5 Mushrooms
        for (int i = 0; i < 5; i++) {
            x = generateRandomAndUnoccupiedCoordinates()[0];
            y = generateRandomAndUnoccupiedCoordinates()[1];
            addMapItem(new Mushroom(getMapPosition(x, y)), x, y);
        }

        // create and add 2 Frogs
        for (int i = 0; i < 2; i++) {
            x = generateRandomAndUnoccupiedCoordinates()[0];
            y = generateRandomAndUnoccupiedCoordinates()[1];
            addMapItem(new Frog(getMapPosition(x, y)), x, y);
        }
    }

    // Method to generate random and unoccupied coordinates for the map items
    public int[] generateRandomAndUnoccupiedCoordinates() {
        Random random = new Random();
        int x = random.nextInt(20);
        int y = random.nextInt(20);
        while (checkOccupancy(x, y)){
            x = random.nextInt(20);
            y = random.nextInt(20);
        }
        return new int[]{x, y};
    }

    // Method to add a MapItem to the map
    // to the given position, row=x, column=y
    public void addMapItem(MapItem item, int x, int y) {
        if (item.getClass() == Player.class) {
            this.map.get(x).set(y, item);
            this.map.get(x).get(y).getPosition().setOccupied(true);
            return;
        }
        if (!this.checkOccupancy(x, y)) {
            this.map.get(x).set(y, item);
            this.map.get(x).get(y).getPosition().setOccupied(true);
        } else {
            System.out.println("The position is already occupied!");
        }
    }

    public boolean checkOccupancy(int x, int y) {
        return this.map.get(x).get(y).checkOccupancy();
    }

    public void printMap(Player player) {
        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 20; j++) {
                if (i == player.getPosition().getX() && j == player.getPosition().getY()) {
                    System.out.print("P ");
                } else if (this.map.get(i).get(j).getSymbol() == "P"){
                    System.out.print("_ ");
                } else{
                    System.out.print(this.map.get(i).get(j).getSymbol() + " ");
                }
            }
            System.out.println();
        }
    }

    // Method to check if every position is traced
    public boolean isEveryItemTraced() {
        // assume every item is traced
        boolean isTraced = true;
        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 20; j++) {
                if (!checkTrace(i, j)) {
                    // if an item is not traced, then the assumption is wrong
                    isTraced = false;
                }
            }
        }
        return isTraced;
    }

    private boolean checkTrace(int x, int y) {
        return this.map.get(x).get(y).isTraced();
    }

    // Getters and Setters
    // It is not a deep copy because we use the exact same map somewhere else
    public ArrayList<ArrayList<MapItem>> getMap() {
        return this.map;
    }

    public void setMap(ArrayList<ArrayList<MapItem>> map) {
        this.map = map;
    }

    public MapPosition getMapPosition(int x, int y) {
        return this.map.get(x).get(y).getPosition();
    }

    public MapItem getMapItem(int x, int y) {
        return this.map.get(x).get(y);
    }
}