package nano.chess.pieces.interfaces;

import java.util.List;

public interface ChessPiece {

    boolean checkMove(int x, int y);

    List<String> listOfAllowedMoves();
}
