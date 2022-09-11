package parkinglot;

import parkinglot.elements.*;
import parkinglot.elements.Category.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Application {

    public ParkingLot setUp() {
        TreeMap<Integer, ParkingSpace> levelParkingSpace = new TreeMap<>();
        List<Category> categoryList1 = new ArrayList<>();
        categoryList1.add(new Category(1, Type.TwoWheeler, 1, 1));
        categoryList1.add(new Category(2, Type.Compact, 15, 15));
        categoryList1.add(new Category(3, Type.TwoWheeler, 15, 15));
        categoryList1.add(new Category(4, Type.Compact, 15, 15));
        List<Category> categoryList2 = new ArrayList<>();
        categoryList2.add(new Category(5, Type.TwoWheeler, 15, 15));
        categoryList2.add(new Category(6, Type.Compact, 15, 15));
        categoryList2.add(new Category(7, Type.TwoWheeler, 15, 15));
        categoryList2.add(new Category(8, Type.Compact, 15, 15));
        ParkingSpace parkingSpace1 = new ParkingSpace(categoryList1);
        ParkingSpace parkingSpace2 = new ParkingSpace(categoryList2);
        levelParkingSpace.put(1, parkingSpace1);
        levelParkingSpace.put(2, parkingSpace2);
        ParkingLot parkingLot = new ParkingLot(2, levelParkingSpace);
        return parkingLot;
    }

    public static void main(String[] args) {
        Application app = new Application();
        ParkingLot parkingLot = app.setUp();
        Vehicle myCar = new Vehicle(Type.TwoWheeler);
        Vehicle fathersCar = new Vehicle(Type.TwoWheeler);
        ParkingProcessor psr = new ParkingProcessorImpl(parkingLot);
        psr.enterVehicle(myCar);
        psr.enterVehicle(fathersCar);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        psr.exitVehicle(2000, myCar);
        psr.exitVehicle(8000, fathersCar);
    }

}
