package memopad;

import java.io.IOException;
import java.util.Scanner;

public class MemoPadMain {
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		MemoPad listMemo = null;
		MemoPadLogic memoPadLogic = MemoPadLogic.getMemoPadLogic();
		while(true) {
			String userWants=null;
			System.out.print("메모패드 기능을 선택해주세요(L/R/W/D/Q) : ");
			userWants = sc.next();
			sc.nextLine();  //버퍼지우기
			if("Q".equals(userWants)|| "q".equals(userWants)) {
				break;
			}else if(userWants.equals("l")|| userWants.equals("L")){
				listMemo=memoPadLogic.getList();  // 파일 목록 불러오기
				int memoCount = listMemo.memo.length;
				for(int i=0;i<memoCount;i++) {
					System.out.println((i+1)+") "+listMemo.memo[i].getTitle());
				}
			}else if(userWants.equals("W")|| userWants.equals("w")){
				System.out.print("제목 : ");
				String title = sc.next();
				sc.nextLine();  //버퍼지우기
				System.out.print("내용 : ");
				String text = sc.nextLine();
				Memo memo1 = new Memo(title,text);
				memoPadLogic.createMemo(memo1);
			}else if(userWants.equals("R")|| userWants.equals("r")){
				int readNum = 0;
				readNum = sc.nextInt();
				memoPadLogic.readMemo(listMemo.memo[readNum-1]);
			}else if(userWants.equals("D")|| userWants.equals("d")){
				int deleteNum = 0;
				deleteNum = sc.nextInt();
				memoPadLogic.deleteMemo(listMemo.memo[deleteNum-1]);
			}
		}
	}
}
