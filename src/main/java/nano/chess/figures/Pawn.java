package nano.chess.figures;

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
    public List<String> listOfAllowedMoves() {
        return null;
    }
}
