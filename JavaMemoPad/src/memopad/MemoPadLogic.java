package memopad;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MemoPadLogic {
	private static MemoPadLogic memoPadLogic = new MemoPadLogic();
	private MemoPadLogic() {
	}
	public static MemoPadLogic getMemoPadLogic() {
		return memoPadLogic;
	}
	
	void createMemo(Memo memo) { // 메모 만들기
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmm");
		String now = sdf.format(date);
		File f = new File("./memo/"+memo.getTitle()+"_"+now+".txt");
		FileWriter fw = null;
		if(f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		try {
			fw = new FileWriter(f);
			fw.write(memo.getText()); //파일 만든 것에 안녕하세요! 를 써줘라(?)
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}finally {
			try {
				fw.close();
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
	
	MemoPad getList() { //목록불러오기
		File f = new File("./memo/");
		File[] fAry = null;
		fAry = f.listFiles();
		int fArylng = fAry.length;
		MemoPad memoPad = new MemoPad(fArylng);
		for(int i=0;i<fArylng;i++) {
			memoPad.memo[i] = new Memo(fAry[i].getName(),new File("./memo/"+fAry[i].getName()));
		}
		return memoPad;
	}
	
	void deleteMemo(Memo memo) {

		if(memo.getFile().delete()) {
			System.out.println(memo.getTitle()+" 파일삭제에 성공했습니다.");
		}else {
			System.out.println("파일 삭제에 실패했습니다.");
		}
	}
	
	void readMemo(Memo memo) {
		System.out.println("제목 : "+memo.getTitle());
		FileReader fr = null ;
		int num=0;
		try {
			fr= new FileReader(memo.getFile());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			while((num=fr.read()) != -1){
				System.out.print((char)num);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fr.close(); // 파일리더 안닫아주고 delete 했더니 오류남 아마 사용중이라 안닫아서 그런거같음
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println();
	}

}
