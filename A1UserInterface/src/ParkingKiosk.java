import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class ParkingKiosk {

	public ParkingKiosk() {
		new ParkingKioskFrame();
	}

	public static void main(String arg[]) {
		new ParkingKiosk();

	}

	public class ParkingKioskFrame extends JFrame {

		/**
	 * 
	 */
		private static final long serialVersionUID = 1L;

		public ParkingKioskFrame() {
			this.setTitle("Parking Kiosk");
			TouchKeyboard keys = new TouchKeyboard();
			TextFieldPanel field = new TextFieldPanel(keys);
			InsuranceInfoPanel insuranceInfo = new InsuranceInfoPanel(keys);

			JPanel info = new JPanel(new BorderLayout());

			info.setLayout(new BoxLayout(info,
                    BoxLayout.LINE_AXIS));
			info.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

			
			info.add(field);
			info.add(new JSeparator(SwingConstants.VERTICAL));
			info.add(insuranceInfo);
			
			Container contentPane = getContentPane();
			contentPane.add(info, BorderLayout.CENTER);
			contentPane.add(keys, BorderLayout.PAGE_END);
			

			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.pack();
			this.setVisible(true);

		}

	}

}