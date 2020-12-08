package com.netcracker.oleg.h2.chess.main;

import com.netcracker.oleg.h2.chess.board.Board;
import com.netcracker.oleg.h2.chess.common.Location;
import com.netcracker.oleg.h2.chess.piece.*;


//  hit another figure - done
//  unallowed coordinates - done
//  all figures are movable - done
//  set on a board - done

public class Game {
    public static void main(String[] args) {
        PieceColor d = PieceColor.DARK;
        PieceColor w = PieceColor.WHITE;

        Board board = new Board();

        AbstractPiece bishopW = new Bishop(w, "A", 1, board);
        AbstractPiece pawnW = new Pawn(w, "B", 1, board);
        AbstractPiece kingW = new King(w, "C", 1, board);
        AbstractPiece knightW = new Knigth(w, "D", 1, board);
        AbstractPiece queenW = new Queen(w, "E", 1, board);
        AbstractPiece rookW = new Rook(d, "F", 1, board);



        AbstractPiece kingD = new King(d, "D", 6, board);


        {//  all figures are movable and return true hods
            board.printBoard();

//            showAllStrokes(board, pawnW);
//            showAllStrokes(board, bishopW);
//            showAllStrokes(board, kingW);
//            showAllStrokes(board, kingD);
//            showAllStrokes(board, knightW);
//            showAllStrokes(board, queenW);
            showAllStrokes(board, rookW);
        }
    }

    public static void showAllStrokes(Board b, AbstractPiece piece) {
        System.out.println("For " + piece.getName() + " : ");
        for (Location l : piece.listOfAllowedMoves()) {
            System.out.println("x:" + l.getFile() + " y:" +l.getRank());
        }
        System.out.println();
    }

}
