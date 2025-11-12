package test;
import java.util.*;
public class BJ11720 {

		public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int N = Integer.parseInt(sc.nextLine());
	    String[] numStr = (sc.nextLine()).split("");
	    int sum =0;
	    
	    for(String num : numStr){
	    	sum += Integer.parseInt(num);
	    }
	    
	    System.out.println(sum);
	}
}
