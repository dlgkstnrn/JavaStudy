package store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class StoreMainFrame extends JFrame implements ActionListener{
	JList<String> storeJl = null;
	String inputname = "";
	StoreIO storeIO = StoreIO.getStoreIO();
	Stores stores;
	DefaultListModel<String> storesModel = new DefaultListModel<String>();
	public StoreMainFrame() {
		init();
	}

	void init() {
		storeJl = new JList<String>();
		updateList();
		JPanel storeJlJP = new JPanel();
		JPanel btnsJP = new JPanel();
		JButton deletebtn = new JButton("D");
		JButton createbtn = new JButton("C");
		JButton selectbtn = new JButton("S");
		JButton randombtn = new JButton("R");
		btnsJP.setLayout(null);
		deletebtn.addActionListener(this);
		createbtn.addActionListener(this);
		selectbtn.addActionListener(this);
		randombtn.addActionListener(this);
		createbtn.setBounds(310, 30, 60, 30);
		deletebtn.setBounds(310, 80, 60, 30);
		selectbtn.setBounds(310, 130, 60, 30);
		randombtn.setBounds(310, 180, 60, 30);
		btnsJP.add(createbtn);
		btnsJP.add(deletebtn);
		btnsJP.add(selectbtn);
		btnsJP.add(randombtn);
		storeJl.setFixedCellHeight(30);
		storeJl.setFixedCellWidth(250);
		storeJlJP.setSize(300, 800);
		btnsJP.setSize(100, 800);
		storeJlJP.add(storeJl);
		this.add(storeJlJP);
		this.add(btnsJP);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // 스윙에서 닫는 옵션
		this.setTitle("StoreMain");
		this.setSize(400, 800);
		this.setVisible(true);
	}//init
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if("C".equals(e.getActionCommand())) {
			String result = "";
			inputname = JOptionPane.showInputDialog("가게 이름을 입력해 주세요");
			result = storeIO.createStore(new Store(inputname));
			JOptionPane.showMessageDialog(null, result, "결과창",JOptionPane.INFORMATION_MESSAGE);
			updateList();
		}else if("D".equals(e.getActionCommand())) {
			String result  = null;
			if(storeJl.getSelectedIndex() == -1) {
				JOptionPane.showMessageDialog(null, "선택하지 않았습니다. ", "결과창",JOptionPane.ERROR_MESSAGE);
			}else {
				for(Store store : stores.getStoreList()) {
					if((storeJl.getSelectedValue()).equals(store.getName())) {
						result = storeIO.deleteStore(store);
					}
				}
				JOptionPane.showMessageDialog(null, result, "결과창",JOptionPane.INFORMATION_MESSAGE);
				updateList();
			}
		}else if("R".equals(e.getActionCommand())) {
			JOptionPane.showMessageDialog(null, storesModel.get((int)(Math.random()*storesModel.getSize())) , "결과창",JOptionPane.INFORMATION_MESSAGE);
		}else if("S".equals(e.getActionCommand())) {
			if(storeJl.getSelectedIndex() == -1) {
				JOptionPane.showMessageDialog(null, "선택하지 않았습니다. ", "결과창",JOptionPane.ERROR_MESSAGE);
			}else {
				String selectIndex = storeJl.getSelectedValue();
				for(Store store : stores.getStoreList()) {
					if(selectIndex.equals(store.getName())) {
						new MenuMainFrame(store);
					}//if
				}//for
			}//else
		}//else if
	}//actionPerformed
	
	void updateList() {
		stores = storeIO.getStores();
		storesModel.removeAllElements();
		if(stores!=null) {
			for(Store store : stores.getStoreList()) {
					storesModel.addElement(store.getName());
			}
		}
		storeJl.setModel(storesModel);
		storeJl.repaint();
	}//updateList
}//class
