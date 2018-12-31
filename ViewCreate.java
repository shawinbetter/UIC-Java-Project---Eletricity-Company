import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ViewCreate extends View<ControllerCreate> implements ModelListener {
	private JTextField t1;
	private JTextField t2;
	private JComboBox<String> cb;

	public ViewCreate(ElectricityCompany m, ControllerCreate c) {
		super(m, c);
		this.setTitle("View Create");
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		GridLayout gl = new GridLayout(4, 1);// create an layout object
		this.setLayout(gl);
		t1 = new JTextField("Type a new consumer name here");
		t2 = new JTextField("Type an amount of power here");
		cb = new JComboBox<String>(new String[] { "Power Plant", "House", "Solar House" });
		JButton j = new JButton("Create");
		j.addActionListener(new ActionListener() {//add a listener
			@Override
			public void actionPerformed(ActionEvent e) {
				if(c.create(t1.getText(), t2.getText(), cb.getSelectedIndex()).equals("")) {
					//it no exception, nothing happen
				}else {
					JOptionPane.showMessageDialog(null,c.create(t1.getText(), t2.getText(), cb.getSelectedIndex()));
				}
			}
		});
		this.add(t1);
		this.add(t2);
		this.add(cb);
		this.add(j);//add them 
		this.setVisible(true);
	}

	public void update() {

	}
}
