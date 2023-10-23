package CotxesEcologics;

public class CotxeHidrogen implements Cotxe {

	private Location l;
	private Model m = Model.Hidrogen;
	
	public CotxeHidrogen (Location l) {
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
		return "CotxeHidrogen [l=" + l + ", m=" + m + "]";
	}
	

}
