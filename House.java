
public class House extends Building {
	public House(String name, int power) throws NotAPowerGeneratorException {// throw Exception
		super(name, power);// super must put first
		if (power < 0) {// conditional statement
			throw new NotAPowerGeneratorException("A new house cannot generate power");
		}
	}

	@Override
	public void morePower(int amount) throws NotAPowerGeneratorException {
		if (getPower() + amount >= 0) {// conditional statement
			setPower(getPower() + amount);// set the power
		} else {
			int result = -(getPower() + amount);// get the value of XXX
			throw new NotAPowerGeneratorException("A house cannot generate " + result + " watts of power");
		}
	}

	public static void testHouse() {// test
		House h = null;// create a void object to store in the register
		try {
			h = new House("jack", 1000);
			h = new House("jack", -1000);// it must throw exception
		} catch (NotAPowerGeneratorException n) {// catch it
			System.out.println(n.getMessage().equals("A new house cannot generate power"));
		}
		System.out.println(h.getName() == "jack");
		System.out.println(h.getPower() == 1000);
		h.setPower(1100);// set power
		System.out.println(h.getPower() == 1100);
		try {
			h.morePower(100);
		} catch (NotAPowerGeneratorException n) {
			System.out.println(n.getMessage().equals("A house cannot generate XXX watts of power"));// we don't need
																									// this test
		}
		System.out.println(h.getPower() == 1200);// consumes more 100 power
		try {
			h.morePower(-1300);// we know it must throw exception
		} catch (NotAPowerGeneratorException n) {
			System.out.println(n.getMessage().equals("A house cannot generate 100 watts of power"));// -(-1300+1200)=100
		}
		System.out.println(h.getPower() == 1200);// nothing happened
		try {
			h.morePower(-200);
		} catch (NotAPowerGeneratorException n) {
			System.out.println(n.getMessage().equals("A new house cannot generate XXX power"));// we know 200 is
																								// acceptable
		}
		System.out.println(h.getPower() == 1000);
	}

}
