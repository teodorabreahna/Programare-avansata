import java.io.FileInputStream;
import java.io.FileNotFoundException;

import net.didion.jwnl.JWNL;
import net.didion.jwnl.JWNLException;
import net.didion.jwnl.data.IndexWordSet;
import net.didion.jwnl.dictionary.Dictionary;

public class Dictionar {
    static Dictionary dictionary;
    public Dictionar(){
        try{
            JWNL.initialize(new FileInputStream("C:\\Users\\teodo\\OneDrive\\Desktop\\facultate 2\\Programare avansata\\git\\Lab7-Homework\\.idea\\properties.xml"));
            dictionary = Dictionary.getInstance();
        }
        catch (JWNLException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static boolean isWord(String word) {
        if (dictionary == null) return false;

        IndexWordSet indexWordSet = null;
        try {
            indexWordSet = dictionary.lookupAllIndexWords(word);
        } catch (JWNLException e) {
            e.printStackTrace();
        }
        return indexWordSet.size() > 0;
    }
}
