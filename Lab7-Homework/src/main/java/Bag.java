import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

@Data
public class Bag {

    private final List<Tile> tileList;
    private int turn = 0;
    private int playerSize;
    private boolean gameDone = false;
    private int rand_int;

    public Bag() {

        tileList = new ArrayList<>();

        List<Integer> points = Arrays.asList(1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10);
        List<Integer> frequency = Arrays.asList(9,2,2,4,12,2,3,2,9,1,4,2,6,8,2,1,6,4,6,4,2,2,1,2,1);

        for(int i=0; i<25; i++){
            for(int j=0; j<frequency.get(i); j++){
                char c = (char) ('A' + (char) i);
                tileList.add(new Tile(c,points.get(i)));
            }
        }

    }

    public synchronized List<Tile> extractTiles(int howMany, int turn, int score){

        while(this.turn != turn){
            try{
                wait();
            }
            catch(InterruptedException e){
                throw new RuntimeException();
            }
        }

        List<Tile> extracted = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < howMany; i++) {
            if (tileList.isEmpty()) {
                gameDone=false;
                break;
            }
            rand_int = rand.nextInt(tileList.size());
            extracted.add(tileList.get(rand_int));
            this.tileList.remove(rand_int);
        }

        this.turn = (this.turn + 1) % playerSize;
        try {
            sleep(1000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        notifyAll();
        return extracted;
    }

}
