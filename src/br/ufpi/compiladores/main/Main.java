package br.ufpi.compiladores.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import br.ufpi.compiladores.acoessematicas.AcoesSemanticas;
import br.ufpi.compiladores.calculos.GeradorCalculos;
import br.ufpi.compiladores.erro.ErroSintaxeException;
import br.ufpi.compiladores.erro.ErroSintaxeListener;
import br.ufpi.compiladores.jasmin.GeradorJasmin;
import br.ufpi.compiladores.semantica.GramaticaLexer;
import br.ufpi.compiladores.semantica.GramaticaParser;

public class Main {
    
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        String fileName = "input/input.jav";
        InputStream input = new FileInputStream(fileName);
        ANTLRInputStream stream = new ANTLRInputStream(input);
        
        //Lexico
        GramaticaLexer lexer = new GramaticaLexer(stream);
        //lexer.removeErrorListeners();
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        //Sintatico
        GramaticaParser parser = new GramaticaParser(tokens);
        ParseTree tree = parser.program();
       // System.out.println(tree.toStringTree(parser));
        
		//Jasmin
        GeradorJasmin jasmin = new GeradorJasmin();
        String code = createJasminFile(jasmin.visit(tree));
		System.out.println(code);
		System.out.println(jasmin.funcoesPrograma);

		
		//Calculos
		//Jasmin
        GeradorCalculos calculos = new GeradorCalculos();
        System.out.println(calculos.visit(tree) == null?"":calculos.visit(tree));

        
        //Erro
		parser.removeErrorListeners();
		//ErroListener erros = new ErroListener();
		//parser.addErrorListener(erros);
		ErroSintaxeListener syntaxError = new ErroSintaxeListener();
		
		//FileWriter codigo = new FileWriter("output/output.j");
        
		//Semântica
		ParseTreeWalker walker = new ParseTreeWalker();
		AcoesSemanticas semantica = new AcoesSemanticas(parser);
		walker.walk(semantica, tree);
		
		if (!syntaxError.getErroSintaxe().isEmpty()) {
			for (ErroSintaxeException erro : syntaxError.getErroSintaxe()) {
				System.err.println(erro.toString());
			}
		}

		for (String erro : semantica.getErros()) {
			System.err.println(erro);
		}

	}
	
	public static String createJasminFile(String stmt){
		return ".class public Main\n" +
	            ".super java/lang/Object\n" +
				"\n" +
	            "; standard initializer\n"+
                 ".method public <init>()V\n"+
                 "  aload_0\n"+
                 "  invokenonvirtual java/lang/Object/<init>()V\n"+
                 "  return\n"+
                 ".end method\n\n"+
	            ".method public static main([Ljava/lang/String;)V\n" +
				".limit stack 100\n" +
	            ".limit locals 100\n" +
				"\n" +
				stmt + "\n" +
				"return" + "\n" + 
				".end method" + "\n";
	}

}
