package CotxesEcologics;

import java.util.ArrayList;

public class MainCotxes {
	public static void main(String[] args) {
		CotxeFactoria cf = new CotxeFactoria();
		
		ArrayList<Cotxe> tremendoGarage = new ArrayList<Cotxe>();
		
		Cotxe cotxe1 = cf.Crear(Location.ElPrincipatDeDorne, Model.Bifuel);
		Cotxe cotxe2 = cf.Crear(Location.RocaCasterly, Model.Cavalls);
		Cotxe cotxe3 = cf.Crear(Location.ElPrincipatDeDorne, Model.Drac);
		Cotxe cotxe4 = cf.Crear(Location.Tempestes, Model.Electric);
		Cotxe cotxe5 = cf.Crear(Location.Invernalia, Model.Hibrid);
		Cotxe cotxe6 = cf.Crear(Location.Harrenhal, Model.Hidrogen);
		
		tremendoGarage.add(cotxe6);
		tremendoGarage.add(cotxe5);
		tremendoGarage.add(cotxe4);
		tremendoGarage.add(cotxe3);
		tremendoGarage.add(cotxe2);
		tremendoGarage.add(cotxe1);
		
		System.out.println(tremendoGarage);
	}
}
