package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void testPlayerSecond() {
        Player Elena = new Player(1, "Елена", 7);
        Player Kostya = new Player(2, "Костя", 15);

        Game game = new Game();
        game.register(Elena);
        game.register(Kostya);

        int actual = game.round("Елена", "Костя");
        int expected = 2;

        Assertions.assertEquals(expected, actual );
    }

    @Test
    public void testPlayerFirst() {
        Player Elena = new Player(1, "Елена", 16);
        Player Vika = new Player(2, "Вика", 15);

        Game game = new Game();
        game.register(Elena);
        game.register(Vika);

        int actual = game.round("Елена", "Вика");
        int expected = 1;

        Assertions.assertEquals(expected, actual );
    }

    @Test
    public void testPlayerStrengths() {
        Player Elena = new Player(1, "Елена", 15);
        Player Vika = new Player(2, "Вика", 15);

        Game game = new Game();
        game.register(Elena);
        game.register(Vika);

        int actual = game.round("Елена", "Вика");
        int expected = 0;

        Assertions.assertEquals(expected, actual );
    }

    @Test
    public void testNotPlayer() {
        Player Elena = new Player(1, "Елена", 16);

        Game game = new Game();
        game.register(Elena);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Костя", "Елена"));
    }

    @Test
    public void testNotPlayer2() {
        Player Elena = new Player(1, "Елена", 16);

        Game game = new Game();
        game.register(Elena);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Елена", "Костя"));
    }

}