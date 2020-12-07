package nano.chess.figures;

import java.util.List;

public class Bishop extends AbstractFigure {

    public Bishop(Color color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public boolean move(int x, int y, AbstractFigure cell) {
        return false;
    }

    @Override
    public List<String> listOfAllowedMoves() {
        return null;
    }
}
