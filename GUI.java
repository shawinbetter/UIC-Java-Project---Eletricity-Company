
public class GUI {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				ElectricityCompany m = new ElectricityCompany("UIC Electric");

				Controller c = new Controller(m);
				ViewSimple vs = new ViewSimple(m, c);
				ControllerGetPower cg = new ControllerGetPower(m);
				ViewGetPower vgp = new ViewGetPower(m, cg);
				ControllerMorePower mp = new ControllerMorePower(m);
				ViewMorePower vmp = new ViewMorePower(m, mp);
				ControllerCreate cc = new ControllerCreate(m);
				ViewCreate vc = new ViewCreate(m, cc);
				ControllerHistory ch = new ControllerHistory(m);
				ViewHistory vh = new ViewHistory(m, ch);

			}
		});
	}
}
