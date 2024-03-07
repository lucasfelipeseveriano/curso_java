package com.softgraf.beans;

import java.io.Serializable;
import java.util.Collection;



import com.softgraf.model.Marca;
import com.softgraf.model.Modelo;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Named;

@Named("carrosBean")
@SessionScoped
public class CarrosManagedBeanCDI implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Collection<Marca> marcas;
	private Collection<Modelo> modelos;
	private String siglaMarca;
	private String nomeModelo;
	
	@PostConstruct
	public void init() {
		this.marcas = Marca.todasMarcas.values();
	}
	
	private void carregarModelo(ValueChangeEvent event) {
		Object item = event.getNewValue();
		if (item != null) {
			String silaMarca = item.toString().toLowerCase();
			Marca marca = Marca.todasMarcas.get(silaMarca);
			this.modelos = marca.getModelos();
		}

	}
	
	public Collection<Marca> getMarcas() {
		return marcas;
	}
	
	public void setMarcas(Collection<Marca> marcas) {
		this.marcas = marcas;
	}
	
	public Collection<Modelo> getModelos() {
		return modelos;
	}
	
	public void setModelos(Collection<Modelo> modelos) {
		this.modelos = modelos;
	}
	
	public String getSiglaMarca() {
		return siglaMarca;
	}
	
	public void setSiglaMarca(String siglaMarca) {
		this.siglaMarca = siglaMarca;
	}
	
	public String getNomeModelo() {
		return nomeModelo;
	}
	
	public void setNomeModelo(String nomeModelo) {
		this.nomeModelo = nomeModelo;
	}
	
	

}
