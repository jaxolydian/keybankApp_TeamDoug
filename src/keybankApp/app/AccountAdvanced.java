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

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;

import keybankApp.colors.Theme;

public class AccountAdvanced {

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
	JLabel ccnn = new JLabel("");
	JLabel labelForCCV = new JLabel("CCV #: ");
	JLabel ccvL = new JLabel("");
	JLabel labelForMoney = new JLabel("Amount: ");
	JLabel money = new JLabel("");
	JLabel tehTitall = new JLabel();
	GridBagConstraints c = new GridBagConstraints();
	public AccountAdvanced(int accountNumber, String name, String ccn, int ccv, double dollaBillz) {
		try {
			BufferedImage lockBankLogo = ImageIO.read(new File("src/imgs/lockbank3KB.png"));
			ImageIcon image = new ImageIcon(lockBankLogo);
			kbLogo.setIcon(image);
		} catch (IOException err) {
			System.err.println("lol ur bad");
		}
		tehTitall.setText("Account #"+(accountNumber+1));
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
		holdingPanel2.add(tehTitall, c);
		tehTitall.setFont(kbTheme.getKbBody36());
		c.gridy = 1;
		labelForName.setFont(kbTheme.getKbBody36());
		tehCahd.add(labelForName, cahd);
		cahd.gridx = 1;
		namee.setFont(kbTheme.getKbCode36());
		namee.setText(name);
		tehCahd.add(namee, cahd);
		cahd.gridx = 0;
		cahd.gridy = 1;
		labelForCCN.setFont(kbTheme.getKbBody36());
		tehCahd.add(labelForCCN, cahd);
		cahd.gridx = 1;
		ccnn.setFont(kbTheme.getKbCode36());
		ccnn.setText(ccn);
		tehCahd.add(ccnn, cahd);
		cahd.gridx = 0;
		cahd.gridy = 2;
		labelForCCV.setFont(kbTheme.getKbBody36());
		tehCahd.add(labelForCCV, cahd);
		cahd.gridx = 1;
		ccvL.setFont(kbTheme.getKbCode36());
		ccvL.setText(""+ccv);
		tehCahd.add(ccvL, cahd);
		cahd.gridx = 0;
		cahd.gridy = 3;
		labelForMoney.setFont(kbTheme.getKbBody36());
		tehCahd.add(labelForMoney, cahd);
		cahd.gridx = 1;
		money.setFont(kbTheme.getKbCode36());
		money.setText("$"+dollaBillz);
		tehCahd.add(money, cahd);
		System.out.println();
		setAccNumber(accountNumber);
		frame.setTitle("Details");
		frame.setMinimumSize(new Dimension(880, 520));
		frame.setSize(880, 520);
		toolbar.setFloatable(false);
		frame.setResizable(false);
		holdingPanel.setBackground(kbTheme.getKbRed());
		frame.add(holdingPanel);
		frame.add(toolbar, BorderLayout.NORTH);
		holdingPanel2.setMinimumSize(new Dimension(870, 452));
		holdingPanel2.setPreferredSize(new Dimension(870, 452));
		holdingPanel.add(holdingPanel2, BorderLayout.CENTER);
		tehCahd.setBorder(BorderFactory.createLineBorder(Color.red));
		tehCahd.setBackground(Color.white);
		tehCahd.setMinimumSize(new Dimension(865-200, 448-200));
		tehCahd.setMaximumSize(new Dimension(865-200, 448-200));
		tehCahd.setPreferredSize(new Dimension(865-200, 448-200));
		tehTitall.setMinimumSize(new Dimension(865-200, 250-200));
		tehTitall.setMaximumSize(new Dimension(865-200, 250-200));
		tehTitall.setPreferredSize(new Dimension(865-200, 250-200));
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
