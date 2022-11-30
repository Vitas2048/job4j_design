package ru.job4j.ood.lsp.parking;

public class PassengerCar implements Vehicle {

    public static final int CAR_SIZE = 1;

    @Override
    public int getSize() {
        return CAR_SIZE;
    }
}
