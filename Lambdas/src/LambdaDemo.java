//import java.lang.reflect.Array;
import java.util.Arrays;
public class LambdaDemo {
	
//	
	@FunctionalInterface
	public interface TwoStringPredicate {
	    
	    public boolean isFirstBetter(String s1,String s2);

	}

	
	public static String betterString(String first, String second, TwoStringPrdeicate condition) {
		if(condition.isFirstBetter(first, second)){
			return first;
		}
		else {
			return second;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int i=0;
		String[] a = {"Hello","this", "is","Shruti"};
		Arrays.sort(a,(s1 , s2) -> s1.length() - s2.length());
		System.out.println("Ascending Order"+Arrays.asList(a));
		//System.out.println(a);
		Arrays.sort(a,(s1,s2)->s2.length()-s1.length());
		System.out.println("Descending Order"+Arrays.asList(a));
		Arrays.sort(a,(s1,s2)->s1.charAt(0)-s2.charAt(0));
		System.out.println("First Alphabet Order"+Arrays.asList(a));
		Arrays.sort(a,(s1,s2)-> {
			int flag = 0;
            if(s1.contains("e") && !s2.contains("e")) {
              flag = -1;
            } else if(s2.contains("e") && !s1.contains("e")) {
              flag = 1;
            }
            return(flag);
		});
		System.out.println("Contains e "+Arrays.asList(a));
		
			
		
		
		
	}
}
