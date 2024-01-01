package person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonMainFrame extends JFrame {

	public PersonMainFrame() {
		init();
	}
	void init() {
		
		JTextField inputPersonNum = new JTextField(10);
		JButton inputPersonbtn = new JButton("INPUT");
		JTextField personInfo = new JTextField("COUNT");
		inputPersonbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new PersonInputFrame(Integer.parseInt(inputPersonNum.getText()));
			}
		});
		personInfo.setEditable(false);
		personInfo.setBounds(10, 20, 100, 50);
		personInfo.setBorder(BorderFactory.createEmptyBorder());
		this.add(personInfo);
		this.setLayout(null);
		inputPersonbtn.setBounds(100, 100, 100, 30);
		inputPersonNum.setBounds(60, 20, 300, 50);
		this.add(inputPersonNum);
		this.add(inputPersonbtn);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //스윙에서 닫는 옵션
		this.setTitle("PersonMain");
		this.setSize(400,200);
		this.setVisible(true);
	}//init

}//class
