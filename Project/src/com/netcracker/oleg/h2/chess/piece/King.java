package com.netcracker.oleg.h2.chess.piece;

import com.netcracker.oleg.h2.chess.board.Board;
import com.netcracker.oleg.h2.chess.common.Location;
import com.netcracker.oleg.h2.chess.squares.Square;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class King extends AbstractPiece {
    private static int check = 0;
    private Bishop bishop;
    private Rook rook;

    public King(PieceColor pieceColor, String file, Integer rank, Board board) {
        super(pieceColor, file, rank, board, check++);
        this.name = "King";
        this.bishop = new Bishop(this.pieceColor, currentBoard);
        this.rook = new Rook(this.pieceColor, currentBoard);
    }

    @Override
    public List<Location> listOfAllowedMoves() {
        List<Location> moveCandidates = new ArrayList<>();
        moveCandidates.addAll(bishop.getIndividualMoves(this.currentSquare));
        moveCandidates.addAll(rook.getIndividualMoves(this.currentSquare));
        Location current = this.getCurrentSquare().getLocation();

        return moveCandidates.stream() //возвращаю оставшиеся возможные ходы вокруг короля
                .filter(candidates -> (
                        Math.abs(candidates.getFile().ordinal() - current.getFile().ordinal()) <= 1 &&
                                Math.abs(candidates.getRank() - current.getRank()) <= 1))
                .collect(Collectors.toList());
    }


    @Override
    public String toString() {
        return "Kin ";
    }
}
