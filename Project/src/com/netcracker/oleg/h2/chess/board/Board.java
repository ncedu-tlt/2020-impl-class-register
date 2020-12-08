package com.netcracker.oleg.h2.chess.board;

import com.netcracker.oleg.h2.chess.common.File;
import com.netcracker.oleg.h2.chess.common.Location;
import com.netcracker.oleg.h2.chess.piece.AbstractPiece;
import com.netcracker.oleg.h2.chess.piece.Movable;
import com.netcracker.oleg.h2.chess.squares.Square;
import com.netcracker.oleg.h2.chess.squares.SquareColor;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private static final Integer BOARD_LENGTH = 8; // константа, чтобы убрать волшебные числа, и для перестановки чисел
    private final Map<Location,Square> locationSquareMap;

    Square[][] boardSquares = new Square[BOARD_LENGTH][BOARD_LENGTH]; // клеточки
    public Board() { // инициализация доски
        locationSquareMap = new HashMap<>();
        for (int i = 0; i < boardSquares.length; i++) {
            int column = 0;
            //определяем цвет
            SquareColor currentColor = (i % 2 == 0) ? SquareColor.LIGHT : SquareColor.DARK;
            for(File file : File.values()) { // итерируемся по строке и заполнем её клетками
                Square newSquare = new Square(currentColor, new Location(file, BOARD_LENGTH - i));
                locationSquareMap.put(newSquare.getLocation(), newSquare);
                boardSquares[i][column] = newSquare;
                currentColor = (currentColor == SquareColor.DARK) ? SquareColor.LIGHT : SquareColor.DARK; // смена цвета
                column++; // переход на след колонку
            }
        }
    }

    public boolean addOnTheBoard(String x, int y, AbstractPiece piece) { //("B", 2);
        try {
            Location curr = new Location(File.valueOf(x), y);
            if (locationSquareMap.containsKey(curr)) {
                Square s = locationSquareMap.get(curr);
                s.reset();
                s.setCurrentPiece(piece);
                piece.setCurrentBoard(this);
                piece.setCurrentSquare(s);
                return true;
            }
            throw new IllegalArgumentException();
        }
        catch (IllegalArgumentException e) {
            System.out.println("Wrong coordinates");
        }
        return false;
    }

    public Map<Location, Square> getLocationSquareMap() {
        return locationSquareMap;
    }

    public void printBoard() { // вывод доски
        for (Square[] row : boardSquares) {
            for (Square square : row) {
                System.out.print(square);
            }
            System.out.println();
        }
    }
}

