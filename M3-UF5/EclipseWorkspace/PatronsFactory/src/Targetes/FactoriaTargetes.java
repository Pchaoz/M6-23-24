package Targetes;

public class FactoriaTargetes {
	public void generarTarjeta(Client c) {
		
		if (c.getTarjeta() == null) {
			if (c.getSalary() > 425) {
				c.setTarjeta(new TarjetaCredit());
				System.out.println("TARJETA DE CREDIT CREADA");
			}else if(c.getSalary() > 0) {
				c.setTarjeta(new TarjetaDebit());
				System.out.println("TARJETA DE DEBIT CREADA");
			}else {
				System.out.println("ERROR, SALARI INSUFICIENT");
			}
		}else {
			System.out.println("ERROR, EL CLIENT YA TE LA TARJETA");
		}
	}
}
