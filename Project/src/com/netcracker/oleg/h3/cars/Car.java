package com.netcracker.oleg.h3.cars;

import com.netcracker.oleg.h3.random.Randomizer;
import com.netcracker.oleg.h3.road.Road;

import java.util.HashMap;
import java.util.Map;

public class Car extends Thread {
    protected static int num;
    private final Road road;
    private final long startTime = System.currentTimeMillis();

    public Map<Integer, Integer> getTypesOfRoads() {
        return typesOfRoads;
    }

    private final Map<Integer, Integer> typesOfRoads = new HashMap<>();

    public Car(String name, Road road) throws InterruptedException {
        super(name);
        this.road = road;
        setRoadTypesTime();
    }

    public void run() {
        for (Integer i : road.getRoad()) {
            try {
                sleep(typesOfRoads.get(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        sayDone(this);
    }

    private void setRoadTypesTime() {
        for (int i = 1; i < road.getNumOfGrunts() + 1; i++) {
            typesOfRoads.put(i, Randomizer.getCountOfSec());
        }
    }

    private synchronized void sayDone(Car c) {
        num++;
        if (num < 4) {
            System.out.println(
                    c.getName() + " comes " + num + "!"
                    + " Time : " + (System.currentTimeMillis() - startTime)/1000 + " sec!"
                    + " List of parts road: " + this.getTypesOfRoads() + " mills!"
            );
        }
    }
}


