package parkinglot.elements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Category {
    public enum Type {
        TwoWheeler {
            public double getPriceForParking(long duration) {
                return duration * .5;
            }
        },
        Compact {
            public double getPriceForParking(long duration) {
                return duration * 75;
            }
        };

        public abstract double getPriceForParking(long duration);
    }

    private Integer id;
    private Type type;
    private Integer capacity;
    private Integer availabilityRoom;

    public Integer increaseAvailabilityAtCarDespatch() {
        this.availabilityRoom++;
        return this.availabilityRoom;
    }

    public Integer decreaseAvailabilityAtCarEntry() {
        this.availabilityRoom--;
        return this.availabilityRoom;
    }
}
