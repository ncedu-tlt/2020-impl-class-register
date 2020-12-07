package nano.chess.figures;

import java.util.List;

public class King extends AbstractFigure {

    public King(Color color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public boolean move(int x, int y, AbstractFigure cell) {
        return false;
    }

    @Override
    public String listOfAllowedMoves(int x, int y, AbstractFigure cell) {
        return null;
    }
}