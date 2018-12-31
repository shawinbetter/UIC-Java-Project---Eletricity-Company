import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ViewGetPower extends View<ControllerGetPower> implements ModelListener{
	private JTextField t;
	public ViewGetPower(ElectricityCompany m, ControllerGetPower c) {
		super(m,c);
		this.setTitle("View Power");
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		GridLayout gl = new GridLayout(2,1);
		this.setLayout(gl);
		t = new JTextField("Type a consumer name here");//create an new JText object
		JButton j = new JButton("Tell me the power");//create an new Button
		j.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,c.getPower(t.getText()));
			}
		});
		this.add(t,gl);
		this.add(j,gl);
		this.setVisible(true);
	}
	public void update() {
		
	}

}
