
public class ControllerMorePower extends Controller {
	public ControllerMorePower(ElectricityCompany m) {
		super(m);
	}

	public String morePower(String name, String amount) {
		int num;
		try {
			num = Integer.parseInt(amount);// first we should know it the input amount correct
		} catch (NumberFormatException n) {
			return n.getMessage();
		}
		try {
			m.morePower(name, num);
		} catch (UnknownConsumerException u) {// catch exception
			return u.getMessage();
		} catch (NotAPowerGeneratorException n) {// catch exception
			return n.getMessage();
		}
		return "";// return nothing
	}
}
