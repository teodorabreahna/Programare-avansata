import java.util.List;
import java.util.Scanner;

public class Player implements Runnable {
    private String name;
    private Game game;
    private boolean running=true;
    public Player(String name) { this.name = name; }
    private boolean submitWord() {
        Scanner s = new Scanner(System.in);
        List<Tile> extracted = game.getBag().extractTiles(7);
        if (extracted.isEmpty()) {
            return false;
        }
        //create a word with all the extracted tiles;
        System.out.println(getName()+" enter word: ");
        String word = s.nextLine();
        game.getBoard().addWord(this, word);
        //make the player sleep 50ms;
        try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return true;
    }

    public String getName() {
        return name;
    }
    public Game getGame() {
        return game;
    }
    public void setGame(Game game) {
        this.game = game;
    }

    //implement the run method;
    public void run() {
        while(running) {
            submitWord();
        }
    }
}
