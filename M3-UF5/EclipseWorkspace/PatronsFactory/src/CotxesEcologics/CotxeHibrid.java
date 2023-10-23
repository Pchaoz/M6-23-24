package CotxesEcologics;

public class CotxeHibrid implements Cotxe {

	private Location l;
	private Model m = Model.Hibrid;
	
	public CotxeHibrid(Location l) {
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
		return "CotxeHibrid [l=" + l + ", m=" + m + "]";
	}

}
