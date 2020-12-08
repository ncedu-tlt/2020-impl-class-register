package com.netcracker.oleg.h2.chess.squares;

import com.netcracker.oleg.h2.chess.common.Location;
import com.netcracker.oleg.h2.chess.piece.AbstractPiece;

public class Square {
    private final SquareColor squareColor;
    private final Location location;
    private boolean isOccupied = false; // занятая, или нет
    private AbstractPiece currentPiece;

    public Square(SquareColor squareColor, Location location) {
        this.squareColor = squareColor;
        this.location = location;
    }

    public void reset() { // Когда фигура покидает клетку
        this.isOccupied = false;
        this.currentPiece = null;
    }

    public AbstractPiece getCurrentPiece() {
        return currentPiece;
    }

    public void setCurrentPiece(AbstractPiece currentPiece) {
        this.currentPiece = currentPiece;
        setOccupied(true);
    }

    public SquareColor getSquareColor() {
        return squareColor;
    }

    public Location getLocation() {
        return location;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }



//    @Override
//    public String toString() {
//        return "Square{" +
//                "squareColor=" + squareColor +
//                ", location=" + location +
//                ", isOccupied=" + isOccupied +
//                '}';
//    }

    @Override
    public String toString() {
        if (isOccupied) return currentPiece.toString();
        return location.getFile() + "." + location.getRank() + " ";
    }
}
