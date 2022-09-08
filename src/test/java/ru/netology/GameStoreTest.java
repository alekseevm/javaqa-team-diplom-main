package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GameStoreTest {

    @Test
    public void shouldContainOneGame() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Roblox", "arcade");

        Assertions.assertTrue(store.containsGame(game1));
    }

    @Test
    public void shouldNotContainOneGame() {
        GameStore store = new GameStore();
        Game game1 = new Game("GTA", "action", store);

        Assertions.assertFalse(store.containsGame(game1));
    }

   @Test
    public void shouldAddTheSameGameTwice() {
        GameStore store = new GameStore();
        store.publishGame("Roblox", "arcade");
        store.publishGame("Roblox", "arcade");

        List<Game> expected = new ArrayList<>();
        List<Game> actual = store.getGames();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotContainTheGame() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Roblox", "arcade");
        Game game2 = new Game("The Sims", "strategy", store);

        Assertions.assertFalse(store.containsGame(game2));
    }

    @Test
    public void shouldBeEmpty() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Roblox", "arcade");

        Assertions.assertFalse(store.containsGame(game1));
    }

    @Test
    public void shouldGetOneMostPlayer() {
        GameStore store = new GameStore();

        store.addPlayTime("Petya", 34);
        store.addPlayTime("Irina", 2);
        store.addPlayTime("Simon", 15);
        store.addPlayTime("Liza", 121);

        String expected = "Liza";
        String actual = store.getMostPlayer();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetSeveralMostPlayers() {
        GameStore store = new GameStore();

        store.addPlayTime("Petya", 34);
        store.addPlayTime("Irina", 2);
        store.addPlayTime("Simon", 121);
        store.addPlayTime("Liza", 121);

        String[] expected = {"Liza", "Simon"};
        String actual = store.getMostPlayer();

        Assertions.assertTrue(expected.equals(actual));
    }

    @Test
    public void shouldGetMostPlayerWhenNoPlayers() {
        GameStore store = new GameStore();

        String expected = null;
        String actual = store.getMostPlayer();

        assertNull(actual);
    }

    @Test
    public void shouldAddNormalPlayTime() {
        GameStore store = new GameStore();

        store.addPlayTime("Irina", 37);

        String expected = "Irina";
        String actual = store.getMostPlayer();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAddZeroPlayTime() {
        GameStore store = new GameStore();

        store.addPlayTime("Petya", 0);

        String expected = null;
        String actual = store.getMostPlayer();

        assertNull(actual);
    }

    @Test
    public void shouldAddNegativePlayTime() {
        GameStore store = new GameStore();

        store.addPlayTime("Liza", -11);

        String expected = null;
        String actual = store.getMostPlayer();

        assertNull(actual);
    }

    @Test
    public void shouldAddNewPlayedTimeToThePrevious() {
        GameStore store = new GameStore();

        store.addPlayTime("Simon", 9);
        store.addPlayTime("Simon", 18);
        store.addPlayTime("Irina", 26);

        String expected = "Simon";
        String actual = store.getMostPlayer();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetSumPlayedTimeIfNoPlayers() {
        GameStore store = new GameStore();

        int expected = 0;
        int actual = store.getSumPlayedTime();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetSumPlayedTimeIfOneAboveZero() {
        GameStore store = new GameStore();

        store.addPlayTime("Petya", 34);
        store.addPlayTime("Irina", 0);
        store.addPlayTime("Simon", 0);
        store.addPlayTime("Liza", 0);

        int expected = 34;
        int actual = store.getSumPlayedTime();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetSumPlayedTimeIfAllAboveZero() {
        GameStore store = new GameStore();

        store.addPlayTime("Petya", 56);
        store.addPlayTime("Irina", 789);
        store.addPlayTime("Simon", 23);

        int expected = 868;
        int actual = store.getSumPlayedTime();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetSumPlayedTimeIfAllHaveZeroHours() {
        GameStore store = new GameStore();

        store.addPlayTime("Petya", 0);
        store.addPlayTime("Irina", 0);
        store.addPlayTime("Simon", 0);

        int expected = 0;
        int actual = store.getSumPlayedTime();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetSumPlayedTimeIfOnePlayer() {
        GameStore store = new GameStore();

        store.addPlayTime("Liza", 87);

        int expected = 87;
        int actual = store.getSumPlayedTime();

        Assertions.assertEquals(expected, actual);
    }
}
