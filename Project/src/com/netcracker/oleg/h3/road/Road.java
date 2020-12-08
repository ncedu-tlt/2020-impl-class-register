package com.netcracker.oleg.h3.road;

import com.netcracker.oleg.h3.random.Randomizer;

import java.util.ArrayList;
import java.util.Collections;

public class Road {
    private ArrayList<Integer> road;
    private int numOfGrunts;

    public Road() {
        buildARoad();
    }

    private void buildARoad() {
        numOfGrunts = Randomizer.getNumOfPriming();
        road = new ArrayList<>();

        for (int i = 0; i < Randomizer.getCountOfKm(); i++) {
            road.add(Randomizer.getIntBySelf(numOfGrunts));
        }
        Collections.shuffle(road);
    }

    public int getNumOfGrunts() {
        return numOfGrunts;
    }

    public ArrayList<Integer> getRoad() {
        return road;
    }

}
