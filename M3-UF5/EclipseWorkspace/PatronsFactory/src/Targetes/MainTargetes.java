package Targetes;

public class MainTargetes {
	public static void main(String[] args) {
		
		FactoriaTargetes ft = new FactoriaTargetes();
		
		Client c1 = new Client("Pol", 300);
		Client c2 = new Client("Raul", 12033.12);
		Client c3 = new Client("Jose", 10213.55, new TarjetaCredit());
		Client c4 = new Client("Mireia", -22);
		
		ft.generarTarjeta(c1);
		ft.generarTarjeta(c2);
		ft.generarTarjeta(c3);
		ft.generarTarjeta(c4);
	}
}
