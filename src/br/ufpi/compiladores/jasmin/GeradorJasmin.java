package br.ufpi.compiladores.jasmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.tree.TerminalNode;

import br.ufpi.compiladores.semantica.GramaticaBaseVisitor;
import br.ufpi.compiladores.semantica.GramaticaParser;
import br.ufpi.compiladores.semantica.GramaticaParser.BoolContext;
import br.ufpi.compiladores.semantica.GramaticaParser.ComandosContext;
import br.ufpi.compiladores.semantica.GramaticaParser.DeclaraVariaveisLocaisContext;
import br.ufpi.compiladores.semantica.GramaticaParser.ListaIDsContext;
import br.ufpi.compiladores.utils.Funcao;
import br.ufpi.compiladores.utils.Variavel;

public class GeradorJasmin extends GramaticaBaseVisitor<String> {
	private List<Variavel> variaveis = new ArrayList<Variavel>();
	private Map<String, Variavel> variaveisStaticas = new HashMap<>();
	private Map<String, Variavel> variaveisGlobais = new HashMap<>();
	private Map<String, Variavel> variaveisLocais = new HashMap<>();
	private HashMap<String, String> atribuicoes = new HashMap<>();
	private HashMap<String, Funcao> funcoes = new HashMap<>();
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
	public String visitProgram(GramaticaParser.ProgramContext ctx) {
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
	public String visitDeclaraVariaveisGlobais(GramaticaParser.DeclaraVariaveisGlobaisContext ctx) {

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
				variaveis.add(val);
				variaveisGlobais.put(terminalNode.getText(), val);

		}
		
		return codeTemp;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public String visitDeclaraVariaveisLocais(GramaticaParser.DeclaraVariaveisLocaisContext ctx) {
		String tipo = ctx.tipo().t;
		List<TerminalNode> ids = ctx.listaIDs().ID();
		Variavel val = new Variavel();
		String codeTemp = "";
		for (TerminalNode terminalNode : ids) {

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
     			variaveis.add(val);
				variaveisLocais.put(terminalNode.getText(), val);

		}
		return codeTemp; 
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public String visitDeclaraConstantes(GramaticaParser.DeclaraConstantesContext ctx) {
		String codeTemp = "";
		Variavel val = new Variavel();
		val.setTipo(ctx.t);
		val.setEnredeco(countLocals);
		countLocals++;
		val.setNome(ctx.ID().getText());
		val.setValor(ctx.factor().getText());
		codeTemp += "ldc " + ctx.factor().getText() + "\n" + 
                    "astore " + val.getEnredeco() + "\n";
		val.setScopo("statica");
		variaveis.add(val);
		variaveisStaticas.put(ctx.ID().getText(), val);
		return codeTemp; 
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
	public String visitComandos(GramaticaParser.ComandosContext ctx) {
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
	public String visitAtribuicao(GramaticaParser.AtribuicaoContext ctx) {
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
		String codeTemp = "";
		String expr = "";
		Variavel a = new Variavel();

		if(variaveisGlobais.get(ctx.atriID.getText()) != null){
			a = variaveisGlobais.get(ctx.atriID.getText());
		}
		if(variaveisLocais.get(ctx.atriID.getText()) != null){
			a = variaveisLocais.get(ctx.atriID.getText());
		}
		if(ctx.exprAtri.t == "int"){
			a.setValor(ctx.exprAtri.getText());
			codeTemp +="ldc " + ctx.exprAtri.getText() + "\n" +  
					   "fstore " + a.getEnredeco() + "\n";
		}
		if(ctx.exprAtri.t == "real"){
			a.setValor(ctx.exprAtri.getText());
			codeTemp +="ldc " + ctx.exprAtri.getText() + "\n" +  
					   "fstore " + a.getEnredeco() + "\n";		}
		if(ctx.exprAtri.t == "string"){
			a.setValor(ctx.exprAtri.getText());
			codeTemp +="ldc " + ctx.exprAtri.getText() + "\n" +  
					   "astore " + a.getEnredeco() + "\n";
		}
		if(ctx.exprAtri.t == "id"){
			if(ctx.exprAtri.getText().equals("TRUE")){
			a.setValor("1");
			codeTemp +="ldc 1"  + "\n" +  
					   "istore " + a.getEnredeco() + "\n";
			}
			if(ctx.exprAtri.getText().equals("FALSE")){
			a.setValor("0");
			codeTemp +="ldc 0"  + "\n" +  
					   "istore " + a.getEnredeco() + "\n";
			}
		}
        if(visit(ctx.exprAtri.bool()) != null){
        	codeTemp+=this.visit(ctx.exprAtri.bool()) + "\n";
        	if(a.getTipo() != null){
            if(a.getTipo().equals("int") || a.getTipo().equals("real")){
            	codeTemp += "fstore " + a.getEnredeco() + "\n";
            }
            if(a.getTipo().equals("bool")){
            	codeTemp += "istore " + a.getEnredeco() + "\n";
            }
        	}
        }
        if(a.getScopo() != null){
		if(a.getScopo().equals("global")){
			variaveisGlobais.remove(a.getNome());
			variaveisGlobais.put(a.getNome(), a);
		}
		if(a.getScopo().equals("local")){
			variaveisLocais.remove(a.getNome());
			variaveisLocais.put(a.getNome(), a);
		}
	}
		return codeTemp;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public String visitDeclaraFuncao(GramaticaParser.DeclaraFuncaoContext ctx) {
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
        	funcoes.put(ctx.ID().getText(), new Funcao(ctx.tipo().getText(),ctx.ID().getText(),listVar));
        }
		}
        count = 0;
		funcoesPrograma += ".method private static " +  ctx.ID();
		funcoesPrograma+="("; 
		
		for(Variavel vrr : listVar){
			if(vrr.getTipo() == "int"){
		       funcoesPrograma+="I";		
			}else if(vrr.getTipo() == "real"){
				funcoesPrograma+="F";
			}else if(vrr.getTipo() == "string"){
				funcoesPrograma+="Ljava/lang/String;";
			}else{
				funcoesPrograma+="Z";
			}
		}
		
		funcoesPrograma+=")";
		if(ctx.tipo().getText().equals("Int")){
		funcoesPrograma+="I";
		}else if(ctx.tipo().getText().equals("Real")){
		funcoesPrograma+="F";	
		}else if(ctx.tipo().getText().equals("String")){
		funcoesPrograma+="Ljava/lang/String;";
		}else{
		funcoesPrograma+="Z;";
		}
		funcoesPrograma+="\n" + 
	            ".limit stack 100" + "\n" + 
				".limit locals 100" + "\n";
		if(ctx.declaraParametros() != null){
        List<ListaIDsContext> s = ctx.declaraParametros().listaIDs();
        for(ListaIDsContext v : s){
        	for(TerminalNode x : v.ID()){
        		funcoesPrograma+="aload_" + count + "\n";
        		count++;
        	}
        }
        	
        }
        if(ctx.declaraVariaveisLocais() != null){
    		for (DeclaraVariaveisLocaisContext c : ctx.declaraVariaveisLocais()) {
    			funcoesPrograma+=this.visitDeclaraVariaveisLocais(c);

    		}
        }
        if(ctx.comandos() != null){
		for (ComandosContext c : ctx.comandos()) {
			funcoesPrograma+=this.visit(c) == null?"":this.visit(c);

		}
        }        
	     funcoesPrograma += ".end method"  + "\n" + "\n";
		return "";
 
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public String visitChamadaFuncao(GramaticaParser.ChamadaFuncaoContext ctx) { 
		String codeTemp = "";
		int count = 0;
		List<Variavel> param = new ArrayList<Variavel>();
		String arg = ctx.listaExpressoes().getText();
		String [] args = arg.split(",");
		for(String s : args){
			if(variaveisGlobais.get(s).getTipo().equals("int")){
				codeTemp += "iload " + variaveisGlobais.get(s).getEnredeco() + "\n";
			}
			if(variaveisGlobais.get(s).getTipo().equals("real")){
				codeTemp += "fload " + variaveisGlobais.get(s).getEnredeco() + "\n";
			}
			if(variaveisGlobais.get(s).getTipo().equals("bool")){
				codeTemp += "iload " + variaveisGlobais.get(s).getEnredeco() + "\n";
			}
			if(variaveisGlobais.get(s).getTipo().equals("string")){
				codeTemp += "aload " + variaveisGlobais.get(s).getEnredeco() + "\n";
			}

		}
		codeTemp += "invokestatic Main/"  + ctx.ID(); 
		codeTemp += "(";
		for(Variavel vr : funcoes.get(ctx.ID().getText()).getParametros()){
			if(vr.getTipo() == "int"){
				codeTemp +="I";
				}else if(vr.getTipo() == "real"){
				codeTemp +="F";	
				}else if(vr.getTipo() == "string"){
				codeTemp +="Ljava/lang/String;";
				}else{
				codeTemp+="Z";
				}
		}
		codeTemp +=")";
		if(funcoes.get(ctx.ID().getText()).getTipo().equals("Int")){
		codeTemp += "I" + "\n";
		}
		if(funcoes.get(ctx.ID().getText()).getTipo().equals("Real")){
		codeTemp += "F" + "\n";
		}
		if(funcoes.get(ctx.ID().getText()).getTipo().equals("String")){
		codeTemp += "Ljava/lang/String;" + "\n";
		}
		if(funcoes.get(ctx.ID().getText()).getTipo().equals("Bool")){
		codeTemp += "Z" + "\n";
		}

		Funcao f = funcoes.get(ctx.ID().getText());
		f.setParametros(param);
		funcoes.remove(ctx.ID().getText());
		funcoes.put(ctx.ID().getText(), f);
		return codeTemp; 
	}
	

		
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitImpressao(GramaticaParser.ImpressaoContext ctx) {
		String codeTemp = "";

		for(BoolContext imp : ctx.listaExpressoes().bool()){
			
		if(imp.t == "id"){
		if(variaveisStaticas.get(imp.getText()) != null){
		codeTemp += "getstatic java/lang/System/out Ljava/io/PrintStream;" + "\n" + 
		            "ldc " + variaveisStaticas.get(imp.getText()).getValor() + "\n"
				+   "invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V" + "\n";
		}
		if(variaveisGlobais.get(imp.getText()) != null){
		codeTemp += "getstatic java/lang/System/out Ljava/io/PrintStream;" + "\n" + 
		            "ldc " + variaveisGlobais.get(imp.getText()).getValor() + "\n"
				+   "invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V" + "\n";
		}
		if(variaveisLocais.get(imp.getText()) != null){
		codeTemp += "getstatic java/lang/System/out Ljava/io/PrintStream;" + "\n" + 
		            "ldc " + variaveisLocais.get(imp.getText()).getValor() + "\n"
				+   "invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V" + "\n";
		}
		}
		codeTemp+="\n";
		}
		return codeTemp;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public String visitRetorno(GramaticaParser.RetornoContext ctx) { 
		String codeTemp = "";
		if(this.visit(ctx.expressoes().bool()) != null){
        codeTemp += this.visit(ctx.expressoes().bool()) == null?"" + "freturn" + "\n":this.visit(ctx.expressoes()) + "freturn" + "\n";
		return codeTemp;
		}
		if(ctx.expressoes().bool().t == "id" && ctx.expressoes().bool().getChildCount() == 1){
			Variavel v = new Variavel();
			if(variaveisLocais.get(ctx.expressoes().bool().getText()) != null){
				v = variaveisLocais.get(ctx.expressoes().bool().getText());
				codeTemp +=  v.getValor() + "\n" + "ldc" + "\n";
		         return codeTemp;
			}
			if(variaveisStaticas.get(ctx.expressoes().bool().getText()) != null){
				v = variaveisStaticas.get(ctx.expressoes().bool().getText());
				codeTemp +=  v.getValor() + "\n" + "ldc" + "\n";
		         return codeTemp;
			}
			if(variaveisGlobais.get(ctx.expressoes().bool().getText()) != null){
				v = variaveisGlobais.get(ctx.expressoes().bool().getText());
				codeTemp +=  v.getValor() + "\n" + "ldc" + "\n";
		         return codeTemp;
			}

			codeTemp +=  atribuicoes.get(ctx.expressoes().bool().getText()) + "\n" + "ldc" + "\n";
	         return codeTemp;
		}
		if(ctx.expressoes().bool().t == "int" && ctx.expressoes().bool().getText().length() == 1){
			codeTemp +=  atribuicoes.get(ctx.expressoes().bool().getText()) + "\n" + "ldc" + "\n";
	         return codeTemp;
		}
		if(ctx.expressoes().bool().t == "real" && ctx.expressoes().bool().getText().length() == 1){
			codeTemp +=  atribuicoes.get(ctx.expressoes().bool().getText()) + "\n" + "ldc" + "\n";
	         return codeTemp;
		}
		if(ctx.expressoes().bool().t == "bool" && ctx.expressoes().bool().getChildCount() == 1){
			codeTemp +=  atribuicoes.get(ctx.expressoes().bool().getText()) + "\n" + "ldc" + "\n";
	         return codeTemp;
		}
         return codeTemp;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public String visitSair(GramaticaParser.SairContext ctx) {
		String codeTemp = "";
		return codeTemp += "return" + "\n"; 
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
	public String visitLeitura(GramaticaParser.LeituraContext ctx) {
		String codeTemp = "";
		Variavel v = new Variavel();
		for(TerminalNode ler : ctx.listaIDs().ID()){
			if(variaveisStaticas.get(ler.getText()) != null){
		       v = variaveisStaticas.get(ler.getText());
			}
			if(variaveisGlobais.get(ler.getText()) != null){
			       v = variaveisGlobais.get(ler.getText());
		    }
			if(variaveisLocais.get(ler.getText()) != null){
			       v = variaveisLocais.get(ler.getText());
			}
			if(v.getTipo().equals("int")){
			codeTemp+=	"new java/util/Scanner" + "\n" + 
				        "dup" + "\n" + 
				        "getstatic java/lang/System/in Ljava/io/InputStream;" + "\n" + 
				        "invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V" + "\n" + 
				        "astore_"+ countStack + "\n" + 
				        "aload_" + countStack + "\n" + 
				        "invokevirtual java/util/Scanner/nextFloat()F" + "\n" +
				        "fstore_"+ v.getEnredeco()	+ "\n";
			countStack++;
			}
			if(v.getTipo().equals("string")){
			codeTemp+=	"new java/util/Scanner" + "\n" + 
				        "dup" + "\n" + 
				        "getstatic java/lang/System/in Ljava/io/InputStream;" + "\n" + 
				        "invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V" + "\n" + 
				        "astore_"+ countStack + "\n" + 
				        "aload_" + countStack + "\n" + 
				        "invokevirtual java/util/Scanner/next()Ljava/lang/String;" + "\n" + 
				        "astore_" + v.getEnredeco()	+ "\n";
			countStack++;
			}
			if(v.getTipo().equals("real")){
			codeTemp+=	"new java/util/Scanner" + "\n" + 
				        "dup" + "\n" + 
				        "getstatic java/lang/System/in Ljava/io/InputStream;" + "\n" + 
				        "invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V" + "\n" + 
				        "astore_"+ countStack + "\n" + 
				        "aload_" + countStack + "\n" + 
				        "invokevirtual java/util/Scanner/nextFloat()F" + "\n" +
				        "fstore_"+ v.getEnredeco()	+ "\n";
			countStack++;
			}
			if(v.getTipo().equals("bool")){
			codeTemp+=	"new java/util/Scanner" + "\n" + 
				        "dup" + "\n" + 
				        "getstatic java/lang/System/in Ljava/io/InputStream;" + "\n" + 
				        "invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V" + "\n" + 
				        "astore_"+ countStack + "\n" + 
				        "aload_" + countStack + "\n" +				        
				        "invokevirtual java/util/Scanner/nextBoolean()Z" + "\n" + 
				        "istore_" + v.getEnredeco()	+ "\n";
			countStack++;
			}
		codeTemp += "\n";
		}
		return codeTemp;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public String visitSe(GramaticaParser.SeContext ctx) {
		String codeTemp = "";
		Variavel a = new Variavel();
		Variavel b = new Variavel();
		if(variaveisStaticas.get(ctx.ifExprB.start.getText()) != null && variaveisStaticas.get(ctx.ifExprB.stop.getText()) != null){
			a = variaveisStaticas.get(ctx.ifExprB.start.getText());
			b = variaveisStaticas.get(ctx.ifExprB.stop.getText());
		}
		if(variaveisGlobais.get(ctx.ifExprB.start.getText()) != null && variaveisGlobais.get(ctx.ifExprB.stop.getText()) != null){
			a = variaveisGlobais.get(ctx.ifExprB.start.getText());
			b = variaveisGlobais.get(ctx.ifExprB.stop.getText());
		}
		if(variaveisLocais.get(ctx.ifExprB.start.getText()) != null && variaveisLocais.get(ctx.ifExprB.stop.getText()) != null){
			a = variaveisLocais.get(ctx.ifExprB.start.getText());
			b = variaveisLocais.get(ctx.ifExprB.stop.getText());
		}
		if(ctx.ifExprB.getText().contains(">")){
			if(((a.getTipo() == "int") && (b.getTipo() == "int")) || ((a.getTipo() == "real") && (b.getTipo() == "real"))){
			if((Integer.parseInt(a.getValor())) > (Integer.parseInt(b.getValor()))){
				codeTemp += "iconst_1" + "\n" + 
			                "istore_" + countLocals + "\n" + 
			                "iload_" + countLocals + "\n" + 
			    		    "ifgt SE" + "\n";//Maior que zero.
				if(ctx.senao() != null){
				codeTemp += this.visit(ctx.senao());
				}
				codeTemp+="goto FIMSE" + "\n";
				codeTemp+="\n" + "SE:" + "\n";
				for (ComandosContext c : ctx.comandos()) {
					codeTemp+=this.visitComandos(c);
				}
				countLocals++;
				return codeTemp += "FIMSE:" + "\n";

			}else{
				codeTemp += "iconst_0" + "\n" + 
			                "istore_"+countLocals + "\n" +  
			                "iload_"+countLocals + "\n" + 
			    		    "ifgt SE" + "\n";
				if(ctx.senao() != null){
				codeTemp += this.visit(ctx.senao());
				}
				codeTemp+="goto FIMSE" + "\n";
				codeTemp+="\n" + "SE:" + "\n";
				for (ComandosContext c : ctx.comandos()) {
					codeTemp+=this.visitComandos(c);
				}
				countLocals++;
				return codeTemp += "FIMSE:" + "\n";
			}
			}else{
				if((a.getValor().length()) > (b.getValor().length())){
					codeTemp += "iconst_1" + "\n" + 
				                "istore_"+countLocals + "\n" +  
				                "iload_"+ countLocals + "\n" + 
				    		    "ifgt SE" + "\n";
					if(ctx.senao() != null){
						codeTemp += this.visit(ctx.senao());
						}
					codeTemp+="goto FIMSE" + "\n";
					codeTemp+="\n" + "SE:" + "\n";
					for (ComandosContext c : ctx.comandos()) {
						codeTemp+=this.visitComandos(c);
					}
					countLocals++;
					return codeTemp += "FIMSE:" + "\n";
				}else{
					codeTemp += "iconst_0" + "\n" + 
				                "istore_"+ countLocals + "\n" +  
				                "iload_"+ countLocals + "\n" + 
				    		    "ifgt SE" + "\n";
					if(ctx.senao() != null){
						codeTemp += this.visit(ctx.senao());
						}
					codeTemp+="goto FIMSE" + "\n";
					codeTemp+="\n" + "SE:" + "\n";
					for (ComandosContext c : ctx.comandos()) {
						codeTemp+=this.visitComandos(c);
					}
					countLocals++;
					return codeTemp += "FIMSE:" + "\n";
				}			
			}

	}
		
		    if(ctx.ifExprB.getText().contains(">=")){
					if(((a.getTipo() == "int") && (b.getTipo() == "int")) || ((a.getTipo() == "real") && (b.getTipo() == "real"))){
					if((Integer.parseInt(a.getValor())) >= (Integer.parseInt(b.getValor()))){							
						    codeTemp += "iconst_1" + "\n" + 
						                "istore_"+ countLocals + "\n" +  
						                "iload_"+ countLocals + "\n" + 
						    		    "ifgt SE" + "\n";
							if(ctx.senao() != null){
								codeTemp += this.visit(ctx.senao());
								}
							codeTemp+="goto FIMSE" + "\n";
							codeTemp+="\n" + "SE:" + "\n";
							for (ComandosContext c : ctx.comandos()) {
								codeTemp+=this.visitComandos(c);
							}
							countLocals++;
							return codeTemp += "FIMSE:" + "\n";
						}else{
							codeTemp += "iconst_0" + "\n" + 
						                "istore_"+countLocals + "\n" +  
						                "iload_"+ countLocals + "\n" + 
						    		    "ifgt SE" + "\n";
							if(ctx.senao() != null){
								codeTemp += this.visit(ctx.senao());
								}
							codeTemp+="goto FIMSE" + "\n";
							codeTemp+="\n" + "SE:" + "\n";
							for (ComandosContext c : ctx.comandos()) {
								codeTemp+=this.visitComandos(c);
							}
							countLocals++;
							return codeTemp += "FIMSE:" + "\n";
						}
						}else{
							if((a.getValor().length()) >= (b.getValor().length())){
								codeTemp += "iconst_1" + "\n" + 
							                "istore_"+countLocals + "\n" + 
							                "iload_"+ countLocals + "\n" + 
							    		    "ifgt SE" + "\n";
								if(ctx.senao() != null){
									codeTemp += this.visit(ctx.senao());
									}
								codeTemp+="goto FIMSE" + "\n";
								codeTemp+="\n" + "SE:" + "\n";
								for (ComandosContext c : ctx.comandos()) {
									codeTemp+=this.visitComandos(c);
								}
								countLocals++;
								return codeTemp += "FIMSE:" + "\n";
							}else{
								codeTemp += "iconst_0" + "\n" + 
							                "istore_"+ countLocals + "\n" +  
							                "iload_" + countLocals + "\n" + 
							    		    "ifgt SE" + "\n";
								if(ctx.senao() != null){
									codeTemp += this.visit(ctx.senao());
									}
								codeTemp+="goto FIMSE" + "\n";
								codeTemp+="\n" + "SE:" + "\n";
								for (ComandosContext c : ctx.comandos()) {
									codeTemp+=this.visitComandos(c);
								}
								countLocals++;
								return codeTemp += "FIMSE:" + "\n";
							}			
						}
			}
				
		if(ctx.ifExprB.getText().contains("<")){
			if(((a.getTipo() == "int") && (b.getTipo() == "int")) || ((a.getTipo() == "real") && (b.getTipo() == "real"))){
			if((Integer.parseInt(a.getValor())) < (Integer.parseInt(b.getValor()))){							
				            codeTemp += "iconst_1" + "\n" + 
						                "istore_"+ countLocals + "\n" +  
						                "iload_" + countLocals + "\n" + 
						    		    "ifgt SE" + "\n";
							if(ctx.senao() != null){
								codeTemp += this.visit(ctx.senao());
								}
							codeTemp+="goto FIMSE" + "\n";
							codeTemp+="\n" + "SE:" + "\n";
							for (ComandosContext c : ctx.comandos()) {
								codeTemp+=this.visitComandos(c);
							}
							countLocals++;
							return codeTemp += "FIMSE:" + "\n";
						}else{
							codeTemp += "iconst_0" + "\n" + 
						                "istore_" + countLocals + "\n" +  
						                "iload_" + countLocals + "\n" + 
						    		    "ifgt SE" + "\n";
							if(ctx.senao() != null){
								codeTemp += this.visit(ctx.senao());
								}
							codeTemp+="goto FIMSE" + "\n";
							codeTemp+="\n" + "SE:" + "\n";
							for (ComandosContext c : ctx.comandos()) {
								codeTemp+=this.visitComandos(c);
							}
							countLocals++;
							return codeTemp += "FIMSE:" + "\n";
						}
						}else{
							if((a.getValor().length()) < (b.getValor().length())){
								codeTemp += "iconst_1" + "\n" + 
							                "istore_" + countLocals + "\n" + 
							                "iload_" + countLocals + "\n" + 
							    		    "ifgt SE" + "\n";
								if(ctx.senao() != null){
									codeTemp += this.visit(ctx.senao());
									}
								codeTemp+="goto FIMSE" + "\n";
								codeTemp+="\n" + "SE:" + "\n";
								for (ComandosContext c : ctx.comandos()) {
									codeTemp+=this.visitComandos(c);
								}
								countLocals++;
								return codeTemp += "FIMSE:" + "\n";
							}else{
								codeTemp += "iconst_0" + "\n" + 
							                "istore_" + countLocals + "\n" +  
							                "iload_" + countLocals + "\n" + 
							    		    "ifgt SE" + "\n";
								if(ctx.senao() != null){
									codeTemp += this.visit(ctx.senao());
									}
								codeTemp+="goto FIMSE" + "\n";
								codeTemp+="\n" + "SE:" + "\n";
								for (ComandosContext c : ctx.comandos()) {
									codeTemp+=this.visitComandos(c);
								}
								countLocals++;
								return codeTemp += "FIMSE:" + "\n";
							}			
						}
			}
				
	        if(ctx.ifExprB.getText().contains("<=")){
			if(((a.getTipo() == "int") && (b.getTipo() == "int")) || ((a.getTipo() == "real") && (b.getTipo() == "real"))){
			if((Integer.parseInt(a.getValor())) <= (Integer.parseInt(b.getValor()))){							
				            codeTemp += "iconst_1" + "\n" + 
						                "istore_" + countLocals + "\n" +  
						                "iload_" + countLocals + "\n" + 
						    		    "ifgt SE" + "\n";
							if(ctx.senao() != null){
								codeTemp += this.visit(ctx.senao());
								}
							codeTemp+="goto FIMSE" + "\n";
							codeTemp+="\n" + "SE:" + "\n";
							for (ComandosContext c : ctx.comandos()) {
								codeTemp+=this.visitComandos(c);
							}
							countLocals++;
							return codeTemp += "FIMSE:" + "\n";
						}else{
							codeTemp += "iconst_0" + "\n" + 
						                "istore_" + countLocals + "\n" +  
						                "iload_" + countLocals + "\n" + 
						    		    "ifgt SE" + "\n";
							if(ctx.senao() != null){
								codeTemp += this.visit(ctx.senao());
								}
							codeTemp+="goto FIMSE" + "\n";
							codeTemp+="\n" + "SE:" + "\n";
							for (ComandosContext c : ctx.comandos()) {
								codeTemp+=this.visitComandos(c);
							}
							countLocals++;
							return codeTemp += "FIMSE:" + "\n";
							
						}
						}else{
							if((a.getValor().length()) <= (b.getValor().length())){
								codeTemp += "iconst_1" + "\n" + 
							                "istore_" + countLocals + "\n" +  
							                "iload_" + countLocals + "\n" + 
							    		    "ifgt SE" + "\n";
								if(ctx.senao() != null){
									codeTemp += this.visit(ctx.senao());
									}
								codeTemp+="goto FIMSE" + "\n";
								codeTemp+="\n" + "SE:" + "\n";
								for (ComandosContext c : ctx.comandos()) {
									codeTemp+=this.visitComandos(c);
								}
								countLocals++;
								return codeTemp += "FIMSE:" + "\n";
							}else{
								codeTemp += "iconst_0" + "\n" + 
							                "istore_" + countLocals + "\n" +  
							                "iload_" + countLocals + "\n" + 
							    		    "ifgt SE" + "\n";
								if(ctx.senao() != null){
									codeTemp += this.visit(ctx.senao());
									}
								codeTemp+="goto FIMSE" + "\n";
								codeTemp+="\n" + "SE:" + "\n";
								for (ComandosContext c : ctx.comandos()) {
									codeTemp+=this.visitComandos(c);
								}
								countLocals++;
								return codeTemp += "FIMSE:" + "\n";
							}			
						}
			}
		
		if(ctx.ifExprB.getText().contains("==")){
			if(((a.getTipo() == "int") && (b.getTipo() == "int")) || ((a.getTipo() == "real") && (b.getTipo() == "real"))){
			if((Integer.parseInt(a.getValor())) == (Integer.parseInt(b.getValor()))){
				            codeTemp += "iconst_1" + "\n" + 
						                "istore_" + countLocals + "\n" + 
						                "iload_" + countLocals + "\n" + 
						    		    "ifgt SE" + "\n";
							if(ctx.senao() != null){
								codeTemp += this.visit(ctx.senao());
								}
							codeTemp+="goto FIMSE" + "\n";
							codeTemp+="\n" + "SE:" + "\n";
							for (ComandosContext c : ctx.comandos()) {
								codeTemp+=this.visitComandos(c);
							}
							countLocals++;
							return codeTemp += "FIMSE:" + "\n";
						}else{
							codeTemp += "iconst_0" + "\n" + 
						                "istore_" + countLocals + "\n" +  
						                "iload_" + countLocals + "\n" + 
						    		    "ifgt SE" + "\n";
							if(ctx.senao() != null){
								codeTemp += this.visit(ctx.senao());
								}
							codeTemp+="goto FIMSE" + "\n";
							codeTemp+="\n" + "SE:" + "\n";
							for (ComandosContext c : ctx.comandos()) {
								codeTemp+=this.visitComandos(c);
							}
							countLocals++;
							return codeTemp += "FIMSE:" + "\n";
						}
						}else{
							if((a.getValor().length()) == (b.getValor().length())){
								codeTemp += "iconst_1" + "\n" + 
							                "istore_" + countLocals + "\n" + 
							                "iload_" + countLocals + "\n" + 
							    		    "ifgt SE" + "\n";
								if(ctx.senao() != null){
									codeTemp += this.visit(ctx.senao());
									}
								codeTemp+="goto FIMSE" + "\n";
								codeTemp+="\n" + "SE:" + "\n";
								for (ComandosContext c : ctx.comandos()) {
									codeTemp+=this.visitComandos(c);
								}
								countLocals++;
								return codeTemp += "FIMSE:" + "\n";
							}else{
								codeTemp += "iconst_0" + "\n" + 
							                "istore_" + countLocals + "\n" +  
							                "iload_" + countLocals + "\n" + 
							    		    "ifgt SE" + "\n";
								if(ctx.senao() != null){
									codeTemp += this.visit(ctx.senao());
									}
								codeTemp+="goto FIMSE" + "\n";
								codeTemp+="\n" + "SE:" + "\n";
								for (ComandosContext c : ctx.comandos()) {
									codeTemp+=this.visitComandos(c);
								}
								countLocals++;
								return codeTemp += "FIMSE:" + "\n";
							}			
						}
			}
		
		if(ctx.ifExprB.getText().contains("!=")){
			if(((a.getTipo() == "int") && (b.getTipo() == "int")) || ((a.getTipo() == "real") && (b.getTipo() == "real"))){
			if((Integer.parseInt(a.getValor())) != (Integer.parseInt(b.getValor()))){							
				            codeTemp += "iconst_1" + "\n" + 
						                "istore_" + countLocals + "\n" +  
						                "iload_" + countLocals + "\n" + 
						    		    "ifgt SE" + "\n";
							if(ctx.senao() != null){
								codeTemp += this.visit(ctx.senao());
								}
							codeTemp+="goto FIMSE" + "\n";
							codeTemp+="\n" + "SE:" + "\n";
							for (ComandosContext c : ctx.comandos()) {
								codeTemp+=this.visitComandos(c);
							}
							countLocals++;
							return codeTemp += "FIMSE:" + "\n";
						}else{
							codeTemp += "iconst_0" + "\n" + 
						                "istore_" + countLocals + "\n" +  
						                "iload_" + countLocals + "\n" + 
						    		    "ifgt SE" + "\n";
							if(ctx.senao() != null){
								codeTemp += this.visit(ctx.senao());
								}
							codeTemp+="goto FIMSE" + "\n";
							codeTemp+="\n" + "SE:" + "\n";
							for (ComandosContext c : ctx.comandos()) {
								codeTemp+=this.visitComandos(c);
							}
							countLocals++;
							return codeTemp += "FIMSE:" + "\n";
						}
						}else{
							if((a.getValor().length()) != (b.getValor().length())){
								codeTemp += "iconst_1" + "\n" + 
							                "istore_" + countLocals + "\n" + 
							                "iload_" + countLocals + "\n" + 
							    		    "ifgt SE" + "\n";
								if(ctx.senao() != null){
									codeTemp += this.visit(ctx.senao());
									}
								codeTemp+="goto FIMSE" + "\n";
								codeTemp+="\n" + "SE:" + "\n";
								for (ComandosContext c : ctx.comandos()) {
									codeTemp+=this.visitComandos(c);
								}
								countLocals++;
								return codeTemp += "FIMSE:" + "\n";
							}else{
								codeTemp += "iconst_0" + "\n" + 
							                "istore_" + countLocals + "\n" + 
							                "iload_" + countLocals + "\n" + 
							    		    "ifgt SE" + "\n";
								if(ctx.senao() != null){
									codeTemp += this.visit(ctx.senao());
									}
								codeTemp+="goto FIMSE" + "\n";
								codeTemp+="\n" + "SE:" + "\n";
								for (ComandosContext c : ctx.comandos()) {
									codeTemp+=this.visitComandos(c);
								}
								countLocals++;
								return codeTemp += "FIMSE:" + "\n";
							}			
						}
			}
		
		
		if(ctx.ifExprB.getText().equals("TRUE")){
							codeTemp += "iconst_1" + "\n" + 
						                "istore_"+ countLocals + "\n" +  
						                "iload_" + countLocals + "\n" + 
						    		    "ifgt SE" + "\n";
							if(ctx.senao() != null){
								codeTemp += this.visit(ctx.senao());
								}
								codeTemp+="\n" + "SE:" + "\n";
								for (ComandosContext c : ctx.comandos()) {
									codeTemp+=this.visitComandos(c);
								}
								countLocals++;
								return codeTemp +="\n";
						
		}
						
		return codeTemp;
 
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitSenao(GramaticaParser.SenaoContext ctx) { 
		String codeTemp = "";
		for (ComandosContext c : ctx.comandos()) {
			codeTemp+=this.visitComandos(c);
		}
		;
		return codeTemp; 
    }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
    public String visitEnquanto(GramaticaParser.EnquantoContext ctx) {
		String codeTemp = "";
		Variavel a = new Variavel();
		Variavel b = new Variavel();
		if(variaveisStaticas.get(ctx.whileExprB.start.getText()) != null && variaveisStaticas.get(ctx.whileExprB.stop.getText()) != null){
			a = variaveisStaticas.get(ctx.whileExprB.start.getText());
			b = variaveisStaticas.get(ctx.whileExprB.stop.getText());
		}
		if(variaveisGlobais.get(ctx.whileExprB.start.getText()) != null && variaveisGlobais.get(ctx.whileExprB.stop.getText()) != null){
			a = variaveisGlobais.get(ctx.whileExprB.start.getText());
			b = variaveisGlobais.get(ctx.whileExprB.stop.getText());
		}
		if(variaveisLocais.get(ctx.whileExprB.start.getText()) != null && variaveisLocais.get(ctx.whileExprB.stop.getText()) != null){
			a = variaveisLocais.get(ctx.whileExprB.start.getText());
			b = variaveisLocais.get(ctx.whileExprB.stop.getText());
		}
		
		if(ctx.whileExprB.getText().contains(">")){
					if(((a.getTipo() == "int") && (b.getTipo() == "int")) ||  ((a.getTipo() == "real") && (b.getTipo() == "real"))){
					if((Integer.parseInt(a.getValor())) > (Integer.parseInt(b.getValor()))){
				codeTemp += "iconst_" + a.getValor() + "\n" + 
				            "istore_"+ countLocals + "\n" +  
				            "bipush " + b.getValor() + "\n" + 
						    "istore_"+ (countLocals+1) + "\n" + 
				            "WHILE:" + "\n" + 
				            "iload_" + (countLocals+1) + "\n" + 
						    "iload_" + countLocals + "\n" + 
				            "if_icmplt FIM" + "\n";
		        for (ComandosContext c : ctx.comandos()) {
		             codeTemp += this.visitComandos(c);
	            }
	     return codeTemp += "\n" +  "iload_" + (countLocals + 1) + "\n" + 
			                "iconst_1" + "\n" + 
	                        "iadd" + "\n" + 
			                "istore_" + (countLocals+1) + "\n" + 
	                        "goto WHILE" + "\n" + 
			                "FIM:" + "\n";
			}
			}else{
				if((a.getValor().length()) > (b.getValor().length())){
					codeTemp += "iconst_" + a.getValor().length() + "\n" + 
				            "istore_"+ countLocals + "\n" +  
				            "bipush " + b.getValor().length() + "\n" + 
						    "istore_"+ (countLocals+1) + "\n" + 
				            "WHILE:" + "\n" + 
				            "iload_" + (countLocals+1) + "\n" + 
						    "iload_" + countLocals + "\n" + 
				            "if_icmplt FIM" + "\n";
		        for (ComandosContext c : ctx.comandos()) {
		             codeTemp += this.visitComandos(c);
	            }
	     return codeTemp += "\n" +  "iload_" + (countLocals + 1) + "\n" + 
			                "iconst_1" + "\n" + 
	                        "iadd" + "\n" + 
			                "istore_" + (countLocals+1) + "\n" + 
	                        "goto WHILE" + "\n" + 
			                "FIM:" + "\n";
				}		
			}
			
		}
	
		if(ctx.whileExprB.getText().contains(">=")){
					if(((a.getTipo() == "int") && (b.getTipo() == "int")) || ((a.getTipo() == "real") && (b.getTipo() == "real"))){
					if((Integer.parseInt(a.getValor())) >= (Integer.parseInt(b.getValor()))){
						codeTemp += "iconst_" + a.getValor() + "\n" + 
					            "istore_"+ countLocals + "\n" +  
					            "bipush " + b.getValor() + "\n" + 
							    "istore_"+ (countLocals+1) + "\n" + 
					            "WHILE:" + "\n" + 
					            "iload_" + (countLocals+1) + "\n" + 
							    "iload_" + countLocals + "\n" + 
					            "if_icmple FIM" + "\n";
			        for (ComandosContext c : ctx.comandos()) {
			             codeTemp += this.visitComandos(c);
		            }
		     return codeTemp += "\n" +  "iload_" + (countLocals + 1) + "\n" + 
				                "iconst_1" + "\n" + 
		                        "iadd" + "\n" + 
				                "istore_" + (countLocals+1) + "\n" + 
		                        "goto WHILE" + "\n" + 
				                "FIM:" + "\n";
					}
						}else{
							if((a.getValor().length()) >= (b.getValor().length())){
								codeTemp += "iconst_" + a.getValor().length() + "\n" + 
							            "istore_"+ countLocals + "\n" +  
							            "bipush " + b.getValor().length() + "\n" + 
									    "istore_"+ (countLocals+1) + "\n" + 
							            "WHILE:" + "\n" + 
							            "iload_" + (countLocals+1) + "\n" + 
									    "iload_" + countLocals + "\n" + 
							            "if_icmple FIM" + "\n";
					        for (ComandosContext c : ctx.comandos()) {
					             codeTemp += this.visitComandos(c);
				            }
				     return codeTemp += "\n" +  "iload_" + (countLocals + 1) + "\n" + 
						                "iconst_1" + "\n" + 
				                        "iadd" + "\n" + 
						                "istore_" + (countLocals+1) + "\n" + 
				                        "goto WHILE" + "\n" + 
						                "FIM:" + "\n";
							}		
						}
			}
				
		
			if(ctx.whileExprB.getText().contains("<")){
					if(((a.getTipo() == "int") && (b.getTipo() == "int")) || ((a.getTipo() == "real") && (b.getTipo() == "real"))){
					if((Integer.parseInt(a.getValor())) < (Integer.parseInt(b.getValor()))){
						codeTemp += "iconst_" + b.getValor() + "\n" + 
					            "istore_"+ countLocals + "\n" +  
					            "bipush " + a.getValor() + "\n" + 
							    "istore_"+ (countLocals+1) + "\n" + 
					            "WHILE:" + "\n" + 
					            "iload_" + (countLocals+1) + "\n" + 
							    "iload_" + countLocals + "\n" + 
					            "if_icmplt FIM" + "\n";
			        for (ComandosContext c : ctx.comandos()) {
			             codeTemp += this.visitComandos(c);
		            }
		     return codeTemp += "\n" +  "iload_" + (countLocals + 1) + "\n" + 
				                "iconst_1" + "\n" + 
		                        "iadd" + "\n" + 
				                "istore_" + (countLocals+1) + "\n" + 
		                        "goto WHILE" + "\n" + 
				                "FIM:" + "\n";
						}
						}else{
							if((a.getValor().length()) < (b.getValor().length())){
								codeTemp += "iconst_" + b.getValor().length() + "\n" + 
							            "istore_"+ countLocals + "\n" +  
							            "bipush " + a.getValor().length() + "\n" + 
									    "istore_"+ (countLocals+1) + "\n" + 
							            "WHILE:" + "\n" + 
							            "iload_" + (countLocals+1) + "\n" + 
									    "iload_" + countLocals + "\n" + 
							            "if_icmplt FIM" + "\n";
					        for (ComandosContext c : ctx.comandos()) {
					             codeTemp += this.visitComandos(c);
				            }
				     return codeTemp += "\n" +  "iload_" + (countLocals + 1) + "\n" + 
						                "iconst_1" + "\n" + 
				                        "iadd" + "\n" + 
						                "istore_" + (countLocals+1) + "\n" + 
				                        "goto WHILE" + "\n" + 
						                "FIM:" + "\n";
							}		
						}
			}
				
		
			if(ctx.whileExprB.getText().contains("<=")){
					if(((a.getTipo() == "int") && (b.getTipo() == "int")) || ((a.getTipo() == "real") && (b.getTipo() == "real"))){
					if((Integer.parseInt(a.getValor())) <= (Integer.parseInt(b.getValor()))){
						codeTemp += "iconst_" + b.getValor() + "\n" + 
					            "istore_"+ countLocals + "\n" +  
					            "bipush " + a.getValor() + "\n" + 
							    "istore_"+ (countLocals+1) + "\n" + 
					            "WHILE:" + "\n" + 
					            "iload_" + (countLocals+1) + "\n" + 
							    "iload_" + countLocals + "\n" + 
					            "if_icmple FIM" + "\n";
			        for (ComandosContext c : ctx.comandos()) {
			             codeTemp += this.visitComandos(c);
		            }
		     return codeTemp += "\n" +  "iload_" + (countLocals + 1) + "\n" + 
				                "iconst_1" + "\n" + 
		                        "iadd" + "\n" + 
				                "istore_" + (countLocals+1) + "\n" + 
		                        "goto WHILE" + "\n" + 
				                "FIM:" + "\n";

						}
						}else{
							if((a.getValor().length()) <= (b.getValor().length())){
								codeTemp += "iconst_" + b.getValor().length() + "\n" + 
							            "istore_"+ countLocals + "\n" +  
							            "bipush " + a.getValor().length() + "\n" + 
									    "istore_"+ (countLocals+1) + "\n" + 
							            "WHILE:" + "\n" + 
							            "iload_" + (countLocals+1) + "\n" + 
									    "iload_" + countLocals + "\n" + 
							            "if_icmple FIM" + "\n";
					        for (ComandosContext c : ctx.comandos()) {
					             codeTemp += this.visitComandos(c);
				            }
				     return codeTemp += "\n" +  "iload_" + (countLocals + 1) + "\n" + 
						                "iconst_1" + "\n" + 
				                        "iadd" + "\n" + 
						                "istore_" + (countLocals+1) + "\n" + 
				                        "goto WHILE" + "\n" + 
						                "FIM:" + "\n";
							}		
						}
			}
		
		
				if(ctx.whileExprB.getText().contains("==")){
							if(((a.getTipo() == "int") && (b.getTipo() == "int")) || ((a.getTipo() == "real") && (b.getTipo() == "real"))){
							if((Integer.parseInt(a.getValor())) == (Integer.parseInt(b.getValor()))){
								codeTemp += "iconst_" + a.getValor() + "\n" + 
							            "istore_"+ countLocals + "\n" +  
							            "bipush " + b.getValor() + "\n" + 
									    "istore_"+ (countLocals+1) + "\n" + 
							            "WHILE:" + "\n" + 
							            "iload_" + (countLocals+1) + "\n" + 
									    "iload_" + countLocals + "\n" + 
							            "if_icmpnq FIM" + "\n";
					        for (ComandosContext c : ctx.comandos()) {
					             codeTemp += this.visitComandos(c);
				            }
				     return codeTemp += "\n" +  "iload_" + (countLocals + 1) + "\n" + 
						                "iconst_1" + "\n" + 
				                        "iadd" + "\n" + 
						                "istore_" + (countLocals+1) + "\n" + 
				                        "goto WHILE" + "\n" + 
						                "FIM:" + "\n";
						}
						}else{
							if((a.getValor().length()) == (b.getValor().length())){
								codeTemp += "iconst_" + a.getValor().length() + "\n" + 
							            "istore_"+ countLocals + "\n" +  
							            "bipush " + b.getValor().length() + "\n" + 
									    "istore_"+ (countLocals+1) + "\n" + 
							            "WHILE:" + "\n" + 
							            "iload_" + (countLocals+1) + "\n" + 
									    "iload_" + countLocals + "\n" + 
							            "if_icmpnq FIM" + "\n";
					        for (ComandosContext c : ctx.comandos()) {
					             codeTemp += this.visitComandos(c);
				            }
				     return codeTemp += "\n" +  "iload_" + (countLocals + 1) + "\n" + 
						                "iconst_1" + "\n" + 
				                        "iadd" + "\n" + 
						                "istore_" + (countLocals+1) + "\n" + 
				                        "goto WHILE" + "\n" + 
						                "FIM:" + "\n";
							}			
						}
			}
		
				if(ctx.whileExprB.getText().contains("!=")){
							if(((a.getTipo() == "int") && (b.getTipo() == "int")) || ((a.getTipo() == "real") && (b.getTipo() == "real"))){
							if((Integer.parseInt(a.getValor())) != (Integer.parseInt(b.getValor()))){
								codeTemp += "iconst_" + a.getValor() + "\n" + 
							            "istore_"+ countLocals + "\n" +  
							            "bipush " + b.getValor() + "\n" + 
									    "istore_"+ (countLocals+1) + "\n" + 
							            "WHILE:" + "\n" + 
							            "iload_" + (countLocals+1) + "\n" + 
									    "iload_" + countLocals + "\n" + 
							            "if_icmpeq FIM" + "\n";
					        for (ComandosContext c : ctx.comandos()) {
					             codeTemp += this.visitComandos(c);
				            }
				     return codeTemp += "\n" +  "iload_" + (countLocals + 1) + "\n" + 
						                "iconst_1" + "\n" + 
				                        "iadd" + "\n" + 
						                "istore_" + (countLocals+1) + "\n" + 
				                        "goto WHILE" + "\n" + 
						                "FIM:" + "\n";						
				     }
						}else{
							if((a.getValor().length()) != (b.getValor().length())){
								codeTemp += "iconst_" + a.getValor().length() + "\n" + 
							            "istore_"+ countLocals + "\n" +  
							            "bipush " + b.getValor().length() + "\n" + 
									    "istore_"+ (countLocals+1) + "\n" + 
							            "WHILE:" + "\n" + 
							            "iload_" + (countLocals+1) + "\n" + 
									    "iload_" + countLocals + "\n" + 
							            "if_icmpeq FIM" + "\n";
					        for (ComandosContext c : ctx.comandos()) {
					             codeTemp += this.visitComandos(c);
				            }
				     return codeTemp += "\n" +  "iload_" + (countLocals + 1) + "\n" + 
						                "iconst_1" + "\n" + 
				                        "iadd" + "\n" + 
						                "istore_" + (countLocals+1) + "\n" + 
				                        "goto WHILE" + "\n" + 
						                "FIM:" + "\n";
							}		
						}
			}
	
		return codeTemp;
 
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public String visitPara(GramaticaParser.ParaContext ctx) { 
		String codeTemp = "";
		
		Variavel a = new Variavel();
		Variavel b = new Variavel();
	    Variavel c = new Variavel();
	    c.setValor("1");

		if(variaveisGlobais.get(ctx.initVarID.getText()) != null && variaveisGlobais.get(ctx.endVar.stop.getText()) != null){
			a = variaveisGlobais.get(ctx.initVarID.getText());
			a.setValor(ctx.intVar.getText());
			b = variaveisGlobais.get(ctx.endVar.stop.getText());
		    c = variaveisGlobais.get(ctx.stepVar.getText()) != null ? variaveisGlobais.get(ctx.stepVar.getText()) : c;
		}
		if(variaveisLocais.get(ctx.initVarID.getText()) != null && variaveisLocais.get(ctx.endVar.stop.getText()) != null){
			a = variaveisLocais.get(ctx.initVarID.getText());
			a.setValor(ctx.intVar.getText());
			b = variaveisLocais.get(ctx.endVar.stop.getText());
		    c = variaveisLocais.get(ctx.stepVar.getText()) != null ? variaveisLocais.get(ctx.stepVar.getText()) : c;
		}		
		if(c.getValor().contains("-") == false){
		codeTemp += "iconst_" + a.getValor() + "\n" + 
		            "istore_" + countLocals + "\n" + 
		            "bipush " + b.getValor() + "\n"+ 
				    "istore_" + (countLocals+1) + "\n" + 
				    "iconst_" + c.getValor() + "\n" + 
		            "istore_" + (countLocals+2) + "\n" +  
		            "iload_"+ countLocals + "\n" + 
				    "istore " + (countLocals+3) + "\n" + 
		            "FOR:" + "\n" + 
				    "iload "+ (countLocals+3) + "\n"+ 
		            "iload_"+ (countLocals+1) + "\n" + 
				    "if_icmpge FIM" + "\n"; 
				for (ComandosContext cmd : ctx.comandos()) {
					codeTemp+=this.visitComandos(cmd) + "\n";
				} 
		 codeTemp += "iinc " + (countLocals + 2) +" 1" + "\n" + 
				     "goto FOR" + "\n"+ 
		             "FIM:" + "\n";
		}else{
			codeTemp += "iconst_" + b.getValor() + "\n" + 
		            "istore_" + countLocals + "\n" + 
		            "bipush " + a.getValor() + "\n"+ 
				    "istore_" + (countLocals+1) + "\n" + 
				    "iconst_" + c.getValor() + "\n" + 
		            "istore_" + (countLocals+2) + "\n" +  
		            "iload_"+ countLocals + "\n" + 
				    "istore " + (countLocals+3) + "\n" + 
		            "FOR:" + "\n" + 
				    "iload "+ (countLocals+3) + "\n"+ 
		            "iload_"+ (countLocals+1) + "\n" + 
				    "if_icmple FIM" + "\n"; 
				for (ComandosContext cmd : ctx.comandos()) {
					codeTemp+=this.visitComandos(cmd) + "\n";
				} 
				 codeTemp += "iinc " + (countLocals + 1) +" -1" + "\n" + 
					     "goto FOR" + "\n"+ 
			             "FIM:" + "\n";			
		}
		return codeTemp;

 
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
	public String visitExpressoes(GramaticaParser.ExpressoesContext ctx) {
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
	public String visitExprParem(GramaticaParser.ExprParemContext ctx) {
		return this.visit(ctx.bool());
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public String visitMais(GramaticaParser.MaisContext ctx) {

		String valorA = (ctx.a.getChildCount() > 1) || (ctx.a.getText().contains("(")) || (ctx.a.getText().contains("+")) || (ctx.a.getText().contains("-")) || (ctx.a.getText().contains("*")) || (ctx.a.getText().contains("^")) || (ctx.a.getText().contains("/"))?this.visit(ctx.a):atribuicoes.get(ctx.a.getText());
		String valorB = (ctx.b.getChildCount() > 1) || (ctx.b.getText().contains("(")) || (ctx.b.getText().contains("+")) || (ctx.b.getText().contains("-")) || (ctx.b.getText().contains("*")) || (ctx.b.getText().contains("^")) || (ctx.b.getText().contains("/"))?this.visit(ctx.b):atribuicoes.get(ctx.b.getText());

		String codeTemp = "";
		if(valorA == null && valorB == null){
			codeTemp+="fadd" + "\n";
			return codeTemp;
		}
			codeTemp += valorA.contains("fconst_") ?valorA: "fconst_" + valorA + "\n";
			codeTemp += valorB.contains("fconst_") ?valorB: "fconst_" + valorB + "\n";
			codeTemp += "fadd" + "\n";
			return codeTemp;	
	}	

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitMenos(GramaticaParser.MenosContext ctx) { 
		
		String valorA = (ctx.a.getChildCount() > 1) || (ctx.a.getText().contains("(")) || (ctx.a.getText().contains("+")) || (ctx.a.getText().contains("-")) || (ctx.a.getText().contains("*")) || (ctx.a.getText().contains("^")) || (ctx.a.getText().contains("/"))?this.visit(ctx.a):atribuicoes.get(ctx.a.getText());
		String valorB = (ctx.b.getChildCount() > 1) || (ctx.b.getText().contains("(")) || (ctx.b.getText().contains("+")) || (ctx.b.getText().contains("-")) || (ctx.b.getText().contains("*")) || (ctx.b.getText().contains("^")) || (ctx.b.getText().contains("/"))?this.visit(ctx.b):atribuicoes.get(ctx.b.getText());

		String codeTemp = "";
		if(valorA == null && valorB == null){
			codeTemp+="fsub" + "\n";
			return codeTemp;
		}
			codeTemp += valorA.contains("fconst_") ?valorA: "fconst_" + valorA + "\n";
			codeTemp += valorB.contains("fconst_") ?valorB: "fconst_" + valorB + "\n";
			codeTemp += "fsub" + "\n";
			return codeTemp;				
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public String visitDiv(GramaticaParser.DivContext ctx) {

		String valorA = (ctx.a.getChildCount() > 1) || (ctx.a.getText().contains("(")) || (ctx.a.getText().contains("+")) || (ctx.a.getText().contains("-")) || (ctx.a.getText().contains("*")) || (ctx.a.getText().contains("^")) || (ctx.a.getText().contains("/"))?this.visit(ctx.a):atribuicoes.get(ctx.a.getText());
		String valorB = (ctx.b.getChildCount() > 1) || (ctx.b.getText().contains("(")) || (ctx.b.getText().contains("+")) || (ctx.b.getText().contains("-")) || (ctx.b.getText().contains("*")) || (ctx.b.getText().contains("^")) || (ctx.b.getText().contains("/"))?this.visit(ctx.b):atribuicoes.get(ctx.b.getText());

		String codeTemp = "";

		if(valorA == null && valorB == null){
			codeTemp+="fdiv" + "\n";
			return codeTemp;
		}
		
			codeTemp += valorA.contains("fconst_") ?valorA: "fconst_" + valorA + "\n"; 
			codeTemp += valorB.contains("fconst_") ?valorB: "fconst_" + valorB + "\n"; 
			codeTemp += "fdiv" + "\n";
			return codeTemp;			
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public String visitMul(GramaticaParser.MulContext ctx) { 
		
		String valorA = (ctx.a.getChildCount() > 1) || (ctx.a.getText().contains("(")) || (ctx.a.getText().contains("+")) || (ctx.a.getText().contains("-")) || (ctx.a.getText().contains("*")) || (ctx.a.getText().contains("^")) || (ctx.a.getText().contains("/"))?this.visit(ctx.a):atribuicoes.get(ctx.a.getText());
		String valorB = (ctx.b.getChildCount() > 1) || (ctx.b.getText().contains("(")) || (ctx.b.getText().contains("+")) || (ctx.b.getText().contains("-")) || (ctx.b.getText().contains("*")) || (ctx.b.getText().contains("^")) || (ctx.b.getText().contains("/"))?this.visit(ctx.b):atribuicoes.get(ctx.b.getText());

		String codeTemp = "";

		if(valorA == null && valorB == null){
			codeTemp+="fmul" + "\n";
			return codeTemp;
		}
		
			codeTemp += valorA.contains("fconst_") ?valorA: "fconst_" + valorA + "\n"; 
			codeTemp += valorB.contains("fconst_") ?valorB: "fconst_" + valorB + "\n"; 
			codeTemp += "fmul" + "\n";
			return codeTemp;			
	
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public String visitOu(GramaticaParser.OuContext ctx) { 
		
		String valorA = (ctx.a.getChildCount() > 1) || (ctx.a.getText().contains("("))?this.visit(ctx.a):atribuicoes.get(ctx.a.getText());
		String valorB = (ctx.b.getChildCount() > 1) || (ctx.b.getText().contains("("))?this.visit(ctx.b):atribuicoes.get(ctx.b.getText());
		
		String codeTemp = "";

		if(valorA == null && valorB == null){
			codeTemp+="ior" + "\n";
			return codeTemp;
		}
		
		codeTemp += valorA.contains("bipush") ?valorA: "bipush " + valorA + "\n"; 
		codeTemp += valorB.contains("bipush") ?valorB: "bipush " + valorB + "\n"; 
		codeTemp += "ior" + "\n";
		return codeTemp; 

	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitAnd(GramaticaParser.AndContext ctx) {
		
		String valorA = (ctx.a.getChildCount() > 1) || (ctx.a.getText().contains("("))?this.visit(ctx.a):atribuicoes.get(ctx.a.getText());
		String valorB = (ctx.b.getChildCount() > 1) || (ctx.b.getText().contains("("))?this.visit(ctx.b):atribuicoes.get(ctx.b.getText());
		
		String codeTemp = "";
		
		if(valorA == null && valorB == null){
			codeTemp+="iand" + "\n";
			return codeTemp;
		}
		
		codeTemp += valorA.contains("bipush") ?valorA: "bipush " + valorA + "\n"; 
		codeTemp += valorB.contains("bipush") ?valorB: "bipush " + valorB + "\n"; 
		codeTemp += "iand" + "\n";
		return codeTemp; 
		
}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
    public String visitDifLog(GramaticaParser.DifLogContext ctx) {
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
		String valorA = (ctx.a.getChildCount() > 1) || (ctx.a.getText().contains("("))?this.visit(ctx.a):atribuicoes.get(ctx.a.getText());
		String valorB = (ctx.b.getChildCount() > 1) || (ctx.b.getText().contains("("))?this.visit(ctx.b):atribuicoes.get(ctx.b.getText());
		if(a.getTipo() == "string"){
			valorA = String.valueOf(valorA.length());
		}
		if(b.getTipo() == "string"){
			valorB = String.valueOf(valorB.length());
		}
		String codeTemp = "";
		
		if(valorA == null && valorB == null){
			codeTemp+="dcmpg" + "\n";
			return codeTemp;
		}
		
		codeTemp += valorA.contains("dconst_") ?valorA: "dconst_" + valorA + "\n"; 
		codeTemp += valorB.contains("dconst_") ?valorB: "dconst_" + valorB + "\n"; 
		codeTemp += "dcmpg" + "\n";
		return codeTemp; 
		
}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public String visitIgualLog(GramaticaParser.IgualLogContext ctx) {
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
		String valorA = (ctx.a.getChildCount() > 1) || (ctx.a.getText().contains("("))?this.visit(ctx.a):atribuicoes.get(ctx.a.getText());
		String valorB = (ctx.b.getChildCount() > 1) || (ctx.b.getText().contains("("))?this.visit(ctx.b):atribuicoes.get(ctx.b.getText());
		if(a.getTipo() == "string"){
			valorA = String.valueOf(valorA.length());
		}
		if(b.getTipo() == "string"){
			valorB = String.valueOf(valorB.length());
		}
		String codeTemp = "";
		if(valorA == null && valorB == null){
			codeTemp+="dcmpg" + "\n";
			return codeTemp;
		}
		codeTemp += valorA.contains("dconst_") ?valorA: "dconst_" + valorA + "\n"; 
		codeTemp += valorB.contains("dconst_") ?valorB: "dconst_" + valorB + "\n"; 
		codeTemp += "dcmpg" + "\n";
		return codeTemp; 
}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public String visitExpo(GramaticaParser.ExpoContext ctx) { 
		
		String valorA = (ctx.a.getChildCount() > 1) || (ctx.a.getText().contains("(")) || (ctx.a.getText().contains("+")) || (ctx.a.getText().contains("-")) || (ctx.a.getText().contains("*")) || (ctx.a.getText().contains("^")) || (ctx.a.getText().contains("/"))?this.visit(ctx.a):atribuicoes.get(ctx.a.getText());
		String valorB = (ctx.b.getChildCount() > 1) || (ctx.b.getText().contains("(")) || (ctx.b.getText().contains("+")) || (ctx.b.getText().contains("-")) || (ctx.b.getText().contains("*")) || (ctx.b.getText().contains("^")) || (ctx.b.getText().contains("/"))?this.visit(ctx.b):atribuicoes.get(ctx.b.getText());

		String codeTemp = "";
		
		if(valorA == null && valorB == null){
			codeTemp+="invokestatic java/lang/Math/pow(DD)D" + "\n";
			return codeTemp;
		}
		
		codeTemp += valorA.contains("fconst_") ?valorA: "fconst_" + valorA + "\n"; 
		codeTemp += valorB.contains("fconst_") ?valorB: "fconst_" + valorB + "\n"; 
		codeTemp += "invokestatic java/lang/Math/pow(DD)D" + "\n";
		
		return codeTemp;
		
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public String visitNegLog(GramaticaParser.NegLogContext ctx) { 
		
		String valorA = (ctx.a.getChildCount() > 1) || (ctx.a.getText().contains("("))?this.visit(ctx.a):atribuicoes.get(ctx.a.getText());

		String codeTemp = "";
		if(valorA == null){
			codeTemp+="ineg" + "\n";
			return codeTemp;
		}
		codeTemp += valorA.contains("bipush") ?valorA: "bipush " + valorA + "\n"; 
		codeTemp += "ineg" + "\n";
		return codeTemp; 
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public String visitMenusUna(GramaticaParser.MenusUnaContext ctx) {
		String codeTemp = "";
		if(ctx.a.getText().length()>1){
			String valorA = (ctx.a.getChildCount() > 1) || (ctx.a.getText().contains("("))?this.visit(ctx.a):atribuicoes.get(ctx.a.getText());
		if(valorA == null){
			codeTemp+="fneg" + "\n";
			return codeTemp;
		}
		codeTemp += valorA.contains("ldc2_w") ?valorA: "ldc2_w " + valorA + "\n"; 
		return codeTemp += "fneg" + "\n";
		}else{
			if(ctx.a.t == "int" || ctx.a.t == "real"){
			codeTemp += ctx.a.getText().contains("ldc2_w") ?ctx.a.getText(): "ldc2_w " + ctx.a.getText() + "\n"; 
			return codeTemp += "fneg" + "\n";
			}
			else{
				codeTemp += ctx.a.getText().contains("ldc2_w") ?atribuicoes.get(ctx.a.getText()): "ldc2_w " + atribuicoes.get(ctx.a.getText()) + "\n"; 
				return codeTemp += "fneg" + "\n";			
			}
		}
}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public String visitMenorQ(GramaticaParser.MenorQContext ctx) { 
		
		String valorA = (ctx.a.getChildCount() > 1) || (ctx.a.getText().contains("("))?this.visit(ctx.a):atribuicoes.get(ctx.a.getText());
		String valorB = (ctx.b.getChildCount() > 1) || (ctx.b.getText().contains("("))?this.visit(ctx.b):atribuicoes.get(ctx.b.getText());
		String codeTemp = "";
		if(valorA == null && valorB == null){
			codeTemp+="dcmpg" + "\n";
			return codeTemp;
		}
		
		codeTemp += valorA.contains("dconst_") ?valorA: "dconst_" + valorA + "\n"; 
		codeTemp += valorB.contains("dconst_") ?valorB: "dconst_" + valorB + "\n"; 
		codeTemp += "dcmpg" + "\n";
		return codeTemp; 
}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public String visitMaiorQ(GramaticaParser.MaiorQContext ctx) {
		
		String valorA = (ctx.a.getChildCount() > 1) || (ctx.a.getText().contains("("))?this.visit(ctx.a):atribuicoes.get(ctx.a.getText());
		String valorB = (ctx.b.getChildCount() > 1) || (ctx.b.getText().contains("("))?this.visit(ctx.b):atribuicoes.get(ctx.b.getText());
			String codeTemp = "";
			
			if(valorA == null && valorB == null){
				codeTemp+="dcmpg" + "\n";
				return codeTemp;
			}
			
			codeTemp += valorA.contains("dconst_") ?valorA: "dconst_" + valorA + "\n"; 
			codeTemp += valorB.contains("dconst_") ?valorB: "dconst_" + valorB + "\n"; 
			codeTemp += "dcmpg" + "\n";
			return codeTemp;
			
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public String visitMaiorIq(GramaticaParser.MaiorIqContext ctx) {
		
		String valorA = (ctx.a.getChildCount() > 1) || (ctx.a.getText().contains("("))?this.visit(ctx.a):atribuicoes.get(ctx.a.getText());
		String valorB = (ctx.b.getChildCount() > 1) || (ctx.b.getText().contains("("))?this.visit(ctx.b):atribuicoes.get(ctx.b.getText());
		String codeTemp = "";
		
		if(valorA == null && valorB == null){
			codeTemp+="dcmpg" + "\n";
			return codeTemp;
		}
		
		codeTemp += valorA.contains("dconst_") ?valorA: "dconst_" + valorA + "\n"; 
		codeTemp += valorB.contains("dconst_") ?valorB: "dconst_" + valorB + "\n"; 
		codeTemp += "dcmpg" + "\n";
		return codeTemp;
		 
}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public String visitMenorIq(GramaticaParser.MenorIqContext ctx) { 
		
		String valorA = (ctx.a.getChildCount() > 1) || (ctx.a.getText().contains("("))?this.visit(ctx.a):atribuicoes.get(ctx.a.getText());
		String valorB = (ctx.b.getChildCount() > 1) || (ctx.b.getText().contains("("))?this.visit(ctx.b):atribuicoes.get(ctx.b.getText());
		String codeTemp = "";
		
		if(valorA == null && valorB == null){
			codeTemp+="dcmpg" + "\n";
			return codeTemp;
		}
		
		codeTemp += valorA.contains("dconst_") ?valorA: "dconst_" + valorA + "\n"; 
		codeTemp += valorB.contains("dconst_") ?valorB: "dconst_" + valorB + "\n"; 
		codeTemp += "dcmpg" + "\n";
		return codeTemp;
}
	
	
	
	public String getFuncoesPrograma() {
		return funcoesPrograma;
	}

	public static void setFuncoesPrograma(String funcoesPrograma) {
		GeradorJasmin.funcoesPrograma = funcoesPrograma;
	}

	@Override
	protected String aggregateResult(String aggregate, String nextResult) {
		if (aggregate == null) {
			return nextResult;
		}
		if (nextResult == null) {
			return aggregate;
		}
		return aggregate + "\n" + nextResult;
	}
}
