import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

public class InsuranceInfoPanel extends JPanel implements ActionListener,FocusListener{
	
	private static final long serialVersionUID = 1L;
	
	private JComboBox companyList;
	
	private JTextField make;
	private JTextField model;
	private JTextField plate;
	
	private JLabel insuranceLabel = new JLabel("Vehicle & Insurance Information: ");
	private JLabel makeLabel = new JLabel("Vehicle Make: ");
	private JLabel modelLabel = new JLabel("Vehicle Model: ");
	private JLabel plateNumLabel = new JLabel("License Plate Number: ");
	
	private TouchKeyboard keys;
	
	public InsuranceInfoPanel(TouchKeyboard keys){	
		 String[] company = { "Co-operators Insurance Company of Canada", 
				 					"State Farm Underwriters Incorporated", 
				 					"Allstate International Insurance Company Ltd.", 
				 					"Metropolitan Life Insurance Company", 
				 					"Bang Em Up Insurance Company of Vaughan",
				 					"Tightwads Incorporated",
				 					"Gottcha Insurance Company, Inc."};
		 
	    companyList = new JComboBox(company);
	    
	    make = new JTextField(20);
		model = new JTextField(20);
		plate = new JTextField(20);
		
		make.addFocusListener(this);
		model.addFocusListener(this);
		plate.addFocusListener(this);
	     
	    companyList.addActionListener(this);
	     
	     this.setLayout(new GridBagLayout());
			GridBagConstraints gc = new GridBagConstraints();
			gc.fill = GridBagConstraints.BOTH;
			gc.insets = new Insets(10, 10, 10, 10);

			gc.gridx = 0;
			gc.gridy = 0;
			this.add(makeLabel, gc);
			gc.gridx = 1;
			this.add(make, gc);
			
			gc.gridy = 1;
			gc.gridx = 0;
			this.add(modelLabel, gc);
			gc.gridx = 1;
			this.add(model, gc);
			
			gc.gridy = 2;
			gc.gridx = 0;
			this.add(plateNumLabel, gc);
			gc.gridx = 1;
			this.add(plate, gc);
			
			gc.gridy = 3;
			gc.gridx = 0;
			this.add(insuranceLabel, gc);
			gc.gridx = 1;
			this.add(companyList, gc);
			
			this.keys = keys;
			keys.setTextField(make);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 JComboBox cb = (JComboBox)e.getSource();
	     String company = (String)cb.getSelectedItem();
	}
	
	@Override
	public void focusGained(FocusEvent fe) {
		if (fe.getSource() == make) {
			keys.setTextField(make);
			keys.setInput(make.getText());
		} else if (fe.getSource() == model) {
			keys.setTextField(model);
			keys.setInput(model.getText());
		} else if (fe.getSource() == plate) {
			keys.setTextField(plate);
			keys.setInput(plate.getText());
		}
	}

	@Override
	public void focusLost(FocusEvent fe) {
		// TODO Auto-generated method stub
		
	}
	
	public void setTouchKeyboard(TouchKeyboard keys) {
		this.keys = keys;
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Combo Box Panel");
		InsuranceInfoPanel panel = new InsuranceInfoPanel(new TouchKeyboard());
		frame.setContentPane(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();

		// put the frame in the middle of the display
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height
				/ 2 - frame.getSize().height / 2);

		frame.setVisible(true);
	}

}
