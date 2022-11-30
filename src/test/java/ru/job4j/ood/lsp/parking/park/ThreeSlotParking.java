package ru.job4j.ood.lsp.parking.park;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.parking.PassengerCar;
import ru.job4j.ood.lsp.parking.Truck;

import static org.junit.jupiter.api.Assertions.*;

class JustParkingTest {

    @Test
    public void whenParkingTruckAnd2CarTrue() {
        Parking parking = new JustParking(2, 1);
        Truck truck = new Truck(2);
        PassengerCar car = new PassengerCar();
        PassengerCar car1 = new PassengerCar();
        assertTrue(parking.store(truck));
        assertTrue(parking.store(car1));
        assertTrue(parking.store(car));
    }

    @Test
    public void whenParkingTruckAndTruckTrue() {
        Parking parking = new JustParking(2, 1);
        Truck truck = new Truck(2);
        Truck truck2 = new Truck(2);
        assertTrue(parking.store(truck));
        assertTrue(parking.store(truck2));
    }

    @Test
    public void whenParkingTruckAndTruckAndCarFalse() {
        Parking parking = new JustParking(2, 1);
        Truck truck = new Truck(2);
        Truck truck2 = new Truck(2);
        PassengerCar car = new PassengerCar();
        assertTrue(parking.store(truck));
        assertTrue(parking.store(truck2));
        assertFalse(parking.store(car));
    }

    @Test
    public void whenParkingCarOnTruckSlotFalse() {
        Parking parking = new JustParking(1, 1);
        PassengerCar car = new PassengerCar();
        PassengerCar car1 = new PassengerCar();
        assertTrue(parking.store(car));
        assertFalse(parking.store(car1));
    }

    @Test
    public void whenParking2TrucksFalse() {
        Parking parking = new JustParking(1, 1);
        Truck truck = new Truck(2);
        Truck truck2 = new Truck(2);
        assertTrue(parking.store(truck));
        assertFalse(parking.store(truck2));
    }
}