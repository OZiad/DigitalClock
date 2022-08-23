import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame extends JFrame {
	// Instance variables declaration
	JLabel timeLabel;
	JLabel dateLabel;
	SimpleDateFormat timeFormat;
	SimpleDateFormat dateFormat;

	Frame() {
		this.setTitle("DigitalClock"); // Set frame title
		this.setSize(600, 250); // Set frame size (width x height)
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set window to close when close button is pressed
		this.setLayout(new FlowLayout()); // JFrame layout

		// time label visual representation
		timeFormat = new SimpleDateFormat("hh:mm:ss a"); // time format set to hour:minute:seconds AM/PM
		timeLabel = new JLabel();
		timeLabel.setFont(new Font("Arial", Font.PLAIN, 70));
		timeLabel.setForeground(Color.red);
		timeLabel.setBackground(Color.black);
		timeLabel.setOpaque(true); // make background visible

		// date label visual representation
		dateFormat = new SimpleDateFormat("E dd/MM/yyyy"); // date format set to day/month/year
		dateLabel = new JLabel();
		dateLabel.setFont(new Font("Arial", Font.PLAIN, 70));
		dateLabel.setForeground(Color.red);
		dateLabel.setBackground(Color.black);
		dateLabel.setOpaque(true);

		// Add labels to frame
		this.add(timeLabel);
		this.add(dateLabel);
		this.setVisible(true); // make Frame window visible
	}

	// method to update time every second
	public void startClock() {
		while (true) {
			timeLabel.setText(timeFormat.format(Calendar.getInstance().getTime()));
			dateLabel.setText(dateFormat.format(Calendar.getInstance().getTime()));
			try {
				Thread.sleep(1000); // sleep method until next second
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
