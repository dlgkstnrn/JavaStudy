package person;
import javax.swing.*;
import java.awt.*;

public class PersonPrintFrame extends JFrame{
	String rendomresult = "";
	public PersonPrintFrame() {
		init();
	}
	public PersonPrintFrame(String rendomresult) {
		this.rendomresult = rendomresult;
		init();
	}
	void init() {
		JTextField jtf = new JTextField(rendomresult+"입니다.");
		jtf.setEditable(false);
		this.add(jtf);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //스윙에서 닫는 옵션
		this.setTitle("PersonPrint");
		this.setSize(400,200);
		this.setVisible(true);
	}//init
}//class
