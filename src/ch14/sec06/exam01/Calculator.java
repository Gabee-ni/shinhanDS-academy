package ch14.sec06.exam01;

public class Calculator {
	private int memory;
	
	public int getMemory() {
		return memory;
	}

//	public void setMemory(int memory) { //동기화가 되지 않음
		
	public synchronized void setMemory(int memory) {
		this.memory = memory;
		
		try {
			Thread.sleep(2000);
			
		} catch (Exception e) {
			
		}
		System.out.println(Thread.currentThread().getName()+ ": "+ this.memory);
	}
	
	public void setMemory2(int memory) {
		synchronized (this) {
			this.memory = memory;
			
			try {
				Thread.sleep(2000);
				
			} catch (Exception e) {
				
			}
			System.out.println(Thread.currentThread().getName()+ ": "+ this.memory);
		}
		
	}
}
