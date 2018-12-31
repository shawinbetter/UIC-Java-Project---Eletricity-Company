
public abstract class Building implements Consumer {//implements the interface
	private String name;
	private int power;

	public Building(String name, int power) {// constructor
		this.name = name;
		this.power = power;
	}

	@Override
	public String getName() {// override the interface method
		return name;
	}

	@Override
	public int getPower() {// override the interface method
		return power;
	}

	protected void setPower(int power) {// set method
		this.power = power;
	}

	public abstract void morePower(int amount) throws NotAPowerGeneratorException;// abstract

	public static void testBuilding() {
		// an abstract class cannot be test since no object is created
	}
}
