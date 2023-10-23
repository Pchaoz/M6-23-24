package CotxesEcologics;

public class CotxeDrac implements Cotxe {
	
	private Location l;
	private Model m = Model.Drac;
	
	public CotxeDrac(Location l) {
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
		return "CotxeDrac [l=" + l + ", m=" + m + "]";
	}

}
