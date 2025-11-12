package ch08.sec08;

import ch08.sec02.RemoteControl;

public class SmartTelevision implements RemoteControl, Searchable {

	@Override
	public void turnOn() {

		System.out.println("스마트 티비를 켭니다.");
	}
	@Override
	public void turnOff() {
		
		System.out.println("스마트 티비를 끕니다.");
	}

	@Override
	public void search(String url) {
		
		System.out.println(url+"를 검사합니다.");
		
	}


}
