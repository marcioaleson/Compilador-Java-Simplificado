package br.ufpi.compiladores.acoessematicas;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.tree.TerminalNode;

import br.ufpi.compiladores.semantica.GramaticaBaseListener;
import br.ufpi.compiladores.semantica.GramaticaParser;
import br.ufpi.compiladores.semantica.GramaticaParser.BoolContext;
import br.ufpi.compiladores.semantica.GramaticaParser.ListaIDsContext;
import br.ufpi.compiladores.utils.Funcao;
import br.ufpi.compiladores.utils.Variavel;

public class AcoesSemanticas extends GramaticaBaseListener {
	private Map<String, Variavel> variaveisStaticas = new HashMap<>();
	private Map<String, Variavel> variaveisGlobais = new HashMap<>();
	private Map<String, Variavel> variaveisLocais = new HashMap<>();
	private Map<String, Variavel> variaveisParam = new HashMap<>();
	private Map<String, String> funcoes = new HashMap<>();
	private Map<String, Funcao> funcoesProg = new HashMap<>();	
	private List<String> erros = new ArrayList<String>();
	private List<Variavel> variaveis = new ArrayList<Variavel>();
	private List<String> palavrasReservadas = new ArrayList<String>();
	public PrintWriter salvar;
	public FileWriter codigo;
	private GramaticaParser parser = null;
	private static final String[] LITERAL_NAMES = { "Prog", "{", "}", "Static", "=", ";", "Int", "Real", "Bool",
			"String", ",", "(", ")", "if", "else", "for", "to", "step", "while", "scan", "break", "print", "||", "&&",
			">=", "<=", ">", "<", "==", "!=", "+", "-", "*", "/", "!", "^", "return" };

	public AcoesSemanticas(GramaticaParser parser) {
		//this.codigo = codigo;
		this.parser = parser;
		//salvar = new PrintWriter(codigo);
		for (String string : LITERAL_NAMES) {
			this.palavrasReservadas.add(string);
		}
	}

	@Override
	public void enterDeclaraVariaveisGlobais(GramaticaParser.DeclaraVariaveisGlobaisContext ctx) {
		String tipo = ctx.tipo().t;
		List<TerminalNode> ids = ctx.listaIDs().ID();
		boolean reservada = false;
		for (String string : palavrasReservadas) {
			if (ctx.listaIDs().getText().equals(string)) {
				reservada = true;
			}
		}
		for (TerminalNode terminalNode : ids) {
			if (variaveisGlobais.get(terminalNode.getText()) != null) {
				erros.add("\nVariável já declarada anteriormente: " + terminalNode.getText() + " linha: "
						+ ctx.start.getLine());
			} else {
				Variavel val = new Variavel();
				val.setTipo(tipo);
				val.setEnredeco(variaveisGlobais.size());
				val.setNome(terminalNode.getText());
				val.setScopo("global");
				variaveis.add(val);
				variaveisGlobais.put(terminalNode.getText(), val);
			}

		}

	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterDeclaraConstantes(GramaticaParser.DeclaraConstantesContext ctx) {
		if (variaveisGlobais.get(ctx.ID()) != null) {
			erros.add("\nVariável statica já declarada anteriormente como global: " + ctx.ID().getText() + " linha: "
					+ ctx.start.getLine() + ".");
		} else if (variaveisStaticas.get(ctx.ID()) != null) {
			erros.add("\nVariável statica já declarada anteriormente: " + ctx.ID().getText() + " linha: "
					+ ctx.start.getLine() + ".");
		} else {
			Variavel val = new Variavel();
			val.setTipo(ctx.t);
			val.setEnredeco(variaveisStaticas.size());
			val.setNome(ctx.ID().getText());
			val.setScopo("statica");
			variaveis.add(val);
			variaveisStaticas.put(ctx.ID().getText(), val);
		}
	}

	@Override
	public void enterDeclaraVariaveisLocais(GramaticaParser.DeclaraVariaveisLocaisContext ctx) {
		String tipo = ctx.tipo().t;
		List<TerminalNode> ids = ctx.listaIDs().ID();
		boolean reservada = false;
		for (String string : palavrasReservadas) {
			if (ctx.listaIDs().getText().equals(string)) {
				reservada = true;
			}
		}
		for (TerminalNode terminalNode : ids) {
			if (variaveisLocais.get(terminalNode.getText()) != null) {
				erros.add("\nVariável local já declarada anteriormente: " + terminalNode.getText() + " linha: "
						+ ctx.start.getLine());
			} else {
				Variavel val = new Variavel();
				val.setTipo(tipo);
				val.setEnredeco(variaveisLocais.size());
				val.setNome(terminalNode.getText());
				val.setScopo("local");
				variaveis.add(val);
				variaveisLocais.put(terminalNode.getText(), val);
				variaveisGlobais.put(terminalNode.getText(),val);
			}
		}

	}

	@Override
	public void enterAtribuicao(GramaticaParser.AtribuicaoContext ctx) {

		if(variaveisStaticas.get(ctx.atriID.getText()) != null){
			erros.add("\nVariável declarada como static: " + ctx.atriID.getText() + " linha: " + ctx.start.getLine());
		}
		
		Variavel test = variaveisGlobais.get(ctx.atriID.getText());
		
		if (test == null && variaveisStaticas.get(ctx.atriID.getText()) == null) {
			test = variaveisLocais.get(ctx.atriID.getText());
			if(test == null){
			erros.add("\nVariável não declarada: " + ctx.atriID.getText() + " linha: " + ctx.start.getLine());
			}
		}
		String tipo = null;
		for (Variavel v : variaveis) {
			if (test != null) {
				if ((v.getNome() == test.getNome()) && (v.getScopo() == test.getScopo())) {
					tipo = v.getTipo();
				}
			}
		}

		if ((test != null) && (test.getTipo() != null) && (ctx.exprAtri.t != null) && (test.getTipo() != "bool")){
			if (test.getTipo() != tipo) {
				erros.add("\nTipo de atribuição com valores errados: " + ctx.ID().getText() + " linha: "
						+ ctx.start.getLine() + "......");
			}
		}
		
		if ( (test != null) && (test.getTipo() != null) && (ctx.exprAtri.start != null) && (variaveisGlobais.get(ctx.exprAtri.start.getText()) != null) && (test.getTipo() != "bool")){
			if (test.getTipo() != variaveisGlobais.get(ctx.exprAtri.start.getText()).getTipo()) {
				erros.add("\nTipo de atribuição com valores errados: " + ctx.ID().getText() +  "," + ctx.exprAtri.start.getText() + " linha: "
						+ ctx.start.getLine() + "......");
			}
		}
		
		if ((test != null) && (test.getTipo() != null) && (ctx.exprAtri.start != null) && (variaveisGlobais.get(ctx.exprAtri.stop.getText()) != null) && (test.getTipo() != "bool")){
			if (test.getTipo() != variaveisGlobais.get(ctx.exprAtri.stop.getText()).getTipo()) {
				erros.add("\nTipo de atribuição com valores errados: " + ctx.ID().getText() + "," + ctx.exprAtri.stop.getText() + " linha: "
						+ ctx.start.getLine() + "......");
			}
		}
		
		if ((test != null) && (test.getTipo() != null) && (ctx.exprAtri.start != null) && (variaveisLocais.get(ctx.exprAtri.start.getText()) != null) && (test.getTipo() != "bool")){
			if (test.getTipo() != variaveisLocais.get(ctx.exprAtri.start.getText()).getTipo()) {
				erros.add("\nTipo de atribuição com valores errados: " + ctx.ID().getText() +  "," + ctx.exprAtri.start.getText() + " linha: "
						+ ctx.start.getLine() + "......");
			}
		}
		
		if ((test != null) && (test.getTipo() != null) && (ctx.exprAtri.start != null) && (variaveisLocais.get(ctx.exprAtri.stop.getText()) != null) && (test.getTipo() != "bool")){
			if (test.getTipo() != variaveisLocais.get(ctx.exprAtri.stop.getText()).getTipo()) {
				erros.add("\nTipo de atribuição com valores errados: " + ctx.ID().getText() + "," + ctx.exprAtri.stop.getText() + " linha: "
						+ ctx.start.getLine() + "......");
			}
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override 
	public void enterImpressao(GramaticaParser.ImpressaoContext ctx) {
		
		List<BoolContext> listExpr = ctx.listaExpressoes().bool();
		for(BoolContext v : listExpr){
			if(variaveisStaticas.get(v.start.getText()) == null){
              if(variaveisGlobais.get(v.start.getText()) == null && variaveisStaticas.get(v.start.getText()) == null){
                 if(variaveisLocais.get(v.start.getText()) == null){
         			erros.add("\nVariável não declarada: " + v.start.getText() + " linha: " + ctx.start.getLine());
                 }
			  }
		     }
			if(variaveisStaticas.get(v.stop.getText()) == null){
	              if(variaveisGlobais.get(v.stop.getText()) == null && variaveisStaticas.get(v.stop.getText()) == null){
	                 if(variaveisLocais.get(v.stop.getText()) == null){
	         			erros.add("\nVariável não declarada: " + v.stop.getText() + " linha: " + ctx.stop.getLine());
	                 }
				  }
			     }
		}
		
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override 
	public void enterLeitura(GramaticaParser.LeituraContext ctx) {
		List<TerminalNode> listExpr = ctx.listaIDs().ID();
		for(TerminalNode v : listExpr){
			if(variaveisStaticas.get(v.getText()) == null){
              if(variaveisGlobais.get(v.getText()) == null && variaveisStaticas.get(v.getText()) == null){
                 if(variaveisLocais.get(v.getText()) == null){
         			erros.add("\nVariável não declarada: " + v.getText() + " linha: " + ctx.start.getLine());
                 }
			  }
		     }
		}
		
	}
	
	@Override
	public void enterPara(GramaticaParser.ParaContext ctx) {
		String initVarID = ctx.initVarID.getText();
		String initVar = ctx.intVar.getText();
		String endVar = ctx.endVar.getText();
		String stepVar = ctx.stepVar.getText();
		if (variaveisGlobais.get(initVarID) != null) {
			if (!variaveisGlobais.get(initVarID).getTipo().equals("int")) {
				erros.add("\nContador " + initVarID + " não declarado como inteiro localmente: " + ctx.ID().getText()
						+ " linha: " + ctx.start.getLine());
			}
		} else if (variaveisGlobais.get(initVarID) != null) {
			if (!variaveisGlobais.get(initVarID).getTipo().equals("int")) {
				erros.add("\nContador " + initVarID + " não declarado como inteiro globalmente: " + ctx.ID().getText()
						+ " linha: " + ctx.start.getLine());
			}
		} else {
			erros.add("\nContador " + initVarID + " não declarado anteriormente:" + ctx.ID().getText() + " linha: "
					+ ctx.start.getLine());
		}

		if (variaveisGlobais.get(endVar) != null) {
			if (!variaveisGlobais.get(endVar).getTipo().equals("int")) {
				erros.add("\nFinal " + endVar + " não declarado como inteiro localmente: " + ctx.ID().getText()
						+ " linha: " + ctx.start.getLine());
			}
		} else if (variaveisGlobais.get(endVar) != null) {
			if (!variaveisGlobais.get(endVar).getTipo().equals("int")) {
				erros.add("\nFinal " + endVar + " não declarado como inteiro globalmente: " + ctx.ID().getText()
						+ " linha: " + ctx.start.getLine());
			}
		} else {
			erros.add("\nFinal " + endVar + " não declarado anteriormente: " + ctx.ID().getText() + " linha: "
					+ ctx.start.getLine());
		}

		if (variaveisGlobais.get(stepVar) != null) {
			if (!variaveisGlobais.get(stepVar).getTipo().equals("int")) {
				erros.add("\nPasso  " + stepVar + " não declarado como inteiro localmente: " + ctx.ID().getText()
						+ " linha: " + ctx.start.getLine());
			}
		} else if (variaveisGlobais.get(stepVar) != null) {
			if (!variaveisGlobais.get(stepVar).getTipo().equals("int")) {
				erros.add("\nPasso  " + stepVar + " não declarado como inteiro globalmente: " + ctx.ID().getText()
						+ " linha: " + ctx.start.getLine());
			}
		} else {
			erros.add("\nPasso " + stepVar + " não declarado anteriormente: " + ctx.ID().getText() + " linha: "
					+ ctx.start.getLine());
		}
		if (ctx.intVar.getText().matches("[0-9]+") == false) {
			erros.add("\nValor inicial " + initVar + " não é um initeiro: " + ctx.ID().getText() + " linha: "
					+ ctx.start.getLine());
		}
	}

	@Override
	public void enterDeclaraFuncao(GramaticaParser.DeclaraFuncaoContext ctx) {
		List<Variavel> listVar = new ArrayList<>();
		int count = 0;
		if(ctx.declaraParametros() != null){
		List<ListaIDsContext> ids = ctx.declaraParametros().listaIDs();
		
        for(ListaIDsContext v : ids){
        	String[] var = v.getRuleContext().getText().split(",");
        	for(String s : var){
        		Variavel vr = new Variavel();
        		vr.setNome(s);
        		vr.setTipo(ctx.declaraParametros().tipo(count).t);
        		vr.setScopo("local");
        		listVar.add(vr);
             
        	}
        	count++;
        	funcoesProg.put(ctx.ID().getText(), new Funcao(ctx.tipo().getText(),ctx.ID().getText(),listVar));
        }
		}
        count = 0;
		
		if (funcoes.get(ctx.ID().getText()) != null) {
			erros.add("\nFunção já declarada anteriormente com mesmo identificador: " + ctx.ID().getText() + " linha: "
					+ ctx.start.getLine());
		}
		if (variaveisGlobais.get(ctx.ID().getText()) != null) {
			erros.add("\nFunção com mesmo identificador de uma variável já declarada: " + ctx.ID().getText() + " linha: "
					+ ctx.start.getLine());
		}
		if (variaveisStaticas.get(ctx.ID().getText()) != null) {
			erros.add("\nFunção com mesmo identificador de uma variável já declarada: " + ctx.ID().getText() + " linha: "
					+ ctx.start.getLine());
		}
		if (ctx.tipo() != null) {
			funcoes.put(ctx.ID().getText(), ctx.tipo().t);
		} else {
			funcoes.put(ctx.ID().getText(), null);
		}
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override 
	public void enterChamadaFuncao(GramaticaParser.ChamadaFuncaoContext ctx) {

		List<BoolContext> listExpr = ctx.listaExpressoes().bool();
		int count = 0;
		List<Variavel> vr = null;
		if(funcoes.get(ctx.ID().getText()) != null){
		Funcao fun = funcoesProg.get(ctx.ID().getText());
	    vr = fun.getParametros();
	    }
		for(BoolContext v : listExpr){
			if(variaveisStaticas.get(v.start.getText()) == null){
              if(variaveisGlobais.get(v.start.getText()) == null && variaveisStaticas.get(v.start.getText()) == null){
                 if(variaveisLocais.get(v.start.getText()) == null){
         			erros.add("\nVariável não declarada: " + v.start.getText() + " linha: " + ctx.start.getLine());
                 }
			  }
		     }
            if(funcoes.get(ctx.ID().getText()) != null && variaveisGlobais.get(v.getText()) != null){
			if(variaveisGlobais.get(v.getText()).getTipo() != vr.get(count).getTipo()){
				erros.add("\nParametro de tipos diferentes: " + v.start.getText() + " linha: " + ctx.start.getLine());
			}
			count++;
            }
		}
		count = 0;
		if(funcoes.get(ctx.ID().getText()) == null){
 			erros.add("\nFunção não declarada: " + ctx.ID().getText() + " linha: " + ctx.stop.getLine());			
		}
		if(funcoesProg.get(ctx.ID().getText()) != null){
			if(funcoesProg.get(ctx.ID().getText()).getParametros().size() != listExpr.size()){
	 			erros.add("\nFunção declarada com quantidade de parametros errados: " + ctx.ID().getText() + " linha: " + ctx.stop.getLine());			
			}			
		}
	
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override 
	public void enterDeclaraParametros(GramaticaParser.DeclaraParametrosContext ctx) {
		String tipo = ctx.t;
		List<ListaIDsContext> listParam = ctx.listaIDs();
		for(ListaIDsContext v : listParam){
			List<TerminalNode> listVar = v.ID();
			for(TerminalNode vr : listVar){
				Variavel val = new Variavel();
				val.setTipo(tipo);
				val.setEnredeco(variaveisLocais.size());
				val.setNome(vr.getText());
				val.setScopo("local");
				variaveis.add(val);
				variaveisParam.put(vr.getText(), val);
				variaveisParam.put(vr.getText(),val);
			}
		}
		
	}
	
	@Override
	public void enterOu(GramaticaParser.OuContext ctx) {
		String tipoA = null;
		String tipoB = null;
		if (variaveisGlobais.get(ctx.a.getText()) != null) {
			tipoA = variaveisGlobais.get(ctx.a.getText()).getTipo();
		}
		if (variaveisGlobais.get(ctx.b.getText()) != null) {
			tipoB = variaveisGlobais.get(ctx.b.getText()).getTipo();
		}
		if (variaveisLocais.get(ctx.a.getText()) != null) {
			tipoA = variaveisLocais.get(ctx.a.getText()).getTipo();
		}
		if (variaveisLocais.get(ctx.b.getText()) != null) {
			tipoB = variaveisLocais.get(ctx.b.getText()).getTipo();
		}
/*		if ((tipoA == null) && (ctx.a.t.equals("id") == false) && (ctx.a.t.equals("chamadaFuncao") == false) && ((ctx.a.t.equals("int")) || (ctx.a.equals("real") || (ctx.a.t.equals("bool") || (ctx.a.t.equals("string")))))) {
			tipoA = ctx.a.t;
		}
		if ((tipoA == null) && (ctx.b.t.equals("id") == false) && (ctx.b.t.equals("chamadaFuncao") == false) && ((ctx.b.t.equals("int")) || (ctx.b.t.equals("real") || (ctx.b.t.equals("bool") || (ctx.b.t.equals("string")))))) {
			tipoB = ctx.b.t;
		}
*/
		if ((tipoA != tipoB) && (tipoA != null) && (tipoB != null) && (tipoA.equals("id") == false) && (tipoB.equals("chamadaFuncao") == false))  {
			erros.add("\nVariáveis com tipos diferentes: " + ctx.a.getText() + "," + ctx.b.getText() + ", linha: "
					+ ctx.start.getLine() + ".");
		}
		if(tipoA == null && ctx.a.t == "id" && variaveisParam.get(ctx.a.getText()) == null){
			erros.add("\nVariável não declarada: " + ctx.a.getText() + ", linha: "
					+ ctx.start.getLine() + ".");			
		}
		
		if(tipoB == null && ctx.b.t == "id" && variaveisParam.get(ctx.b.getText()) == null){
			erros.add("\nVariável não declarada: " + ctx.b.getText() + ", linha: "
					+ ctx.start.getLine() + ".");			
		}
		
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterAnd(GramaticaParser.AndContext ctx) {
		String tipoA = null;
		String tipoB = null;
		if (variaveisGlobais.get(ctx.a.getText()) != null) {
			tipoA = variaveisGlobais.get(ctx.a.getText()).getTipo();
		}
		if (variaveisGlobais.get(ctx.b.getText()) != null) {
			tipoB = variaveisGlobais.get(ctx.b.getText()).getTipo();
		}
		if (variaveisLocais.get(ctx.a.getText()) != null) {
			tipoA = variaveisLocais.get(ctx.a.getText()).getTipo();
		}
		if (variaveisLocais.get(ctx.b.getText()) != null) {
			tipoB = variaveisLocais.get(ctx.b.getText()).getTipo();
		}
/*		if ((tipoA == null) && (ctx.a.t.equals("id") == false) && (ctx.a.t.equals("chamadaFuncao") == false) && ((ctx.a.t.equals("int")) || (ctx.a.equals("real") || (ctx.a.t.equals("bool") || (ctx.a.t.equals("string")))))) {
			tipoA = ctx.a.t;
		}
		if ((tipoA == null) && (ctx.b.t.equals("id") == false) && (ctx.b.t.equals("chamadaFuncao") == false) && ((ctx.b.t.equals("int")) || (ctx.b.t.equals("real") || (ctx.b.t.equals("bool") || (ctx.b.t.equals("string")))))) {
			tipoB = ctx.b.t;
		}
*/
		if ((tipoA != tipoB) && (tipoA != null) && (tipoB != null) && (tipoA.equals("id") == false) && (tipoB.equals("chamadaFuncao") == false))  {
			erros.add("\nVariáveis com tipos diferentes: " + ctx.a.getText() + "," + ctx.b.getText() + ", linha: "
					+ ctx.start.getLine() + ".");
		}
		
		if(tipoA == null && ctx.a.t == "id" && variaveisParam.get(ctx.a.getText()) == null){
			erros.add("\nVariável não declarada: " + ctx.a.getText() + ", linha: "
					+ ctx.start.getLine() + ".");			
		}
		
		if(tipoB == null && ctx.b.t == "id" && variaveisParam.get(ctx.b.getText()) == null){
			erros.add("\nVariável não declarada: " + ctx.b.getText() + ", linha: "
					+ ctx.start.getLine() + ".");			
		}
		
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterMaiorIq(GramaticaParser.MaiorIqContext ctx) {
		String tipoA = null;
		String tipoB = null;
		if (variaveisGlobais.get(ctx.a.getText()) != null) {
			tipoA = variaveisGlobais.get(ctx.a.getText()).getTipo();
		}
		if (variaveisGlobais.get(ctx.b.getText()) != null) {
			tipoB = variaveisGlobais.get(ctx.b.getText()).getTipo();
		}
		if (variaveisLocais.get(ctx.a.getText()) != null) {
			tipoA = variaveisLocais.get(ctx.a.getText()).getTipo();
		}
		if (variaveisLocais.get(ctx.b.getText()) != null) {
			tipoB = variaveisLocais.get(ctx.b.getText()).getTipo();
		}
		if ((tipoA == null) && (ctx.a.t.equals("id") == false) && (ctx.a.t.equals("chamadaFuncao") == false) && ((ctx.a.t.equals("int")) || (ctx.a.equals("real") || (ctx.a.t.equals("bool") || (ctx.a.t.equals("string")))))) {
			tipoA = ctx.a.t;
		}
		if ((tipoA == null) && (ctx.b.t.equals("id") == false) && (ctx.b.t.equals("chamadaFuncao") == false) && ((ctx.b.t.equals("int")) || (ctx.b.t.equals("real") || (ctx.b.t.equals("bool") || (ctx.b.t.equals("string")))))) {
			tipoB = ctx.b.t;
		}

		if ((tipoA != tipoB) && (tipoA != null) && (tipoB != null) && (tipoA.equals("id") == false) && (tipoB.equals("chamadaFuncao") == false))  {
			erros.add("\nVariáveis com tipos diferentes: " + ctx.a.getText() + "," + ctx.b.getText() + ", linha: "
					+ ctx.start.getLine() + ".");
		}
		
		if(tipoA == null && ctx.a.t == "id" && variaveisParam.get(ctx.a.getText()) == null){
			erros.add("\nVariável não declarada: " + ctx.a.getText() + ", linha: "
					+ ctx.start.getLine() + ".");			
		}
		
		if(tipoB == null && ctx.b.t == "id" && variaveisParam.get(ctx.b.getText()) == null){
			erros.add("\nVariável não declarada: " + ctx.b.getText() + ", linha: "
					+ ctx.start.getLine() + ".");			
		}
		
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterMaiorQ(GramaticaParser.MaiorQContext ctx) {
		String tipoA = null;
		String tipoB = null;
		if (variaveisGlobais.get(ctx.a.getText()) != null) {
			tipoA = variaveisGlobais.get(ctx.a.getText()).getTipo();
		}
		if (variaveisGlobais.get(ctx.b.getText()) != null) {
			tipoB = variaveisGlobais.get(ctx.b.getText()).getTipo();
		}
		if (variaveisLocais.get(ctx.a.getText()) != null) {
			tipoA = variaveisLocais.get(ctx.a.getText()).getTipo();
		}
		if (variaveisLocais.get(ctx.b.getText()) != null) {
			tipoB = variaveisLocais.get(ctx.b.getText()).getTipo();
		}
/*		if ((tipoA == null) && (ctx.a.t.equals("id") == false) && (ctx.a.t.equals("chamadaFuncao") == false) && ((ctx.a.t.equals("int")) || (ctx.a.equals("real") || (ctx.a.t.equals("bool") || (ctx.a.t.equals("string")))))) {
			tipoA = ctx.a.t;
		}
		if ((tipoA == null) && (ctx.b.t.equals("id") == false) && (ctx.b.t.equals("chamadaFuncao") == false) && ((ctx.b.t.equals("int")) || (ctx.b.t.equals("real") || (ctx.b.t.equals("bool") || (ctx.b.t.equals("string")))))) {
			tipoB = ctx.b.t;
		}
*/
		if ((tipoA != tipoB) && (tipoA != null) && (tipoB != null) && (tipoA.equals("id") == false) && (tipoB.equals("chamadaFuncao") == false))  {
			erros.add("\nVariáveis com tipos diferentes: " + ctx.a.getText() + "," + ctx.b.getText() + ", linha: "
					+ ctx.start.getLine() + ".");
		}
		
		if(tipoA == null && ctx.a.t == "id" && variaveisParam.get(ctx.a.getText()) == null){
			erros.add("\nVariável não declarada: " + ctx.a.getText() + ", linha: "
					+ ctx.start.getLine() + ".");			
		}
		
		if(tipoB == null && ctx.b.t == "id" && variaveisParam.get(ctx.b.getText()) == null){
			erros.add("\nVariável não declarada: " + ctx.b.getText() + ", linha: "
					+ ctx.start.getLine() + ".");			
		}
		
	}


	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterMenorIq(GramaticaParser.MenorIqContext ctx) {
		String tipoA = null;
		String tipoB = null;
		if (variaveisGlobais.get(ctx.a.getText()) != null) {
			tipoA = variaveisGlobais.get(ctx.a.getText()).getTipo();
		}
		if (variaveisGlobais.get(ctx.b.getText()) != null) {
			tipoB = variaveisGlobais.get(ctx.b.getText()).getTipo();
		}
		if (variaveisLocais.get(ctx.a.getText()) != null) {
			tipoA = variaveisLocais.get(ctx.a.getText()).getTipo();
		}
		if (variaveisLocais.get(ctx.b.getText()) != null) {
			tipoB = variaveisLocais.get(ctx.b.getText()).getTipo();
		}
		if ((tipoA == null) && (ctx.a.t.equals("id") == false) && (ctx.a.t.equals("chamadaFuncao") == false) && ((ctx.a.t.equals("int")) || (ctx.a.equals("real") || (ctx.a.t.equals("bool") || (ctx.a.t.equals("string")))))) {
			tipoA = ctx.a.t;
		}
		if ((tipoA == null) && (ctx.b.t.equals("id") == false) && (ctx.b.t.equals("chamadaFuncao") == false) && ((ctx.b.t.equals("int")) || (ctx.b.t.equals("real") || (ctx.b.t.equals("bool") || (ctx.b.t.equals("string")))))) {
			tipoB = ctx.b.t;
		}

		if ((tipoA != tipoB) && (tipoA != null) && (tipoB != null) && (tipoA.equals("id") == false) && (tipoB.equals("chamadaFuncao") == false))  {
			erros.add("\nVariáveis com tipos diferentes: " + ctx.a.getText() + "," + ctx.b.getText() + ", linha: "
					+ ctx.start.getLine() + ".");
		}
		
		if(tipoA == null && ctx.a.t == "id" && variaveisParam.get(ctx.a.getText()) == null){
			erros.add("\nVariável não declarada: " + ctx.a.getText() + ", linha: "
					+ ctx.start.getLine() + ".");			
		}
		
		if(tipoB == null && ctx.b.t == "id" && variaveisParam.get(ctx.b.getText()) == null){
			erros.add("\nVariável não declarada: " + ctx.b.getText() + ", linha: "
					+ ctx.start.getLine() + ".");			
		}
		
	}


	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterMenorQ(GramaticaParser.MenorQContext ctx) {
		String tipoA = null;
		String tipoB = null;
		if (variaveisGlobais.get(ctx.a.getText()) != null) {
			tipoA = variaveisGlobais.get(ctx.a.getText()).getTipo();
		}
		if (variaveisGlobais.get(ctx.b.getText()) != null) {
			tipoB = variaveisGlobais.get(ctx.b.getText()).getTipo();
		}
		if (variaveisLocais.get(ctx.a.getText()) != null) {
			tipoA = variaveisLocais.get(ctx.a.getText()).getTipo();
		}
		if (variaveisLocais.get(ctx.b.getText()) != null) {
			tipoB = variaveisLocais.get(ctx.b.getText()).getTipo();
		}
		if ((tipoA == null) && (ctx.a.t.equals("id") == false) && (ctx.a.t.equals("chamadaFuncao") == false) && ((ctx.a.t.equals("int")) || (ctx.a.equals("real") || (ctx.a.t.equals("bool") || (ctx.a.t.equals("string")))))) {
			tipoA = ctx.a.t;
		}
		if ((tipoA == null) && (ctx.b.t.equals("id") == false) && (ctx.b.t.equals("chamadaFuncao") == false) && ((ctx.b.t.equals("int")) || (ctx.b.t.equals("real") || (ctx.b.t.equals("bool") || (ctx.b.t.equals("string")))))) {
			tipoB = ctx.b.t;
		}

		if ((tipoA != tipoB) && (tipoA != null) && (tipoB != null) && (tipoA.equals("id") == false) && (tipoB.equals("chamadaFuncao") == false))  {
			erros.add("\nVariáveis com tipos diferentes: " + ctx.a.getText() + "," + ctx.b.getText() + ", linha: "
					+ ctx.start.getLine() + ".");
		}
		
		if(tipoA == null && ctx.a.t == "id" && variaveisParam.get(ctx.a.getText()) == null){
			erros.add("\nVariável não declarada: " + ctx.a.getText() + ", linha: "
					+ ctx.start.getLine() + ".");			
		}
		
		if(tipoB == null && ctx.b.t == "id" && variaveisParam.get(ctx.b.getText()) == null){
			erros.add("\nVariável não declarada: " + ctx.b.getText() + ", linha: "
					+ ctx.start.getLine() + ".");			
		}
		
	}

		
	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterIgualLog(GramaticaParser.IgualLogContext ctx) {
		String tipoA = null;
		String tipoB = null;
		if (variaveisGlobais.get(ctx.a.getText()) != null) {
			tipoA = variaveisGlobais.get(ctx.a.getText()).getTipo();
		}
		if (variaveisGlobais.get(ctx.b.getText()) != null) {
			tipoB = variaveisGlobais.get(ctx.b.getText()).getTipo();
		}
		if (variaveisLocais.get(ctx.a.getText()) != null) {
			tipoA = variaveisLocais.get(ctx.a.getText()).getTipo();
		}
		if (variaveisLocais.get(ctx.b.getText()) != null) {
			tipoB = variaveisLocais.get(ctx.b.getText()).getTipo();
		}
		if ((tipoA == null) && (ctx.a.t.equals("id") == false) && (ctx.a.t.equals("chamadaFuncao") == false) && ((ctx.a.t.equals("int")) || (ctx.a.equals("real") || (ctx.a.t.equals("bool") || (ctx.a.t.equals("string")))))) {
			tipoA = ctx.a.t;
		}
		if ((tipoA == null) && (ctx.b.t.equals("id") == false) && (ctx.b.t.equals("chamadaFuncao") == false) && ((ctx.b.t.equals("int")) || (ctx.b.t.equals("real") || (ctx.b.t.equals("bool") || (ctx.b.t.equals("string")))))) {
			tipoB = ctx.b.t;
		}

		if ((tipoA != tipoB) && (tipoA != null) && (tipoB != null) && (tipoA.equals("id") == false) && (tipoB.equals("chamadaFuncao") == false))  {
			erros.add("\nVariáveis com tipos diferentes: " + ctx.a.getText() + "," + ctx.b.getText() + ", linha: "
					+ ctx.start.getLine() + ".");
		}
		if(tipoA == null && ctx.a.t == "id" && variaveisParam.get(ctx.a.getText()) == null){
			erros.add("\nVariável não declarada: " + ctx.a.getText() + ", linha: "
					+ ctx.start.getLine() + ".");			
		}
		
		if(tipoB == null && ctx.b.t == "id" && variaveisParam.get(ctx.b.getText()) == null){
			erros.add("\nVariável não declarada: " + ctx.b.getText() + ", linha: "
					+ ctx.start.getLine() + ".");			
		}
		
	}

	
	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterDifLog(GramaticaParser.DifLogContext ctx) {
		String tipoA = null;
		String tipoB = null;
		if (variaveisGlobais.get(ctx.a.getText()) != null) {
			tipoA = variaveisGlobais.get(ctx.a.getText()).getTipo();
		}
		if (variaveisGlobais.get(ctx.b.getText()) != null) {
			tipoB = variaveisGlobais.get(ctx.b.getText()).getTipo();
		}
		if (variaveisLocais.get(ctx.a.getText()) != null) {
			tipoA = variaveisLocais.get(ctx.a.getText()).getTipo();
		}
		if (variaveisLocais.get(ctx.b.getText()) != null) {
			tipoB = variaveisLocais.get(ctx.b.getText()).getTipo();
		}
		if ((tipoA == null) && (ctx.a.t.equals("id") == false) && (ctx.a.t.equals("chamadaFuncao") == false) && ((ctx.a.t.equals("int")) || (ctx.a.equals("real") || (ctx.a.t.equals("bool") || (ctx.a.t.equals("string")))))) {
			tipoA = ctx.a.t;
		}
		if ((tipoA == null) && (ctx.b.t.equals("id") == false) && (ctx.b.t.equals("chamadaFuncao") == false) && ((ctx.b.t.equals("int")) || (ctx.b.t.equals("real") || (ctx.b.t.equals("bool") || (ctx.b.t.equals("string")))))) {
			tipoB = ctx.b.t;
		}

		if ((tipoA != tipoB) && (tipoA != null) && (tipoB != null) && (tipoA.equals("id") == false) && (tipoB.equals("chamadaFuncao") == false))  {
			erros.add("\nVariáveis com tipos diferentes: " + ctx.a.getText() + "," + ctx.b.getText() + ", linha: "
					+ ctx.start.getLine() + ".");
		}
		if(tipoA == null && ctx.a.t == "id" && variaveisParam.get(ctx.a.getText()) == null){
			erros.add("\nVariável não declarada: " + ctx.a.getText() + ", linha: "
					+ ctx.start.getLine() + ".");			
		}
		
		if(tipoB == null && ctx.b.t == "id" && variaveisParam.get(ctx.b.getText()) == null){
			erros.add("\nVariável não declarada: " + ctx.b.getText() + ", linha: "
					+ ctx.start.getLine() + ".");			
		}
		
	}

	
	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterMais(GramaticaParser.MaisContext ctx) {
		String tipoA = null;
		String tipoB = null;
		if (variaveisGlobais.get(ctx.a.getText()) != null) {
			tipoA = variaveisGlobais.get(ctx.a.getText()).getTipo();
		}
		if (variaveisGlobais.get(ctx.b.getText()) != null) {
			tipoB = variaveisGlobais.get(ctx.b.getText()).getTipo();
		}
		if (variaveisLocais.get(ctx.a.getText()) != null) {
			tipoA = variaveisLocais.get(ctx.a.getText()).getTipo();
		}
		if (variaveisLocais.get(ctx.b.getText()) != null) {
			tipoB = variaveisLocais.get(ctx.b.getText()).getTipo();
		}
/*		if ((tipoA == null) && (ctx.a.t.equals("id") == false) && (ctx.a.t.equals("chamadaFuncao") == false) && ((ctx.a.t.equals("int")) || (ctx.a.equals("real") || (ctx.a.t.equals("bool") || (ctx.a.t.equals("string")))))) {
			tipoA = ctx.a.t;
		}
		if ((tipoA == null) && (ctx.b.t.equals("id") == false) && (ctx.b.t.equals("chamadaFuncao") == false) && ((ctx.b.t.equals("int")) || (ctx.b.t.equals("real") || (ctx.b.t.equals("bool") || (ctx.b.t.equals("string")))))) {
			tipoB = ctx.b.t;
		}
*/
		if ((tipoA != tipoB) && (tipoA != null) && (tipoB != null) && (tipoA.equals("id") == false) && (tipoB.equals("chamadaFuncao") == false))  {
			erros.add("\nVariáveis com tipos diferentes: " + ctx.a.getText() + "," + ctx.b.getText() + ", linha: "
					+ ctx.start.getLine() + ".");
		}
		
		if(tipoA == null && ctx.a.t == "id" && variaveisParam.get(ctx.a.getText()) == null){
			erros.add("\nVariável não declarada: " + ctx.a.getText() + ", linha: "
					+ ctx.start.getLine() + ".");			
		}
		
		if(tipoB == null && ctx.b.t == "id" && variaveisParam.get(ctx.b.getText()) == null){
			erros.add("\nVariável não declarada: " + ctx.b.getText() + ", linha: "
					+ ctx.start.getLine() + ".");			
		}
		
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterMenos(GramaticaParser.MenosContext ctx) {
		String tipoA = null;
		String tipoB = null;
		if (variaveisGlobais.get(ctx.a.getText()) != null) {
			tipoA = variaveisGlobais.get(ctx.a.getText()).getTipo();
		}
		if (variaveisGlobais.get(ctx.b.getText()) != null) {
			tipoB = variaveisGlobais.get(ctx.b.getText()).getTipo();
		}
		if (variaveisLocais.get(ctx.a.getText()) != null) {
			tipoA = variaveisLocais.get(ctx.a.getText()).getTipo();
		}
		if (variaveisLocais.get(ctx.b.getText()) != null) {
			tipoB = variaveisLocais.get(ctx.b.getText()).getTipo();
		}
/*		if ((tipoA == null) && (ctx.a.t.equals("id") == false) && (ctx.a.t.equals("chamadaFuncao") == false) && ((ctx.a.t.equals("int")) || (ctx.a.equals("real") || (ctx.a.t.equals("bool") || (ctx.a.t.equals("string")))))) {
			tipoA = ctx.a.t;
		}
		if ((tipoA == null) && (ctx.b.t.equals("id") == false) && (ctx.b.t.equals("chamadaFuncao") == false) && ((ctx.b.t.equals("int")) || (ctx.b.t.equals("real") || (ctx.b.t.equals("bool") || (ctx.b.t.equals("string")))))) {
			tipoB = ctx.b.t;
		}
*/
		if ((tipoA != tipoB) && (tipoA != null) && (tipoB != null) && (tipoA.equals("id") == false) && (tipoB.equals("chamadaFuncao") == false))  {
			erros.add("\nVariáveis com tipos diferentes: " + ctx.a.getText() + "," + ctx.b.getText() + ", linha: "
					+ ctx.start.getLine() + ".");
		}
		
		if(tipoA == null && ctx.a.t == "id" && variaveisParam.get(ctx.a.getText()) == null){
			erros.add("\nVariável não declarada: " + ctx.a.getText() + ", linha: "
					+ ctx.start.getLine() + ".");			
		}
		
		if(tipoB == null && ctx.b.t == "id" && variaveisParam.get(ctx.b.getText()) == null){
			erros.add("\nVariável não declarada: " + ctx.b.getText() + ", linha: "
					+ ctx.start.getLine() + ".");			
		}
		
	}

	
	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterMul(GramaticaParser.MulContext ctx) {
		String tipoA = null;
		String tipoB = null;
		if (variaveisGlobais.get(ctx.a.getText()) != null) {
			tipoA = variaveisGlobais.get(ctx.a.getText()).getTipo();
		}
		if (variaveisGlobais.get(ctx.b.getText()) != null) {
			tipoB = variaveisGlobais.get(ctx.b.getText()).getTipo();
		}
		if (variaveisLocais.get(ctx.a.getText()) != null) {
			tipoA = variaveisLocais.get(ctx.a.getText()).getTipo();
		}
		if (variaveisLocais.get(ctx.b.getText()) != null) {
			tipoB = variaveisLocais.get(ctx.b.getText()).getTipo();
		}
/*		if ((tipoA == null) && (ctx.a.t.equals("id") == false) && (ctx.a.t.equals("chamadaFuncao") == false) && ((ctx.a.t.equals("int")) || (ctx.a.equals("real") || (ctx.a.t.equals("bool") || (ctx.a.t.equals("string")))))) {
			tipoA = ctx.a.t;
		}
		if ((tipoA == null) && (ctx.b.t.equals("id") == false) && (ctx.b.t.equals("chamadaFuncao") == false) && ((ctx.b.t.equals("int")) || (ctx.b.t.equals("real") || (ctx.b.t.equals("bool") || (ctx.b.t.equals("string")))))) {
			tipoB = ctx.b.t;
		}
*/
		if ((tipoA != tipoB) && (tipoA != null) && (tipoB != null) && (tipoA.equals("id") == false) && (tipoB.equals("chamadaFuncao") == false))  {
			erros.add("\nVariáveis com tipos diferentes: " + ctx.a.getText() + "," + ctx.b.getText() + ", linha: "
					+ ctx.start.getLine() + ".");
		}
		
		if(tipoA == null && ctx.a.t == "id" && variaveisParam.get(ctx.a.getText()) == null){
			erros.add("\nVariável não declarada: " + ctx.a.getText() + ", linha: "
					+ ctx.start.getLine() + ".");			
		}
		
		if(tipoB == null && ctx.b.t == "id" && variaveisParam.get(ctx.b.getText()) == null){
			erros.add("\nVariável não declarada: " + ctx.b.getText() + ", linha: "
					+ ctx.start.getLine() + ".");			
		}
		
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterDiv(GramaticaParser.DivContext ctx) {
		String tipoA = null;
		String tipoB = null;
		if (variaveisGlobais.get(ctx.a.getText()) != null) {
			tipoA = variaveisGlobais.get(ctx.a.getText()).getTipo();
		}
		if (variaveisGlobais.get(ctx.b.getText()) != null) {
			tipoB = variaveisGlobais.get(ctx.b.getText()).getTipo();
		}
		if (variaveisLocais.get(ctx.a.getText()) != null) {
			tipoA = variaveisLocais.get(ctx.a.getText()).getTipo();
		}
		if (variaveisLocais.get(ctx.b.getText()) != null) {
			tipoB = variaveisLocais.get(ctx.b.getText()).getTipo();
		}
/*		if ((tipoA == null) && (ctx.a.t.equals("id") == false) && (ctx.a.t.equals("chamadaFuncao") == false) && ((ctx.a.t.equals("int")) || (ctx.a.equals("real") || (ctx.a.t.equals("bool") || (ctx.a.t.equals("string")))))) {
			tipoA = ctx.a.t;
		}
		if ((tipoA == null) && (ctx.b.t.equals("id") == false) && (ctx.b.t.equals("chamadaFuncao") == false) && ((ctx.b.t.equals("int")) || (ctx.b.t.equals("real") || (ctx.b.t.equals("bool") || (ctx.b.t.equals("string")))))) {
			tipoB = ctx.b.t;
		}
*/
		if ((tipoA != tipoB) && (tipoA != null) && (tipoB != null) && (tipoA.equals("id") == false) && (tipoB.equals("chamadaFuncao") == false))  {
			erros.add("\nVariáveis com tipos diferentes: " + ctx.a.getText() + "," + ctx.b.getText() + ", linha: "
					+ ctx.start.getLine() + ".");
		}
		
		if(tipoA == null && ctx.a.t == "id" && variaveisParam.get(ctx.a.getText()) == null){
			erros.add("\nVariável não declarada: " + ctx.a.getText() + ", linha: "
					+ ctx.start.getLine() + ".");			
		}
		
		if(tipoB == null && ctx.b.t == "id" && variaveisParam.get(ctx.b.getText()) == null){
			erros.add("\nVariável não declarada: " + ctx.b.getText() + ", linha: "
					+ ctx.start.getLine() + ".");			
		}
		
	}

	
	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterNegLog(GramaticaParser.NegLogContext ctx) {
		String tipoB = null;
		if (variaveisGlobais.get(ctx.a.getText()) != null) {
			tipoB = variaveisGlobais.get(ctx.a.getText()).getTipo();
		}
		if (variaveisLocais.get(ctx.a.getText()) != null) {
			tipoB = variaveisLocais.get(ctx.a.getText()).getTipo();
		}
		if (tipoB == null) {
			tipoB = ctx.a.t;
		}
		if (tipoB != "bool"){
			erros.add("\nOperação invalida : " + ctx.a.getText() + ", linha: " + ctx.start.getLine() + ".");
		}
	}


	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterMenusUna(GramaticaParser.MenusUnaContext ctx) {
		String tipoB = null;
		if (variaveisGlobais.get(ctx.a.getText()) != null) {
			tipoB = variaveisGlobais.get(ctx.a.getText()).getTipo();
		}
		if (variaveisLocais.get(ctx.a.getText()) != null && variaveisGlobais.get(ctx.a.getText()) == null) {
			tipoB = variaveisLocais.get(ctx.a.getText()).getTipo();
		}
		if (tipoB == null) {
			tipoB = ctx.a.t;
		}
		if (tipoB.equals("bool") == true || tipoB.equals("string") == true) {
			erros.add("\nOperação invalida : " + ctx.a.getText() + ", linha: " + ctx.start.getLine() + ".");
		}
/*		if (variaveisGlobais.get(ctx.a.getText()) == null && variaveisLocais.get(ctx.a.getText()) == null && ctx.a.getText().contains("(") == false && ctx.a.getText().contains(")") == false) {
			erros.add("Operação com variável não declarada : " + ctx.a.getText() + ", linha: " + ctx.start.getLine() + ".");
		}*/
		
	}


	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterExpo(GramaticaParser.ExpoContext ctx) {
		String tipoA = null;
		String tipoB = null;
		if (variaveisGlobais.get(ctx.a.getText()) != null) {
			tipoA = variaveisGlobais.get(ctx.a.getText()).getTipo();
		}
		if (variaveisGlobais.get(ctx.b.getText()) != null) {
			tipoB = variaveisGlobais.get(ctx.b.getText()).getTipo();
		}
		if (variaveisLocais.get(ctx.a.getText()) != null) {
			tipoA = variaveisLocais.get(ctx.a.getText()).getTipo();
		}
		if (variaveisLocais.get(ctx.b.getText()) != null) {
			tipoB = variaveisLocais.get(ctx.b.getText()).getTipo();
		}
/*		if ((tipoA == null) && (ctx.a.t.equals("id") == false) && (ctx.a.t.equals("chamadaFuncao") == false) && ((ctx.a.t.equals("int")) || (ctx.a.equals("real")))) {
			tipoA = ctx.a.t;
		}
		if ((tipoA == null) && (ctx.b.t.equals("id") == false) && (ctx.b.t.equals("chamadaFuncao") == false) && ((ctx.b.t.equals("int")) || (ctx.b.t.equals("real")))) {
			tipoB = ctx.b.t;
		}*/
		if ((tipoA != tipoB) && (tipoA != null) && (tipoB != null) && (tipoA.equals("id") == false) && (tipoB.equals("chamadaFuncao") == false))  {
			erros.add("\nOperação invalida : " + ctx.b.getText() + ", linha: " + ctx.start.getLine() + ".");
		}
		
		if(tipoA == null && ctx.a.t == "id" && variaveisParam.get(ctx.a.getText()) == null){
			erros.add("\nVariável não declarada: " + ctx.a.getText() + ", linha: "
					+ ctx.start.getLine() + ".");			
		}
		
		if(tipoB == null && ctx.b.t == "id" && variaveisParam.get(ctx.b.getText()) == null){
			erros.add("\nVariável não declarada: " + ctx.b.getText() + ", linha: "
					+ ctx.start.getLine() + ".");			
		}
		
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override 
	public void enterRetorno(GramaticaParser.RetornoContext ctx) {
		
	}
	
	public Map<String, String> getFuncoes() {
		return funcoes;
	}

	public void setFuncoes(Map<String, String> funcoes) {
		this.funcoes = funcoes;
	}

	public List<String> getErros() {
		return erros;
	}

}
