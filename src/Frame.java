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
		
		this.setTitle("DigitalClock");
		this.setSize(600, 250); 
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setLayout(new FlowLayout());

		// time label visual representation
		timeFormat = new SimpleDateFormat("hh:mm:ss a"); // time format set to hour:minute:seconds AM/PM
		timeLabel = new JLabel();
		timeLabel.setFont(new Font("Arial", Font.PLAIN, 70));
		timeLabel.setForeground(Color.red);
		timeLabel.setBackground(Color.black);
		timeLabel.setOpaque(true); 

		// date label visual representation
		dateFormat = new SimpleDateFormat("E dd/MM/yyyy"); // date format set to weekday day/month/year
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

	/** updates time every second and sets time and date labels to display time. */
	public void startClock() {
		while (true) {
			timeLabel.setText(timeFormat.format(Calendar.getInstance().getTime()));
			dateLabel.setText(dateFormat.format(Calendar.getInstance().getTime()));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
