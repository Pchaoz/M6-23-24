package CotxesEcologics;

public class CotxeBifuel implements Cotxe {

	private Location l;
	private Model m = Model.Bifuel;
	
	public CotxeBifuel(Location l) {
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
		return "CotxeBifuel [l=" + l + ", m=" + m + "]";
	}

	

}
