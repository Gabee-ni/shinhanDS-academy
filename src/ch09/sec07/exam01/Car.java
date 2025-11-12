package ch09.sec07.exam01;

public class Car {
//	private Tire tire1 = new Tire();
	
	//익명 자식 객체를 필드로
	private Tire tire2 = new Tire() {
		@Override
		public void roll() {
			System.out.println("tire 객체 1 굴러감.");
		}

		@Override
		public void stop() {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	public void run1() {
//		tire1.roll();
		tire2.roll();
	}
	
	public void run2() {
		//로컬 변수로
		Tire tire = new Tire() {
			@Override
			public void roll() {
				System.out.println("tire 객체 2 굴러감.");
			}

			@Override
			public void stop() {
				// TODO Auto-generated method stub
				
			};
		
		};
		
		tire.roll();
	
	}
	//매개변수로
	public void run3(Tire tire) {
		tire.roll();
	}
}
