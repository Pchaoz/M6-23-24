package Comparadors;

public class Anime implements Comparable<Anime> {
	
	private String name;
	private int release_year;
	private int cap_length;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRelease_year() {
		return release_year;
	}

	public void setRelease_year(int release_year) {
		this.release_year = release_year;
	}

	public int getCap_length() {
		return cap_length;
	}

	public void setCap_length(int cap_length) {
		this.cap_length = cap_length;
	}

	public Anime(String name, int release_year, int cap_length) {
		super();
		this.name = name;
		this.release_year = release_year;
		this.cap_length = cap_length;
	}

	@Override
	public String toString() {
		return "Anime [name=" + name + ", release_year=" + release_year + ", cap_length=" + cap_length + "]";
	}

	@Override
	public int compareTo(Anime o) {
		return this.name.compareTo(o.name);
	}
}
