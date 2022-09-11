package parkinglot.elements;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Data
@AllArgsConstructor
public class ParkingLot {
    private int totalLevels;
    TreeMap<Integer, ParkingSpace> levelPrakingSpaceMap;

    public Map<Category, Integer> getRoom(Category.Type type) {
        HashMap<Category, Integer> categoryLevelMap = new HashMap<>();
        for (Map.Entry<Integer, ParkingSpace> item : levelPrakingSpaceMap.entrySet()) {
            List<Category> categories = item.getValue().getAvailableCategory(type);
            if (!categories.isEmpty()) {
                categoryLevelMap.put(categories.get(0), item.getKey());
                return categoryLevelMap;
            }
        }
        return categoryLevelMap;
    }

}
