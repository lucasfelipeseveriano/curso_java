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
		
		//Verifica menor preço
		if(p1 < p2 && p1 < p3)
			out.println("Produto 1 tem o menor preço");
		else if(p1 < p3)
			out.println("Produto 2 tem o menor preço");
		else
			out.println("Produto 3 tem o menor preço");
		
		//Verifica maior preço
		if(p1 > p2 && p1 > p3)
			s.println("Produto 1 tem o maior preço");
		else if(p1 > p3)
			s.println("Produto 2 tem o maior preço");
		else
			s.println("Produto 3 tem o maior preço");
		
		//Verifica preço total
		System.out.printf("Total = R$ %.2f\n", total);
		
		//Verifica a media
		s.printf("preço médio dos produtos R$ %.2f\n", media);
		
		s.printf("Preço à vista com 10%% de desconto: R$ %.2f\n", aVista);
		
		s.printf("valor da parcela em 3x sem juros: R$ %.2f\n", em3x);
		
		s.printf("Valor em 10x com 15%% de acréscimo: R$ %.2f\n", em10x);
		
	}
	
}
