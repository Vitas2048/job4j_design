package ru.job4j.ood.lsp.parking.park;

import ru.job4j.ood.lsp.parking.Vehicle;

public class ThreeSlotParking implements Parking {

    @Override
    public boolean store(Vehicle vehicle) {
        return false;
    }

    @Override
    public boolean remove(Vehicle vehicle) {
        return false;
    }
}
