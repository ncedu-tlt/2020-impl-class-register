package com.netcracker.oleg.h2.chess.common;

public class LocationsFactory {
    private static final File[] files = File.values();
    public static Location build(Location current, Integer fileOffset, Integer rackOffset) throws ArrayIndexOutOfBoundsException {
        Integer currentFile = current.getFile().ordinal(); // получаем номер конкретного Enum'a
        return new Location(files[currentFile + fileOffset], current.getRank() + rackOffset); // новая позиция
    }
}
