
public class SolarHouse extends House {
	public SolarHouse(String name, int power) throws NotAPowerGeneratorException {// throw Exception
		super(name, power);// super must put first
		if (power < 0) {// conditional statement
			throw new NotAPowerGeneratorException("A new house cannot generate power");
		}
	}

	@Override
	public void morePower(int power) {// throw no exception
		setPower(getPower() + power);
	}

	public static void testSolarHouse() {
		SolarHouse s = null;// create an null object
		try {
			s = new SolarHouse("jack", 1000);
			s = new SolarHouse("jack", -1000);// it throws exception

		} catch (NotAPowerGeneratorException n) {
			System.out.println(n.getMessage().equals("A new house cannot generate power"));
		}
		System.out.println(s.getName() == "jack");
		System.out.println(s.getPower() == 1000);
		s.setPower(1100);
		System.out.println(s.getPower() == 1100);
		s.morePower(100);
		System.out.println(s.getPower() == 1200);
		s.morePower(-1300);// it must generate 1300 watts of power
		System.out.println(s.getPower() == -100);// it consumed 1200 watts, and generate 1300 watts
	}
}
