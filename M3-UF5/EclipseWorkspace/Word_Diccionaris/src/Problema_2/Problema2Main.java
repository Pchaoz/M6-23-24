package Problema_2;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Problema2Main {

	public static void main(String[] args) {

		int cases = 0;
		int years = 0;
		String input = "";

		Scanner kyb = new Scanner(System.in);
		TreeMap<String, Integer> winnersCount = new TreeMap<String, Integer>();

		cases = kyb.nextInt();

		for (int i = 0; i < cases; i++) {
			years = kyb.nextInt();
			kyb.nextLine();

			for (int y = 0; y < years; y++) {
				input = kyb.nextLine();
				String[] temp = input.split("-");
				
				winnersCount.put(temp[1], winnersCount.getOrDefault(temp[1], 0) + 1);

			}
			System.out.println(winnersCount.toString());
			//Comparator comp = winnersCount.comparator();
			//System.out.println(comp);
			winnersCount.clear();
		}
	}
	
	
	
	
	/* NO SIRVE DE NADA PERO ME DA PENA BORRARLO
	public static TreeMap<String, Integer> SortTreeMap (TreeMap<String, Integer> mapToSort) {
		
		TreeMap<String, Integer> sortedMap = new TreeMap<String, Integer>();
		int mapSize = mapToSort.size();
		
		for (int i = 0; i < mapSize; i++) {
			int TopValue = -1;
			String TopValueName = "";
			for (String key : mapToSort.keySet()) {
				
				if (mapToSort.get(key) > TopValue) {
					TopValue = mapToSort.get(key);
					TopValueName = key;
				}
			}
			System.out.println("POSICION " + i + " NOMBRE -> " + TopValueName + " VALOR -> " + TopValue);
			sortedMap.put(TopValueName, TopValue);
			mapToSort.remove(TopValueName);
		}
		System.out.println("RESULTAT: " + sortedMap.toString());
		return sortedMap;
	}
	
	
	//METODO GENERICO QUE ORDENA TREEMAPS CON UN COMPARATOR?
	static <K,V extends Comparable<? super V>>
	SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
	    SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
	        new Comparator<Map.Entry<K,V>>() {
	            @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
	                int res = e1.getValue().compareTo(e2.getValue());
	                return res != 0 ? res : 1;
	            }
	        }
	    );
	    sortedEntries.addAll(map.entrySet());
	    return sortedEntries;
	}*/
}
