package ru.job4j.ood.lsp.parking;

public class Truck implements Vehicle {

    private int size;

    public Truck(int size) {
        this.size = size;
        if (size <= PassengerCar.CAR_SIZE) {
            throw new IllegalArgumentException("Truck must take more than 1 slot");
        }
    }

    @Override
    public int getSize() {
        return this.size;
    }
}
