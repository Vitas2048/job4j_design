package ru.job4j.ood.lsp.parking.park;

import ru.job4j.ood.lsp.parking.PassengerCar;
import ru.job4j.ood.lsp.parking.Truck;
import ru.job4j.ood.lsp.parking.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class JustParking implements Parking {

    private int carCapacity;

    private int truckCapacity;

    private List<Vehicle> trucks;

    private List<Vehicle> cars;

    public JustParking(int carCapacity, int truckCapacity) {
        this.carCapacity = carCapacity;
        this.truckCapacity = truckCapacity;
        this.cars = new ArrayList<>(carCapacity);
        this.trucks = new ArrayList<>(truckCapacity);
    }

    @Override
    public boolean store(Vehicle vehicle) {
        int vehiicleSize = vehicle.getSize();
        if (vehiicleSize > PassengerCar.CAR_SIZE && truckCapacity >= PassengerCar.CAR_SIZE) {
            truckCapacity--;
            trucks.add(vehicle);
            return true;
        }
        if (vehiicleSize > PassengerCar.CAR_SIZE && carCapacity >= vehiicleSize) {
            carCapacity -= vehiicleSize;
            trucks.add(vehicle);
            return true;
        }
        if (carCapacity - vehiicleSize >= 0) {
            carCapacity--;
            cars.add(vehicle);
            return true;
        }
        return false;
    }
}
