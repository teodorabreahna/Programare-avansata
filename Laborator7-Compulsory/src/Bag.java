import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bag {
    //declare a collection for tiles;
    private final List<Tile> letters = new ArrayList<>();
    private List<Integer> aparitii= Arrays.asList(9,2,2,4,12,2,3,2,9,1,1,4,2,6,8,2,1,6,4,6,4,2,2,1,2,1);
    private List<Integer> points= Arrays.asList(1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10);

    public Bag() {
        char c='a';
        for (int i=0;i<aparitii.size();i++) {
            //add a new tile to the collection;
            int pct = points.get(i);
            int nr = aparitii.get(i);
            for(int j=0;j<nr;j++)
                letters.add(new Tile(c,pct));
            c++;
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
