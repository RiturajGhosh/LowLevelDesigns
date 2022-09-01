package snakeladder.elements;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Jumper {
    public enum Type {
        LADDER, SNAKE;
    }

    private int startPos;
    private int endPos;
    private Type type;

    /**
     * If player reaches ladder it will jump to end of the ladder<br></br>
     * If player reaches to snake it will slip to start of the snake<br></br>
     * Otherwise it won't change player position
     *
     * @param playerPosition
     * @return player's new position
     */
    public int doJump(int playerPosition) {
        if (playerPosition == startPos && this.type == Type.LADDER) {
            return endPos;
        } else if (playerPosition == endPos && this.type == Type.SNAKE) {
            return startPos;
        }
        return 0;
    }
}
