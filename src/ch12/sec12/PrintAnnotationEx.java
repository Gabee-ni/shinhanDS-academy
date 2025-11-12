package ch12.sec12;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrintAnnotationEx {

	public static void main(String[] args) throws Exception {

		//서비스라는 클래스의 메타 정보를 가져옴. 리플렉션 -> 정의되어 있는 메서드들을 메서드 배열 타입으로 담은 것. Service.class -> 서비스 클래스로부터 메타정보 얻어오고
		//.getDeclaredMethods : 정의된 메서드들을 다 가져옴
		Method[] declareMethod = Service.class.getDeclaredMethods();
		
		for(Method method : declareMethod) {
			//해당 메서드에 지정된 어노테이션 정보를 가져오는 코드. Service 클래스에 선언된 메소드를 리플렉션 해서 어노테이션 설정 정보를 얻어낸 후
			PrintAnnotation printAnnotation =method.getAnnotation(PrintAnnotation.class);
			
			//설정 정보를 이용해서 선 출력 
			printLine(printAnnotation);
			
			//메소드를 호출 invoke -> 리플렉션에서 메서드를 실제로 실행시키는 기능. 
			method.invoke(new Service());
			
			printLine(printAnnotation);
			
		}
		
	
	}
	
	//어노테이션 받아와서
	private static void printLine(PrintAnnotation printAnnotation) {

		if(printAnnotation != null) {
			//어노테이션의 넘버를 읽어와서 
			int number = printAnnotation.number();
			//그것만큼 어노테이션의 value값을 가져와서 출력 
			for(int i=0; i<number; i++) {
				String value = printAnnotation.value();
				System.out.print(value);
			}
			System.out.println();
		}
	}

}
