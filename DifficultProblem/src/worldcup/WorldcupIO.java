package worldcup;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WorldcupIO {
	private int worldcuptotalnum;
	File file = null;
	BufferedReader bfr = null;
	String[] menuList = null;
	
	public WorldcupIO() {
	}
	public WorldcupIO(int worldcuptotalnum) {
		this.worldcuptotalnum = worldcuptotalnum;
		allDataread();
	}
	
	protected void allDataread() {
		file = new File("./store/");
		String[] storeList = file.list();
		String allData = "";
		String readData = null;
		int storelng = storeList.length;
		for(int i = 0;i<storelng;i++) {
			try {
				bfr = new BufferedReader(new FileReader(new File("./store/"+storeList[i])));
				if((readData = bfr.readLine())!=null) {
					allData+=readData;
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}//catch
		}//for
		
		try {
			bfr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		menuList = allData.split("-");
	}//allDataread
	
	protected List<String> getmenuList(){
		List<String> menuArrayList = new ArrayList<String>();
		int menutotallng = menuList.length;
		for(int i=0;i<worldcuptotalnum;) {
			int randomnum = (int)(Math.random()*menutotallng);
			if(!menuArrayList.contains(menuList[randomnum])) {
				menuArrayList.add(menuList[randomnum]);
				i++;
			}//if
		}//for
		return menuArrayList;
	}//getmenuList
	
}//class
