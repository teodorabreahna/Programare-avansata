import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
/**
 * Class representing the board of the
 * game. It contains the words made by
 * the players.
 */
public class Board {

    private final List<String> words;
    private int turn = 0;
    private int playerSize;

    public Board() {
        words = new ArrayList<>();
    }

    public synchronized void addWord(Player player, String word, int turn) {
        while(this.turn != turn){
            try{
                wait();
            }
            catch(InterruptedException e){
                throw new RuntimeException();
            }
        }
        words.add(word);
        //System.out.println(player.getName() + ": " + word);
        this.turn = (this.turn + 1) % playerSize;
        notifyAll();
    }
}
