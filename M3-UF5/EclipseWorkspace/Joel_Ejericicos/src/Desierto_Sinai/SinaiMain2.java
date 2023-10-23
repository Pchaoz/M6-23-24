package Desierto_Sinai;

import java.util.HashMap;
import java.util.Scanner;

public class SinaiMain2 {

	public static void main(String[] args) {

		// Variables
		Scanner kyb = new Scanner(System.in);

		int cases = 0;
		int lines = 0;

		HashMap<String, Integer> maps = new HashMap<String, Integer>();

		cases = kyb.nextInt();

		for (int i = 0; i < cases; i++) {
			
			//Variables especificas para el bucle
			int top_votes = -1;
			String top_key = "";
			
			lines = kyb.nextInt();
			kyb.nextLine();

			for (int x = 0; x < lines; x++) {

				//Variables especificas para el bucle
				int lastString = 0;
				String map_votes = kyb.nextLine();
				String[] map_split = map_votes.split("\\s+");

				for (int y = 0; y < map_split.length; y++) {
					//Compruebas cual es la ultima posicion antes de que salga el numero de votos
					if (isNumeric(map_split[y].charAt(0))) {
						lastString = y;
					}
				}
				//Generas el string separando el numero de votos del nombre del mapa
				String map_put = GenerateString(map_split, lastString);
				//System.out.println("Mapa: " + map_put + " Votos: " + map_split[lastString]);
				
				//Metes el nombre del mapa como clave y separas los votos en el hash map
				if (maps.containsKey(map_put)) {
					//Si existe le sumas los votos
					maps.put(map_put, maps.get(map_put) + Integer.parseInt(String.valueOf(map_split[lastString])));
				}else {
					//Si no lo añades de zero
					maps.put(map_put, Integer.parseInt(String.valueOf(map_split[lastString])));
				}
			}
			
			for ( String key : maps.keySet()) {
				
				if (maps.get(key) > top_votes) {
					top_votes = maps.get(key);
					top_key = key;
				}
			}
			System.out.println(top_key);
			maps.clear();
		}
	}

	public static boolean isNumeric(char ch) {
		try {
			Integer.parseInt(String.valueOf(ch));
			return true;
		} catch (NumberFormatException error) {
			return false;
		}
	}

	public static String GenerateString(String[] array, int lastString) {
		String result = "";
		for (int i = 0; i < lastString; i++) {
			if (i == 0) {
				result = array[i];
			}else {
				result = result + " " + array[i];
			}
		}
		return result;
	}
}
