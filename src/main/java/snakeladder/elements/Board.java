package snakeladder.elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;


public class Board {
    private Dice dice;
    private List<Jumper> snakes;
    private List<Jumper> ladders;
    private Jumper currentLadder;
    private Jumper currentSnake;
    private Queue<Player> players;


    public Board(Dice dice, List<Jumper> snakes, List<Jumper> ladders, Queue<Player> players) {
        this.dice = dice;
        this.snakes = snakes;
        this.ladders = ladders;
        this.players = players;
    }


    public boolean isLadderReached(int playerPosition) {
        List<Jumper> ladderStartCnt = ladders.stream().filter(ladder -> ladder.getStartPos() == playerPosition).collect(Collectors.toList());
        if (ladderStartCnt.size() > 0) this.currentLadder = ladderStartCnt.get(0);
        return !ladderStartCnt.isEmpty();
    }

    public boolean isSnakeByte(int playerPosition) {
        List<Jumper> snakeStartCnt = snakes.stream().filter(snake -> snake.getEndPos() == playerPosition).collect(Collectors.toList());
        if (snakeStartCnt.size() > 0) this.currentSnake = snakeStartCnt.get(0);
        return !snakeStartCnt.isEmpty();
    }

    public void startGame() throws InterruptedException {
        int winNum = 1;
        while (players.size() > 1) {
            Player currentPlayer = players.poll();
            System.out.println(currentPlayer.getPlayerName() + " is Rolling dice . . . .");
            Thread.sleep(1000);
            int number = dice.rollDice();
            System.out.println("dice gave number: " + number);
            int nextPos = 0;
            if (isLadderReached(currentPlayer.getPlayerPosition() + number)) {
                System.out.println("Hurrah!! got a ladder");
                nextPos = currentLadder.getEndPos();
            } else if (isSnakeByte(currentPlayer.getPlayerPosition() + number)) {
                System.out.println("Alas! it's a snake byte");
                nextPos = currentSnake.getStartPos();
            } else if (currentPlayer.getPlayerPosition() + number > 100) {
                nextPos = currentPlayer.getPlayerPosition();
            } else {
                nextPos = currentPlayer.getPlayerPosition() + number;
            }
            currentPlayer.setPlayerPosition(nextPos);
            System.out.println(currentPlayer.getPlayerName() + "'s new position is " + currentPlayer.getPlayerPosition());
            if (currentPlayer.getPlayerPosition() == 100) {
                System.out.println(winNum++ + "th Winner is " + currentPlayer.getPlayerName());
            } else {
                players.add(currentPlayer);
            }
        }
    }
}
