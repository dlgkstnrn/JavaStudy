package worldcup;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import java.awt.SystemColor;

public class WorldcupMainFrame extends JFrame implements ActionListener{
	private WorldcupIO worldcupIO;
	private JTextField textField;
	private JTextField textField_1;
	private List<String> menuArrayList;
	private int nowCount;
	
	public WorldcupMainFrame() {
		initialize();
	}
	public WorldcupMainFrame(int selectedCount) {
		worldcupIO = new WorldcupIO(selectedCount);
		menuArrayList = worldcupIO.getmenuList();
		initialize();
		textField.setText(menuArrayList.get(0));
		textField_1.setText(menuArrayList.get(1));
	}

	private void initialize() {

		this.setTitle("WORLDCUP");
		this.setBounds(100, 100, 565, 397);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //스윙에서 닫는 옵션
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBackground(new Color(0, 0, 0));
		textField.setForeground(new Color(255, 255, 255));
		textField.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		textField.setEnabled(false);
		textField.setBounds(24, 96, 217, 33);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(255, 255, 255));
		textField_1.setBackground(new Color(0, 0, 0));
		textField_1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(306, 96, 217, 33);
		getContentPane().add(textField_1);
		
		JButton selectedbtn_1 = new JButton("1번 선택");
		selectedbtn_1.setBounds(80, 190, 97, 23);
		getContentPane().add(selectedbtn_1);
		selectedbtn_1.addActionListener(this);
		
		JButton selectedbtn_2 = new JButton("2번 선택");
		selectedbtn_2.setBounds(366, 190, 97, 23);
		getContentPane().add(selectedbtn_2);
		selectedbtn_2.addActionListener(this);
		
	}//initalize
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if("1번 선택".equals(e.getActionCommand())) {
			menuArrayList.remove(nowCount+1);
		}else if("2번 선택".equals(e.getActionCommand())) {
			menuArrayList.remove(nowCount);
		}
		nowCount++;
		settingWorldcup();
	}//actionPerformed
	
	public void settingWorldcup() {
		int listlng = menuArrayList.size();
		if(listlng==1) {
			JOptionPane.showMessageDialog(null, "최종승자는 "+menuArrayList.get(0)+" 입니다." , "결과창",JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
		}else {
			if(nowCount>=listlng) {
				nowCount=0;
				settingWorldcup();
			}else {
				textField.setText(menuArrayList.get(nowCount));
				textField_1.setText(menuArrayList.get(nowCount+1));
				this.repaint();
			}
		}
	}//settingWorldcup
	
}
