package Targetes;

import java.util.Random;

public abstract class Tarjeta {
	private int codeNumber;
	
	public Tarjeta() {
		Random rng = new Random();
		codeNumber = rng.nextInt(90000000) + 10000000;
	}

	public int getCodeNumber() {
		return codeNumber;
	}

	public void setCodeNumber(int codeNumber) {
		this.codeNumber = codeNumber;
	}

	@Override
	public String toString() {
		return "Tarjeta [codeNumber=" + codeNumber + "]";
	}
}
