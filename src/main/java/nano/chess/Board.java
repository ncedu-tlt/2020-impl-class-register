package nano.chess;

import nano.chess.figures.*;

public class Board {
    
    public final static AbstractFigure[][] CELLS = new AbstractFigure[8][8];

    public Board() {
        addFiguresOnBoard();
    }

    public void printBoard() {
        char[] letters = new char[] {'a', 'b', 's', 'd', 'e', 'f', 'g', 'h'};
        for (int y = CELLS.length - 1; y >= 0; y--) {
            System.out.print(letters[y] + " ");
            for (int x = 0; x < CELLS[y].length; x++) {
                if (CELLS[x][y] == null) {
                    System.out.print("[ ] ");
                } else {
                    System.out.print(CELLS[x][y] + " ");
                }
            }
            System.out.println();
        }
        System.out.print("   ");
        for (int i = 1; i <= CELLS.length; i++) {
            System.out.print(i + "   ");
        }
        System.out.println();
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

    public void printListOfAllowedMoves() {
        for (int y = 0; y < CELLS.length; y++) {
            for (int x = 0; x < CELLS[y].length; x++) {
                for (int i = 0; i < CELLS.length; i++) {
                    for (int j = 0; j < CELLS[i].length; j++) {
                        if (CELLS[x][y].move(i + 1, j + 1, CELLS[i][j])) {
                            System.out.println(CELLS[x][y].listOfAllowedMoves(i + 1, j + 1, CELLS[i][j]));
                        }
                    }
                }
            }
        }
    }
}
