package snakeladder;

import snakeladder.elements.Board;
import snakeladder.elements.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    private Configureboard configBoard;
    private Board board;

    public void setup() {
        int numOfDice = 1;
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Player player = new Player(i, "player" + i, 0);
            players.add(player);
        }
        Map<Integer, Integer> snakePos = new HashMap<>();
        snakePos.put(4, 6);
        snakePos.put(5, 98);
        snakePos.put(12, 25);
        snakePos.put(20, 63);
        snakePos.put(55, 87);
        Map<Integer, Integer> ladderPos = new HashMap<>();
        ladderPos.put(6, 24);
        ladderPos.put(13, 50);
        ladderPos.put(25, 65);
        ladderPos.put(78, 88);
        ladderPos.put(15, 56);
        configBoard = new Configureboard();
        configBoard.placeLadders(ladderPos);
        configBoard.placeSnakes(snakePos);
        configBoard.configDiceAndPlayer(numOfDice, players);
        Board board = configBoard.configure();
        this.board = board;
    }

    public void startGame() throws InterruptedException {
        board.startGame();
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.setup();
        try {
            app.startGame();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
