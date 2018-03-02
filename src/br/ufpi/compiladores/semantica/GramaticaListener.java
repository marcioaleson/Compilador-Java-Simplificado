// Generated from Gramatica.g4 by ANTLR 4.5.3

    package br.ufpi.compiladores.semantica;
    import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GramaticaParser}.
 */
public interface GramaticaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(GramaticaParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(GramaticaParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void enterAtribuicao(GramaticaParser.AtribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void exitAtribuicao(GramaticaParser.AtribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#declaraConstantes}.
	 * @param ctx the parse tree
	 */
	void enterDeclaraConstantes(GramaticaParser.DeclaraConstantesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#declaraConstantes}.
	 * @param ctx the parse tree
	 */
	void exitDeclaraConstantes(GramaticaParser.DeclaraConstantesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#declaraVariaveisGlobais}.
	 * @param ctx the parse tree
	 */
	void enterDeclaraVariaveisGlobais(GramaticaParser.DeclaraVariaveisGlobaisContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#declaraVariaveisGlobais}.
	 * @param ctx the parse tree
	 */
	void exitDeclaraVariaveisGlobais(GramaticaParser.DeclaraVariaveisGlobaisContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#declaraVariaveisLocais}.
	 * @param ctx the parse tree
	 */
	void enterDeclaraVariaveisLocais(GramaticaParser.DeclaraVariaveisLocaisContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#declaraVariaveisLocais}.
	 * @param ctx the parse tree
	 */
	void exitDeclaraVariaveisLocais(GramaticaParser.DeclaraVariaveisLocaisContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#declaraParametros}.
	 * @param ctx the parse tree
	 */
	void enterDeclaraParametros(GramaticaParser.DeclaraParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#declaraParametros}.
	 * @param ctx the parse tree
	 */
	void exitDeclaraParametros(GramaticaParser.DeclaraParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(GramaticaParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(GramaticaParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#listaIDs}.
	 * @param ctx the parse tree
	 */
	void enterListaIDs(GramaticaParser.ListaIDsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#listaIDs}.
	 * @param ctx the parse tree
	 */
	void exitListaIDs(GramaticaParser.ListaIDsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#declaraFuncao}.
	 * @param ctx the parse tree
	 */
	void enterDeclaraFuncao(GramaticaParser.DeclaraFuncaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#declaraFuncao}.
	 * @param ctx the parse tree
	 */
	void exitDeclaraFuncao(GramaticaParser.DeclaraFuncaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#comandos}.
	 * @param ctx the parse tree
	 */
	void enterComandos(GramaticaParser.ComandosContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#comandos}.
	 * @param ctx the parse tree
	 */
	void exitComandos(GramaticaParser.ComandosContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#chamadaFuncao}.
	 * @param ctx the parse tree
	 */
	void enterChamadaFuncao(GramaticaParser.ChamadaFuncaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#chamadaFuncao}.
	 * @param ctx the parse tree
	 */
	void exitChamadaFuncao(GramaticaParser.ChamadaFuncaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#se}.
	 * @param ctx the parse tree
	 */
	void enterSe(GramaticaParser.SeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#se}.
	 * @param ctx the parse tree
	 */
	void exitSe(GramaticaParser.SeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#senao}.
	 * @param ctx the parse tree
	 */
	void enterSenao(GramaticaParser.SenaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#senao}.
	 * @param ctx the parse tree
	 */
	void exitSenao(GramaticaParser.SenaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#para}.
	 * @param ctx the parse tree
	 */
	void enterPara(GramaticaParser.ParaContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#para}.
	 * @param ctx the parse tree
	 */
	void exitPara(GramaticaParser.ParaContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#enquanto}.
	 * @param ctx the parse tree
	 */
	void enterEnquanto(GramaticaParser.EnquantoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#enquanto}.
	 * @param ctx the parse tree
	 */
	void exitEnquanto(GramaticaParser.EnquantoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#leitura}.
	 * @param ctx the parse tree
	 */
	void enterLeitura(GramaticaParser.LeituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#leitura}.
	 * @param ctx the parse tree
	 */
	void exitLeitura(GramaticaParser.LeituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#impressao}.
	 * @param ctx the parse tree
	 */
	void enterImpressao(GramaticaParser.ImpressaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#impressao}.
	 * @param ctx the parse tree
	 */
	void exitImpressao(GramaticaParser.ImpressaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#sair}.
	 * @param ctx the parse tree
	 */
	void enterSair(GramaticaParser.SairContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#sair}.
	 * @param ctx the parse tree
	 */
	void exitSair(GramaticaParser.SairContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#expressoes}.
	 * @param ctx the parse tree
	 */
	void enterExpressoes(GramaticaParser.ExpressoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#expressoes}.
	 * @param ctx the parse tree
	 */
	void exitExpressoes(GramaticaParser.ExpressoesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolJoin}
	 * labeled alternative in {@link GramaticaParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBoolJoin(GramaticaParser.BoolJoinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolJoin}
	 * labeled alternative in {@link GramaticaParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBoolJoin(GramaticaParser.BoolJoinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Ou}
	 * labeled alternative in {@link GramaticaParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterOu(GramaticaParser.OuContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Ou}
	 * labeled alternative in {@link GramaticaParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitOu(GramaticaParser.OuContext ctx);
	/**
	 * Enter a parse tree produced by the {@code And}
	 * labeled alternative in {@link GramaticaParser#join}.
	 * @param ctx the parse tree
	 */
	void enterAnd(GramaticaParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code And}
	 * labeled alternative in {@link GramaticaParser#join}.
	 * @param ctx the parse tree
	 */
	void exitAnd(GramaticaParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolEquality}
	 * labeled alternative in {@link GramaticaParser#join}.
	 * @param ctx the parse tree
	 */
	void enterBoolEquality(GramaticaParser.BoolEqualityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolEquality}
	 * labeled alternative in {@link GramaticaParser#join}.
	 * @param ctx the parse tree
	 */
	void exitBoolEquality(GramaticaParser.BoolEqualityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DifLog}
	 * labeled alternative in {@link GramaticaParser#equality}.
	 * @param ctx the parse tree
	 */
	void enterDifLog(GramaticaParser.DifLogContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DifLog}
	 * labeled alternative in {@link GramaticaParser#equality}.
	 * @param ctx the parse tree
	 */
	void exitDifLog(GramaticaParser.DifLogContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IgualLog}
	 * labeled alternative in {@link GramaticaParser#equality}.
	 * @param ctx the parse tree
	 */
	void enterIgualLog(GramaticaParser.IgualLogContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IgualLog}
	 * labeled alternative in {@link GramaticaParser#equality}.
	 * @param ctx the parse tree
	 */
	void exitIgualLog(GramaticaParser.IgualLogContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolRel}
	 * labeled alternative in {@link GramaticaParser#equality}.
	 * @param ctx the parse tree
	 */
	void enterBoolRel(GramaticaParser.BoolRelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolRel}
	 * labeled alternative in {@link GramaticaParser#equality}.
	 * @param ctx the parse tree
	 */
	void exitBoolRel(GramaticaParser.BoolRelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MenorQ}
	 * labeled alternative in {@link GramaticaParser#rel}.
	 * @param ctx the parse tree
	 */
	void enterMenorQ(GramaticaParser.MenorQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MenorQ}
	 * labeled alternative in {@link GramaticaParser#rel}.
	 * @param ctx the parse tree
	 */
	void exitMenorQ(GramaticaParser.MenorQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MenorIq}
	 * labeled alternative in {@link GramaticaParser#rel}.
	 * @param ctx the parse tree
	 */
	void enterMenorIq(GramaticaParser.MenorIqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MenorIq}
	 * labeled alternative in {@link GramaticaParser#rel}.
	 * @param ctx the parse tree
	 */
	void exitMenorIq(GramaticaParser.MenorIqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MaiorIq}
	 * labeled alternative in {@link GramaticaParser#rel}.
	 * @param ctx the parse tree
	 */
	void enterMaiorIq(GramaticaParser.MaiorIqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MaiorIq}
	 * labeled alternative in {@link GramaticaParser#rel}.
	 * @param ctx the parse tree
	 */
	void exitMaiorIq(GramaticaParser.MaiorIqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MaiorQ}
	 * labeled alternative in {@link GramaticaParser#rel}.
	 * @param ctx the parse tree
	 */
	void enterMaiorQ(GramaticaParser.MaiorQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MaiorQ}
	 * labeled alternative in {@link GramaticaParser#rel}.
	 * @param ctx the parse tree
	 */
	void exitMaiorQ(GramaticaParser.MaiorQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolExpr}
	 * labeled alternative in {@link GramaticaParser#rel}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(GramaticaParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolExpr}
	 * labeled alternative in {@link GramaticaParser#rel}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(GramaticaParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Menos}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMenos(GramaticaParser.MenosContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Menos}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMenos(GramaticaParser.MenosContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprTerm}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprTerm(GramaticaParser.ExprTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprTerm}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprTerm(GramaticaParser.ExprTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Mais}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMais(GramaticaParser.MaisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Mais}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMais(GramaticaParser.MaisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TermUnary}
	 * labeled alternative in {@link GramaticaParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTermUnary(GramaticaParser.TermUnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TermUnary}
	 * labeled alternative in {@link GramaticaParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTermUnary(GramaticaParser.TermUnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Div}
	 * labeled alternative in {@link GramaticaParser#term}.
	 * @param ctx the parse tree
	 */
	void enterDiv(GramaticaParser.DivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Div}
	 * labeled alternative in {@link GramaticaParser#term}.
	 * @param ctx the parse tree
	 */
	void exitDiv(GramaticaParser.DivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Expo}
	 * labeled alternative in {@link GramaticaParser#term}.
	 * @param ctx the parse tree
	 */
	void enterExpo(GramaticaParser.ExpoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Expo}
	 * labeled alternative in {@link GramaticaParser#term}.
	 * @param ctx the parse tree
	 */
	void exitExpo(GramaticaParser.ExpoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Mul}
	 * labeled alternative in {@link GramaticaParser#term}.
	 * @param ctx the parse tree
	 */
	void enterMul(GramaticaParser.MulContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Mul}
	 * labeled alternative in {@link GramaticaParser#term}.
	 * @param ctx the parse tree
	 */
	void exitMul(GramaticaParser.MulContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NegLog}
	 * labeled alternative in {@link GramaticaParser#unary}.
	 * @param ctx the parse tree
	 */
	void enterNegLog(GramaticaParser.NegLogContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NegLog}
	 * labeled alternative in {@link GramaticaParser#unary}.
	 * @param ctx the parse tree
	 */
	void exitNegLog(GramaticaParser.NegLogContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MenusUna}
	 * labeled alternative in {@link GramaticaParser#unary}.
	 * @param ctx the parse tree
	 */
	void enterMenusUna(GramaticaParser.MenusUnaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MenusUna}
	 * labeled alternative in {@link GramaticaParser#unary}.
	 * @param ctx the parse tree
	 */
	void exitMenusUna(GramaticaParser.MenusUnaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FactorUnary}
	 * labeled alternative in {@link GramaticaParser#unary}.
	 * @param ctx the parse tree
	 */
	void enterFactorUnary(GramaticaParser.FactorUnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FactorUnary}
	 * labeled alternative in {@link GramaticaParser#unary}.
	 * @param ctx the parse tree
	 */
	void exitFactorUnary(GramaticaParser.FactorUnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprParem}
	 * labeled alternative in {@link GramaticaParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterExprParem(GramaticaParser.ExprParemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprParem}
	 * labeled alternative in {@link GramaticaParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitExprParem(GramaticaParser.ExprParemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variavel}
	 * labeled alternative in {@link GramaticaParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterVariavel(GramaticaParser.VariavelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variavel}
	 * labeled alternative in {@link GramaticaParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitVariavel(GramaticaParser.VariavelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Inteiro}
	 * labeled alternative in {@link GramaticaParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterInteiro(GramaticaParser.InteiroContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Inteiro}
	 * labeled alternative in {@link GramaticaParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitInteiro(GramaticaParser.InteiroContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Real}
	 * labeled alternative in {@link GramaticaParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterReal(GramaticaParser.RealContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Real}
	 * labeled alternative in {@link GramaticaParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitReal(GramaticaParser.RealContext ctx);
	/**
	 * Enter a parse tree produced by the {@code String}
	 * labeled alternative in {@link GramaticaParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterString(GramaticaParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code String}
	 * labeled alternative in {@link GramaticaParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitString(GramaticaParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolTrueOrFalse}
	 * labeled alternative in {@link GramaticaParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterBoolTrueOrFalse(GramaticaParser.BoolTrueOrFalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolTrueOrFalse}
	 * labeled alternative in {@link GramaticaParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitBoolTrueOrFalse(GramaticaParser.BoolTrueOrFalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ChaFuncao}
	 * labeled alternative in {@link GramaticaParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterChaFuncao(GramaticaParser.ChaFuncaoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ChaFuncao}
	 * labeled alternative in {@link GramaticaParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitChaFuncao(GramaticaParser.ChaFuncaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#listaExpressoes}.
	 * @param ctx the parse tree
	 */
	void enterListaExpressoes(GramaticaParser.ListaExpressoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#listaExpressoes}.
	 * @param ctx the parse tree
	 */
	void exitListaExpressoes(GramaticaParser.ListaExpressoesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#retorno}.
	 * @param ctx the parse tree
	 */
	void enterRetorno(GramaticaParser.RetornoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#retorno}.
	 * @param ctx the parse tree
	 */
	void exitRetorno(GramaticaParser.RetornoContext ctx);
}