package ru.job4j.ood.lsp.parking.park;

import ru.job4j.ood.lsp.parking.Vehicle;

public class JustParking implements Parking {

    private int carCapacity;

    private int truckCapacity;

    public JustParking(int carCapacity, int truckCapacity) {
        this.carCapacity = carCapacity;
        this.truckCapacity = truckCapacity;
    }

    @Override
    public boolean store(Vehicle vehicle) {
        int vehiicleSize = vehicle.getSize();
        if (vehiicleSize > 1 && truckCapacity > 0) {
            truckCapacity--;
            return true;
        } else if (vehiicleSize > 1 && truckCapacity == 0 && carCapacity >= vehiicleSize) {
            carCapacity -= vehiicleSize;
            return true;
        } else if (carCapacity - vehiicleSize >= 0) {
            return true;
        }
        return false;
    }

}
