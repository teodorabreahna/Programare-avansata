import java.util.ArrayList;
import java.util.List;

public class Board {
    //a collection for words;
    private final List<String> words = new ArrayList<>();
    public void addWord(Player player, String word) {
        //add the word to the collection;
        words.add(word);
        System.out.println(player.getName() + ": " + word);
    }
    @Override
    public String toString() {
        return words.toString();
    }

}
