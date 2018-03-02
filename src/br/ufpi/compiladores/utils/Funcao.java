package br.ufpi.compiladores.utils;

import java.util.ArrayList;
import java.util.List;

public class Funcao {
	private String tipo;
	private String id;
	private List<Variavel> parametros = new ArrayList<>();

	public Funcao(String tipo, String id, List<Variavel> parametros) {
		super();
		this.tipo = tipo;
		this.id = id;
		this.parametros = parametros;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Variavel> getParametros() {
		return parametros;
	}

	public void setParametros(List<Variavel> parametros) {
		this.parametros = parametros;
	}
}
