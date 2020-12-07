package nano.chess.pieces;

import nano.chess.pieces.enums.Color;
import nano.chess.pieces.interfaces.ChessPiece;

public abstract class AbstractPiece implements ChessPiece {

    private final Color color;
    private int x;
    private int y;

    public AbstractPiece(Color color, int x, int y) {
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
}
