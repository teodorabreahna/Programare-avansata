import lombok.Data;
import org.apache.commons.logging.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Thread.sleep;

@Data
public class Player implements Runnable {

    private String name;
    private Game game;
    private boolean running;
    private int score = 0;
    private int turn;
    private Dictionar dict = new Dictionar();
    private String word;

    public Player(String name) {
        this.name = name;
    }

    private void addScore(List<Tile> usedTiles){
        int points = 0;
        for(Tile tile: usedTiles){
            points += tile.getPoints();
        }
        score += points;
    }


    public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    private void permute(String str, int l, int r) {
        if(l==r)
            if (dict.isWord(str) == true) {
                System.out.println(str);
                word = str;
                return;
            }
        else
        {

                for (int i = l; i <= r; i++)
                {
                    str = swap(str,l,i);
                    permute(str, l+1, r);
                    str = swap(str,l,i);
                }

            }

        }


    private boolean submitWord() {

        List<Tile> extracted = game.getBag().extractTiles(7, turn, score);
        if (extracted.isEmpty()) {
            System.out.println("Player ul asta a terminat!");
            game.setRunning(false);
            return false;
        }

        /*creates a word with all the given letters*/
        StringBuilder wordForming = new StringBuilder();
        for (int i = 0; i < extracted.size(); i++) {
            wordForming.append(extracted.get(i).getLetter());
        }
        String wordSubmit = wordForming.toString();
        word=null;
        System.out.println(this.getName()+" are literele: "+wordSubmit);
        permute(wordSubmit,0,wordSubmit.length()-1);
        if(word==null){
            System.out.println("Nu am gasit cuvant");
        }
        else{
            System.out.println("Am gasit cuvant" + word);
            this.addScore(extracted);
        }

        game.getBoard().addWord(this, word, turn);

        return true;
    }

    public void run() {
        while (this.submitWord() == true) {
        }
    }

}
