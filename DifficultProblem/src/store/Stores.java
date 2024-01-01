package store;

import java.util.List;

public class Stores {
	private List<Store> storeList;
	
	public Stores() {
	}
	public Stores(List<Store> storeList) {
		this.storeList = storeList;
	}
	public List<Store> getStoreList() {
		return storeList;
	}
	public void setStoreList(List<Store> storeList) {
		this.storeList = storeList;
	}
	
}//class
