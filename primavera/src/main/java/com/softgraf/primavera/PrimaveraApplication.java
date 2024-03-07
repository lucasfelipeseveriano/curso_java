package com.softgraf.primavera;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.softgraf.primavera.service.CrudService;
import static java.lang.System.out;

@SpringBootApplication
public class PrimaveraApplication implements CommandLineRunner {
	
	private final CrudService crudService;
	
	public PrimaveraApplication(CrudService crudService) {
		System.out.println("PrimaveraApplication instancia pelo Spring");
		this.crudService = crudService;
	}

	public static void main(String[] args) {
		System.out.println("Iniciou main");
		SpringApplication.run(PrimaveraApplication.class, args);
		System.out.println("Finalizou main");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Executou run()");
		Scanner scanner = new Scanner(System.in);
		boolean rodar = true;
		
		while (rodar) {
			out.println("\n\n==== Sistema Primavera ====");
			out.println("1 - Cadastra 3 produtos");
			out.println("2 - Cadastra novo produto");
			out.println("3 - Cadastra 100 produtos");
			out.println("4 - Lista todos os produtos");
			out.println("5 - Buscar produto por descrição");
			out.println("6 - Listar produto com paginação");
			out.println("7 - Sair!");
			
			int opcao = 0;
			while (opcao < 1 || opcao > 7) {
				out.println("\nQual opção");
				opcao = scanner.nextInt();
			}
			
			switch (opcao) {
				case 1 -> crudService.cadastra3produtos();
				case 2 -> crudService.cadastraNovoProduto();
				case 3 -> crudService.cadastra100Produtos();
				case 4 -> crudService.listarTodosProdutos();
				case 5 -> crudService.buscarPorDescricao();
				case 6 -> crudService.listarProdutosComPaginacao("id");
				case 7 -> rodar = false;
			}
		}
		
		scanner.close();
		System.out.println("\nFui! Tchau!");
		
	}

}
