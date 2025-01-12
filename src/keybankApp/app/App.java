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
import java.nio.file.Path;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;

import keybankApp.colors.Theme;

public class App implements ActionListener {

	Theme kbTheme = new Theme();
	static JFrame frame = new JFrame();
	JPanel holdingPanel = new JPanel();
	JToolBar toolbar = new JToolBar("LockBank");
	JLabel kbLogo = new JLabel();
	JPanel panelWithAccountsIn = new JPanel();
	public static int AMOUNT_OF_ACCOUNTS;
	GridBagConstraints accountPanelConstraints = new GridBagConstraints();
	GridBagConstraints accountConst = new GridBagConstraints();
	JPanel bottomPanel = new JPanel();
	JButton deposit = new JButton("Deposit");
	JButton website = new JButton("Website");
	JButton edit = new JButton("Edit PIN");
	JButton exit = new JButton("Exit");
	ArrayList<String> ACCOUNT_NAMES = new ArrayList<String>();
	ArrayList<String> creditCardNumber = new ArrayList<String>();
	ArrayList<String> firstName = new ArrayList<String>();
	ArrayList<String> lastName = new ArrayList<String>();
	ArrayList<Double> money = new ArrayList<Double>();
	ArrayList<Integer> ccvs = new ArrayList<Integer>();
	ArrayList<Integer> pins = new ArrayList<Integer>();
	ArrayList<Integer> amt = new ArrayList<Integer>();
	Path path;
	
	public App(Path path, ArrayList<Integer> amt, ArrayList<String> ACCOUNT_NAMES, ArrayList<String> creditCardNumber, 
			ArrayList<String> firstName, ArrayList<String> lastName, ArrayList<Double> money, ArrayList<Integer> ccvs, ArrayList<Integer> pins) 
	{ 
		this.ACCOUNT_NAMES = ACCOUNT_NAMES;
		this.creditCardNumber = creditCardNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.money = money;
		this.ccvs = ccvs;
		this.pins = pins;
		this.path = path;
		this.amt = amt;
		AMOUNT_OF_ACCOUNTS = amt.size();
		
		System.out.println(AMOUNT_OF_ACCOUNTS);
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
		panelScrollability.setPreferredSize(new Dimension(255, 612));
		holdingPanel.add(panelScrollability);
		toolbar.setFloatable(false);
		bottomPanel.add(edit);
		bottomPanel.add(deposit);
		bottomPanel.add(website);
		bottomPanel.add(exit);
		edit.addActionListener(this);
		deposit.addActionListener(this);
		website.addActionListener(this);
		exit.addActionListener(this);
		bottomPanel.setBackground(Color.white);
		kbLogo.setFont(kbTheme.getKbHeader());
		// frame.setMinimumSize(new Dimension(860, 700));
		frame.setTitle("LockBank");
		frame.setMinimumSize(new Dimension(1080, 720));
		frame.setSize(1080, 720);
		frame.setResizable(false);
		toolbar.setBackground(Color.white);
		holdingPanel.setBackground(kbTheme.getKbRed());
		frame.add(holdingPanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	ArrayList<JButton> openAccButtons = new ArrayList<JButton>();
	
	public void processAccountPanel(GridBagConstraints accountConst, JPanel panelWithAccountsIn, int amt) {
		for (int i = 0; i < amt; i++) { // grab the amount from a txt file (Nahhh)
			Account user = new Account(true, creditCardNumber.get(i), firstName.get(i), lastName.get(i), ccvs.get(i), pins.get(i));
			JPanel accountPanel = new JPanel(new GridBagLayout());
			JLabel accountName = new JLabel(ACCOUNT_NAMES.get((i)));
			JLabel l4dig = new JLabel("**** "+user.getL4Dig());
			
			JLabel moneyAmt = new JLabel("$"+money.get(i)); // get money amount from checking acc of this guy
			JButton openAccWindow = new JButton("Details");
			accountName.setFont(kbTheme.getKbSubHead());
			l4dig.setFont(kbTheme.getKbCode());
			moneyAmt.setFont(kbTheme.getKbCode());
			openAccWindow.setFont(kbTheme.getKbBody());
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
		if (e.getSource().equals(edit)) {
			new Edit(path, amt, ACCOUNT_NAMES, creditCardNumber, firstName, lastName, ccvs, money, pins);
	   } else if (e.getSource().equals(deposit)) {
			new Deposit(path, amt, ACCOUNT_NAMES, creditCardNumber, firstName, lastName, ccvs, money, pins);
	   }
		else if (e.getSource().equals(exit)) {
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			System.exit(0);
		} else if (e.getSource().equals(website)) {
        	JOptionPane.showMessageDialog(null, "Visit us at: \nhttps://codepen.io/Daniel-OBrien-the-flexboxer/full/gbYezjQ", "Website Link", JOptionPane.PLAIN_MESSAGE);
		}
		
		else if (e.getSource().equals(openAccButtons.get(0))) {
			System.out.println("Account1");
			new AccountAdvanced(0, (firstName.get(0)+" "+lastName.get(0)), creditCardNumber.get(0), ccvs.get(0), money.get(0), pins.get(0));
		} else if (e.getSource().equals(openAccButtons.get(1))) {
			System.out.println("Account2");
			 new AccountAdvanced(1, (firstName.get(1)+" "+lastName.get(1)), creditCardNumber.get(1), ccvs.get(1), money.get(1), pins.get(1));
		} else if (e.getSource().equals(openAccButtons.get(2))) {
			System.out.println("Account3");
			 new AccountAdvanced(2, (firstName.get(2)+" "+lastName.get(2)), creditCardNumber.get(2), ccvs.get(2), money.get(2), pins.get(2));
		} else if (e.getSource().equals(openAccButtons.get(3))) {
			System.out.println("Account4");
			new AccountAdvanced(3, (firstName.get(3)+" "+lastName.get(3)), creditCardNumber.get(3), ccvs.get(3), money.get(3), pins.get(3));
		} else if (e.getSource().equals(openAccButtons.get(4))) {
			System.out.println("Account5");
			new AccountAdvanced(4, (firstName.get(4)+" "+lastName.get(4)), creditCardNumber.get(4), ccvs.get(4), money.get(4), pins.get(4));
		} else if (e.getSource().equals(openAccButtons.get(5))) {
			System.out.println("Account6");
			new AccountAdvanced(5, (firstName.get(5)+" "+lastName.get(5)), creditCardNumber.get(5), ccvs.get(5), money.get(5), pins.get(5));
		} else if (e.getSource().equals(openAccButtons.get(6))) {
			System.out.println("Account7");
			new AccountAdvanced(6, (firstName.get(6)+" "+lastName.get(6)), creditCardNumber.get(6), ccvs.get(6), money.get(6), pins.get(6));
		} else if (e.getSource().equals(openAccButtons.get(7))) {
			System.out.println("Account8");
			new AccountAdvanced(7, (firstName.get(7)+" "+lastName.get(7)), creditCardNumber.get(7), ccvs.get(7), money.get(7), pins.get(7));
		} else if (e.getSource().equals(openAccButtons.get(8))) {
			System.out.println("Account9");
			 new AccountAdvanced(8, (firstName.get(8)+" "+lastName.get(8)), creditCardNumber.get(8), ccvs.get(8), money.get(8), pins.get(8));
		} else if (e.getSource().equals(openAccButtons.get(9))) {
			System.out.println("Account10");
			new AccountAdvanced(9, (firstName.get(9)+" "+lastName.get(9)), creditCardNumber.get(9), ccvs.get(9), money.get(9), pins.get(9));
		}

	}
}
