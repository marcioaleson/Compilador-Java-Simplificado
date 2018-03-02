package br.ufpi.compiladores.utils;

public class Variavel {
	private int enredeco;
	private String tipo;
	private String nome;
	private String scopo;
	private String valor;
	
	public Variavel(int enredeco, String tipo) {
		super();
		this.enredeco = enredeco;
		this.tipo = tipo;
	}

	public Variavel() {
		// TODO Auto-generated constructor stub
	}

	public int getEnredeco() {
		return enredeco;
	}

	public void setEnredeco(int enredeco) {
		this.enredeco = enredeco;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getScopo() {
		return scopo;
	}

	public void setScopo(String scopo) {
		this.scopo = scopo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}


}