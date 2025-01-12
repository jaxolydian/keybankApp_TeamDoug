package keybankApp.app;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;

import keybankApp.colors.Theme;

public class Edit {

	private int accNumber;
	Theme kbTheme = new Theme();
	JFrame frame = new JFrame();
	JToolBar toolbar = new JToolBar();
	JPanel holdingPanel = new JPanel();
	JLabel kbLogo = new JLabel();
	JPanel holdingPanel2 = new JPanel(new GridBagLayout());
	JPanel tehCahd = new JPanel(new GridBagLayout());
	GridBagConstraints cahd = new GridBagConstraints();
	JLabel labelForName = new JLabel("Name: ");
	JLabel namee = new JLabel("");
	JLabel labelForCCN = new JLabel("Card #: ");
	JTextField ccnn = new JTextField("");
	JLabel labelForCCV = new JLabel("CCV #: ");
	JTextField ccvL = new JTextField("");
	JLabel labelForCurrentPin = new JLabel("Current Pin #: ");
	JTextField pin1 = new JTextField("");
	JLabel labelForNewPin = new JLabel("New Pin #: ");
	JTextField pin2 = new JTextField("");
	JLabel tehTitall = new JLabel();
	JButton confirm = new JButton("Confirm");
	
	
	GridBagConstraints c = new GridBagConstraints();
	public Edit(ArrayList<String> ccn, ArrayList<Integer> ccv, ArrayList<Double> dollaBillz, ArrayList<Integer> pinz) {
		try {
			BufferedImage lockBankLogo = ImageIO.read(new File("src/imgs/lockbank3KB.png"));
			ImageIcon image = new ImageIcon(lockBankLogo);
			kbLogo.setIcon(image);
		} catch (IOException err) {
			System.err.println("lol ur bad");
		}
		
		tehTitall.setText("Account Setup");
		c.insets = new Insets(0,0,0,0);
		c.gridx = 0;
		c.gridy = 0;
		c.ipadx = 0;
		c.ipady = 0;
		cahd.insets = new Insets(0,0,0,0);
		cahd.gridx = 0;
		cahd.gridy = 0;
		cahd.ipadx = 0;
		cahd.ipady = 0;
		cahd.gridx = 0;
		cahd.gridy = 0;
		tehTitall.setFont(kbTheme.getKbBody36());
		holdingPanel2.add(tehTitall, c);
		c.gridy = 1;
		labelForCCN.setFont(kbTheme.getKbBody36());
		tehCahd.add(labelForCCN, cahd);
		cahd.gridx = 1;
		ccnn.setFont(kbTheme.getKbCode36());
		ccnn.setText(""+ccn);
		tehCahd.add(ccnn, cahd);
		cahd.gridx = 0;
		cahd.gridy = 1;
		labelForCCV.setFont(kbTheme.getKbBody36());
		tehCahd.add(labelForCCV, cahd);
		cahd.gridx = 1;
		ccvL.setFont(kbTheme.getKbCode36());
		ccvL.setText(""+ccv);
		tehCahd.add(ccvL, cahd);
		cahd.gridx = 0;
		cahd.gridy = 2;
		labelForCurrentPin.setFont(kbTheme.getKbBody36());
		tehCahd.add(labelForCurrentPin, cahd);
		cahd.gridx = 1;
		pin1.setFont(kbTheme.getKbCode36());
		pin1.setText(""+pinz);
		tehCahd.add(pin1, cahd);
		cahd.gridx = 0;
		cahd.gridy = 3;
		labelForNewPin.setFont(kbTheme.getKbBody36());
		tehCahd.add(labelForNewPin, cahd);
		cahd.gridx = 1;
		pin2.setFont(kbTheme.getKbCode36());
		pin2.setText(""+pinz);
		tehCahd.add(pin2, cahd);
		cahd.gridy = 4;
		System.out.println();
		confirm.setFont(kbTheme.getKbBody36());
		tehCahd.add(confirm, cahd);
		ccnn.setPreferredSize(new Dimension(400, 50));
		ccvL.setPreferredSize(new Dimension(400, 50));
		pin1.setPreferredSize(new Dimension(400, 50));
		pin2.setPreferredSize(new Dimension(400, 50));
//		setAccNumber(accountNumber);
		frame.setTitle("Details");
		frame.setMinimumSize(new Dimension(880, 520));
		frame.setSize(880, 520+100);
		toolbar.setFloatable(false);
		frame.setResizable(false);
		holdingPanel.setBackground(kbTheme.getKbRed());
		frame.add(holdingPanel);
		frame.add(toolbar, BorderLayout.NORTH);
		holdingPanel2.setMinimumSize(new Dimension(870, 452+100));
		holdingPanel2.setPreferredSize(new Dimension(870, 452+100));
		holdingPanel.add(holdingPanel2, BorderLayout.CENTER);
		tehCahd.setBorder(BorderFactory.createLineBorder(Color.red));
		tehCahd.setBackground(Color.white);
		tehCahd.setMinimumSize(new Dimension(865-100, 448-100));
		tehCahd.setMaximumSize(new Dimension(865-100, 448-100));
		tehCahd.setPreferredSize(new Dimension(865-100, 448-100));
		tehTitall.setMinimumSize(new Dimension(865-100, 250-200));
		tehTitall.setMaximumSize(new Dimension(865-100, 250-200));
		tehTitall.setPreferredSize(new Dimension(865-100, 250-200));
		holdingPanel2.add(tehCahd, c);
		toolbar.add(kbLogo);
		toolbar.setMinimumSize(new Dimension(880, 30));
		toolbar.setMaximumSize(new Dimension(880, 30));
		toolbar.setPreferredSize(new Dimension(880, 30));
		kbLogo.setFont(kbTheme.getKbHeader());
		toolbar.setBackground(Color.white);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
	}
	public int getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}

}
