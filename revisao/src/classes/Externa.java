package classes;

public class Externa {

	public static void main(String[] args) {
		new Externa();

	}
	public Externa() {
		System.out.println("construtor");
		
	}
	
	public class Interna {
		public void mensagem() {
			System.out.println("Texto da classe interna");
		}
	}

}
