package br.ufpi.compiladores.calculos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.antlr.v4.runtime.tree.TerminalNode;

import br.ufpi.compiladores.semantica.GramaticaBaseVisitor;
import br.ufpi.compiladores.semantica.GramaticaParser;
import br.ufpi.compiladores.semantica.GramaticaParser.BoolContext;
import br.ufpi.compiladores.semantica.GramaticaParser.DifLogContext;
import br.ufpi.compiladores.semantica.GramaticaParser.DivContext;
import br.ufpi.compiladores.semantica.GramaticaParser.ExpoContext;
import br.ufpi.compiladores.semantica.GramaticaParser.ExprContext;
import br.ufpi.compiladores.semantica.GramaticaParser.IgualLogContext;
import br.ufpi.compiladores.semantica.GramaticaParser.MaiorIqContext;
import br.ufpi.compiladores.semantica.GramaticaParser.MaiorQContext;
import br.ufpi.compiladores.semantica.GramaticaParser.MaisContext;
import br.ufpi.compiladores.semantica.GramaticaParser.MenorIqContext;
import br.ufpi.compiladores.semantica.GramaticaParser.MenorQContext;
import br.ufpi.compiladores.semantica.GramaticaParser.MenosContext;
import br.ufpi.compiladores.semantica.GramaticaParser.MenusUnaContext;
import br.ufpi.compiladores.semantica.GramaticaParser.MulContext;
import br.ufpi.compiladores.semantica.GramaticaParser.NegLogContext;
import br.ufpi.compiladores.utils.Variavel;

public class GeradorCalculos extends GramaticaBaseVisitor<Object>{
	
	private HashMap<String, String> variaveis = new HashMap<String, String>();
	private Map<String, Variavel> variaveisStaticas = new HashMap<>();
	private Map<String, Variavel> variaveisGlobais = new HashMap<>();
	private Map<String, Variavel> variaveisLocais = new HashMap<>();
	private HashMap<String, String> atribuicoes = new HashMap<>();
	private HashMap<String, String> funcoes = new HashMap<>();
	private static int countStack;
	private static int countLocals;
	public static String funcoesPrograma = "";

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public Object visitProgram(GramaticaParser.ProgramContext ctx) {
		return visitChildren(ctx);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public Object visitDeclaraVariaveisGlobais(GramaticaParser.DeclaraVariaveisGlobaisContext ctx) {
		String tipo = ctx.tipo().t;
		List<TerminalNode> ids = ctx.listaIDs().ID();
		String codeTemp = "";
		
		for (TerminalNode terminalNode : ids) {
				Variavel val = new Variavel();
				val.setTipo(tipo);
				val.setNome(terminalNode.getText());
				val.setScopo("global");
				val.setEnredeco(countLocals);
				countLocals++;
				if (tipo.equals("int")) {
					val.setValor("0");
					codeTemp += "ldc 0.0" + "\n" + 
					             "fstore " + val.getEnredeco() + "\n";
				}
				if (tipo.equals("real")) {
					val.setValor("0.0");
					codeTemp += "ldc 0.0" + "\n" + 
				                "fstore " + val.getEnredeco() + "\n";
				}
				if (tipo.equals("bool")) {
					val.setValor("FALSE");
					codeTemp += "iconst_0" + "\n" + 
				                "istore " + val.getEnredeco() + "\n";

					
				}
				if (tipo.equals("string")) {
					val.setValor("");
					codeTemp += "ldc" + " \"vazio\""+ "\n" + 
				                "astore " + val.getEnredeco() + "\n";

				}
		
				variaveisGlobais.put(terminalNode.getText(), val);
		}
		return visitChildren(ctx);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public Object visitDeclaraVariaveisLocais(GramaticaParser.DeclaraVariaveisLocaisContext ctx) { 
		String tipo = ctx.tipo().t;
		List<TerminalNode> ids = ctx.listaIDs().ID();

		
		String codeTemp = "";
		for (TerminalNode terminalNode : ids) {
				Variavel val = new Variavel();
				val.setTipo(tipo);
				val.setEnredeco(variaveisLocais.size());
				val.setNome(terminalNode.getText());
				val.setScopo("local");
				if (tipo.equals("int")) {
					val.setValor("0");
					codeTemp += "ldc 0.0" + "\n" + 
					             "fstore " + val.getEnredeco() + "\n";
				}
				if (tipo.equals("real")) {
					val.setValor("0.0");
					codeTemp += "ldc 0.0" + "\n" + 
				                "fstore " + val.getEnredeco() + "\n";
				}
				if (tipo.equals("bool")) {
					val.setValor("FALSE");
					codeTemp += "iconst_0" + "\n" + 
				                "istore " + val.getEnredeco() + "\n";

					
				}
				if (tipo.equals("string")) {
					val.setValor("");
					codeTemp += "ldc" + " \"vazio\""+ "\n" + 
				                "astore " + val.getEnredeco() + "\n";

				}

				variaveisLocais.put(terminalNode.getText(), val);

		}
		
		return visitChildren(ctx); 
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public Object visitDeclaraConstantes(GramaticaParser.DeclaraConstantesContext ctx) {
		Variavel val = new Variavel();
		val.setTipo(ctx.t);
		val.setEnredeco(countLocals);
		countLocals++;
		val.setNome(ctx.ID().getText());
		val.setValor(ctx.factor().getText());
		val.setScopo("statica");
		variaveisStaticas.put(ctx.ID().getText(), val);
		return visitChildren(ctx);
	}

	
	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public Object visitComandos(GramaticaParser.ComandosContext ctx) {
		return visitChildren(ctx);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public Object visitAtribuicao(GramaticaParser.AtribuicaoContext ctx) {
		if(ctx.exprAtri.getChildCount() == 1 && ctx.exprAtri.t != null){
			if (ctx.exprAtri.getText().matches("[0-9]+")) {
				String valor = ctx.exprAtri.getText();
				atribuicoes.put(ctx.atriID.getText(), valor);
			}else if (ctx.exprAtri.getText().matches("[0-9]+(.[0-9]+)?")) {
				String valor = ctx.exprAtri.getText().replace(".0","");
				atribuicoes.put(ctx.atriID.getText(), valor);
			}else if (ctx.exprAtri.getText().matches("FALSE") || ctx.exprAtri.getText().matches("TRUE")) {
				String valor = ctx.exprAtri.getText().equals("TRUE")?"1":"0";
				atribuicoes.put(ctx.atriID.getText(), valor);
			} else if (ctx.exprAtri.t.equals("id") && ctx.exprAtri.t != null && ctx.exprAtri.getChildCount() < 1) {
	        if(variaveisStaticas.get(ctx.exprAtri.getText()) != null){
	        	atribuicoes.put(ctx.atriID.getText(), variaveisStaticas.get(ctx.atriID.getText()).getValor());
	        }
	        if(variaveisGlobais.get(ctx.exprAtri.getText()) != null){
	        	atribuicoes.put(ctx.exprAtri.getText(), variaveisGlobais.get(ctx.exprAtri.getText()).getValor());
	        }
	        if(variaveisLocais.get(ctx.exprAtri.getText()) != null){
	        	atribuicoes.put(ctx.exprAtri.getText(), variaveisLocais.get(ctx.exprAtri.getText()).getValor());
	        }
	        
		    }else {
				String valor = ctx.exprAtri.getText();
				atribuicoes.put(ctx.atriID.getText(), valor);
			}
		}
		return visitChildren(ctx);
	}
/*
	*//**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public 
	Object visitDeclaraFuncao(GramaticaParser.DeclaraFuncaoContext ctx) {
		return visitChildren(ctx); 
		}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public Object visitChamadaFuncao(GramaticaParser.ChamadaFuncaoContext ctx) { 
		return visitChildren(ctx); 
	}
	

	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public Object visitListaExpressoes(GramaticaParser.ListaExpressoesContext ctx) { 
		return visitChildren(ctx); 
		}
		
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public Object visitImpressao(GramaticaParser.ImpressaoContext ctx) {
		return visitChildren(ctx); 
		}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public Object visitRetorno(GramaticaParser.RetornoContext ctx) { 
         return this.visit(ctx.expressoes()) == null?"":this.visit(ctx.expressoes());
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public Object visitSair(GramaticaParser.SairContext ctx) {
		return ""; 
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public Object visitLeitura(GramaticaParser.LeituraContext ctx) {
		return visitChildren(ctx);
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public Object visitSe(GramaticaParser.SeContext ctx) {
		return visitChildren(ctx); 
		}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Object visitSenao(GramaticaParser.SenaoContext ctx) { 
		return visitChildren(ctx);  
    }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
    public Object visitEnquanto(GramaticaParser.EnquantoContext ctx) {
		return visitChildren(ctx);  
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public Object visitPara(GramaticaParser.ParaContext ctx) { 
		return visitChildren(ctx);  
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public Object visitExpressoes(GramaticaParser.ExpressoesContext ctx) {
		return this.visit(ctx.bool());
	}

	
	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public Object visitExprParem(GramaticaParser.ExprParemContext ctx) {
		return this.visit(ctx.bool());
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public Object visitMais(GramaticaParser.MaisContext ctx) { 
		
		Object valorA = (ctx.a.getChildCount() > 1) || (ctx.a.getText().contains("(")) || (ctx.a.getText().contains("+")) || (ctx.a.getText().contains("-")) || (ctx.a.getText().contains("*")) || (ctx.a.getText().contains("^")) || (ctx.a.getText().contains("/"))?this.visit(ctx.a):atribuicoes.get(ctx.a.getText());
		Object valorB = (ctx.b.getChildCount() > 1) || (ctx.b.getText().contains("(")) || (ctx.b.getText().contains("+")) || (ctx.b.getText().contains("-")) || (ctx.b.getText().contains("*")) || (ctx.b.getText().contains("^")) || (ctx.b.getText().contains("/"))?this.visit(ctx.b):atribuicoes.get(ctx.b.getText());

		if(valorA == null && valorB == null){
			valorA="0";
			valorB="0";
		}
		double a =  valorA instanceof String?Double.parseDouble((String) valorA):(double) valorA;
		double b = valorB instanceof String?Double.parseDouble((String) valorB):(double) valorB;
	    double resultado = 0;
	    resultado = a + b;
	    return resultado;			
	
	}	


	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Object visitMenos(GramaticaParser.MenosContext ctx) { 
		Object valorA = (ctx.a.getChildCount() > 1) || (ctx.a.getText().contains("(")) || (ctx.a.getText().contains("+")) || (ctx.a.getText().contains("-")) || (ctx.a.getText().contains("*")) || (ctx.a.getText().contains("^")) || (ctx.a.getText().contains("/"))?this.visit(ctx.a):atribuicoes.get(ctx.a.getText());
		Object valorB = (ctx.b.getChildCount() > 1) || (ctx.b.getText().contains("(")) || (ctx.b.getText().contains("+")) || (ctx.b.getText().contains("-")) || (ctx.b.getText().contains("*")) || (ctx.b.getText().contains("^")) || (ctx.b.getText().contains("/"))?this.visit(ctx.b):atribuicoes.get(ctx.b.getText());

		if(valorA == null && valorB == null){
			valorA="0";
			valorB="0";
		}
		double a =  valorA instanceof String?Double.parseDouble((String) valorA):(double) valorA;
		double b = valorB instanceof String?Double.parseDouble((String) valorB):(double) valorB;
	    double resultado = 0;
	    resultado = a - b;
	    return resultado;				
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public Object visitDiv(GramaticaParser.DivContext ctx) {
		
		Object valorA = (ctx.a.getChildCount() > 1) || (ctx.a.getText().contains("(")) || (ctx.a.getText().contains("+")) || (ctx.a.getText().contains("-")) || (ctx.a.getText().contains("*")) || (ctx.a.getText().contains("^")) || (ctx.a.getText().contains("/"))?this.visit(ctx.a):atribuicoes.get(ctx.a.getText());
		Object valorB = (ctx.b.getChildCount() > 1) || (ctx.b.getText().contains("(")) || (ctx.b.getText().contains("+")) || (ctx.b.getText().contains("-")) || (ctx.b.getText().contains("*")) || (ctx.b.getText().contains("^")) || (ctx.b.getText().contains("/"))?this.visit(ctx.b):atribuicoes.get(ctx.b.getText());

		if(valorA == null && valorB == null){
			valorA="0";
			valorB="0";
		}
		double a =  valorA instanceof String?Double.parseDouble((String) valorA):(double) valorA;
		double b = valorB instanceof String?Double.parseDouble((String) valorB):(double) valorB;
	    double resultado = 0;
	    resultado = a / b;
	    return resultado;			
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public Object visitMul(GramaticaParser.MulContext ctx) { 
		
		Object valorA = (ctx.a.getChildCount() > 1) || (ctx.a.getText().contains("(")) || (ctx.a.getText().contains("+")) || (ctx.a.getText().contains("-")) || (ctx.a.getText().contains("*")) || (ctx.a.getText().contains("^")) || (ctx.a.getText().contains("/"))?this.visit(ctx.a):atribuicoes.get(ctx.a.getText());
		Object valorB = (ctx.b.getChildCount() > 1) || (ctx.b.getText().contains("(")) || (ctx.b.getText().contains("+")) || (ctx.b.getText().contains("-")) || (ctx.b.getText().contains("*")) || (ctx.b.getText().contains("^")) || (ctx.b.getText().contains("/"))?this.visit(ctx.b):atribuicoes.get(ctx.b.getText());

		if(valorA == null && valorB == null){
			valorA="0";
			valorB="0";
		}
		double a =  valorA instanceof String?Double.parseDouble((String) valorA):(double) valorA;
		double b = valorB instanceof String?Double.parseDouble((String) valorB):(double) valorB;
	    double resultado = 0;
	    resultado = a * b;
	    return resultado;			
	
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public Object visitOu(GramaticaParser.OuContext ctx) { 
		Object valorA = (ctx.a.getChildCount() > 1) || (ctx.a.getText().contains("(")) || (ctx.a.getText().contains("+")) || (ctx.a.getText().contains("-")) || (ctx.a.getText().contains("*")) || (ctx.a.getText().contains("^")) || (ctx.a.getText().contains("/"))?this.visit(ctx.a):atribuicoes.get(ctx.a.getText());
		Object valorB = (ctx.b.getChildCount() > 1) || (ctx.b.getText().contains("(")) || (ctx.b.getText().contains("+")) || (ctx.b.getText().contains("-")) || (ctx.b.getText().contains("*")) || (ctx.b.getText().contains("^")) || (ctx.b.getText().contains("/"))?this.visit(ctx.b):atribuicoes.get(ctx.b.getText());

		if(valorA == null && valorB == null){
			valorA="0";
			valorB="0";
		}
		int a =  valorA instanceof String?Integer.parseInt((String) valorA):(int) valorA;
		boolean aBool = a == 1?true:false;
		int b = valorB instanceof String?Integer.parseInt((String) valorB):(int) valorB;
		boolean bBool = b == 1?true:false;
	    boolean resultado = false;
	    resultado = aBool || bBool;
	    return resultado; 

	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Object visitAnd(GramaticaParser.AndContext ctx) {
		Object valorA = (ctx.a.getChildCount() > 1) || (ctx.a.getText().contains("(")) || (ctx.a.getText().contains("+")) || (ctx.a.getText().contains("-")) || (ctx.a.getText().contains("*")) || (ctx.a.getText().contains("^")) || (ctx.a.getText().contains("/"))?this.visit(ctx.a):atribuicoes.get(ctx.a.getText());
		Object valorB = (ctx.b.getChildCount() > 1) || (ctx.b.getText().contains("(")) || (ctx.b.getText().contains("+")) || (ctx.b.getText().contains("-")) || (ctx.b.getText().contains("*")) || (ctx.b.getText().contains("^")) || (ctx.b.getText().contains("/"))?this.visit(ctx.b):atribuicoes.get(ctx.b.getText());

		if(valorA == null && valorB == null){
			valorA="0";
			valorB="0";
		}
		int a =  valorA instanceof String?Integer.parseInt((String) valorA):(int) valorA;
		boolean aBool = a == 1?true:false;
		int b = valorB instanceof String?Integer.parseInt((String) valorB):(int) valorB;
		boolean bBool = b == 1?true:false;
	    boolean resultado = false;
	    resultado = aBool && bBool;
	    return resultado; 
		
}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
    public Object visitDifLog(GramaticaParser.DifLogContext ctx) {
		
		Variavel a = new Variavel();
		Variavel b = new Variavel();
		if(variaveisGlobais.get(ctx.a.getText()) != null && variaveisGlobais.get(ctx.b.getText()) != null){
			a = variaveisGlobais.get(ctx.a.getText());
			b = variaveisGlobais.get(ctx.b.getText());
		}
		if(variaveisLocais.get(ctx.a.getText()) != null && variaveisLocais.get(ctx.b.getText()) != null){
			a = variaveisLocais.get(ctx.a.getText());
			b = variaveisLocais.get(ctx.b.getText());
		}
		Object valorA = (ctx.a.getChildCount() > 1) || (ctx.a.getText().contains("(")) || (ctx.a.getText().contains("+")) || (ctx.a.getText().contains("-")) || (ctx.a.getText().contains("*")) || (ctx.a.getText().contains("^")) || (ctx.a.getText().contains("/"))?this.visit(ctx.a):atribuicoes.get(ctx.a.getText());
		Object valorB = (ctx.b.getChildCount() > 1) || (ctx.b.getText().contains("(")) || (ctx.b.getText().contains("+")) || (ctx.b.getText().contains("-")) || (ctx.b.getText().contains("*")) || (ctx.b.getText().contains("^")) || (ctx.b.getText().contains("/"))?this.visit(ctx.b):atribuicoes.get(ctx.b.getText());

		if(valorA == null && valorB == null){
			valorA="0";
			valorB="0";
		}
		if(a.getTipo() == "string"){
			valorA = String.valueOf(((String) valorA).length());
		}
		if(b.getTipo() == "string"){
			valorB = String.valueOf(((String) valorB).length());
		}
		int a1 =  valorA instanceof String?Integer.parseInt((String) valorA):(int) valorA;
		boolean aBool = a1 == 1?true:false;
		int b2 = valorB instanceof String?Integer.parseInt((String) valorB):(int) valorB;
		boolean bBool = b2 == 1?true:false;
	    boolean resultado = false;
	    resultado = aBool != bBool;
	    return resultado; 
	    }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public Object visitIgualLog(GramaticaParser.IgualLogContext ctx) {
		
		Variavel a = new Variavel();
		Variavel b = new Variavel();
		if(variaveisGlobais.get(ctx.a.getText()) != null && variaveisGlobais.get(ctx.b.getText()) != null){
			a = variaveisGlobais.get(ctx.a.getText());
			b = variaveisGlobais.get(ctx.b.getText());
		}
		if(variaveisLocais.get(ctx.a.getText()) != null && variaveisLocais.get(ctx.b.getText()) != null){
			a = variaveisLocais.get(ctx.a.getText());
			b = variaveisLocais.get(ctx.b.getText());
		}
		Object valorA = (ctx.a.getChildCount() > 1) || (ctx.a.getText().contains("(")) || (ctx.a.getText().contains("+")) || (ctx.a.getText().contains("-")) || (ctx.a.getText().contains("*")) || (ctx.a.getText().contains("^")) || (ctx.a.getText().contains("/"))?this.visit(ctx.a):atribuicoes.get(ctx.a.getText());
		Object valorB = (ctx.b.getChildCount() > 1) || (ctx.b.getText().contains("(")) || (ctx.b.getText().contains("+")) || (ctx.b.getText().contains("-")) || (ctx.b.getText().contains("*")) || (ctx.b.getText().contains("^")) || (ctx.b.getText().contains("/"))?this.visit(ctx.b):atribuicoes.get(ctx.b.getText());

		if(valorA == null && valorB == null){
			valorA="0";
			valorB="0";
		}
		if(a.getTipo() == "string"){
			valorA = String.valueOf(((String) valorA).length());
		}
		if(b.getTipo() == "string"){
			valorB = String.valueOf(((String) valorB).length());
		}
		int a1 =  valorA instanceof String?Integer.parseInt((String) valorA):(int) valorA;
		boolean aBool = a1 == 1?true:false;
		int b2 = valorB instanceof String?Integer.parseInt((String) valorB):(int) valorB;
		boolean bBool = b2 == 1?true:false;
	    boolean resultado = false;
	    resultado = aBool == bBool;
	    return resultado; 
}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public Object visitExpo(GramaticaParser.ExpoContext ctx) { 
		
		Object valorA = (ctx.a.getChildCount() > 1) || (ctx.a.getText().contains("(")) || (ctx.a.getText().contains("+")) || (ctx.a.getText().contains("-")) || (ctx.a.getText().contains("*")) || (ctx.a.getText().contains("^")) || (ctx.a.getText().contains("/"))?this.visit(ctx.a):atribuicoes.get(ctx.a.getText());
		Object valorB = (ctx.b.getChildCount() > 1) || (ctx.b.getText().contains("(")) || (ctx.b.getText().contains("+")) || (ctx.b.getText().contains("-")) || (ctx.b.getText().contains("*")) || (ctx.b.getText().contains("^")) || (ctx.b.getText().contains("/"))?this.visit(ctx.b):atribuicoes.get(ctx.b.getText());

		if(valorA == null && valorB == null){
			valorA="0";
			valorB="0";
		}
		double a =  valorA instanceof String?Double.parseDouble((String) valorA):(double) valorA;
		double b = valorB instanceof String?Double.parseDouble((String) valorB):(double) valorB;
	    double resultado = 0;
	    resultado = Math.pow(a, b);
	    return resultado;	
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public Object visitNegLog(GramaticaParser.NegLogContext ctx) { 
		Object valorA = (ctx.a.getChildCount() > 1) || (ctx.a.getText().contains("(")) || (ctx.a.getText().contains("+")) || (ctx.a.getText().contains("-")) || (ctx.a.getText().contains("*")) || (ctx.a.getText().contains("^")) || (ctx.a.getText().contains("/"))?this.visit(ctx.a):atribuicoes.get(ctx.a.getText());

		if(valorA == null){
			valorA="0";
		}
		int a =  valorA instanceof String?Integer.parseInt((String) valorA):(int) valorA;
		boolean aBool = a == 1?true:false;
	    boolean resultado = false;
	    resultado = !aBool;
	    return resultado; 
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public Object visitMenusUna(GramaticaParser.MenusUnaContext ctx) {
		
		Object valorA = (ctx.a.getChildCount() > 1) || (ctx.a.getText().contains("(")) || (ctx.a.getText().contains("+")) || (ctx.a.getText().contains("-")) || (ctx.a.getText().contains("*")) || (ctx.a.getText().contains("^")) || (ctx.a.getText().contains("/"))?this.visit(ctx.a):atribuicoes.get(ctx.a.getText());

		if(valorA == null){
			valorA=ctx.a.getText();
		}
		double a =  valorA instanceof String?Double.parseDouble((String) valorA):(double) valorA;
	    double resultado = 0;
	    resultado = -a;
	    return resultado;	
}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public Object visitMenorQ(GramaticaParser.MenorQContext ctx) { 	
		Object valorA = (ctx.a.getChildCount() > 1) || (ctx.a.getText().contains("(")) || (ctx.a.getText().contains("+")) || (ctx.a.getText().contains("-")) || (ctx.a.getText().contains("*")) || (ctx.a.getText().contains("^")) || (ctx.a.getText().contains("/"))?this.visit(ctx.a):atribuicoes.get(ctx.a.getText());
		Object valorB = (ctx.b.getChildCount() > 1) || (ctx.b.getText().contains("(")) || (ctx.b.getText().contains("+")) || (ctx.b.getText().contains("-")) || (ctx.b.getText().contains("*")) || (ctx.b.getText().contains("^")) || (ctx.b.getText().contains("/"))?this.visit(ctx.b):atribuicoes.get(ctx.b.getText());

		if(valorA == null && valorB == null){
			valorA="0";
			valorB="0";
		}
		double a =  valorA instanceof String?Double.parseDouble((String) valorA):(double) valorA;
		double b = valorB instanceof String?Double.parseDouble((String) valorB):(double) valorB;
	    boolean resultado = false;
	    resultado = a < b;
	    return resultado;
}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public Object visitMaiorQ(GramaticaParser.MaiorQContext ctx) {
		Object valorA = (ctx.a.getChildCount() > 1) || (ctx.a.getText().contains("(")) || (ctx.a.getText().contains("+")) || (ctx.a.getText().contains("-")) || (ctx.a.getText().contains("*")) || (ctx.a.getText().contains("^")) || (ctx.a.getText().contains("/"))?this.visit(ctx.a):atribuicoes.get(ctx.a.getText());
		Object valorB = (ctx.b.getChildCount() > 1) || (ctx.b.getText().contains("(")) || (ctx.b.getText().contains("+")) || (ctx.b.getText().contains("-")) || (ctx.b.getText().contains("*")) || (ctx.b.getText().contains("^")) || (ctx.b.getText().contains("/"))?this.visit(ctx.b):atribuicoes.get(ctx.b.getText());

		if(valorA == null && valorB == null){
			valorA="0";
			valorB="0";
		}
		double a =  valorA instanceof String?Double.parseDouble((String) valorA):(double) valorA;
		double b = valorB instanceof String?Double.parseDouble((String) valorB):(double) valorB;
	    boolean resultado = false;
	    resultado = a > b;
	    return resultado;		
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public Object visitMaiorIq(GramaticaParser.MaiorIqContext ctx) {
		Object valorA = (ctx.a.getChildCount() > 1) || (ctx.a.getText().contains("(")) || (ctx.a.getText().contains("+")) || (ctx.a.getText().contains("-")) || (ctx.a.getText().contains("*")) || (ctx.a.getText().contains("^")) || (ctx.a.getText().contains("/"))?this.visit(ctx.a):atribuicoes.get(ctx.a.getText());
		Object valorB = (ctx.b.getChildCount() > 1) || (ctx.b.getText().contains("(")) || (ctx.b.getText().contains("+")) || (ctx.b.getText().contains("-")) || (ctx.b.getText().contains("*")) || (ctx.b.getText().contains("^")) || (ctx.b.getText().contains("/"))?this.visit(ctx.b):atribuicoes.get(ctx.b.getText());

		if(valorA == null && valorB == null){
			valorA="0";
			valorB="0";
		}
		double a =  valorA instanceof String?Double.parseDouble((String) valorA):(double) valorA;
		double b = valorB instanceof String?Double.parseDouble((String) valorB):(double) valorB;
	    boolean resultado = false;
	    resultado = a >= b;
	    return resultado;	 
}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public Object visitMenorIq(GramaticaParser.MenorIqContext ctx) { 
		Object valorA = (ctx.a.getChildCount() > 1) || (ctx.a.getText().contains("(")) || (ctx.a.getText().contains("+")) || (ctx.a.getText().contains("-")) || (ctx.a.getText().contains("*")) || (ctx.a.getText().contains("^")) || (ctx.a.getText().contains("/"))?this.visit(ctx.a):atribuicoes.get(ctx.a.getText());
		Object valorB = (ctx.b.getChildCount() > 1) || (ctx.b.getText().contains("(")) || (ctx.b.getText().contains("+")) || (ctx.b.getText().contains("-")) || (ctx.b.getText().contains("*")) || (ctx.b.getText().contains("^")) || (ctx.b.getText().contains("/"))?this.visit(ctx.b):atribuicoes.get(ctx.b.getText());

		if(valorA == null && valorB == null){
			valorA="0";
			valorB="0";
		}
		double a =  valorA instanceof String?Double.parseDouble((String) valorA):(double) valorA;
		double b = valorB instanceof String?Double.parseDouble((String) valorB):(double) valorB;
	    boolean resultado = false;
	    resultado = a <= b;
	    return resultado;
}
	
	
	@Override
	protected Object aggregateResult(Object aggregate, Object nextResult) {
		if (aggregate == null) {
			return nextResult;
		}
		if (nextResult == null) {
			return aggregate;
		}
		return aggregate + "\n" + nextResult;
	}


}
