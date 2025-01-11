package keybankApp.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import keybankApp.colors.Theme;

public class UserInputRegions implements ActionListener {

	Theme kbTheme = new Theme();
	JFrame frame = new JFrame();
	JPanel holdingPanel = new JPanel();
	JPanel holdingPanel2 = new JPanel(new GridBagLayout());
	JPanel holdingPanel3 = new JPanel(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
	JPanel discussingTheFilepath = new JPanel(new GridBagLayout());
	JLabel label = new JLabel("Enter filepath: ");
	JLabel errMessage = new JLabel("");
	JTextField filepathArea = new JTextField();
	JButton confirm = new JButton("Confirm");
	GridBagConstraints g = new GridBagConstraints();
	public UserInputRegions() /* Starting account setup */ {
		c.insets = new Insets(0,0,0,0);
		c.gridx = 0;
		c.gridy = 0;
		c.ipadx = 0;
		c.ipady = 0;
		discussingTheFilepath.add(label, c);
		c.gridx = 1;
		discussingTheFilepath.add(filepathArea, c);
		filepathArea.setPreferredSize(new Dimension(180, 24));
		g.insets = new Insets(0,0,0,0);
		g.gridx = 0;
		g.gridy = 0;
		g.ipadx = 0;
		g.ipady = 0;
		frame.setTitle("LockBank");
		frame.setMinimumSize(new Dimension(680, 720));
		frame.setSize(680, 720);
		frame.setResizable(false);
		confirm.addActionListener(this);
		holdingPanel.setBackground(kbTheme.getKbRed());
		holdingPanel2.setMinimumSize(new Dimension(670, 700));
		holdingPanel2.setPreferredSize(new Dimension(670, 682));
		holdingPanel.add(holdingPanel2, BorderLayout.CENTER);
		discussingTheFilepath.setMinimumSize(new Dimension(295, 50));
		discussingTheFilepath.setPreferredSize(new Dimension(295, 50));
		holdingPanel3.setBorder(BorderFactory.createLineBorder(Color.red, 1));
		holdingPanel3.setMinimumSize(new Dimension(300, 100));
		holdingPanel3.setPreferredSize(new Dimension(300, 100));
		discussingTheFilepath.setBackground(Color.white);
		holdingPanel3.setBackground(Color.white);
		holdingPanel3.add(discussingTheFilepath, g);
		g.gridy = 1;
		holdingPanel3.add(confirm, g);
		g.gridy = 2;
		errMessage.setFont(kbTheme.getKbCode());
		errMessage.setForeground(Color.red);
		holdingPanel3.add(errMessage, g);
		holdingPanel2.add(holdingPanel3, c);
		confirm.setFont(kbTheme.getKbHeader());
		confirm.setPreferredSize(new Dimension(120, 40));
		frame.add(holdingPanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(confirm)) {
			File filePath = new File(filepathArea.getText());
			if (!filePath.isFile()) {
				System.out.println("No filepath input.");
			} else {
			new App();
			frame.dispose();
			}
		}
	}
}
