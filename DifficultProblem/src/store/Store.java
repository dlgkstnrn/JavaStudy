package store;

import java.io.File;
import java.util.List;

public class Store {
	private String name;
	private File file;
	public Store() {
	}
	public Store(String name) {
		this.name = name;
	}
	public Store(String name, File file) {
		this.name = name;
		this.file = file;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}//class
