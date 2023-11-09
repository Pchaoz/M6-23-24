package Comparador;

import java.util.Comparator;
import java.util.HashMap;

public class ComparadorMissions implements Comparator<HashMap<String, String>>{

	@Override
	public int compare(HashMap<String, String> o1, HashMap<String, String> o2) {
		return Integer.valueOf(o1.get("UREGENCIA")) - Integer.valueOf(o2.get("UREGENCIA"));

	}

}
