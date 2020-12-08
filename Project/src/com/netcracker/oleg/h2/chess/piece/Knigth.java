package com.netcracker.oleg.h2.chess.piece;

import com.netcracker.oleg.h2.chess.board.Board;
import com.netcracker.oleg.h2.chess.common.Location;
import com.netcracker.oleg.h2.chess.common.LocationsFactory;
import com.netcracker.oleg.h2.chess.squares.Square;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Knigth extends AbstractPiece {
    private static int check = 0;
    private static final Integer MINUS_ONE = -1;
    private static final Integer PLUS_ONE = 1;
    private static final Integer MINUS_TWO = -2;
    private static final Integer PLUS_TWO = 2;

    public Knigth(PieceColor pieceColor, String file, Integer rank, Board board) {
        super(pieceColor, file, rank, board, check++);
        this.name = "Knight";
    }

    @Override
    public List<Location> listOfAllowedMoves() {
        List<Location> moveCandidates = new ArrayList<>();
        Map<Location,Square> squareMap = currentBoard.getLocationSquareMap();
        Location current = this.getCurrentSquare().getLocation();

        getMoves(moveCandidates, squareMap, current, PLUS_TWO, MINUS_ONE);
        getMoves(moveCandidates, squareMap, current, PLUS_TWO, PLUS_ONE);
        getMoves(moveCandidates, squareMap, current, MINUS_TWO, MINUS_ONE);
        getMoves(moveCandidates, squareMap, current, MINUS_TWO, PLUS_ONE);
        getMoves(moveCandidates, squareMap, current, PLUS_ONE, MINUS_TWO);
        getMoves(moveCandidates, squareMap, current, PLUS_ONE, PLUS_TWO);
        getMoves(moveCandidates, squareMap, current, MINUS_ONE, MINUS_TWO);
        getMoves(moveCandidates, squareMap, current, MINUS_ONE, PLUS_TWO);

        return moveCandidates;
    }

    private void getMoves(
            List<Location> moveCandidates,
            Map<Location, Square> squareMap,
            Location current,
            int rankOffset,
            int fileOffset) {
        try {
            Location next = LocationsFactory.build(current, fileOffset, rankOffset);
            if (squareMap.containsKey(next)) {
                if(squareMap.get(next).isOccupied()) {
                    if (squareMap.get(next).getCurrentPiece().pieceColor.equals(this.pieceColor)) return;
                    moveCandidates.add(next);
                    return;
                }
                moveCandidates.add(next);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }

    @Override
    public String toString() {
        return "Kni ";
    }
}
