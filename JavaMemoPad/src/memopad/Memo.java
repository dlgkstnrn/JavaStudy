package memopad;

import java.io.File;

public class Memo {
	private String title;
	private String text;
	private File file;
	Memo(){
	}
	Memo(String title){
		this.title = title;
	}
	Memo(String title,String text){
		this.title = title;
		this.text = text;
	}
	Memo(String title,File file){
		this.title = title;
		this.file = file;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	
}
