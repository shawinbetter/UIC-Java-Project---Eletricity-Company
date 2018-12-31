import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ViewMorePower extends View<ControllerMorePower> implements ModelListener {
	private JTextField t1;
	private JTextField t2;

	public ViewMorePower(ElectricityCompany m, ControllerMorePower c) {
		super(m, c);
		this.setTitle("View More Power");
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		GridLayout gl = new GridLayout(3, 1);// create an layout object
		this.setLayout(gl);
		t1 = new JTextField("Type a consumer name here");
		t2 = new JTextField("Type an amount of power here");
		JButton j = new JButton("More Power");
		j.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (c.morePower(t1.getText(), t2.getText()).equals("")) {
					// nothing happen
				} else {
					JOptionPane.showMessageDialog(null, c.morePower(t1.getText(), t2.getText()));
				}
			}
		});
		this.add(t1, gl);
		this.add(t2, gl);
		this.add(j, gl);// add them
		this.setVisible(true);
	}

	public void update() {

	}
}
