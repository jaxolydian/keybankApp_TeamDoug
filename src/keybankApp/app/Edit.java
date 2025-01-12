package keybankApp.app;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;

import keybankApp.colors.Theme;

public class Edit implements ActionListener {

	String split1;
	
	String split2;
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
	JLabel labelForCCN = new JLabel("Account #: ");
	JTextField ccnn = new JTextField("");
	JLabel labelForCCV = new JLabel("CCV #: ");
	JTextField ccvL = new JTextField("");
	JLabel labelForCurrentPin = new JLabel("Current Pin #: ");
	JTextField pin1 = new JTextField("");
	JLabel labelForNewPin = new JLabel("New Pin #: ");
	JTextField pin2 = new JTextField("");
	JLabel tehTitall = new JLabel();
	JButton confirm = new JButton("Confirm");
	Path path;
	ArrayList<String> ACCOUNT_NAMES = new ArrayList<String>();
	ArrayList<String> ccn = new ArrayList<String>();
	ArrayList<String> firstName = new ArrayList<String>();
	ArrayList<String> lastName = new ArrayList<String>();
	ArrayList<Double> dollaBillz = new ArrayList<Double>();
	ArrayList<Integer> ccv = new ArrayList<Integer>();
	ArrayList<Integer> pinz = new ArrayList<Integer>();
	ArrayList<Integer> amt = new ArrayList<Integer>();
	GridBagConstraints c = new GridBagConstraints();
	public Edit(Path path, ArrayList<Integer> amt, ArrayList<String> ACCOUNT_NAMES, ArrayList<String> ccn, 
			ArrayList<String> firstName, ArrayList<String> lastName, 
			ArrayList<Integer> ccv, ArrayList<Double> dollaBillz, ArrayList<Integer> pinz) {
		try {
			this.ACCOUNT_NAMES = ACCOUNT_NAMES;
			this.ccn = ccn;
			this.firstName = firstName;
			this.lastName = lastName;
			this.dollaBillz = dollaBillz;
			this.ccv = ccv;
			this.pinz = pinz;
			this.path = path;
			this.amt = amt;
			BufferedImage lockBankLogo = ImageIO.read(new File("src/imgs/lockbank3KB.png"));
			ImageIcon image = new ImageIcon(lockBankLogo);
			
			kbLogo.setIcon(image);
		} catch (IOException err) {
			System.err.println("lol ur bad");
		}
		
		tehTitall.setText("PIN Setup");
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
		tehCahd.add(ccnn, cahd);
		cahd.gridx = 0;
		cahd.gridy = 1;
		labelForCCV.setFont(kbTheme.getKbBody36());
		tehCahd.add(labelForCCV, cahd);
		cahd.gridx = 1;
		ccvL.setFont(kbTheme.getKbCode36());
		tehCahd.add(ccvL, cahd);
		cahd.gridx = 0;
		cahd.gridy = 2;
		labelForCurrentPin.setFont(kbTheme.getKbBody36());
		tehCahd.add(labelForCurrentPin, cahd);
		cahd.gridx = 1;
		pin1.setFont(kbTheme.getKbCode36());
		tehCahd.add(pin1, cahd);
		cahd.gridx = 0;
		cahd.gridy = 3;
		labelForNewPin.setFont(kbTheme.getKbBody36());
		tehCahd.add(labelForNewPin, cahd);
		cahd.gridx = 1;
		pin2.setFont(kbTheme.getKbCode36());
		tehCahd.add(pin2, cahd);
		cahd.gridy = 4;
		System.out.println();
		confirm.setFont(kbTheme.getKbBody36());
		tehCahd.add(confirm, cahd);
		ccnn.setPreferredSize(new Dimension(400, 50));
		ccvL.setPreferredSize(new Dimension(400, 50));
		pin1.setPreferredSize(new Dimension(400, 50));
		pin2.setPreferredSize(new Dimension(400, 50));
		
		confirm.addActionListener(this);
		frame.setTitle("Edit PIN");
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// edit pin
		boolean check = false;
		if (e.getSource().equals(confirm)) {
			setAccNumber(Integer.parseInt(ccnn.getText()));
			int accNo = getAccNumber();
			try {
				try (BufferedReader br = new BufferedReader(new FileReader(path.toString()))) {
		            String line;
		            String allLinesNonList = "";
		            ArrayList<String> allLines = new ArrayList<String>();
		            int i = 0;
		            while ((line = br.readLine()) != null) {
		            	allLines.add(line);
		            	allLinesNonList = allLinesNonList + (allLines.get(i) + "\n");
		                System.out.println(line);
		                i++;
		            }
		            
		            	try {
		            		if (allLinesNonList.contains("TAG="+accNo)) {
		            			split1 = allLinesNonList.substring(0, allLinesNonList.indexOf("TAG="+accNo));
		            			split2 = allLinesNonList.substring(allLinesNonList.indexOf("PIN="+pin1.getText()));
		            			
		            		}
		            	} catch (Exception e3) {
		            		System.out.println("Failed: " + e3.getMessage());
		            	}
						if (allLinesNonList.contains("CCV="+ccv.get(accNumber))) {
							if (allLinesNonList.contains("PIN="+pin1.getText())) {
								System.out.println("Give the go ahead");
								check = true;
							} else check = false;
						} else check = false;
		            
				} catch (IOException e6) {
            		System.out.println("Failed: " + e6.getMessage());
            	}
				if (check == true) {
	            Files.deleteIfExists(path);
	            System.out.println("File deleted successfully.");
	            try (FileWriter replacement = new FileWriter(path.toString())) {
	            	replacement.write("TAG="+accNumber+"\n");
	            	replacement.write("ACC="+ACCOUNT_NAMES.get(accNumber)+"\n");
	            	replacement.write("CC="+ccn.get(accNumber)+"\n");
	            	replacement.write("FN="+firstName.get(accNumber)+"\n");
	            	replacement.write("LN="+lastName.get(accNumber)+"\n");
	            	replacement.write("M="+dollaBillz.get(accNumber)+"\n");
	            	replacement.write("CCV="+ccv.get(accNumber)+"\n");
	            	replacement.write("PIN="+pin2.getText()+"\n");
	            	replacement.write(split2);
	            	JOptionPane.showMessageDialog(null, "Please restart the program to update your changes.", "Alert", JOptionPane.ERROR_MESSAGE);
	            	System.out.println("File has been edited successfully. Please close and open the program to update.");
	    			frame.dispose();
	            
				} catch (IOException e4) {
					System.out.println("Failed to write to new replacement file: " + e4.getMessage());
				}
				}
	        } catch (IOException e2) {
	            System.out.println("Failed to delete the file: " + e2.getMessage());
	        }
			
		}
	}

}
