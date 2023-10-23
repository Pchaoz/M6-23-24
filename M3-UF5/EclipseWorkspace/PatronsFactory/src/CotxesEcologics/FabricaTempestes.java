package CotxesEcologics;

public class FabricaTempestes {
	public Cotxe Generar(Model m, Location l) {
		if (m == Model.Electric) {
			return new CotxeElectric(l);
		}else if (m == Model.Bifuel) {
			return new CotxeBifuel(l);
		}else if (m == Model.Cavalls) {
			return new CotxeCavalls(l);
		}else if (m == Model.Hidrogen) {
			return new CotxeHidrogen(l);
		}else if (m == Model.Hibrid) {
			return new CotxeHibrid(l);
		}else if (m == Model.Drac) {
			return new CotxeDrac(l);
		}else {
			return null;
		}
	}
}
