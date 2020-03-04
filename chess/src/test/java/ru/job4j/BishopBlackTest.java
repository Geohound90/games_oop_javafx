package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopBlackTest {
    @Test
    public void positionTest() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Cell rsl = bishop.position();
        Cell expected = Cell.C1;
        assertThat(rsl, is(expected));
    }

    @Test
    public void copyTest() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Figure copy = bishop.copy(Cell.G5);
        Cell rsl = copy.position();
        Cell expected = Cell.G5;
        assertThat(rsl, is(expected));
    }

    @Test
    public void wayTest() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Cell[] rsl = bishop.way(Cell.C1, Cell.G5);
        Cell[] expected = new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(rsl, is(expected));
    }

    @Test
    public void diagonalTest() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        boolean rsl = bishop.isDiagonal(Cell.C1, Cell.G6);
        assertThat(rsl, is(false));
    }
}
