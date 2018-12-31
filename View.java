import javax.swing.JFrame;

public abstract class View<T extends Controller> extends JFrame implements ModelListener {
	protected ElectricityCompany m;
	protected T c;

	public View(ElectricityCompany m, T c) {//constructor
		this.m = m;
		this.c = c;
		m.addListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//for Convenience
	}

	public abstract void update();
}
