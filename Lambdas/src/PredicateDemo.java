import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateDemo {

	public static void main(String[] args) {
		List<String> words = Arrays.asList("hi","Hello","How","are","you","wassssub","beautiful");
		List<String> newWords = allMatch(words,s->s.length()<4);
		System.out.println(newWords);
		List<String> containsB = allMatch(words, s->s.contains("b"));
		System.out.println(containsB);
		List<String> evenLength = allMatch(words, s -> (s.length() %2) == 0);
		System.out.println(evenLength);
		List<Integer> nums = Arrays.asList(1, 10, 100, 1000, 10000, 56, 53, 9);
		System.out.println(nums);
		List<Integer> evenNumber = allMatch(nums, n -> (n %2) == 0);
		System.out.println(evenNumber);
		List<Integer> bigNums = allMatch(nums, n -> n>500);
		System.out.println(bigNums);
		List<String> newString = transformedList(words, s -> s + "!");
		System.out.println(newString);
		List<String> eyeWords = transformedList(words, s -> s.replace("i","eye"));
		System.out.println(eyeWords);
		List<String> upperCaseWords = transformedList(words,String::toUpperCase);
		System.out.println(upperCaseWords);
		List<Integer> wordLengths = transformedList(words, String::length);
		System.out.println("Length "+wordLengths);
		
	}

	private static <T> List<T> allMatch(List<T> x,Predicate<T> condition ) {
		List<T> results = new ArrayList<>();
	    for(T possibleMatch: x) {
	      if(condition.test(possibleMatch)) {
	        results.add(possibleMatch);
	      }
	    }
	    return(results);}
	    
	private static <T,R> List<R> transformedList(List<T> newWords, Function<T,R> conditions){
		
		List<R> result = new ArrayList<>();
	    for(T original: newWords) {
	      result.add(conditions.apply(original));
	    }
	    return(result); 
		
	}
		
		
	}

