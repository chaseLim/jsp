package servlet;

public class Exam {

	String str;
	
	public static void main(String[] args) {
		Exam e = new Exam();
		e.str = new String("asdf");
		
		System.out.println(e.str);
		try {
			System.out.println(e.str.toUpperCase());
		}catch(Exception e1){
			System.out.println("뭔지는 모르겠는데 에러가 났을것이여!");
		}
		
	}
}
