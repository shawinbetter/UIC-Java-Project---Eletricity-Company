
public class ViewHistory extends View<ControllerHistory> implements ModelListener {
	public ViewHistory(ElectricityCompany m, ControllerHistory c) {
		super(m, c);
		this.setTitle("View History");//title
		this.setSize(400, 200);
		this.setLocationRelativeTo(null);
		HistoryPanel hp = new HistoryPanel(m);
		update();//call the update method
		this.add(hp);//add this object
		this.setVisible(true);
	}

	public void update() {//call the swing repaint method
		repaint();
	}
}
