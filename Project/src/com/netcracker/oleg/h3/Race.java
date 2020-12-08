package com.netcracker.oleg.h3;

import com.netcracker.oleg.h3.cars.Car;
import com.netcracker.oleg.h3.random.Randomizer;
import com.netcracker.oleg.h3.road.Road;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


public class Race {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        int numOfCar = Randomizer.getNumOfCar();
        Road road = new Road();

        System.out.println("Our road: " + road.getRoad());

        final CyclicBarrier gate = new CyclicBarrier(numOfCar);

        for (int i = 0; i < numOfCar; i++) {
            Car c = new Car("Name" + i, road);
            c.start();
            System.out.println("Car driver : " + c.getName());
        }

// At this point, threads are blocking on the gate.
// Since we gave "3" as the argument, gate is not opened yet.
// Now if we block on the gate from the main thread, it will open
// and all threads will start to do stuff!

        //gate.await();
        System.out.println("Race is started!");
    }
}
