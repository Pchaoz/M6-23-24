package Main;

import Observer.ClasseQueEscucha;
import Observer.GenericPropertyChanges;

public class Main {

	public static void main(String[] args) {
		GenericPropertyChanges pc = new GenericPropertyChanges();
		
		//HAGO LA CLSE QUE ESCUCHA
		ClasseQueEscucha cqe = new ClasseQueEscucha();
		
		pc.addPropertyChangeListener(cqe); //SUBSCRIBO AL EVENTO
		
		pc.setTipusAigua("patata"); //HACE EL CAMBIO Y LO ENVIA A LOS DEMAS
	}
}
