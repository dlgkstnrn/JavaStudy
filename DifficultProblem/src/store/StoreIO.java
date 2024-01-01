package store;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StoreIO {
	private File file;
	private Store store;
	private static StoreIO storeIO = new StoreIO();
	
	private StoreIO(){
	}
	
	public static StoreIO getStoreIO() {
		return storeIO;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	
	protected Stores getStores() {
		file = new File("./store/");
		if(!file.exists()) {
			file.mkdir();
		}
		String[] storeSList = file.list();
		List<Store> storeList = new ArrayList<>();
		for(String str1 : storeSList) {
			storeList.add(new Store(str1.replaceAll(".txt", ""),new File("./store/"+str1)));
		}
		return new Stores(storeList);
	}//getStores
	
	protected String createStore(Store store) {
		file = new File("./store/"+store.getName()+".txt");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			return "성공";
		}else {
			return "실패";
		}
	}//createStore
	
	protected String deleteStore(Store store) {
		file = store.getFile();
		if(file.delete()) {
			return "성공";
		}else {
			return "실패";
		}
	}//deleteStore

}//class
