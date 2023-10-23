package Comparadors;

import java.util.ArrayList;
import java.util.Comparator;

public class AnimeMain2 {

	public static void main(String[] args) {
		ArrayList<Anime> mal = new ArrayList<Anime>();
		Anime a1 = new Anime("Doctor piedra", 2019, 24);
		Anime a2 = new Anime("Bocchi la roca!", 2022, 24);
		Anime a3 = new Anime("Inicial D Segundo escenario", 1999, 23);
		Anime a4 = new Anime("[ El amor de las mentiras ]", 2023, 24);
		
		mal.add(a1);
		mal.add(a2);
		mal.add(a3);
		mal.add(a4);
		
		Comparator<Anime> c = new comparatorAnime();
		
		System.out.println("LISTA SIN ORDENAR:");
		System.out.println(mal);
		System.out.println("LLISTA ORDENADA PER EL COMPARATOR: ");
		mal.sort(c);
		System.out.println(mal);
	}

	public static class comparatorAnime implements Comparator<Anime> {

		@Override
		public int compare(Anime o1, Anime o2) {
			return o1.getRelease_year() - o2.getRelease_year();
		}
		
	}
}
