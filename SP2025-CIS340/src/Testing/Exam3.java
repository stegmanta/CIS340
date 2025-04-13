package Testing;

import java.awt.*;

import javax.swing.*;

public class Exam3 {

	public static void main(String[] args) {
		
		
		// FlowLayout Example
		JPanel flowPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		flowPanel.add(new JButton("One"));
		flowPanel.add(new JButton("Two"));
//		flowPanel.add(new JButton("Three"));
		JFrame flowFrame = new JFrame("FlowLayout Demo");
		flowFrame.add(flowPanel);
		flowFrame.pack();
		flowFrame.setVisible(true);
		
		// GridLayout
		JPanel grid = new JPanel(new GridLayout(2, 3, 5, 5)); // 2 rows, 3 cols, hgap=5, vgap=5
		for (int i = 1; i <= 6; i++) {
		    grid.add(new JButton("Btn " + i));
		}

		JFrame gridFrame = new JFrame("GridLayout Demo");
		gridFrame.add(grid);
		gridFrame.pack();
		gridFrame.setVisible(true);
		
		// BorderLayout
		JFrame borderFrame = new JFrame("BorderLayout Demo");
		borderFrame.setLayout(new BorderLayout(5, 5)); // hgap=5, vgap=5
		borderFrame.add(new JButton("North"),  BorderLayout.NORTH);
//		borderFrame.add(new JButton("South"),  BorderLayout.SOUTH);
//		borderFrame.add(new JButton("East"),   BorderLayout.EAST);
//		borderFrame.add(new JButton("West"),   BorderLayout.WEST);
//		borderFrame.add(new JButton("Center"), BorderLayout.CENTER);
		borderFrame.pack();
		borderFrame.setVisible(true);

	}

}
