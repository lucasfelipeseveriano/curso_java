package com.softgraf.primavera.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softgraf.primavera.data.dto.ProdutoRecordDTO;
import com.softgraf.primavera.data.entity.Produto;
import com.softgraf.primavera.data.repository.ProdutoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api")
public class ProdutoApiController {
	
	@Autowired
	private ProdutoRepository repository;
	
	/*
	*JSON: {"descricao": "Computador",
	*	"preco": 5999.0,
	*  "quantidade": 5,
	*  "url": "imagem.png"
	  }
	*/
	
//	public void cadastrar(@RequestBody String json) {
//		System.out.println(json);
//	}

	@PostMapping("cadastrar")
	public Produto cadastrar(@RequestBody Produto produto) {
		return repository.save(produto);	
	}
	
	@GetMapping("listar")
	public List<Produto> listarTodos(){
		return repository.findAll();
	}
	
	@GetMapping("produto/{id}")
	public Produto buscarPorId(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new ProdutoNotFoundException(id));
	}
	
	@PutMapping("/produto/{id}")
	public Produto atualizarPorId(@RequestBody @Valid ProdutoRecordDTO produtoDTO, @PathVariable Long id) {

	return repository.findById(id).map(produto -> {		
		produto.setDescricao(produtoDTO.descricao());
		produto.setPreco(produtoDTO.preco());
		produto.setQuantidade(produtoDTO.quantidade());
		produto.setUrl(produtoDTO.url());
		return repository.save(produto);
	}).orElseGet(() -> {
		return repository.save(produtoDTO.toProduto() );
	});
}
	
	@DeleteMapping("produto/{id}")
	public void deletarPorId(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
