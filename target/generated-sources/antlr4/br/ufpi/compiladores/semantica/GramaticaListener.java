// Generated from Gramatica.g4 by ANTLR 4.4

    package br.ufpi.compiladores.semantica;
    import java.util.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GramaticaParser}.
 */
public interface GramaticaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code Expresao}
	 * labeled alternative in {@link GramaticaParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterExpresao(@NotNull GramaticaParser.ExpresaoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Expresao}
	 * labeled alternative in {@link GramaticaParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitExpresao(@NotNull GramaticaParser.ExpresaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#declaraFuncao}.
	 * @param ctx the parse tree
	 */
	void enterDeclaraFuncao(@NotNull GramaticaParser.DeclaraFuncaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#declaraFuncao}.
	 * @param ctx the parse tree
	 */
	void exitDeclaraFuncao(@NotNull GramaticaParser.DeclaraFuncaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(@NotNull GramaticaParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(@NotNull GramaticaParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#sair}.
	 * @param ctx the parse tree
	 */
	void enterSair(@NotNull GramaticaParser.SairContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#sair}.
	 * @param ctx the parse tree
	 */
	void exitSair(@NotNull GramaticaParser.SairContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#enquanto}.
	 * @param ctx the parse tree
	 */
	void enterEnquanto(@NotNull GramaticaParser.EnquantoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#enquanto}.
	 * @param ctx the parse tree
	 */
	void exitEnquanto(@NotNull GramaticaParser.EnquantoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#chamadaFuncao}.
	 * @param ctx the parse tree
	 */
	void enterChamadaFuncao(@NotNull GramaticaParser.ChamadaFuncaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#chamadaFuncao}.
	 * @param ctx the parse tree
	 */
	void exitChamadaFuncao(@NotNull GramaticaParser.ChamadaFuncaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#declaraParametros}.
	 * @param ctx the parse tree
	 */
	void enterDeclaraParametros(@NotNull GramaticaParser.DeclaraParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#declaraParametros}.
	 * @param ctx the parse tree
	 */
	void exitDeclaraParametros(@NotNull GramaticaParser.DeclaraParametrosContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(@NotNull GramaticaParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(@NotNull GramaticaParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Ou}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOu(@NotNull GramaticaParser.OuContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Ou}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOu(@NotNull GramaticaParser.OuContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#listaExpressoes}.
	 * @param ctx the parse tree
	 */
	void enterListaExpressoes(@NotNull GramaticaParser.ListaExpressoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#listaExpressoes}.
	 * @param ctx the parse tree
	 */
	void exitListaExpressoes(@NotNull GramaticaParser.ListaExpressoesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull GramaticaParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull GramaticaParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#declaraVariaveisLocais}.
	 * @param ctx the parse tree
	 */
	void enterDeclaraVariaveisLocais(@NotNull GramaticaParser.DeclaraVariaveisLocaisContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#declaraVariaveisLocais}.
	 * @param ctx the parse tree
	 */
	void exitDeclaraVariaveisLocais(@NotNull GramaticaParser.DeclaraVariaveisLocaisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code String}
	 * labeled alternative in {@link GramaticaParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterString(@NotNull GramaticaParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code String}
	 * labeled alternative in {@link GramaticaParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitString(@NotNull GramaticaParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#senao}.
	 * @param ctx the parse tree
	 */
	void enterSenao(@NotNull GramaticaParser.SenaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#senao}.
	 * @param ctx the parse tree
	 */
	void exitSenao(@NotNull GramaticaParser.SenaoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Comp}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterComp(@NotNull GramaticaParser.CompContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Comp}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitComp(@NotNull GramaticaParser.CompContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#declaraConstantes}.
	 * @param ctx the parse tree
	 */
	void enterDeclaraConstantes(@NotNull GramaticaParser.DeclaraConstantesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#declaraConstantes}.
	 * @param ctx the parse tree
	 */
	void exitDeclaraConstantes(@NotNull GramaticaParser.DeclaraConstantesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#se}.
	 * @param ctx the parse tree
	 */
	void enterSe(@NotNull GramaticaParser.SeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#se}.
	 * @param ctx the parse tree
	 */
	void exitSe(@NotNull GramaticaParser.SeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#para}.
	 * @param ctx the parse tree
	 */
	void enterPara(@NotNull GramaticaParser.ParaContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#para}.
	 * @param ctx the parse tree
	 */
	void exitPara(@NotNull GramaticaParser.ParaContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#declaraVariaveisGlobais}.
	 * @param ctx the parse tree
	 */
	void enterDeclaraVariaveisGlobais(@NotNull GramaticaParser.DeclaraVariaveisGlobaisContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#declaraVariaveisGlobais}.
	 * @param ctx the parse tree
	 */
	void exitDeclaraVariaveisGlobais(@NotNull GramaticaParser.DeclaraVariaveisGlobaisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link GramaticaParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterBool(@NotNull GramaticaParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link GramaticaParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitBool(@NotNull GramaticaParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#expressoes}.
	 * @param ctx the parse tree
	 */
	void enterExpressoes(@NotNull GramaticaParser.ExpressoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#expressoes}.
	 * @param ctx the parse tree
	 */
	void exitExpressoes(@NotNull GramaticaParser.ExpressoesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Real}
	 * labeled alternative in {@link GramaticaParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterReal(@NotNull GramaticaParser.RealContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Real}
	 * labeled alternative in {@link GramaticaParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitReal(@NotNull GramaticaParser.RealContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Inteiro}
	 * labeled alternative in {@link GramaticaParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterInteiro(@NotNull GramaticaParser.InteiroContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Inteiro}
	 * labeled alternative in {@link GramaticaParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitInteiro(@NotNull GramaticaParser.InteiroContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MenusUna}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMenusUna(@NotNull GramaticaParser.MenusUnaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MenusUna}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMenusUna(@NotNull GramaticaParser.MenusUnaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Iqual}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIqual(@NotNull GramaticaParser.IqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Iqual}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIqual(@NotNull GramaticaParser.IqualContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void enterAtribuicao(@NotNull GramaticaParser.AtribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void exitAtribuicao(@NotNull GramaticaParser.AtribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#comandos}.
	 * @param ctx the parse tree
	 */
	void enterComandos(@NotNull GramaticaParser.ComandosContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#comandos}.
	 * @param ctx the parse tree
	 */
	void exitComandos(@NotNull GramaticaParser.ComandosContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fatorExpr}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFatorExpr(@NotNull GramaticaParser.FatorExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fatorExpr}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFatorExpr(@NotNull GramaticaParser.FatorExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NegLog}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNegLog(@NotNull GramaticaParser.NegLogContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NegLog}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNegLog(@NotNull GramaticaParser.NegLogContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#listaIDs}.
	 * @param ctx the parse tree
	 */
	void enterListaIDs(@NotNull GramaticaParser.ListaIDsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#listaIDs}.
	 * @param ctx the parse tree
	 */
	void exitListaIDs(@NotNull GramaticaParser.ListaIDsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#op_n1}.
	 * @param ctx the parse tree
	 */
	void enterOp_n1(@NotNull GramaticaParser.Op_n1Context ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#op_n1}.
	 * @param ctx the parse tree
	 */
	void exitOp_n1(@NotNull GramaticaParser.Op_n1Context ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#op_n2}.
	 * @param ctx the parse tree
	 */
	void enterOp_n2(@NotNull GramaticaParser.Op_n2Context ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#op_n2}.
	 * @param ctx the parse tree
	 */
	void exitOp_n2(@NotNull GramaticaParser.Op_n2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code Expo}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpo(@NotNull GramaticaParser.ExpoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Expo}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpo(@NotNull GramaticaParser.ExpoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#op_n3}.
	 * @param ctx the parse tree
	 */
	void enterOp_n3(@NotNull GramaticaParser.Op_n3Context ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#op_n3}.
	 * @param ctx the parse tree
	 */
	void exitOp_n3(@NotNull GramaticaParser.Op_n3Context ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#retorno}.
	 * @param ctx the parse tree
	 */
	void enterRetorno(@NotNull GramaticaParser.RetornoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#retorno}.
	 * @param ctx the parse tree
	 */
	void exitRetorno(@NotNull GramaticaParser.RetornoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#impressao}.
	 * @param ctx the parse tree
	 */
	void enterImpressao(@NotNull GramaticaParser.ImpressaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#impressao}.
	 * @param ctx the parse tree
	 */
	void exitImpressao(@NotNull GramaticaParser.ImpressaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#op_n4}.
	 * @param ctx the parse tree
	 */
	void enterOp_n4(@NotNull GramaticaParser.Op_n4Context ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#op_n4}.
	 * @param ctx the parse tree
	 */
	void exitOp_n4(@NotNull GramaticaParser.Op_n4Context ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#op_n5}.
	 * @param ctx the parse tree
	 */
	void enterOp_n5(@NotNull GramaticaParser.Op_n5Context ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#op_n5}.
	 * @param ctx the parse tree
	 */
	void exitOp_n5(@NotNull GramaticaParser.Op_n5Context ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#op_n6}.
	 * @param ctx the parse tree
	 */
	void enterOp_n6(@NotNull GramaticaParser.Op_n6Context ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#op_n6}.
	 * @param ctx the parse tree
	 */
	void exitOp_n6(@NotNull GramaticaParser.Op_n6Context ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#op_n7}.
	 * @param ctx the parse tree
	 */
	void enterOp_n7(@NotNull GramaticaParser.Op_n7Context ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#op_n7}.
	 * @param ctx the parse tree
	 */
	void exitOp_n7(@NotNull GramaticaParser.Op_n7Context ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#leitura}.
	 * @param ctx the parse tree
	 */
	void enterLeitura(@NotNull GramaticaParser.LeituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#leitura}.
	 * @param ctx the parse tree
	 */
	void exitLeitura(@NotNull GramaticaParser.LeituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#op_n8}.
	 * @param ctx the parse tree
	 */
	void enterOp_n8(@NotNull GramaticaParser.Op_n8Context ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#op_n8}.
	 * @param ctx the parse tree
	 */
	void exitOp_n8(@NotNull GramaticaParser.Op_n8Context ctx);
	/**
	 * Enter a parse tree produced by the {@code CamadaFucao}
	 * labeled alternative in {@link GramaticaParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterCamadaFucao(@NotNull GramaticaParser.CamadaFucaoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CamadaFucao}
	 * labeled alternative in {@link GramaticaParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitCamadaFucao(@NotNull GramaticaParser.CamadaFucaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#op_n9}.
	 * @param ctx the parse tree
	 */
	void enterOp_n9(@NotNull GramaticaParser.Op_n9Context ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#op_n9}.
	 * @param ctx the parse tree
	 */
	void exitOp_n9(@NotNull GramaticaParser.Op_n9Context ctx);
	/**
	 * Enter a parse tree produced by the {@code End}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEnd(@NotNull GramaticaParser.EndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code End}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEnd(@NotNull GramaticaParser.EndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Id}
	 * labeled alternative in {@link GramaticaParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterId(@NotNull GramaticaParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Id}
	 * labeled alternative in {@link GramaticaParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitId(@NotNull GramaticaParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SomSub}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSomSub(@NotNull GramaticaParser.SomSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SomSub}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSomSub(@NotNull GramaticaParser.SomSubContext ctx);
}