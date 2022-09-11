package parkinglot.elements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import parkinglot.elements.Category.Type;

@Data
@AllArgsConstructor
public class Vehicle {
    private Type type;
    private Integer assignedLevel;
    private Category assignedCategory;

    public Vehicle(Type type) {
        this.type = type;
    }
}
