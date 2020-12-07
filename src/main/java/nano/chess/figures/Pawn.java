package nano.chess.figures;

import nano.chess.Board;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractFigure {

    final boolean up;
    private boolean firstStep = true;

    public Pawn(Color color, int x, int y) {
        super(color, x, y);
        up = y == 7;
    }

    @Override
    public boolean move(int x, int y, AbstractFigure cell) {
        if (up) {
            if (firstStep) {
                firstStep = false;
                return ((getX() == x) && (getY() - 1 == y)) ||
                        ((getX() == x) && (getY() - 2 == y));
            } else {
                return (getX() == x) && (getY() - 1 == y);
            }
        } else {
            if (firstStep) {
                firstStep = false;
                return ((getX() == x) && (getY() + 1 == y)) ||
                        ((getX() == x) && (getY() + 2 == y));
            } else {
                return (getX() == x) && (getY() + 1 == y);
            }
        }
    }

    @Override
    public String listOfAllowedMoves(int x, int y, AbstractFigure cell) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < Board.CELLS.length; i++) {
            for (int j = 0; j < Board.CELLS[i].length; j++) {
                if (move(i + 1, i + 2, Board.CELLS[i][j])) {
                    list.add(toString() + " (" + x + ", " + y + ");");
                }
            }
        }
        return list;
    }
}
