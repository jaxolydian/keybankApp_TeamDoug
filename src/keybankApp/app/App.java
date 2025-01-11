package keybankApp.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;

import keybankApp.colors.Theme;
import keybankApp.data.DATA;

public class App implements ActionListener {

	Theme kbTheme = new Theme();
	JFrame frame = new JFrame();
	JPanel holdingPanel = new JPanel();
	JToolBar toolbar = new JToolBar("LockBank");
	JLabel kbLogo = new JLabel();
	JPanel panelWithAccountsIn = new JPanel();
	public static int AMOUNT_OF_ACCOUNTS;
	GridBagConstraints accountPanelConstraints = new GridBagConstraints();
	GridBagConstraints accountConst = new GridBagConstraints();
	JPanel bottomPanel = new JPanel();
	JButton add = new JButton("Add");
	JButton deposit = new JButton("Deposit");
	JButton transfer = new JButton("Transfer");
	JButton log = new JButton("Logs");
	
	public App() 
	{
		AMOUNT_OF_ACCOUNTS = 10;
		//imaging
		try {
			BufferedImage lockBankLogo = ImageIO.read(new File("src/imgs/lockbank3KB.png"));
			ImageIcon image = new ImageIcon(lockBankLogo);
			kbLogo.setIcon(image);
		} catch (IOException err) {
			System.err.println("lol ur bad");
		}
		bottomPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		panelWithAccountsIn.setLayout(new BoxLayout(panelWithAccountsIn, BoxLayout.PAGE_AXIS));
		accountPanelConstraints.insets = new Insets(10,10,10,10);
		accountConst.insets = new Insets(0,10,0,10);
		processAccountPanel(accountConst, panelWithAccountsIn, AMOUNT_OF_ACCOUNTS);
		
		/* JMenu setup stuff lol */
		toolbar.add(kbLogo);
		toolbar.setMinimumSize(new Dimension(1080, 30));
		toolbar.setMaximumSize(new Dimension(1080, 30));
		toolbar.setPreferredSize(new Dimension(1080, 30));
		frame.add(toolbar, BorderLayout.NORTH);
		frame.add(bottomPanel, BorderLayout.SOUTH);
//		bottomPanel.add(deposit, ComponentOrientation.LEFT_TO_RIGHT);
		JScrollPane panelScrollability = new JScrollPane(panelWithAccountsIn, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panelScrollability.setAutoscrolls(true);
		panelScrollability.setPreferredSize(new Dimension(255, 575));
		holdingPanel.add(panelScrollability);
		toolbar.setFloatable(false);
		bottomPanel.add(add);
		bottomPanel.add(deposit);
		bottomPanel.add(transfer);
		bottomPanel.add(log);
		bottomPanel.setBackground(Color.white);
		add.addActionListener(this);
		add.setPreferredSize(new Dimension(50, 30));
		kbLogo.setFont(kbTheme.getKbHeader());
		// frame.setMinimumSize(new Dimension(860, 700));
		frame.setTitle("LockBank");
		frame.setMinimumSize(new Dimension(1080, 720));
		frame.setSize(1080, 720);
		frame.setResizable(true);
		toolbar.setBackground(Color.white);
		holdingPanel.setBackground(kbTheme.getKbRed());
		frame.add(holdingPanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	ArrayList<JButton> openAccButtons = new ArrayList<JButton>();
	
	public void processAccountPanel(GridBagConstraints accountConst, JPanel panelWithAccountsIn, int amt) {
		for (int i = 0; i < amt; i++) { // grab the amount from a txt file (Nahhh)
			Account user = new Account(1216, "Bren", "Chen", 216);
			JPanel accountPanel = new JPanel(new GridBagLayout());
			JLabel accountName = new JLabel("Account "+(i+1));
			JLabel l4dig = new JLabel("**** "+user.getL4Dig());
			JLabel moneyAmt = new JLabel("$####.##"); // get money amount from checking acc of this guy
			JButton openAccWindow = new JButton("Details");
			accountName.setFont(kbTheme.getKbSubHead());
			l4dig.setFont(kbTheme.getKbCode());
			moneyAmt.setFont(kbTheme.getKbCode());
			openAccWindow.setFont(kbTheme.getKbBody());
			DATA.datalist.add(user);
			openAccButtons.add(openAccWindow);
			openAccWindow.addActionListener(this);
			accountPanelConstraints.gridx = 0;
			accountPanelConstraints.gridy = i;
			accountPanelConstraints.ipadx = 0;
			accountPanelConstraints.ipady = 0;
			accountPanelConstraints.fill = GridBagConstraints.BOTH;
			accountPanel.setMinimumSize(new Dimension(235, 60));
			accountPanel.setMaximumSize(new Dimension(235, 60));
			accountPanel.setPreferredSize(new Dimension(235, 60));
			accountPanel.setBackground(Color.white);
			accountConst.gridx = 0;
			accountConst.gridy = 0;
			accountConst.ipadx = 0;
			accountConst.ipady = 0;
			accountConst.fill = GridBagConstraints.BOTH;
			accountConst.gridx = 0;
			accountConst.gridy = 0;
			accountPanel.add(accountName, accountConst);
			accountConst.gridx = 1;
			accountConst.gridy = 0;
			accountPanelConstraints.ipadx = 0;
			accountPanel.add(l4dig, accountConst);
			accountConst.gridx = 0;
			accountConst.gridy = 1;
			accountPanel.add(moneyAmt, accountConst);
			accountConst.gridx = 1;
			accountConst.gridy = 1;
			accountPanel.add(openAccWindow, accountConst);
//			accountPanel.add(moneyAmt, accountConst);
			accountPanel.setBorder(BorderFactory.createLineBorder(Color.red, 1));
			
			panelWithAccountsIn.add(accountPanel, accountConst);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(openAccButtons.get(0))) {
			System.out.println("Account1");
			AccountAdvanced a = new AccountAdvanced(0);
		} else if (e.getSource().equals(openAccButtons.get(1))) {
			System.out.println("Account2");
		} else if (e.getSource().equals(openAccButtons.get(2))) {
			System.out.println("Account3");
		} else if (e.getSource().equals(openAccButtons.get(3))) {
			System.out.println("Account4");
		} else if (e.getSource().equals(openAccButtons.get(4))) {
			System.out.println("Account5");
		} else if (e.getSource().equals(openAccButtons.get(5))) {
			System.out.println("Account6");
		} else if (e.getSource().equals(openAccButtons.get(6))) {
			System.out.println("Account7");
			
		} else if (e.getSource().equals(openAccButtons.get(7))) {
			System.out.println("Account8");
			
		} else if (e.getSource().equals(openAccButtons.get(8))) {
			System.out.println("Account9");
			
		} else if (e.getSource().equals(openAccButtons.get(9))) {
			System.out.println("Account10");
			
		} else if (e.getSource().equals(add)) {
			new AddNewAccount();
		}
	}
}
