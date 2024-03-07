package com.softgraf.agenda.dao.abstrato;

public interface MeuDataSource {
	
	String getStringConexao();
	String getClasse();
	String getDriver();
	String getUrl();
	String getDataBase();
	String getUser();
	String getPassword();

}
