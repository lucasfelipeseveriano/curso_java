package com.softgraf.beans;

import java.io.Serializable;
import java.util.Map;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.component.html.HtmlInputText;
import jakarta.faces.event.AjaxBehaviorEvent;
import jakarta.inject.Named;

@Named(value = "bean")
@RequestScoped
public class MeuBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer num;
	private String texto;
	private Float v1 = 0f, v2 =0f;
	
	public Integer getNum() {
		return num;
	}
	
	public void setNum(Integer num) {
		this.num = num;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	private void maiusculas(AjaxBehaviorEvent event) {
		this.texto = texto.toUpperCase();
		
		HtmlInputText input = (HtmlInputText) event.getComponent();
		System.out.println("ID" + input.getId());
		System.out.println("Value" + input.getValue());
		
		Map<String, Object> atributos = input.getAttributes();
		atributos.keySet().forEach(k -> {
			System.out.println(k + " = " + atributos.get(k));
		});
		
	}

	public Float getV1() {
		return v1;
	}

	public void setV1(Float v1) {
		this.v1 = v1;
	}

	public Float getV2() {
		return v2;
	}

	public void setV2(Float v2) {
		this.v2 = v2;
	}
	
	public Float getSoma() {
		return v1 + v2;
	}


}
