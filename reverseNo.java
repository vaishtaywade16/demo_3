package udemy_project;
import java.util.Scanner;

public class reverseNo {

	public static void main(String[] args) {
		int num;
		int r;
		int rev=0;
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter any number");
		
	 num=sc.nextInt();
	 while(num>0) {
		r=num%10;
		rev=rev*10+r;
		num=num/10;
		
		 }
	 System.out.println("reverse number is :"+ rev);
	}
	

	}


