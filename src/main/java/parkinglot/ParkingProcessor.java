package parkinglot;

import parkinglot.elements.Category;
import parkinglot.elements.Vehicle;

import java.util.Map;

public interface ParkingProcessor {
    void enterVehicle(Vehicle vehicle);
    Double exitVehicle(long duration, Vehicle vehicle);
}
