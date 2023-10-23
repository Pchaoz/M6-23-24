package Capials;

import java.util.HashMap;
import java.util.Scanner;

public class CapitalsMain {
	public static void main(String[] args) {

		Scanner kyb = new Scanner(System.in);

		int cases = 0;
		int lines = 0;
		String capital = "";
		String country_capital = "";

		HashMap<String, String> capitals = new HashMap<String, String>();

		cases = kyb.nextInt();

		for (int i = 0; i < cases; i++) {
			lines = kyb.nextInt();
			kyb.nextLine();

			for (int x = 0; x < lines; x++) {
				country_capital = kyb.nextLine();
				String[] c_p_split = country_capital.split("-");
				
				if (c_p_split.length == 1) {
					if (capitals.containsKey(country_capital)) {
						capital = capitals.get(country_capital);
					}else {
						capital = "NO HO SE";
					}
				}else {
					capitals.put(c_p_split[0], c_p_split[1]);
				}
			}
			System.out.println(capital);
			capitals.clear();
		}
	}
}
