import javax.swing.*;

import person.PersonMainFrame;
import store.StoreMainFrame;
import worldcup.WorldcupMainFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener{
	JButton personbtn = null;
	JButton storebtn = null;
	JButton worldcupbtn = null;
	private String[] worldcupbtns = {"64강","32강","16강"};
	public MainFrame() {
		init();
	}
	void init() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //스윙에서 닫는 옵션
		this.setTitle("MainFrame");
		this.setSize(400,100);
		this.setLayout(new FlowLayout());
		personbtn = new JButton("PERSON");
		storebtn = new JButton("STORE");
		worldcupbtn = new JButton("WORLDCUP");
		personbtn.addActionListener(this);
		storebtn.addActionListener(this);
		worldcupbtn.addActionListener(this);
		this.setLocation(600,400);
		this.add(personbtn);
		this.add(storebtn);
		this.add(worldcupbtn);
		this.setVisible(true);
	}//init
	public static void main(String[] args) {
		new MainFrame();
	}//main
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if("PERSON".equals(e.getActionCommand())) {
			new PersonMainFrame();
		}else if("STORE".equals(e.getActionCommand())) {
			new StoreMainFrame();
		}else if("WORLDCUP".equals(e.getActionCommand())) {
			int i = JOptionPane.showOptionDialog(this, "몇강?", "월드컵 선택", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, worldcupbtns,null);
			if(i==0) {
				new WorldcupMainFrame(64);
			}else if(i==1) {
				new WorldcupMainFrame(32);
			}else {
				new WorldcupMainFrame(16);
			}
		}//else if
		
	}//actionPerformed
}//class
