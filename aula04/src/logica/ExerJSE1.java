package logica;

import static java.lang.System.out;

import java.io.PrintStream;
import java.util.Scanner;

public class ExerJSE1 {
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		PrintStream s = System.out;
		
		s.println("Valor do produto 1");
		float p1 = teclado.nextFloat();
		
		s.println("Valor do produto 2");
		float p2 = teclado.nextFloat();
		
		s.println("Valor do produto 3");
		float p3 = teclado.nextFloat();
				
		float total = p1 + p2 + p3;
		float media = total/3;
		float aVista = total * 0.9f;
		float em3x = total / 3;
		float em10x = total / 0.115f;
		
		//Verifica menor pre�o
		if(p1 < p2 && p1 < p3)
			out.println("Produto 1 tem o menor pre�o");
		else if(p1 < p3)
			out.println("Produto 2 tem o menor pre�o");
		else
			out.println("Produto 3 tem o menor pre�o");
		
		//Verifica maior pre�o
		if(p1 > p2 && p1 > p3)
			s.println("Produto 1 tem o maior pre�o");
		else if(p1 > p3)
			s.println("Produto 2 tem o maior pre�o");
		else
			s.println("Produto 3 tem o maior pre�o");
		
		//Verifica pre�o total
		System.out.printf("Total = R$ %.2f\n", total);
		
		//Verifica a media
		s.printf("pre�o m�dio dos produtos R$ %.2f\n", media);
		
		s.printf("Pre�o � vista com 10%% de desconto: R$ %.2f\n", aVista);
		
		s.printf("valor da parcela em 3x sem juros: R$ %.2f\n", em3x);
		
		s.printf("Valor em 10x com 15%% de acr�scimo: R$ %.2f\n", em10x);
		
	}
	
}
