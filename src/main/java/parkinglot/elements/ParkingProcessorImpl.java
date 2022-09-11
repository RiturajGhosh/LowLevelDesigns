package parkinglot.elements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import parkinglot.ParkingProcessor;
import parkinglot.elements.Category.Type;

import java.util.Map;

@AllArgsConstructor
@Data
public class ParkingProcessorImpl implements ParkingProcessor {
    private ParkingLot parkingLot;

    @Override
    public void enterVehicle(Vehicle vehicle) {
        Map<Category, Integer> categoryLevelMap = parkingLot.getRoom(vehicle.getType());
        if (!categoryLevelMap.isEmpty()) {
            for (Map.Entry<Category, Integer> pair : categoryLevelMap.entrySet()) {
                Category category = pair.getKey();
                category.decreaseAvailabilityAtCarEntry();
                vehicle.setAssignedLevel(pair.getValue());
                vehicle.setAssignedCategory(pair.getKey());
                System.out.println("your vehicle has entered level: " + pair.getValue() + " category id: " + category.getId());
            }
        }
    }

    @Override
    public Double exitVehicle(long duration, Vehicle vehicle) {
        Integer level = vehicle.getAssignedLevel();
        Category category = vehicle.getAssignedCategory();
        category.increaseAvailabilityAtCarDespatch();
        System.out.println("For exiting the vehicle price paid is: " + vehicle.getType().getPriceForParking(duration));
        return vehicle.getType().getPriceForParking(duration);
    }
}
