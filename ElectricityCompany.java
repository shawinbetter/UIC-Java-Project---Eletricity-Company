import java.util.ArrayList;

public class ElectricityCompany {
	private String name;
	private ArrayList<Consumer> consumers;// take Consumer as generic
	private ArrayList<ModelListener> listeners;
	private ArrayList<Integer> history;

	public ElectricityCompany(String name) {
		this.name = name;
		consumers = new ArrayList<Consumer>();// create an null array list
		listeners = new ArrayList<ModelListener>();
		history = new ArrayList<Integer>();// create object
		history.add(0);// generating or consuming 0 powers
	}

	public void addConsumer(Consumer consumer) {
		consumers.add(consumer);// add an object
		history.add(totalConsumption());// before notify listeners
		notifyListeners();
	}

	public void addListener(ModelListener ml) {
		listeners.add(ml);
	}

	private void notifyListeners() {
		for (ModelListener ml : listeners) {
			ml.update();
		}
	}

	public int totalConsumption() {
		int total = 0;// count the total consumption
		for (int i = 0; i < consumers.size(); i++) {// read all the object in the array list
			total += consumers.get(i).getPower();// sum
		}
		return total;
	}

	public int getPower(String name) throws UnknownConsumerException {
		for (int i = 0; i < consumers.size(); i++) {// read all the object
			if (name.equals(consumers.get(i).getName())) {// if it finds corresponded name
				return consumers.get(i).getPower();
			}
		}
		throw new UnknownConsumerException("Consumer " + name + " unknown");// no name
	}

	public void morePower(String name, int amount) throws UnknownConsumerException, NotAPowerGeneratorException {
		for (int i = 0; i < consumers.size(); i++) {// read all the object
			if (name.equals(consumers.get(i).getName())) {// if it finds corresponded name
				consumers.get(i).morePower(amount);
				history.add(totalConsumption());// before notify listeners
				notifyListeners();
				return;
			}
		}
		throw new UnknownConsumerException("Consumer " + name + " unknown");
	}

	public ArrayList<Integer> getHistory() {
		return history;//return the history array list
	}

	public static void testElectricityCompany() {
		ElectricityCompany e = new ElectricityCompany("company");// create an object
		e.addConsumer(new PowerPlant("powerplant", 1000));// add a consumer
		House h = null;
		try {
			h = new House("house", 1000);
		} catch (NotAPowerGeneratorException n) {
			System.out.println(n.getMessage().equals("A new house cannot generate power"));
		} finally {
		}
		e.addConsumer(h);// finally add h into array list
		// below is same as above
		SolarHouse s = null;
		try {
			s = new SolarHouse("solarhouse", 1000);
		} catch (NotAPowerGeneratorException n) {
			System.out.println(n.getMessage().equals("A new house cannot generate power"));
		} finally {
			e.addConsumer(s);
		}
		System.out.println(e.totalConsumption() == 1000);// since 1000+1000-1000 = 1000
		try {
			System.out.println(e.getPower("powerplant") == -1000);// generate 1000 watts of power
		} catch (UnknownConsumerException n) {
			System.out.println(n.getMessage() == "Consumer powerplant unknown");
		}
		try {
			System.out.println(e.getPower("house") == 1000);// consumed 1000 watts
		} catch (UnknownConsumerException n) {
			System.out.println(n.getMessage() == "Consumer house unknown");
		}
		try {
			System.out.println(e.getPower("solarhouse") == 1000);// consumed 1000 watts
		} catch (UnknownConsumerException n) {
			System.out.println(n.getMessage() == "Consumer solarhouse unknown");
		}
		try {
			System.out.println(e.getPower("unknown"));// unknown consumer
		} catch (UnknownConsumerException n) {
			System.out.println(n.getMessage().equals("Consumer unknown unknown"));
		}
		try {
			e.morePower("house", 1000);// house consumes 1000 watts more

		} catch (UnknownConsumerException u) {
		} catch (NotAPowerGeneratorException n) {
		}
		try {
			System.out.println(e.getPower("house") == 2000);// house consumes 2000 watts
		} catch (UnknownConsumerException n) {
			System.out.println(n.getMessage() == "Consumer house unknown");
		}
	}
}
