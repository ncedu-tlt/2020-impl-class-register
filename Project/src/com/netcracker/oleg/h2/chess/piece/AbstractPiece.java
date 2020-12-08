package com.netcracker.oleg.h2.chess.piece;

import com.netcracker.oleg.h2.chess.board.Board;
import com.netcracker.oleg.h2.chess.common.File;
import com.netcracker.oleg.h2.chess.common.Location;
import com.netcracker.oleg.h2.chess.squares.Square;

import java.util.List;
import java.util.Map;

public abstract class AbstractPiece implements Movable {
    protected String name;
    protected PieceColor pieceColor;
    protected Square currentSquare;
    protected Board currentBoard;

    public AbstractPiece(PieceColor pieceColor, String file, Integer rank, Board board, int check) {
        try {
            checkOnAnExcess(check);
            this.pieceColor = pieceColor;
            this.currentBoard = board;
            currentBoard.addOnTheBoard(file, rank, this);
        } catch (Exception e) {
            System.out.println("you can't do it!");
        }
    }

    public AbstractPiece(PieceColor pieceColor, Board board) {
        this.pieceColor = pieceColor;
        this.currentBoard = board;
    }

    public String getName() {
        return name;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public Square getCurrentSquare() {
        return currentSquare;
    }

    public void setCurrentSquare(Square currentSquare) {
        this.currentSquare = currentSquare;
    }

    public void setCurrentBoard(Board currentBoard) {
        this.currentBoard = currentBoard;
    }

    @Override
    public boolean checkMove(String file, Integer rank) {
        List<Location> validMoves = listOfAllowedMoves();
        Map<Location,Square> squareMap = currentBoard.getLocationSquareMap();
        Location current = this.getCurrentSquare().getLocation();
        Location wantedLoc = new Location(File.valueOf(file), rank);

        if(validMoves.contains(wantedLoc)) {
            Square wantedSquare = squareMap.get(wantedLoc); //   to
            Square currSquare = squareMap.get(current); //   from

            currSquare.reset();   //clear old square
            squareMap.put(current, currSquare);

            wantedSquare.setCurrentPiece(this);   //update new square
            this.setCurrentSquare(wantedSquare);
            squareMap.put(wantedLoc, wantedSquare);

            return true;
        }
        return false;
    }

    protected void checkOnAnExcess(int check) throws Exception {
        if (check < 2) {
            check++;
        } else {
            throw new Exception();
        }
    }

    @Override
    public String toString() {
        return "AbstractPiece{" +
                "name='" + name + '\'' +
                ", pieceColor=" + pieceColor +
                ", currentSquare=" + currentSquare +
                '}';
    }
}
