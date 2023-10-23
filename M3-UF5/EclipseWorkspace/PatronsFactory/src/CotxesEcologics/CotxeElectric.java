package CotxesEcologics;

public class CotxeElectric implements Cotxe {

	private Location l;
	private Model m = Model.Electric;
	
	public CotxeElectric (Location l) {
		this.l = l;
	}
	
	@Override
	public Model getModel() {
		return m;
	}

	@Override
	public Location getLocation() {
		return l;
	}

	@Override
	public String toString() {
		return "CotxeElectric [l=" + l + ", m=" + m + "]";
	}

	
}
