package presentation;

import domain.Map;
import domain.Scoreboard;
import domain.map_items.Player;

public class Game {
    public static void main(String[] args) throws Exception {
        Game game = new Game();
        Map map = new Map();
        Player player = game.createPlayer(map);
        System.out.println(player.getClass());
        Scoreboard scoreboard = new Scoreboard();
        game.playGame(map, player, scoreboard);
        scoreboard.writeScoreFile();
    }

    // creates the player for the a single game
    private Player createPlayer(Map map) {
        Player player = new Player();
        int x = map.generateRandomAndUnoccupiedCoordinates()[0];
        int y = map.generateRandomAndUnoccupiedCoordinates()[1];
        map.addMapItem(player, x, y);
        return player;
    }

    private void playGame(Map map, Player player, Scoreboard scoreboard) {
        // print the initial map
        map.printMap(player);
        while (player.getLives() > 0 && player.getScore().getPoint() > 0 && !map.isEveryItemTraced()) {
            
            // move the player if the game is not over
            player.movePlayer(map);
            int playerX = player.getPosition().getX();
            int playerY = player.getPosition().getY();
            
            // make the player interact with the map item if it is not traced
            map.getMap().get(playerX).get(playerY).interaction(player);

            // print the map after each move
            map.printMap(player);

            // update the scoreboard
            scoreboard.addScore(player.getScore());

            // print the score and map after each move
            System.out.println(player.getScore().toString());
            System.out.println(player.getLives() + " lives left.");
        }

        // say why the game ended
        if (player.getLives() == 0) {
            System.out.println("Game over! You ran out of lives.");
        } else if (player.getScore().getPoint() == 0) {
            System.out.println("Game over! You ran out of points.");
        } else if (map.isEveryItemTraced()) {
            System.out.println("Game over! You traced all the positions.");
        }

        // print the final max score
        System.out.println("Your maximum score in the game is " + player.getScore().getMaxPoint());
    }
}
