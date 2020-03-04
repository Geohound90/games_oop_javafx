package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Ryudo
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (isDiagonal(source, dest)) {
            int size = Math.abs(dest.y - source.y);
            Cell[] steps = new Cell[size];
            int deltaX = 1;
            int deltaY = 1;
            for (int index = 0; index < size; index++) {
                if (source.x > dest.x && source.y > dest.y) {
                    steps[index] = Cell.findBy(source.x - index - deltaX, source.y - index - deltaY);
                } else if (source.x > dest.x && source.y < dest.y) {
                    steps[index] = Cell.findBy(source.x - index - deltaX, source.y + index + deltaY);
                } else if (source.x < dest.x && source.y > dest.y) {
                    steps[index] = Cell.findBy(source.x + index + deltaX, source.y - index - deltaY);
                } else {
                    steps[index] = Cell.findBy(source.x + index + deltaX, source.y + index + deltaY);
                }
            }
            return steps;
        } else {
            Cell[] steps = new Cell[0];
            return steps;
            /*throw new IllegalStateException(
                    String.format("Could not way by diagonal from %s to %s", source, dest)
            );*/
        }
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean rsl = false;
        if (Math.abs(dest.x - source.x) == (Math.abs(dest.y - source.y))) {
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
