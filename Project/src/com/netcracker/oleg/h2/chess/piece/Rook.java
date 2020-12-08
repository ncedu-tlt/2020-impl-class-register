package com.netcracker.oleg.h2.chess.piece;

import com.netcracker.oleg.h2.chess.board.Board;
import com.netcracker.oleg.h2.chess.common.Location;
import com.netcracker.oleg.h2.chess.common.LocationsFactory;
import com.netcracker.oleg.h2.chess.squares.Square;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Rook extends AbstractPiece {
    private static int check = 0;

    public Rook(PieceColor pieceColor, String file, Integer rank, Board board) {
        super(pieceColor, file, rank, board, check++);
        this.name = "Rook";
    }

    public Rook(PieceColor pieceColor,Board board) {
        super(pieceColor, board);
        this.name = "Rook";
    }

    @Override
    public List<Location> listOfAllowedMoves() {
        List<Location> moveCandidates = new ArrayList<>();
        Map<Location,Square> squareMap = currentBoard.getLocationSquareMap();
        Location current = this.getCurrentSquare().getLocation();
        getFileAndRank(moveCandidates, squareMap, current);
        return moveCandidates;
    }

    private void getRankCandidates(
            List<Location> moveCandidates,
            Map<Location, Square> squareMap,
            Location current,
            int offset) {
        try {
            Location next = LocationsFactory.build(current, 0, offset);
            while (squareMap.containsKey(next)) {
                if(squareMap.get(next).isOccupied()) {
                    if (squareMap.get(next).getCurrentPiece().getPieceColor().equals(this.getPieceColor())) {
                        break;
                    }
                    moveCandidates.add(next);
                    break;
                }
                moveCandidates.add(next);
                next = LocationsFactory.build(next, 0, offset);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }

    private void getFileCandidates(
            List<Location> moveCandidates,
            Map<Location, Square> squareMap,
            Location current,
            int offset) {
        try {
            Location next = LocationsFactory.build(current, offset, 0);
            while (squareMap.containsKey(next)) {
                if (squareMap.get(next).isOccupied()) {
                    if (squareMap.get(next).getCurrentPiece().getPieceColor().equals(this.getPieceColor())) {
                        break;
                    }
                    moveCandidates.add(next);
                    break;
                }
                moveCandidates.add(next);
                next = LocationsFactory.build(next, offset, 0);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }

    public List<Location> getIndividualMoves(Square square) {
        List<Location> moveCandidates = new ArrayList<>();
        Map<Location,Square> squareMap = currentBoard.getLocationSquareMap();
        Location current = square.getLocation();
        getFileAndRank(moveCandidates, squareMap, current);
        return moveCandidates;
    }

    private void getFileAndRank(List<Location> moveCandidates, Map<Location, Square> squareMap, Location current) {
        getFileCandidates(moveCandidates, squareMap, current, -1);
        getFileCandidates(moveCandidates, squareMap, current, 1);
        getRankCandidates(moveCandidates, squareMap, current, -1);
        getRankCandidates(moveCandidates, squareMap, current, 1);
    }

    @Override
    public String toString() {
        return "Rok ";
    }
}
