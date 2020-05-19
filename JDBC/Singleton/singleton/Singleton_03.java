package singleton;


//  단점
//  1. 인스턴스를 생성할 때 추가 작업을 할 수 없다
//			-> 예외처리 불가

//  2. 인스턴스(객체) 를 사용하지 않아도 생성해 놓는다
//  3. 


public class Singleton_03 {
	
	public String data="Apple"; //데이터
	
	// private 생성자 - 클래스 외부에서 객체 생성하지 하게 막는다
	
	private Singleton_03() {
		
	}

	
	// 자신 클래스에 대한 객체 생성
	private static Singleton_03 instance;
		//
	
	//싱글톤 객체 반환메소드
	public static Singleton_03 getInstance() {
		// getInstance() 를 처음 호출할 때까지 객체생성을 하지 않고
		// 기다린다
		
		// 두 번째 호출부터는 만들어져있는 객체를 반환한다
		
		
		if(instance == null) { //
			try {
				instance = new Singleton_03(); // 객체 생성
			} catch( Exception e) {
				e.printStackTrace();
			
			}
		}
		return instance;
		
	}

}
