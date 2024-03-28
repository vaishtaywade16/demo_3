package udemy_project;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

public class streams {

public static void main(String args[]) {
	ArrayList<String> names= new ArrayList<String>();
	names.add("ramik");
	names.add("naman");
	names.add("dam");
	names.add("nomesh");
	names.add("clarl");
	
	long c=names.stream().filter(s->s.startsWith("n")).count();
    System.out.println(c);
  
    names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
    names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
    
	// to convert the any string to uppercase
names.stream().filter(s->s.endsWith("k")).map(s->s.toUpperCase())
.forEach(s->System.out.println(s));

//convert string which have starts with firstletter n to uppercase and sorted
names.stream().filter(s->s.startsWith("n")).map(s->s.toUpperCase())
.sorted().forEach(s->System.out.println(s));


// when u want to combine two list
 ArrayList<String> name1= new ArrayList<String>();
name1.add("adon");
name1.add("tom");
name1.add("ricky");

  Stream<String> newstream =Stream.concat(names.stream(), name1.stream());
  //newstream.sorted().forEach(s->System.out.println(s));
  //we can not use same stream once we after concat
  //to find any name from whole string
 boolean flag= newstream.anyMatch(s->s.equalsIgnoreCase("adon"));
 System.out.println(flag);
 Assert.assertTrue(flag);
streams obj= new streams();
collectmethod();
uniqno();
}

     public static void collectmethod() {
    	List<String>newlist= Stream.of("ramik","naman","dam","nomesh","clarl").filter(s->s.endsWith("n")).map(s->s.toUpperCase())
    	 .collect(Collectors.toList());
	System.out.println(newlist);
	//System.out.println(newlist.get(2));
}
		

public static void uniqno() {
	List<Integer>values=Arrays.asList(1,2,2,3,5,8,3,5,7);
	//print the unique numbers from list in sorted way
	values.stream().distinct().sorted().forEach(s->System.out.println(s));
	//if i want only 2 nd value from list
	List<Integer>li=values.stream().distinct().sorted().collect(Collectors.toList());
	System.out.println(li.get(1));
}
	}


