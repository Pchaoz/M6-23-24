package Salam_bestFriend;

import java.util.HashMap;
import java.util.Scanner;

public class SalamMain2 {
	public static void main(String[] args) {
		
		//VARIABLES
		Scanner kyb = new Scanner(System.in);
		
		HashMap<String, String> bestfriends = new HashMap<String, String>();
		int cases = 0;
		int lines = 0;
		String input = "";
		String bestFriend = "";
		cases = kyb.nextInt();
		
		for (int i = 0; i < cases; i++) {
			lines = kyb.nextInt();
			kyb.nextLine();
			
			for (int x = 0; x < lines; x++) {
				
				input = kyb.nextLine();
				String[] friends = input.split("\\s+");
				//System.out.println(friends.length);
				/*for (int z = 0; z < friends.length; z++) {
					System.out.println(friends[z]);
				}*/
				if (friends.length == 1) {
					//System.out.println("ULTIMA LINEA");
					bestFriend = bestfriends.get(input);
				}else {
					//System.out.println("MODIFICANDO");
					bestfriends.put(friends[0], friends[1]);
					bestfriends.put(friends[1], friends[0]);
				}
				
			}
			System.out.println(bestFriend);
			bestfriends.clear();
		}
	}
}
