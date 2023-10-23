package Singleton;

public class SingletonCounter {

	private static SingletonCounter instance = null;
	private int animeInstances;
	
	private SingletonCounter () {
		//NO HAY NA
	}
	
	public static SingletonCounter getInstance () {
		
		if (instance == null) {
			return instance = new SingletonCounter();
		}else {
			System.out.println("La instància ja ha estat creada.");
		}
		return instance;
	}
	
	private void incrementInstanceCount() {
		animeInstances++;
	}
	
	public int getInstanceCount() {
		return animeInstances;
	}
	public Anime getNewAnime(String n, int ry, double cl) {
		incrementInstanceCount();
		return new Anime(n, ry, cl);
	}
	
}
