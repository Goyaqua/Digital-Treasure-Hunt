# Digital Treasure Hunt - CENG211 Homework #2

## Overview
This Java application implements a Digital Treasure Hunt game based on a 20x20 map. Each cell on the map contains an instance of `MapItem`, which can be either a player, a booster (Coin, Diamond, Treasure), or a breaker (Mushroom, Frog). The game progresses as the player moves randomly across the map, interacting with various objects to either gain or lose points and lives.

## Features
- **Dynamic Map Generation:** The map is populated with different items at random positions.
- **Player Interactions:** Players can collect boosters to increase their points or lives and must avoid breakers that decrease their stats.
- **Score Tracking:** The game tracks the player's score, updating it based on the interactions on the map.
- **End Game Conditions:** The game ends when the player runs out of lives or points.
- **Scoreboard Output:** At the end of the game, the scoreboard is output to a TXT file.

## Classes and Hierarchy
- `MapItem`: Base class for all items on the map.
- `Player`, `Booster`, `Breaker`: Subclasses of `MapItem`, each with specific behaviors and properties.
- `Map`: Holds the game's map structure and logic for player movement and item placement.

