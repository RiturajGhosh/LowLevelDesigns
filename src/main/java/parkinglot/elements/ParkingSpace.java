package parkinglot.elements;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class ParkingSpace {
    List<Category> parkingCategories;

    public List<Category> getAvailableCategory(Category.Type type) {
        List<Category> availableCategories = parkingCategories.stream()
                .filter(category -> category.getType().equals(type) && category.getAvailabilityRoom() > 0)
                .collect(Collectors.toList());
        return availableCategories;
    }
}
