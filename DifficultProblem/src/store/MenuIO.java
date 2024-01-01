package store;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuIO {

	private Store store;
	private static MenuIO menuIO = new MenuIO();
	
	private MenuIO(){
	}
	public static MenuIO getMenuIO() {
		return menuIO;
	}
	
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	
	protected String[] getMenus() {
		BufferedReader bfr = null;
		String readData = "";
		String[] menuAry;
		try {
			bfr = new BufferedReader(new FileReader(store.getFile()));
			readData = bfr.readLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bfr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}//finally
		
		if(readData !=null) {
			menuAry = readData.split("-");
			return menuAry;
		}else {
			return null;
		}
	}//readMenu
	
	protected void createMenu(Menu menu) {
		FileWriter fw = null;
		String inputData = "";
		try {
			fw = new FileWriter(store.getFile(),true);
			inputData = menu.getName()+"_"+menu.getPrice()+"-";
			fw.write(inputData.toCharArray());
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}//try
		}//finally
	}//createMenu
	
	protected void deleteMenu(Menu menu) {
		BufferedReader bfr = null;
		String saveData = "";
		FileWriter fw = null;
		try {
			bfr = new BufferedReader(new FileReader(store.getFile()));
			saveData = bfr.readLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<String> menuList = new ArrayList<String>(Arrays.asList(saveData.split("-")));
		menuList.remove(menu.getName()+"_"+menu.getPrice());
		saveData = String.join("-", menuList)+"-";
		try {
			fw = new FileWriter(store.getFile());
			fw.write(saveData);
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bfr.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}//finally
	}//deleteMenu
	
}//class
