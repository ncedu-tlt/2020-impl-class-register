package com.netcracker.oleg.h2.chess.piece;

import com.netcracker.oleg.h2.chess.common.Location;

import java.util.List;

public interface Movable {
    List<Location> listOfAllowedMoves();
    boolean checkMove(String file, Integer rank);
}
