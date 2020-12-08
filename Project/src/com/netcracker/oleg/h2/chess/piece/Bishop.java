package com.netcracker.oleg.h2.chess.piece;

import com.netcracker.oleg.h2.chess.board.Board;
import com.netcracker.oleg.h2.chess.common.Location;
import com.netcracker.oleg.h2.chess.common.LocationsFactory;
import com.netcracker.oleg.h2.chess.squares.Square;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Bishop extends AbstractPiece {
    private static int check = 0;

    public Bishop(PieceColor pieceColor, String file, Integer rank, Board board) {
        super(pieceColor, file, rank, board, check++);
        this.name = "Bishop";
    }

    public Bishop(PieceColor pieceColor,Board board) {
        super(pieceColor, board);
        this.name = "Bishop";
    }

    @Override
    public List<Location> listOfAllowedMoves() {
        List<Location> moveCandidates = new ArrayList<>();
        Map<Location,Square> squareMap = currentBoard.getLocationSquareMap();
        Location current = this.getCurrentSquare().getLocation();
        getAllMoves(moveCandidates, squareMap, current);
        return moveCandidates;
    }

    private void getAllMoves(List<Location> moveCandidates, Map<Location, Square> squareMap, Location current) {
        getMoves(moveCandidates, squareMap, current, 1, -1);
        getMoves(moveCandidates, squareMap, current, 1, 1);
        getMoves(moveCandidates, squareMap, current, -1, -1);
        getMoves(moveCandidates, squareMap, current, -1, 1);
    }

    private void getMoves(
            List<Location> moveCandidates,
            Map<Location, Square> squareMap,
            Location current,
            int rankOffset,
            int fileOffset) {
        try { // проверка на выход из строки
            Location next = LocationsFactory.build(current, fileOffset, rankOffset);
            while (squareMap.containsKey(next)) {
                if (squareMap.get(next).isOccupied()) {
                    PieceColor cols = squareMap.get(next).getCurrentPiece().getPieceColor();
                    if (squareMap.get(next).getCurrentPiece().pieceColor.equals(this.pieceColor)) {
                        break;
                    }
                    moveCandidates.add(next);
                    break;
                }
                moveCandidates.add(next);

                next = LocationsFactory.build(next, fileOffset, rankOffset);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }

    public List<Location> getIndividualMoves(Square square) {
        List<Location> moveCandidates = new ArrayList<>();
        Map<Location,Square> squareMap = currentBoard.getLocationSquareMap();
        Location current = square.getLocation();
        getAllMoves(moveCandidates, squareMap, current);
        return moveCandidates;
    }

    @Override
    public String toString() {
        return "Bih ";
    }
}
