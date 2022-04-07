import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Bag bag = new Bag();
    private final Board board = new Board();
    //private final Dictionary dictionary = new MockDictionary();
    private final List<Player> players = new ArrayList<>();
    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }
    public void play() {
        for (Player player : players) {
            //start a new Thread representing the player;
            Thread[] threadList = new Thread[players.size()];
            for (int i = 0; i < threadList.length; i++) {
                threadList[i] = new Thread(players.get(i));
            }
            for (Thread thread : threadList) {
                thread.start();
            }
        }
    }

    public Bag getBag(){return bag;}
    public Board getBoard(){return board;}

    public static void main(String args[]) {
        Game game = new Game();
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.play();
    }
}
