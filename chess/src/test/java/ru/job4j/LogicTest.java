package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.Logic;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LogicTest {
    @Test
    public void positionTest() {
        Figure bishop = new BishopBlack(Cell.C1);
        Logic rsl = new Logic();
        rsl.add(bishop);
        boolean result = rsl.move(Cell.E1, Cell.G5);
        assertThat(result, is(false));
    }

}
