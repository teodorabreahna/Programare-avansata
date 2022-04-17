import java.util.ArrayList;
import java.util.List;

public class Bag {
    //declare a collection for tiles;
    private final List<Tile> letters = new ArrayList<>();
    public Bag() {
        for (char c = 'a'; c < 'z'; c++) {
            //add a new tile to the collection;
            int rand = (int)(Math.random() * 10) + 1;
            for(int i=0;i<10;i++)
                letters.add(new Tile(c,rand));
        }
    }
    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (letters.isEmpty()) {
                break;
            }
            extracted.add(letters.get(i));
        }
        return extracted;
    }

}
