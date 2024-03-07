package logica;

public class LoopWhile {
	
	public static void main(String[] args) {
		
		int x = 0;
		while (x<10) {
			System.out.println(x++);
		}
		
		System.out.println("===========");
		x = 0;
		do {
			System.out.println(x);
			x++;
		} while(x<10);
	}

}
