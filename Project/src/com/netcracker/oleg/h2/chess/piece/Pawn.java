package com.netcracker.oleg.h2.chess.piece;

import com.netcracker.oleg.h2.chess.board.Board;
import com.netcracker.oleg.h2.chess.common.Location;
import com.netcracker.oleg.h2.chess.common.LocationsFactory;
import com.netcracker.oleg.h2.chess.squares.Square;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Pawn extends AbstractPiece { //пешка
    private boolean isFirstMove = true;
    private static int check = 0;

    public Pawn(PieceColor pieceColor, String file, Integer rank, Board board) {
        super(pieceColor, file, rank, board, check++);
        this.name = "Pawn";
    }

    @Override
    public List<Location> listOfAllowedMoves() {
        List<Location> moveCandidates = new ArrayList<>();
        Location current = this.getCurrentSquare().getLocation();

        try {  // check for out of Bounds
            if(isFirstMove) {
                moveCandidates.add(LocationsFactory
                        .build(current, 0, 2));
            }
            moveCandidates.add(LocationsFactory.build(current, 0, 1));
            moveCandidates.add(LocationsFactory.build(current, 1, 1));
            moveCandidates.add(LocationsFactory.build(current, -1, 1));
        } catch (ArrayIndexOutOfBoundsException e) {
        }

        Map<Location, Square> squareMap = currentBoard.getLocationSquareMap();
        //проверка на валидность
        List<Location> validMoves = moveCandidates.stream()
                .filter(squareMap::containsKey)
                .collect(Collectors.toList());

//        int g = 0;
//        for (Location candidate : validMoves) {
//            if (!candidate.getFile().equals(this.getCurrentSquare().getLocation().getFile()) &&
//                    !squareMap.get(candidate).isOccupied()) {
//                g++;
//            }
//            try {
//                if (!squareMap.get(candidate).getCurrentPiece().getPieceColor().equals(this.getPieceColor())) {
//                    g++;
//                }
//            } catch (NullPointerException e) {
//                g++;
//            }
//        }

        return validMoves.stream().filter((candidate) -> {
            if (!candidate.getFile().equals(this.getCurrentSquare().getLocation().getFile()) &&
                    !squareMap.get(candidate).isOccupied()) {
                return false;
            }
            try {
                return !squareMap.get(candidate).getCurrentPiece().getPieceColor().equals(this.getPieceColor());
            } catch (NullPointerException e) {
                return true;
            }
        }).collect(Collectors.toList());
    }

    @Override
    protected void checkOnAnExcess(int check) throws Exception {
        if (check < 8) {
            check++;
        } else {
            throw new Exception();
        }
    }

    @Override
    public String toString() {
        return "Paw ";
    }
}
