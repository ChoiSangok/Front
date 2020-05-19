package singleton;


//  단점 보완(해결)
//  1. 인스턴스를 생성할 때 추가 작업을 할 수 없다
//			-> 예외처리 불가

//  2. 인스턴스(객체)를 사용하지 않아도 생성해 놓는다



public class Singleton_02 {
	
	public String data="Apple"; //데이터
	

	// private 생성자 - 클래스 외부에서 객체 생성하지 하게 막는다
	private Singleton_02() {
		
	}
	
	
	//정적 메소드로 바꿈 
	//하나 만들어놓고 모든곳에서 같은것만 쓰게 
	
	
	// 자신 클래스에 대한 객체 생성
	private static Singleton_02 instance;
	
	// static 초기화 블록
	// 클래스 변수(정적 변수) 를 초기화하는 블록
	
	static { 
		try {
			instance = new Singleton_02(); //객체 생성
		} catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
	
	//싱글톤 객체 반환메소드
	public static Singleton_02 getInstance() {
		return instance;
		
	}

}







