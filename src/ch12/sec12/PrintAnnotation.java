package ch12.sec12;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//어떤 대상에 설정 정보를 적용할 것인지 설정 가능. -> 적용 대상 지정할 때는 @Target으로 지정 가능. 
//@Target의 기본 속성 value는 ElementType 열거 상수로 정의 
@Target({ElementType.METHOD})

//어노테이션 유지 정책 -> 언제까지 유지할 것인지도 지정해줘야 함. -> 지정할 때는 @Retention으로 지정 가능. 
//아래는 실행할 때 적용해서 계속 유지된다는 runtime 
@Retention(RetentionPolicy.RUNTIME)

//어노테이션 정의 @interface  A-> 이렇게 정의하면 추후 @A처럼 사용 가능하다. 
public @interface PrintAnnotation {
	
	//어노테이션은 속성(타입과 이름)을 가질 수 있음. -> 기본 값은 default 붙여서 지정 가능 
	String value() default "-";    //value는 어노테이션 내부에서 정의된 속성 이름 중 하나 ->  따라서 기본 속성 취급 되기에 이름 생략 가능. 값은 자동으로 value 속성에 대입됨. 
	int number() default 15;
}
