package com.softgraf.primavera.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.softgraf.primavera.data.entity.Produto;
import com.softgraf.primavera.data.repository.ProdutoRepository;

import static java.lang.System.out;

@Service
public class CrudService {
	
	private final ProdutoRepository produtoRepository;
	
	public CrudService(ProdutoRepository produtoRepositoty) {
		System.out.println("CrudService instanciado pelo string");
		this.produtoRepository = produtoRepositoty;
	}
	
	public void cadastra3produtos() {
		Produto p1 = new Produto("TV Samsung OLED", 2999f, 10);
		Produto p3 = new Produto("Computador Intel", 5800f, 5);
		Produto p2 = new Produto("Teclado 101 teclas", 49.90f, 20);
		
		produtoRepository.save(p1);
		produtoRepository.save(p2);
		produtoRepository.save(p3);
	}
	
	public void cadastraNovoProduto() {
		Scanner scanner = new Scanner(System.in);
		Produto p = new Produto();
		
		System.out.println("Descrição: ");
		p.setDescricao(scanner.nextLine());
		
		System.out.println("Preço: ");
		p.setPreco(scanner.nextFloat());
		
		System.out.println("Quantidade: ");
		p.setQuantidade(scanner.nextInt());
		
	//	scanner.close();
		produtoRepository.save(p);
		System.out.println("=== produto salvo ===");
	}
	
	public void listarTodosProdutos() {
		System.out.println("\n\n=== Listando todos os Produtos ===");
		produtoRepository.findAll().forEach(System.out::println);
	}
	
	public void buscarPorDescricao() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite a descrição do produto: ");
		String descricao = scanner.nextLine();
		Sort sort = Sort.by("descricao").descending();
		
		List<Produto> lista = produtoRepository.findByDescricaoContaining(descricao, sort);
		if (lista.isEmpty())
			System.out.println("Nenhum produto encontrado com cada descrição");
		else
			lista.forEach(System.out::println);
	}
	
	public void cadastra100Produtos() {
		for(int i=1; i<100; i++) {
			Produto p = new Produto();
			p.setDescricao(ramdomTexto(7));
			p.setPreco((float) Math.random() * 100);
			p.setQuantidade(1 + (int) (Math.random() * 300));
			
			produtoRepository.save(p);
			System.out.printf("\nProduto %d/100 salvo", i);
		}
	}

	private String ramdomTexto(int tamanho) {
		StringBuilder builder = new StringBuilder();
		int base = 97;
		for (int i=0; i<tamanho; i++) {
			char letra = (char) (base +(Math.random() * 26));
			builder.append(letra);
		}
		
		return builder.toString();
	}
	
	public void listarProdutosComPaginacao(String campo) {
		int pageNumber = 0;
		int pageSize = 20;
		
		Pageable paginacao = PageRequest.of(pageNumber, pageSize, Sort.by(campo).ascending());
		
		Page<Produto> pagina = produtoRepository.findAll(paginacao);
		out.println("\n\n>>>Total de páginas: " + pagina.getTotalPages());
		out.println(">>Página Atual: " + pagina.getNumber());
		out.println(">>Itens por página:" + pagina.getSize());
		out.println(">>Total de itens da conslta" + pagina.getTotalElements());
		
		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		
		do {
			out.println("\n\n==== Menu de Paginação ====");
			out.println("MOSTRAR - conteúdo da página atual");
			out.println("PROX - vai para próximo página");
			out.println("ANT - vai para a página anterior");
			out.println("PRI - vai para primeira página");
			out.println("ULT - vai para a última página");
			out.println("CONV - converte página atual em lista");
			out.println("FIM - sai do menu");
			
			out.println("Qual opção?");
			escolha = scanner.next().toUpperCase();
			
			switch (escolha) {
				case "MOSTRAR:" -> {
					out.println("\n\n----- Exibindo página: " + pagina.getNumber());
					pagina.forEach(out::println);
				}
			
				case "PROX:" -> {
					if (pagina.hasNext()){
						pagina = produtoRepository.findAll(pagina.nextPageable());
						out.println("\n\n*** Foi para página: " + pagina.getNumber());
					} else
						out.println("\n\n*** Não há proxima página");
				}	
				
				case "ANT" -> {
					if (pagina.hasPrevious()) { 
						pagina = produtoRepository.findAll(pagina.previousPageable());
						out.println("\n\n*** Foi para página: " + pagina.getNumber());
					} else
						out.println("\n\n*** Não há página anterior");
				}
				
				case "PRI" -> {
					pagina = produtoRepository.findAll(paginacao.first());
					out.println("\n\n*** Foi para página: " + pagina.getNumber());
				}
				
				case "ULT" -> {
					paginacao = PageRequest.of(pagina.getTotalPages()- 1 , pageSize );
					pagina = produtoRepository.findAll(paginacao);
					out.println("\n\n***Foi para página: " + pagina.getNumber());
				}
				
				case "CONV" -> {
					List<Produto> lista = pagina.getContent();
					out.println("\n\n*** Converteu página em lista");
				}
				
				case "FIM" -> out.println("\n\n*** Saiu do menu de paginação");
				
				default -> out.println("\n*** Opção inválida");
			}
			
			
		} while (!escolha.equals("FIM"));
	}
	
	

}
