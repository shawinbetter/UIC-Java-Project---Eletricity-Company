import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class HistoryPanel extends JPanel {
	private ElectricityCompany m;

	public HistoryPanel(ElectricityCompany m) {
		this.m = m;
	}

	private int historyMax(ArrayList<Integer> history) {
		int temp = history.get(0);// we assume that the first number is maximum
		for (int i = 1; i < history.size(); i++) {
			if (history.get(i) > temp) {
				temp = history.get(i);
			}
		}
		return temp;
	}

	private int historyMin(ArrayList<Integer> history) {
		int temp = history.get(0);// same as above
		for (int i = 1; i < history.size(); i++) {
			if (history.get(i) < temp) {
				temp = history.get(i);//get the minimum number
			}
		}
		return temp;
	}

	private int historyRange(ArrayList<Integer> history) {
		if (historyMax(history) - historyMin(history) < 200) {//if the difference is strictly less than 0
			return 200;
		} else {
			return historyMax(history) - historyMin(history);
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int min = historyMin(m.getHistory());
		int range = historyRange(m.getHistory());
		int maxX = getWidth() - 1;
		int maxY = getHeight() - 1;
		int zero = maxY + min * maxY / range;
		g.setColor(Color.BLUE);
		g.drawLine(0, zero, maxX, zero);
		for (int i = 0; i < m.getHistory().size(); i++) {
			g.setColor(Color.RED);
			if (i == 0) {//while there is only one point, draw a rectangle
				g.drawRect(10 * i, zero - ((int) m.getHistory().get(i)) * maxY / range, 1, 1);
				repaint();
			} else {
				int x1 = 10 * (i - 1);
				int y1 = zero - ((int) m.getHistory().get(i - 1)) * maxY / range;
				int x2 = 10 * (i);
				int y2 = zero - ((int) m.getHistory().get(i)) * maxY / range;
				g.drawLine(x1, y1, x2, y2);//connect this points
				repaint();
			}

		}

	}
}
