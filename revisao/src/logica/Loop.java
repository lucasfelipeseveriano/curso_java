package logica;

import static logica.Mensagem.*;

public class Loop {
	public static void main(String[] args) {
		

		
		for (int i = 0; i < 10; i++) {
			imprimir(i);
		}
		
		for (int i = 100; i < 110; i++) {
			imprimirln(i);
		}
		
		String frutas[] = new String[10];
		frutas[0] ="abacate";
		frutas[2] = "banana";
		frutas[5] = "kiwi";
		
		for (String f : frutas) {
			if(f != null && f != "banana")
			System.out.println(f);
		}
		
		
	}
}
