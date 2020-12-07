package nano.chess.figures;

import java.util.List;

public abstract class AbstractFigure {

    private final Color color;
    private int x;
    private int y;

    public AbstractFigure(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return color.name().charAt(0) + getClass().getSimpleName().substring(0, 2);
    }

    public abstract boolean move(int x, int y, AbstractFigure cell);

    public abstract List<String> listOfAllowedMoves();
}
