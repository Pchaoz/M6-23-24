package Generics3;

import java.util.ArrayList;
import java.util.List;

public class CalculadorDeMedianasGenericoMaravilloso<T extends Number> {

	private List<T> numbers = new ArrayList<T>();

	public void AddNumber(T number) {
		numbers.add(number);
	}
	
	public void GenerateAverageNote() {
		
		double res = 0;
		for (T t : numbers) {
			res = t.doubleValue() + res;
		}
		res = res / numbers.size();
		System.out.println("La mitjana es: " + res);
	}
}
