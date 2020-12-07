package nano.chess;

import nano.chess.figures.*;

public class Board {
    
    private final static AbstractFigure[][] CELLS = new AbstractFigure[8][8];

    public Board() {
        addFiguresOnBoard();
    }

    public void printBoard() {
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (CELLS[x][y] == null) {
                    empty();
                } else {
                    busy(x, y);
                }
            }
            System.out.println();
        }
    }

    private void empty() {
        System.out.print("[ ] ");
    }

    private void busy(int x, int y) {
        System.out.print(CELLS[x][y] + " ");
    }

    private void addFiguresOnBoard() {
        try {
            AbstractFigure[] figures = new AbstractFigure[32];
            figures[0] = new Rook(Color.WHITE, 1, 1);
            figures[1] = new Knight(Color.WHITE, 2, 1);
            figures[2] = new Bishop(Color.WHITE, 3, 1);
            figures[3] = new Queen(Color.WHITE, 4, 1);
            figures[4] = new King(Color.WHITE, 5, 1);
            figures[5] = new Bishop(Color.WHITE, 6, 1);
            figures[6] = new Knight(Color.WHITE, 7, 1);
            figures[7] = new Rook(Color.WHITE, 8, 1);
            for (int i = 8; i < 16; i++) {
                figures[i] = new Pawn(Color.WHITE, i - 7, 2);
            }

            figures[16] = new Rook(Color.BLACK, 1, 8);
            figures[17] = new Knight(Color.BLACK, 2, 8);
            figures[18] = new Bishop(Color.BLACK, 3, 8);
            figures[19] = new Queen(Color.BLACK, 4, 8);
            figures[20] = new King(Color.BLACK, 5, 8);
            figures[21] = new Bishop(Color.BLACK, 6, 8);
            figures[22] = new Knight(Color.BLACK, 7, 8);
            figures[23] = new Rook(Color.BLACK, 8, 8);
            for (int i = 24; i < 32; i++) {
                figures[i] = new Pawn(Color.BLACK, i - 23, 7);
            }

            for (int i = 0; i < 8; i++) {
                CELLS[i][0] = figures[i];
            }
            for (int i = 8; i < 16; i++) {
                CELLS[i - 8][1] = figures[i];
            }
            for (int i = 16; i < 24; i++) {
                CELLS[i - 16][7] = figures[i];
            }
            for (int i = 24; i < 32; i++) {
                CELLS[i - 24][6] = figures[i];
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Лишняя фигура");
        }
    }
}
