package Comparadors;

import java.util.ArrayList;
import java.util.Collections;

public class AnimeMain {

	public static void main(String[] args) {
		
		ArrayList<Anime> mal = new ArrayList<Anime>();
		Anime a1 = new Anime("Pibe motosierra", 2023, 25);
		Anime a2 = new Anime("Arte de la espada en linea", 2012, 22);
		Anime a3 = new Anime("Mi academia de heroes", 2016, 23);
		Anime a4 = new Anime("Tu nombre", 2018, 107);
		Anime a5 = new Anime("El juego de los panas", 2022, 23);
		
		mal.add(a1);
		mal.add(a2);
		mal.add(a3);
		mal.add(a4);
		mal.add(a5);
		
		System.out.println("LISTA SIN ORDENAR:");
		System.out.println(mal);
		Collections.sort(mal);
		System.out.println("LISTA ORDENADA:");
		System.out.println(mal);
	}

}
