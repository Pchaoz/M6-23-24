package Arribar_a_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ArribarMain {

	public static void main(String[] args) {
		
		Scanner kyb = new Scanner(System.in);
		
		HashMap<String, Integer> WinCount = new HashMap<String, Integer>();
		ArrayList<String> winners = new ArrayList<String>();
		String input = "";
		Boolean finish = false;
		
		while (!finish) {
			input = kyb.nextLine();
			
			if (input.equals("xxx")) {
				finish = true;
			}else {
				if (WinCount.containsKey(input)) {
					WinCount.put(input, WinCount.get(input)+1);
					
					if (WinCount.get(input) == 4) {
						winners.add(input);
					}
				}else {
					WinCount.put(input, 1);
				}
			}
		}
		if (winners.isEmpty()) {
			System.out.println("NO");
		}else {
			System.out.println(winners.get(0));
		}
	}

}
