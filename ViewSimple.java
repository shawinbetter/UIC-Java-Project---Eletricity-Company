import javax.swing.JFrame;
import javax.swing.JLabel;

public class ViewSimple extends View<Controller> implements ModelListener {
	private JLabel label;//only this variable left

	public ViewSimple(ElectricityCompany m, Controller c) {
		super(m, c);//everything same as before
		this.setTitle("ViewSimple");
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		label = new JLabel();
		this.add(label);
		update();
		this.setVisible(true);
	}

	@Override
	public void update() {
		label.setText("Total amount consumption: " + m.totalConsumption());// set Text
	}
}
