package com.softgraf.primavera.data.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softgraf.primavera.data.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	@Cacheable("descricao_produto")
	List<Produto> findByDescricaoContaining(String descricao, Sort sort);
		
	
}
