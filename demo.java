package udemy_project;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class demo {

	public static void main(String[] args) {
		String name= "vaishnavi";
	char word[]= name.toCharArray();
		
		HashMap<Character,Integer>Map =new HashMap<Character,Integer>();
		
	
for(Character ch:word) {
	
if(Map.containsKey(ch)) {
	Map.put(ch, Map.get(ch)+1);
}
else {
	Map.put(ch,1);
}
}
	Set<Entry<Character,Integer>>prword=Map.entrySet();
	
	for(Map.Entry<Character,Integer> countwrd:prword) {
		if(countwrd.getValue()>1) {
			System.out.println(countwrd.getKey()+":"+countwrd.getValue());
		}
	}
	
	
	}
}
	


