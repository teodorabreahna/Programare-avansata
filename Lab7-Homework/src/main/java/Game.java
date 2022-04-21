import lombok.Data;
import net.didion.jwnl.JWNL;
import net.didion.jwnl.JWNLException;
import net.didion.jwnl.data.IndexWord;
import net.didion.jwnl.data.POS;
import net.didion.jwnl.dictionary.Dictionary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Data
/**
 Class that represents a game round. It has a bag of tiles,
 a board, a dictionary and several players.
 */
public class Game {

    private final Bag bag = new Bag();
    private final Board board = new Board();
    private Timekeeper timekeeper;
    private final Dictionar dictionar = new Dictionar();
    private final List<Player> players = new ArrayList<>();
    private boolean running = true;

    private int playerSize = 0;

    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
        playerSize++;
        players.get(playerSize - 1).setTurn(playerSize-1);
    }

    public void getWinner(){
        synchronized(this){
            while(running == true){
                try{
                    wait();
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }

    }

    public void play() {
        bag.setPlayerSize(playerSize);
        board.setPlayerSize(playerSize);
        Timekeeper timekeeper = new Timekeeper(20);
        Thread th = new Thread(timekeeper);
        th.start();

        for (Player player : players) {
            Thread t = new Thread(player);
            t.start();
        }

        while(bag.isGameDone() == false){
            //waiting for the game to finish
        }

        int maxScore = 0;
        String winner;
        for(Player player : players){
            if(player.getScore() >= maxScore) {
                maxScore = player.getScore();
                winner = player.getName();
            }
        }
    }

    public static void main(String args[]) {
        Dictionar dict = new Dictionar();
        System.out.println(dict.isWord("A"));
        System.out.println(dict.isWord("math"));
        Game game = new Game();
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.play();
    }

}
