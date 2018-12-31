
public class ControllerCreate extends Controller {
	public ControllerCreate(ElectricityCompany m) {
		super(m);
	}

	public String create(String name, String amount, int type) {
		int num;
		try {
			num = Integer.parseInt(amount);// first we should know it the input amount correct
		} catch (NumberFormatException n) {
			return n.getMessage();//retrun erroe message
		}
		switch (type) {
		case 0:
			m.addConsumer(new PowerPlant(name, num));
			return "";// return nothing
		case 1:
			try {
				m.addConsumer(new House(name, num));
			} catch (NotAPowerGeneratorException n) {
				return n.getMessage();// return the error message
			}
			return "";
		case 2:
			try {
				m.addConsumer(new SolarHouse(name, num));
			} catch (NotAPowerGeneratorException n) {
				return n.getMessage();
			}
			return "";
		}
		return ""; // to match the return type

	}
}
