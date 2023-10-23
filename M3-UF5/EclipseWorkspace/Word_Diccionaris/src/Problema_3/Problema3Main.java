package Problema_3;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Problema3Main {

	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	public static void main(String[] args) {
		
		int cases = 0;
		int animes = 0;
		String input = "";
		
		Scanner kyb = new Scanner(System.in);
		LinkedHashMap<String, Integer> animeList = new LinkedHashMap<String,Integer>();
		
		/// ME QUIERO PEGAR UN TIRO GRACIAS EJERCICIO 2
		
		cases = kyb.nextInt();
		
		for (int i = 0; i < cases; i++) {
			
			animes = kyb.nextInt();
			kyb.nextLine();
			
			for (int n = 0; n < animes; n++) {
				
				input = kyb.nextLine();
				String[] temp = input.split("-");
				
				animeList.put(temp[0], Integer.valueOf(temp[1]));
				
			}
			
			String TopAnime = "";
			int TopAnimePoints = -1;
			String HatedAnime = "";
			int HatedAnimePoints = 10;
			float averageNote = 0;
			
			for (String key : animeList.keySet()) {
				
				averageNote = averageNote + animeList.get(key);
				
				if (TopAnimePoints < animeList.get(key) || TopAnimePoints == animeList.get(key)) {
					TopAnimePoints = animeList.get(key);
					TopAnime = key;
				}
				if (animeList.get(key) < HatedAnimePoints || HatedAnimePoints == animeList.get(key)) {
					HatedAnimePoints = animeList.get(key);
					HatedAnime = key;
				}
			}
			averageNote = averageNote / animeList.size();
			System.out.println(df.format(averageNote) + " " + HatedAnime + " " + TopAnime);
			animeList.clear();
		} 
	}
}
