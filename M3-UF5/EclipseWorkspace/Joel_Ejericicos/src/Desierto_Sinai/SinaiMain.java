package Desierto_Sinai;

import java.util.HashMap;
import java.util.Scanner;

public class SinaiMain {

	public static void main(String[] args) {
		
		//variables
		int cases = 0;
		int n_maps = 0;
		HashMap<String, Integer> m_count = new HashMap<String, Integer>();
		
		Scanner kyb = new Scanner(System.in);
		
		int top = -1;
		String top_key = "";
		
		cases = kyb.nextInt();
		
		for (int i = 0; i < cases; i++) {
			n_maps = kyb.nextInt();
			kyb.nextLine();
			
			for(int x = 0; x < n_maps; x++) {
				String map = kyb.nextLine();
				//System.out.println(map);
				
				if (m_count.containsKey(map)) {
					//System.out.println("Repetido");
					m_count.put(map, m_count.get(map) + 1);
				}
				else {
					//System.out.println("Nuevo");
					m_count.put(map, 1);
				}
			}
			
			for ( String key : m_count.keySet()) {
				//System.out.println("Comprovando la clave" + key + "El resulteado es: " + m_count.get(key));
				
				if (m_count.get(key) > top) {
					top = m_count.get(key);
					top_key = key;
				}
			}
			System.out.println(top_key);
			
			m_count.clear();
			top_key = "";
			top = -1;
		}
	}

}
