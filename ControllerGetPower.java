
public class ControllerGetPower extends Controller {
	public ControllerGetPower(ElectricityCompany m) {
		super(m);
	}

	public String getPower(String name) {
		String str = "";//create an null string to store
		try {
			str += m.getPower(name);
		} catch (UnknownConsumerException u) {
			return u.getMessage();//return the error message
		}
		return str;
	}
}
