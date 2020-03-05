package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.black.PawnBlack;

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

    @Test
    public void whenWayDontFreeTest() {
        Figure bishop = new BishopBlack(Cell.C1);
        Figure pawn = new PawnBlack(Cell.D2);
        Logic rsl = new Logic();
        rsl.add(bishop);
        rsl.add(pawn);
        boolean result = rsl.move(Cell.C1, Cell.G5);
        assertThat(result, is(false));
    }
    @Test
    public void whenDestDontFreeTest() {
        Figure bishop = new BishopBlack(Cell.C1);
        Figure pawn = new PawnBlack(Cell.G5);
        Logic rsl = new Logic();
        rsl.add(bishop);
        rsl.add(pawn);
        boolean result = rsl.move(Cell.C1, Cell.G5);
        assertThat(result, is(false));
    }

    @Test
    public void whenStepIsZeroTest() {
        Figure bishop = new BishopBlack(Cell.C1);
        Logic rsl = new Logic();
        rsl.add(bishop);
        boolean result = rsl.move(Cell.C1, Cell.C1);
        assertThat(result, is(false));
    }
}
