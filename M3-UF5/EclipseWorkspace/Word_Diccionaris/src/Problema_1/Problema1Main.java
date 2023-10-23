package Problema_1;

import java.util.HashMap;
import java.util.Scanner;

public class Problema1Main {

	public static void main(String[] args) {

		int cases = 0;
		int years = 0;
		String input = "";

		Scanner kyb = new Scanner(System.in);
		HashMap<String, Integer> winnerCount = new HashMap<String, Integer>();

		cases = kyb.nextInt();

		for (int i = 0; i < cases; i++) {
			years = kyb.nextInt();
			kyb.nextLine();

			for (int y = 0; y < years; y++) {
				input = kyb.nextLine();

				if (y == years - 1) {
					if (winnerCount.containsKey(input)) {
						System.out.println(winnerCount.get(input));
					}else {
						System.out.println("0");
					}
				} else {
					String[] temp = input.split("-");
					winnerCount.put(temp[1], winnerCount.getOrDefault(temp[1], 0) + 1);
				}
			}
			winnerCount.clear();
		}
	}
}
