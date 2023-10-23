package Comparadors;

import java.util.ArrayList;
import java.util.Comparator;

public class AnimeMain3 {

	public static void main(String[] args) {
		
		ArrayList<Anime> mal = new ArrayList<Anime>();
		Anime a1 = new Anime("Josee, el tigre y los peces", 2020, 98);
		Anime a2 = new Anime("Exorcista azul pelicula", 2012, 88);
		Anime a3 = new Anime("Suzume", 2022, 121);
		Anime a4 = new Anime("Quiero comerme tu pancreas", 2018, 108);
		
		mal.add(a1);
		mal.add(a2);
		mal.add(a3);
		mal.add(a4);
		
		Comparator<Anime> c = new comparatorAnimeDuracio();
		
		System.out.println("LISTA SIN ORDENAR:");
		System.out.println(mal);
		System.out.println("LLISTA ORDENADA PER EL COMPARATOR: ");
		mal.sort(c);
		System.out.println(mal);

	}
	public static class comparatorAnimeDuracio implements Comparator<Anime> {

		@Override
		public int compare(Anime o1, Anime o2) {
			return o2.getCap_length() - o1.getCap_length();
		}
		
	}

}
