package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.PlayerData;
import ru.netology.exception.NotRegisteredException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameManagerTest {
    GameManager manager = new GameManager();
    PlayerData playerOne = new PlayerData(1, "Николай-мастер", 100);
    PlayerData playerTwo = new PlayerData(2, "Кирилл", 90);
    PlayerData playerThree = new PlayerData(3, "Петр", 90);

    @BeforeEach
    void setup() {
        manager.register(playerOne);
        manager.register(playerTwo);
        manager.register(playerThree);
    }

    @Test
    void shouldFirstPlayerWin() {
        assertEquals(1, manager.round("Николай-мастер", "Кирилл"));
    }

    @Test
    void shouldSecondPlayerWin() {
        assertEquals(2, manager.round("Кирилл", "Николай-мастер"));
    }

    @Test
    void shouldDraw() {
        assertEquals(0, manager.round("Петр", "Кирилл"));
    }

    @Test
    void shouldThrowNotRegisteredExceptionOne() {
        assertThrows(NotRegisteredException.class, () -> {
            manager.round("Николай-мастер", "Виталий");
        });
    }

    @Test
    void shouldThrowNotRegisteredExceptionTwo() {
        assertThrows(NotRegisteredException.class, () -> {
            manager.round("Виталий", "Николай-мастер");
        });
    }
}