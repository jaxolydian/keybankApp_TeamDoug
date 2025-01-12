//package keybankApp.app;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//
//import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JToolBar;
//import javax.swing.WindowConstants;
//
//import keybankApp.colors.Theme;
//
//public class AddNewAccount {
//
//	Theme kbTheme = new Theme();
//	JFrame frame = new JFrame();
//	JToolBar toolbar = new JToolBar();
//	JPanel holdingPanel = new JPanel();
//	JLabel kbLogo = new JLabel();
//	public AddNewAccount() {
//		try {
//			BufferedImage lockBankLogo = ImageIO.read(new File("src/imgs/lockbank3KB.png"));
//			ImageIcon image = new ImageIcon(lockBankLogo);
//			kbLogo.setIcon(image);
//		} catch (IOException err) {
//			System.err.println("lol ur bad");
//		}
//		frame.setTitle("Add Account");
//		frame.setMinimumSize(new Dimension(1080, 720));
//		frame.setSize(1080, 720);
//		toolbar.setFloatable(false);
//		frame.setResizable(true);
//		holdingPanel.setBackground(kbTheme.getKbRed());
//		frame.add(holdingPanel);
//		frame.add(toolbar, BorderLayout.NORTH);
//		toolbar.add(kbLogo);
//		toolbar.setMinimumSize(new Dimension(1080, 30));
//		toolbar.setMaximumSize(new Dimension(1080, 30));
//		toolbar.setPreferredSize(new Dimension(1080, 30));
//		kbLogo.setFont(kbTheme.getKbHeader());
//		toolbar.setBackground(Color.white);
//		frame.setVisible(true);
//		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//	}
//
//}
