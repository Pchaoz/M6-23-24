package CotxesEcologics;

public class CotxeCavalls implements Cotxe {
	
	private Model m = Model.Cavalls;
	private Location l;

	public CotxeCavalls(Location l) {
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

}
