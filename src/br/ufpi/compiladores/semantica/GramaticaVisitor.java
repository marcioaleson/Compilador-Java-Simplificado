// Generated from Gramatica.g4 by ANTLR 4.5.3

    package br.ufpi.compiladores.semantica;
    import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GramaticaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GramaticaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(GramaticaParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#atribuicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtribuicao(GramaticaParser.AtribuicaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#declaraConstantes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaraConstantes(GramaticaParser.DeclaraConstantesContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#declaraVariaveisGlobais}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaraVariaveisGlobais(GramaticaParser.DeclaraVariaveisGlobaisContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#declaraVariaveisLocais}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaraVariaveisLocais(GramaticaParser.DeclaraVariaveisLocaisContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#declaraParametros}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaraParametros(GramaticaParser.DeclaraParametrosContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(GramaticaParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#listaIDs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaIDs(GramaticaParser.ListaIDsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#declaraFuncao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaraFuncao(GramaticaParser.DeclaraFuncaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#comandos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandos(GramaticaParser.ComandosContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#chamadaFuncao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChamadaFuncao(GramaticaParser.ChamadaFuncaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#se}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSe(GramaticaParser.SeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#senao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSenao(GramaticaParser.SenaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#para}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPara(GramaticaParser.ParaContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#enquanto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnquanto(GramaticaParser.EnquantoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#leitura}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeitura(GramaticaParser.LeituraContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#impressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImpressao(GramaticaParser.ImpressaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#sair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSair(GramaticaParser.SairContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#expressoes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressoes(GramaticaParser.ExpressoesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolJoin}
	 * labeled alternative in {@link GramaticaParser#bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolJoin(GramaticaParser.BoolJoinContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Ou}
	 * labeled alternative in {@link GramaticaParser#bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOu(GramaticaParser.OuContext ctx);
	/**
	 * Visit a parse tree produced by the {@code And}
	 * labeled alternative in {@link GramaticaParser#join}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(GramaticaParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolEquality}
	 * labeled alternative in {@link GramaticaParser#join}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolEquality(GramaticaParser.BoolEqualityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DifLog}
	 * labeled alternative in {@link GramaticaParser#equality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDifLog(GramaticaParser.DifLogContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IgualLog}
	 * labeled alternative in {@link GramaticaParser#equality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIgualLog(GramaticaParser.IgualLogContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolRel}
	 * labeled alternative in {@link GramaticaParser#equality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolRel(GramaticaParser.BoolRelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MenorQ}
	 * labeled alternative in {@link GramaticaParser#rel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMenorQ(GramaticaParser.MenorQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MenorIq}
	 * labeled alternative in {@link GramaticaParser#rel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMenorIq(GramaticaParser.MenorIqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MaiorIq}
	 * labeled alternative in {@link GramaticaParser#rel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaiorIq(GramaticaParser.MaiorIqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MaiorQ}
	 * labeled alternative in {@link GramaticaParser#rel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaiorQ(GramaticaParser.MaiorQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolExpr}
	 * labeled alternative in {@link GramaticaParser#rel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpr(GramaticaParser.BoolExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Menos}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMenos(GramaticaParser.MenosContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprTerm}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprTerm(GramaticaParser.ExprTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Mais}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMais(GramaticaParser.MaisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TermUnary}
	 * labeled alternative in {@link GramaticaParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermUnary(GramaticaParser.TermUnaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Div}
	 * labeled alternative in {@link GramaticaParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv(GramaticaParser.DivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Expo}
	 * labeled alternative in {@link GramaticaParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpo(GramaticaParser.ExpoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Mul}
	 * labeled alternative in {@link GramaticaParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMul(GramaticaParser.MulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NegLog}
	 * labeled alternative in {@link GramaticaParser#unary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegLog(GramaticaParser.NegLogContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MenusUna}
	 * labeled alternative in {@link GramaticaParser#unary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMenusUna(GramaticaParser.MenusUnaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FactorUnary}
	 * labeled alternative in {@link GramaticaParser#unary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorUnary(GramaticaParser.FactorUnaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprParem}
	 * labeled alternative in {@link GramaticaParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprParem(GramaticaParser.ExprParemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variavel}
	 * labeled alternative in {@link GramaticaParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariavel(GramaticaParser.VariavelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Inteiro}
	 * labeled alternative in {@link GramaticaParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteiro(GramaticaParser.InteiroContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Real}
	 * labeled alternative in {@link GramaticaParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReal(GramaticaParser.RealContext ctx);
	/**
	 * Visit a parse tree produced by the {@code String}
	 * labeled alternative in {@link GramaticaParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(GramaticaParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolTrueOrFalse}
	 * labeled alternative in {@link GramaticaParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolTrueOrFalse(GramaticaParser.BoolTrueOrFalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ChaFuncao}
	 * labeled alternative in {@link GramaticaParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChaFuncao(GramaticaParser.ChaFuncaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#listaExpressoes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaExpressoes(GramaticaParser.ListaExpressoesContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#retorno}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetorno(GramaticaParser.RetornoContext ctx);
}