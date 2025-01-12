package keybankApp.colors;
import java.awt.Color;
import java.awt.Font;
public class Theme 
{
	/** 
	 * Font Types Available:
	 * Dialog
	   DialogInput
	   Monospaced
	   Serif
	   SansSerif
	 */
	private Color kbRed = new Color(204, 0, 0);
	private Color kbLGrey = new Color(218, 218, 217);
	private Color kbDGrey = new Color(116, 120, 114);
	private Color kbBlack = new Color(13, 22, 11);
	private Font kbHeader = new Font("SansSerif", Font.BOLD, 18);
	private Font kbSubHead = new Font("SansSerif", Font.PLAIN, 15);
	private Font kbBody = new Font("Dialog", Font.PLAIN, 12);
	private Font kbCode = new Font("Monospaced", Font.PLAIN, 12);
	private Font kbBody36 = new Font("Dialog", Font.BOLD, 36);
	private Font kbCode36 = new Font("Monospaced", Font.PLAIN, 36);
	public Theme() 
	{
		// TODO Imports everything :)
	}
	public Color getKbRed() {
		return kbRed;
	}
	public Color getKbLGrey() {
		return kbLGrey;
	}
	public Color getKbDGrey() {
		return kbDGrey;
	}
	public Color getKbBlack() {
		return kbBlack;
	}
	public Font getKbHeader() {
		return kbHeader;
	}
	public Font getKbSubHead() {
		return kbSubHead;
	}
	public Font getKbBody() {
		return kbBody;
	}
	public Font getKbCode() {
		return kbCode;
	}
	public Font getKbBody36() {
		return kbBody36;
	}
	public void setKbBody36(Font kbBody36) {
		this.kbBody36 = kbBody36;
	}
	public Font getKbCode36() {
		return kbCode36;
	}
	public void setKbCode36(Font kbCode36) {
		this.kbCode36 = kbCode36;
	}
}
