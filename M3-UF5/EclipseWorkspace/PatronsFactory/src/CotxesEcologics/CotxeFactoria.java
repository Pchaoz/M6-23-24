package CotxesEcologics;

public class CotxeFactoria {
	public Cotxe Crear(Location l, Model m) {
		if (l == Location.ElPrincipatDeDorne) {
			return new FabricaElPrincipatDeDorne().Generar(m, l);
		}else if (l == Location.Harrenhal) {
			return new FabricaHarrenhal().Generar(m, l);
		}else if (l == Location.Invernalia) {
			return new FabricaInvernalia().Generar(m, l);
		}else if (l == Location.RocaCasterly) {
			return new FabricaRocaCasterly().Generar(m, l);
		}else if (l == Location.Tempestes) {
			return new FabricaTempestes().Generar(m, l);
		}else {
			return null;
		}
	}
}
