package lambdaExpressions;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class Test1 {
	
	public static void main(String args[]) {
		Function1 f = x -> x*x+3*x;
		System.out.println(f.exec(10));
		
		Function1 o = x-> {System.out.println(x); return x;};
		o.exec(40);
		
		List<Integer> integerList = Arrays.asList(3,6,3,7,9);
		integerList.forEach(x-> System.out.println(x));
		
		BiFunction<Integer, Integer, Integer> b = (x,y) -> x+y;
		System.out.println(b.apply(4, 7));
		
	}
	
}
