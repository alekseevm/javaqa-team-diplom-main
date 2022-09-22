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
    public void shouldSumGenreIfOneGame0() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 0);

        int expected = 0;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfOneGameRPG() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 0;
        int actual = player.sumGenre("РПГ");
        assertEquals(expected, actual);
    }



    @Test
    public void shouldPlayRuntimeException() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");

        assertThrows(RuntimeException.class, () -> {
            player.play(game, 2);
        });

    }

    @Test
    public void shouldMostPlayerByGenre() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Name1");
        player.installGame(game);
        player.play(game, 3);

        Game expected = game;
        Game actual = player.mostPlayerByGenre("Аркады");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMostPlayerByGenreNull() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Name1");
        player.installGame(game);
        player.play(game, 0);

        Game expected = null;
        Game actual = player.mostPlayerByGenre("Аркады");
        assertEquals(expected, actual);

    }


}

