package test;

public class ItemTest {

	  public static void main(String[] args) {
		    // 아이템 객체 생성
		    Item storm = new Item("스톰 브레이커", 600);
		    Item gauntlet = new Item("인피니티 건틀렛", 999);
		    Item bow = new Item("호크아이의 활", 50);
		    Item shield = new Item("캡틴아메리카의 방패", 50);
		    
		    // 객체 배열에 아이템 할당
		    Item[] items = { /* 1. 아이템을 배열에 할당하세요. */ 
		    	storm, gauntlet, bow, shield
		    };
		    
		    /* 2. 모든 아이템 정보를 출력하세요. */
		    for(Item i : items) {
		    	System.out.println(i.toString());
		    }
		    
		  }

}
