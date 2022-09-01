package snakeladder;

import snakeladder.elements.Board;
import snakeladder.elements.Dice;
import snakeladder.elements.Jumper;
import snakeladder.elements.Player;

import java.util.*;

public class Configureboard {
    //  placeSnake,placeLadder, configureDice, configurePlayer, configure
    private List<Jumper> snakes;
    private List<Jumper> ladders;
    private Dice dice;
    private Queue<Player> players;

    public Board configure() {
        Board board = new Board(dice, snakes, ladders, players);
        return board;
    }

    public void placeSnakes(Map<Integer, Integer> snakeStartEndPos) {
        List<Jumper> snakeList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : snakeStartEndPos.entrySet()) {
            snakeList.add(new Jumper(entry.getKey(), entry.getValue(), Jumper.Type.SNAKE));
        }
        this.snakes = snakeList;
    }

    public void placeLadders(Map<Integer, Integer> ladderStartEndPos) {
        List<Jumper> ladderList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : ladderStartEndPos.entrySet()) {
            ladderList.add(new Jumper(entry.getKey(), entry.getValue(), Jumper.Type.LADDER));
        }
        this.ladders = ladderList;
    }

    public void configDiceAndPlayer(int numOfDice, List<Player> players) {
        Dice dice = new Dice(numOfDice);
        Queue<Player> playersQueue = new LinkedList<>(players);
        this.dice = dice;
        this.players = playersQueue;
    }

}
