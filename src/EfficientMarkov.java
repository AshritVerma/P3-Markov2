import java.util.*;

public class   EfficientMarkov extends BaseMarkov {
	private Map<String,ArrayList<String>> myMap;
	private ArrayList<String> list;
	
	EfficientMarkov(){
		this(3);
	}

	EfficientMarkov(int order) {
		super(order);
		myMap = new HashMap<>();
	}

	public void setTraining(String text) {
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

}	
