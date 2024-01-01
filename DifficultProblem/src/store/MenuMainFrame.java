package store;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class MenuMainFrame extends JFrame implements ActionListener{
	String[] menuAry;
	private JPanel contentPane;
	MenuIO menuIO;
	DefaultListModel<String> menuModel = new DefaultListModel<String>();
	JList menuJl = new JList();
	
	public MenuMainFrame(Store store) {
		menuIO = MenuIO.getMenuIO();
		menuIO.setStore(store);
		init();
	}
	
	void init() {
		updateList();
		
		setBounds(100, 100, 606, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton readbtn = new JButton("C");
		readbtn.setBounds(429, 33, 97, 23);
		contentPane.add(readbtn);
		readbtn.addActionListener(this);
		
		JButton deletebtn = new JButton("D");
		deletebtn.setBounds(429, 79, 97, 23);
		contentPane.add(deletebtn);
		deletebtn.addActionListener(this);
		
		JButton randombtn = new JButton("R");
		randombtn.setBounds(429, 124, 97, 23);
		contentPane.add(randombtn);
		randombtn.addActionListener(this);
		
		menuJl.setBounds(12, 10, 375, 357);
		contentPane.add(menuJl);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // 스윙에서 닫는 옵션
		this.setVisible(true);
	}//init
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if("C".equals(e.getActionCommand())) {
			int menuprice = 0;
			String menuname = JOptionPane.showInputDialog(null, "메뉴 이름 입력하세요.", "메뉴입력", JOptionPane.INFORMATION_MESSAGE);
			try {
				menuprice = Integer.parseInt(JOptionPane.showInputDialog(null,  menuname + " 메뉴 가격을 입력하세요.", "가격입력", JOptionPane.INFORMATION_MESSAGE)) ;
				menuIO.createMenu(new Menu(menuname,menuprice));
			}catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "숫자를 입력하세요. ", "에러",JOptionPane.ERROR_MESSAGE);
			}
			updateList();
			menuJl.repaint();
		}else if("D".equals(e.getActionCommand())) {
			if(menuJl.getSelectedIndex() == -1) {
				JOptionPane.showMessageDialog(null, "선택하지 않았습니다. ", "결과창",JOptionPane.ERROR_MESSAGE);
			}else {
				String selectedValue = (String) menuJl.getSelectedValue();
				String[] selectedValueAry = selectedValue.split("_");
				menuIO.deleteMenu(new Menu(selectedValueAry[0],Integer.parseInt(selectedValueAry[1])));
				updateList();
				menuJl.repaint();
			}
		}else if("R".equals(e.getActionCommand())) {
			JOptionPane.showMessageDialog(null, menuModel.get((int)(Math.random()*menuModel.getSize())) , "결과창",JOptionPane.INFORMATION_MESSAGE);
		}
	}//actionPerformed
	
	void updateList() {
		menuAry = menuIO.getMenus();
		menuModel.removeAllElements();
		if(menuAry != null) {
			for(String str1 : menuAry) {
					menuModel.addElement(str1);
			}
		}
		menuJl.setModel(menuModel);
	}//updateList
}//class
