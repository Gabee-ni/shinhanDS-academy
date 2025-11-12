package ch15.sec02.exam01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ArraysListExample {

	public static void main(String[] args) {

//		List<Board> list = new ArrayList<>();
		
//		Vector<Board> list = new Vector<Board>();
//		//이는 리스트에 없고 Vector에만 있음. 확장한 것처럼 보이지만, vetcor는 원래 collection 프레임 나오기 전부터 있어서 그냥 이 메서드만 추가한 것. 
//		list.addElement(new Board("제목0", "내용0", "글쓴이0"));
//		
		
		List<Board> list = new LinkedList<Board>();
		
		list.add(new Board("제목1", "내용1", "글쓴이1"));
		list.add(new Board("제목2", "내용2", "글쓴이2"));
		list.add(new Board("제목3", "내용3", "글쓴이3"));
		list.add(new Board("제목4", "내용4", "글쓴이4"));
		list.add(new Board("제목5", "내용5", "글쓴이5"));
		
		int size = list.size();
		System.out.println("총 객체 수 : "+size);
		System.out.println();
		
		Board board = list.get(2);
		System.out.println(board);
		
		System.out.println();
		
		for(int i=0; i<list.size();i++) {
			Board b = list.get(i);
			System.out.println(b);
		}
		System.out.println();
		
		list.remove(2); //2번 인덱스가 사라지면 원래 3이던 인덱스부터 마지막까지 1씩 앞당겨짐. 
		list.remove(2); 
		
		for(Board b : list) {
			System.out.println(b);
		}
		
		
	}

}
