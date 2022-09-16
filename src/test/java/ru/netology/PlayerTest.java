package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfSomeGames() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Game1", "Аркады");
        Game game2 = store.publishGame("Game2", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.play(game1, 3);
        player.play(game2, 4);

        int expected = 7;
        int actual = player.sumGenre(game1.getGenre() + game2.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSeeMostPlayerByGenre() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Game1", "Аркады");
        Game game2 = store.publishGame("Game2", "Аркады");
        Game game3 = store.publishGame("Game3", "Стратегия");


        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.play(game1, 3);
        player.play(game2, 4);
        player.play(game3, 2);
        player.mostPlayerByGenre("Аркады");


        String expected = "Game2";
        String actual = player.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSeeMostPlayerByGenreIfGameNotPlayed() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Game1", "Аркады");
        Game game2 = store.publishGame("Game2", "Аркады");
        Game game3 = store.publishGame("Game3", "Стратегия");


        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.play(game1, 3);
        player.play(game2, 4);
        player.mostPlayerByGenre("Стратегии");


        String expected = null;
        String actual = player.getName();
        assertEquals(expected, actual);
    }
}

