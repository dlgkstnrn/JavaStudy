package person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PersonInputFrame extends JFrame{
	private int column;
	List<JTextField> jtflist = new ArrayList<JTextField>();
	public PersonInputFrame() {
		init();
	}
	public PersonInputFrame(int column) {
		this.column = column;
		init();
	}
	
	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}
	
	void init() {
		JPanel textfieldjp = new JPanel();
		FlowLayout fl = new FlowLayout();
		JButton jbtn = new JButton("RANDOM");
		jbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int rennum = (int)(Math.random()*column);
				new PersonPrintFrame(jtflist.get(rennum).getText());
			}
		});
		fl.setVgap(20);
		fl.setHgap(9);
		textfieldjp.setLayout(fl);
		for(int i=0;i<column;i++) {
			jtflist.add(new JTextField(30));
			textfieldjp.add(jtflist.get(i));
		}
		textfieldjp.setSize(400, 80*column);
		this.add(jbtn,BorderLayout.SOUTH);
		this.add(textfieldjp);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //스윙에서 닫는 옵션
		this.setTitle("PersonInput");
		this.setSize(400,100*column);
		this.setVisible(true);
	}//init
	
}//class
