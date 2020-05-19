package singleton;

public class SingletonEx {
	public static void main(String[] args) {
		
		//private 생성자 호출 불가 - 객체 생성 불가
		
//		Singleton_01 s1= new Singleton_01();
//		Singleton_01 s2= new Singleton_01();

//		System.out.println(s1);
//		System.out.println(s2);
		
		//-----------------------------------
		
		//클래스 메소드 호출하는 방법
		Singleton_01 s1 = Singleton_01.getInstance();
		Singleton_01 s2 = Singleton_01.getInstance();
		Singleton_01 s3 = Singleton_01.getInstance();
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		System.out.println("0-------------------");
		
		Singleton_02 s4= Singleton_02.getInstance();
		Singleton_02 s5 = Singleton_02.getInstance();
		
		System.out.println(s4);
		System.out.println(s5);
		
		System.out.println("---------------");
		
		Singleton_03 s6= Singleton_03.getInstance();
		Singleton_03 s7 = Singleton_03.getInstance();
		
		System.out.println(s6);
		System.out.println(s7);
		
	}

}

















