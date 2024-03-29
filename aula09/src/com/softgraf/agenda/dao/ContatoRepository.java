package com.softgraf.agenda.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import com.softgraf.agenda.dao.abstrato.Repository;
import com.softgraf.agenda.model.Contato;

public class ContatoRepository implements Repository<Contato>{
	
	private Connection conexao;
	private String aql;
	private PreparedStatement stmt;
	private String sql;
	private Long id;
	
	public ContatoRepository(Connection conexao) {
		this.conexao = conexao;
		
		
	}
	

	@Override
	public boolean save(Contato contato) {
		int retorno = 0;
		
		sql = "INSERT INTO Contato (nome, fone) VALUES (?, ?)";
		
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getFone());
			retorno = stmt.executeUpdate();
			
			if (retorno > 0) {
				ResultSet rs = stmt.executeQuery("SELECT LAST_INSERT_ID() AS id");
				rs.next();
				Long id = rs.getLong("id");
				contato.setId(id);
			}
			
		} catch (SQLException e) {
			System.out.println();
			e.printStackTrace();
		}
		return retorno>0;
		
	}


	@Override
	public Contato findById(Long peimaryKey) {
		sql = "SELECT * FROM Contato WHERE id=?";
		Contato contato = null;
		
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				String nome = rs.getString("nome");
				String fone = rs.getString("fone");
				contato = new Contato(id, nome, fone);
				stmt.close();
			}
				
			} catch (SQLException e) {
				System.out.println("Erro ao buscar entidade ID");
				e.printStackTrace();
				
			}
		return contato;
		

	}

	@Override
	public List<Contato> findAll() {
		List <Contato> lista = new ArrayList<>();
		sql = "SELECT * FROM Contato";
		
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Long id = rs.getLong("id");
				String nome = rs.getString("nome");
				String fone = rs.getString("fone");
				Contato contato = new Contato(id, nome, fone);
				lista.add(contato);
			}
			
			stmt.close();
			
		} catch (SQLException e) {
			System.out.println("Erro ao listar entidade com findAll()");
			e.printStackTrace();
			
		}		
		return lista;
		
	}

	@Override
	public void delete(Long id) {
		sql = "DELETE FROM Contato WHERE id=?";
		
		try {
			stmt=conexao.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.executeUpdate();
			stmt.close();
			
		} catch (SQLException e) {
			System.out.println("Erro ao apagar entidade contato");
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean existsById(Long id) {
		sql = "SELECT EXISTS(SELECT * FROM Contato WHERE id=?) AS existe";
		boolean existe = false;
		
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
			existe = rs.getInt("existe") == 1;
			stmt.close();
			
		} catch (SQLException e) {
			System.out.println("Erro em existsById()");
			e.printStackTrace();
		}
				
		return existe;
	}

	@Override
	public void update(Long id, Contato contato) {
		sql = "UPDATE Contato SET nome=?, fone=? WHERE id=?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getFone());
			stmt.setLong(3, id);
			stmt.executeUpdate();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public long count() {
		sql = "SELECT COUNT(*) AS quant FROM contato";
		long quant = 0;
		
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			// vai para a primeira linha da tabela retornada no resultset
			rs.next();
			quant = rs.getLong("quant");
			stmt.close();
			
		} catch (SQLException e) {
			System.out.println("Erro em quant()");
			e.printStackTrace();
		}
		
		return quant;
	}
	
	public int storeProcedureTotalContatos() {
		int total = 0;
		
		try {
			CallableStatement stmt = conexao.prepareCall("CALL get_total_contatos(?)");
			stmt.registerOutParameter(1, Types.INTEGER);
			stmt.execute();
			total = stmt.getInt(1);
			stmt.close();
			
		} catch (SQLException e) {
			System.out.println("Erro em storeProcedureTotalContatos");
			e.printStackTrace();
		}
		
		return total;
	}


	@Override
	public void delete(Contato entity) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean existsById(Long primatiKey, Contato emtity) {
		// TODO Auto-generated method stub
		return false;
	}

}
