package com.softgraf.agenda.dao.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import com.softgraf.agenda.dao.ConnectionFactory;
import com.softgraf.agenda.dao.ContatoRepository;
import com.softgraf.agenda.dao.MysqlDataSource;
import com.softgraf.agenda.model.Contato;

public class Teste {
	
	public static void main(String[] args) throws IOException, SQLException {
		MysqlDataSource ds = new MysqlDataSource();
		Connection conexao = ConnectionFactory.getMysqlConnection(ds);
		ContatoRepository repositorio = new ContatoRepository(conexao);
		
		/*
		Contato contato = new Contato("Luiza Camargo", "(42)3456-1278");
		repositorio.save(contato);
		System.out.println(contato.getId());
		
		Contato procurado = repositorio.findById(1L);
		System.out.println(procurado);
		
		List<Contato> lista = repositorio.findAll();
		lista.forEach(System.out::println);
		
		repositorio.delete(9L);
	
		System.out.println(repositorio.existsById(1L));
		
		repositorio.update(7L, new Contato("Helena Souza", "(42)9999-0969"));
		
		long quant = repositorio.count();
		System.out.println("numero de registros " + repositorio.count());
		*/
		
		System.out.println("\nstoreProcrdureTotalContatos(): "+ repositorio.storeProcedureTotalContatos());
		
		conexao.close();
		System.out.println("\n-OK");
		
	}
}