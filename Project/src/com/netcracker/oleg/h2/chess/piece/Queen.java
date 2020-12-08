package com.netcracker.oleg.h2.chess.piece;

import com.netcracker.oleg.h2.chess.board.Board;
import com.netcracker.oleg.h2.chess.common.Location;
import com.netcracker.oleg.h2.chess.squares.Square;

import java.util.ArrayList;
import java.util.List;

public class Queen extends AbstractPiece implements Movable{
    private Bishop bishop;
    private Rook rook;
    private static int check = 0;

    public Queen(PieceColor pieceColor, String file, Integer rank, Board board) {
        super(pieceColor, file, rank, board, check++);
        this.bishop = new Bishop(this.pieceColor, currentBoard);
        this.rook = new Rook(this.pieceColor, currentBoard);
        this.name = "Queen";
    }

    @Override
    public List<Location> listOfAllowedMoves() {
        List<Location> moveCandidates = new ArrayList<>();
        moveCandidates.addAll(bishop.getIndividualMoves(this.currentSquare));
        moveCandidates.addAll(rook.getIndividualMoves(this.currentSquare));
        return moveCandidates;
    }

    @Override
    public String toString() {
        return "Que ";
    }
}
