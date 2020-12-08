package com.netcracker.oleg.h3.random;

import java.security.SecureRandom;

public class Randomizer {
    public static SecureRandom randomiz = new SecureRandom(); // more random values
    //secureRandom

    public static int getNumOfCar() { return randomiz.nextInt(4) + 4; } // from 4 to 8

    public static int getCountOfSec() { return (randomiz.nextInt(2000) + 10) ;} // from 500 to 5000 seconds

    public static int getCountOfKm() { return (randomiz.nextInt(25) + 20);} // from 8 to 16

    public static int getIntBySelf(int i) { return randomiz.nextInt(i) + 1;} // personal int

    public static int getNumOfPriming() {
        return randomiz.nextInt(7) + 5;
    } // from 1 to 10
}
