package ru.job4j.ood.lsp.parking;

public class PassengerCar implements Vehicle {

    private final int size = 1;

    @Override
    public int getSize() {
        return this.size;
    }
}
