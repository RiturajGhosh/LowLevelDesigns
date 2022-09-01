package snakeladder.elements;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Dice {
    private int numberOfDice;

    public int rollDice() {
        return (int) Math.floor((double) Math.random() * (6 * numberOfDice - numberOfDice) + numberOfDice);
    }
}
