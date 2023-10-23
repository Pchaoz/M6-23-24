package Generics3;

public class MitjanaMain {

	public static void main(String[] args) {
		
		int n1 = 1;
		float n2 = 5.4f;
		double n3 = 7.5;
		//long n4 = Long.MAX_VALUE;
		
		CalculadorDeMedianasGenericoMaravilloso<Number> cdmgm = new CalculadorDeMedianasGenericoMaravilloso<>();
		
		cdmgm.AddNumber(n1);
		cdmgm.AddNumber(n2);
		cdmgm.AddNumber(n3);
		//cdmgm.AddNumber(n4);
		
		cdmgm.GenerateAverageNote();
		
	}

}
