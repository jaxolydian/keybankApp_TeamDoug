package keybankApp.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;

import keybankApp.colors.Theme;

public class App {

	Theme kbTheme = new Theme();
	JFrame frame = new JFrame();
	JPanel holdingPanel = new JPanel();
	JToolBar toolbar = new JToolBar("LockBank");
	JLabel kbLogo = new JLabel("LockBank");
	JPanel panelWithAccountsIn = new JPanel();
	int amtOfAccounts = 8;
	GridBagConstraints accountPanelConstraints = new GridBagConstraints();
	GridBagConstraints accountConst = new GridBagConstraints();
	public App() 
	{
		panelWithAccountsIn.setLayout(new BoxLayout(panelWithAccountsIn, BoxLayout.PAGE_AXIS));
		accountPanelConstraints.insets = new Insets(10,10,10,10);
		accountConst.insets = new Insets(5,5,5,5);
		for (int i = 0; i <= amtOfAccounts; i++) {
			JPanel accountPanel = new JPanel(new GridBagLayout());
			JLabel accountName = new JLabel("Checking Account");
			JLabel l4dig = new JLabel("****");
			JLabel moneyAmt = new JLabel("$####.##");
			accountPanelConstraints.gridx = 0;
			accountPanelConstraints.gridy = i;
			accountPanelConstraints.ipadx = 0;
			accountPanelConstraints.ipady = 0;
			accountPanelConstraints.fill = GridBagConstraints.BOTH;
			accountPanel.setMinimumSize(new Dimension(475, 90));
			accountPanel.setMaximumSize(new Dimension(475, 90));
			accountPanel.setPreferredSize(new Dimension(475, 90));
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
			accountPanel.add(l4dig, accountConst);
			accountConst.gridx = 0;
			accountConst.gridy = 1;
			accountPanel.add(moneyAmt, accountConst);
//			accountPanel.add(moneyAmt, accountConst);
			accountPanel.setBorder(BorderFactory.createLineBorder(Color.red, 1));
			
			panelWithAccountsIn.add(accountPanel, accountPanelConstraints);
		}
		
		/* JMenu setup stuff lol */
		toolbar.add(kbLogo);
		toolbar.setMinimumSize(new Dimension(1080, 30));
		toolbar.setMaximumSize(new Dimension(1080, 30));
		toolbar.setPreferredSize(new Dimension(1080, 30));
		frame.add(toolbar, BorderLayout.NORTH);
//		panelWithAccountsIn.setMinimumSize(new Dimension(1050, 632));
////		panelWithAccountsIn.setMaximumSize(new Dimension(1050, 632));
//		panelWithAccountsIn.setPreferredSize(new Dimension(1050, 632));
		
		JScrollPane panelScrollability = new JScrollPane(panelWithAccountsIn, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panelScrollability.setAutoscrolls(true);
		panelScrollability.setPreferredSize(new Dimension(600, 400));
		holdingPanel.add(panelScrollability);
		toolbar.setFloatable(false);
		
		kbLogo.setFont(kbTheme.getKbHeader());
		// frame.setMinimumSize(new Dimension(860, 700));
		frame.setTitle("LockBank");
		frame.setSize(1080, 720);
		frame.setResizable(true);
		holdingPanel.setBackground(kbTheme.getKbRed());
		frame.add(holdingPanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

}
