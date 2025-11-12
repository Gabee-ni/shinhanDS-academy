package test;

public class Order {
	  // 필드(인스턴스 필드)
	  int orderNum;
	  Menu[] menus;
	  
	  // 생성자
	  public Order(int i, Menu[] arr) {
	    orderNum = i;
	    menus = arr;
	  }
	  
	  // 메소드(인스턴스 메소드)
	  public int totalPrice() {
	    int sum =0; 
	    for(Menu m : menus) {
	    	sum += m.price;
	    }
	    return sum;
	  }
}
