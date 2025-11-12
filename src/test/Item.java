package test;

public class Item {
	String name;
	int power;
	
	public Item (String str, int i) {
		name = str;
		power = i;
	}
	
	public String toString() {
		return String.format("Item { name :%s, power :%d}", name, power);
		
	}
}
