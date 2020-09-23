import java.lang.reflect.Array;
import java.util.*;

public class EfficientWordMarkov extends BaseWordMarkov
{
    private Map<WordGram, ArrayList<String>> myMap;

    public EfficientWordMarkov() {
        this(2);
    }

    public EfficientWordMarkov(int n) {
        super(n);
        myMap = new HashMap<>();

    }

    public void setTraining(String text)
    {
        myMap.clear();
        myWords = text.split("\\s+");
        for(int i = 0; i <= myWords.length - myOrder; i++)
        {
            WordGram wg = new WordGram(myWords, i, myOrder);
            String nextValue = PSEUDO_EOS;
            if(i < myWords.length - myOrder)
                nextValue = myWords[i + myOrder];
            if(!myMap.containsKey(wg))
                myMap.put(wg, new ArrayList<>());
            //myMap.put(wg, getFollows(wg));
            myMap.get(wg).add(nextValue);
        }
    }

    public ArrayList<String> getFollows(WordGram key)
    {
        if(!myMap.containsKey(key))
        {
            throw new NoSuchElementException(key + " not in map");
        }
        return myMap.get(key);
    }
}

//myText = myWords
    /*public void setTraining(String text) {
        super.setTraining(text); //set myTest to text
        myMap.clear(); //clear and initialize the map when overriden method called
        for(int i = 0; i<text.length() + myOrder; i++)
        {
            String key1 = myText.substring(i, i+myOrder-1); //create substrings of appropriate length starting anywhere
            String nextValue = PSEUDO_EOS;
            if(i < text.length() - myOrder)
            {
                nextValue = String.valueOf(text.charAt(i+myOrder));
                myMap.get(key1).add(PSEUDO_EOS);
            }
            if(!myMap.containsKey(key1))
                myMap.put(key1, new ArrayList<>());
            myMap.get(key1).add(nextValue);
        }
    }

    public ArrayList<String> getFollows(String key)
    {
        if(!myMap.containsKey(key))
        {
            throw new NoSuchElementException(key + " not in map");
        }
        return myMap.get(key);
    }
*/