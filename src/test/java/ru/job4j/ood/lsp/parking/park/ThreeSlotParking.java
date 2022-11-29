package ru.job4j.ood.lsp.parking.park;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.parking.PassengerCar;
import ru.job4j.ood.lsp.parking.Truck;

import static org.junit.jupiter.api.Assertions.*;

class ThreeSlotParkingTest {

    @Test
    public void parkingTruckAndCarTrue() {
        Parking parking = new ThreeSlotParking();
        Truck truck = new Truck();
        PassengerCar car = new PassengerCar();
        assertTrue(parking.store(truck));
        assertTrue(parking.store(car));
    }

    @Test
    public void parkingThreeCarsTure() {
        Parking parking = new ThreeSlotParking();
        PassengerCar car = new PassengerCar();
        PassengerCar car1 = new PassengerCar();
        PassengerCar car2 = new PassengerCar();
        assertTrue(parking.store(car1));
        assertTrue(parking.store(car2));
        assertTrue(parking.store(car));
    }

    @Test
    public void parkingOneCarTwoTimesFalse() {
        Parking parking = new ThreeSlotParking();
        PassengerCar car = new PassengerCar();
        assertTrue(parking.store(car));
        assertFalse(parking.store(car));
    }

}