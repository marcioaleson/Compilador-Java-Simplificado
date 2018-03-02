// Generated from Gramatica.g4 by ANTLR 4.5.3

    package br.ufpi.compiladores.semantica;
    import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GramaticaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, ID=38, INT=39, 
		REAL=40, STRING=41, BOOLEANO=42, WS=43, LINE_COMMENT=44, COMMENT=45;
	public static final int
		RULE_program = 0, RULE_atribuicao = 1, RULE_declaraConstantes = 2, RULE_declaraVariaveisGlobais = 3, 
		RULE_declaraVariaveisLocais = 4, RULE_declaraParametros = 5, RULE_tipo = 6, 
		RULE_listaIDs = 7, RULE_declaraFuncao = 8, RULE_comandos = 9, RULE_chamadaFuncao = 10, 
		RULE_se = 11, RULE_senao = 12, RULE_para = 13, RULE_enquanto = 14, RULE_leitura = 15, 
		RULE_impressao = 16, RULE_sair = 17, RULE_expressoes = 18, RULE_bool = 19, 
		RULE_join = 20, RULE_equality = 21, RULE_rel = 22, RULE_expr = 23, RULE_term = 24, 
		RULE_unary = 25, RULE_factor = 26, RULE_listaExpressoes = 27, RULE_retorno = 28;
	public static final String[] ruleNames = {
		"program", "atribuicao", "declaraConstantes", "declaraVariaveisGlobais", 
		"declaraVariaveisLocais", "declaraParametros", "tipo", "listaIDs", "declaraFuncao", 
		"comandos", "chamadaFuncao", "se", "senao", "para", "enquanto", "leitura", 
		"impressao", "sair", "expressoes", "bool", "join", "equality", "rel", 
		"expr", "term", "unary", "factor", "listaExpressoes", "retorno"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'Prog'", "'{'", "'}'", "'='", "';'", "'Static'", "'Int'", "'String'", 
		"'Real'", "'Bool'", "','", "'('", "')'", "'if'", "'else'", "'for'", "'to'", 
		"'step'", "'while'", "'scan'", "'print'", "'break'", "'||'", "'&&'", "'=='", 
		"'!='", "'<'", "'<='", "'>='", "'>'", "'+'", "'-'", "'^'", "'*'", "'/'", 
		"'!'", "'return'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "ID", "INT", "REAL", "STRING", "BOOLEANO", "WS", "LINE_COMMENT", 
		"COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Gramatica.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GramaticaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GramaticaParser.ID, 0); }
		public List<DeclaraVariaveisGlobaisContext> declaraVariaveisGlobais() {
			return getRuleContexts(DeclaraVariaveisGlobaisContext.class);
		}
		public DeclaraVariaveisGlobaisContext declaraVariaveisGlobais(int i) {
			return getRuleContext(DeclaraVariaveisGlobaisContext.class,i);
		}
		public List<DeclaraConstantesContext> declaraConstantes() {
			return getRuleContexts(DeclaraConstantesContext.class);
		}
		public DeclaraConstantesContext declaraConstantes(int i) {
			return getRuleContext(DeclaraConstantesContext.class,i);
		}
		public List<DeclaraFuncaoContext> declaraFuncao() {
			return getRuleContexts(DeclaraFuncaoContext.class);
		}
		public DeclaraFuncaoContext declaraFuncao(int i) {
			return getRuleContext(DeclaraFuncaoContext.class,i);
		}
		public List<ComandosContext> comandos() {
			return getRuleContexts(ComandosContext.class);
		}
		public ComandosContext comandos(int i) {
			return getRuleContext(ComandosContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(T__0);
			setState(59);
			match(ID);
			setState(60);
			match(T__1);
			setState(65);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(63);
					switch (_input.LA(1)) {
					case T__6:
					case T__7:
					case T__8:
					case T__9:
						{
						setState(61);
						declaraVariaveisGlobais();
						}
						break;
					case T__5:
						{
						setState(62);
						declaraConstantes();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(67);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(71);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(68);
					declaraFuncao();
					}
					} 
				}
				setState(73);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__13) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__31) | (1L << T__35) | (1L << T__36) | (1L << ID) | (1L << INT) | (1L << REAL) | (1L << STRING) | (1L << BOOLEANO))) != 0)) {
				{
				{
				setState(74);
				comandos();
				}
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(80);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtribuicaoContext extends ParserRuleContext {
		public String t;
		public Token atriID;
		public ExpressoesContext exprAtri;
		public TerminalNode ID() { return getToken(GramaticaParser.ID, 0); }
		public ExpressoesContext expressoes() {
			return getRuleContext(ExpressoesContext.class,0);
		}
		public AtribuicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atribuicao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterAtribuicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitAtribuicao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitAtribuicao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtribuicaoContext atribuicao() throws RecognitionException {
		AtribuicaoContext _localctx = new AtribuicaoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_atribuicao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			((AtribuicaoContext)_localctx).atriID = match(ID);
			setState(83);
			match(T__3);
			setState(84);
			((AtribuicaoContext)_localctx).exprAtri = expressoes();
			((AtribuicaoContext)_localctx).t =  ((AtribuicaoContext)_localctx).exprAtri.t;
			setState(86);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaraConstantesContext extends ParserRuleContext {
		public String t;
		public FactorContext a;
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(GramaticaParser.ID, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public DeclaraConstantesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaraConstantes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterDeclaraConstantes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitDeclaraConstantes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDeclaraConstantes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaraConstantesContext declaraConstantes() throws RecognitionException {
		DeclaraConstantesContext _localctx = new DeclaraConstantesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaraConstantes);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(T__5);
			setState(89);
			tipo();
			setState(90);
			match(ID);
			setState(91);
			match(T__3);
			setState(92);
			((DeclaraConstantesContext)_localctx).a = factor();
			((DeclaraConstantesContext)_localctx).t = ((DeclaraConstantesContext)_localctx).a.t;
			setState(94);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaraVariaveisGlobaisContext extends ParserRuleContext {
		public String t;
		public ListaIDsContext a;
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public ListaIDsContext listaIDs() {
			return getRuleContext(ListaIDsContext.class,0);
		}
		public DeclaraVariaveisGlobaisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaraVariaveisGlobais; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterDeclaraVariaveisGlobais(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitDeclaraVariaveisGlobais(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDeclaraVariaveisGlobais(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaraVariaveisGlobaisContext declaraVariaveisGlobais() throws RecognitionException {
		DeclaraVariaveisGlobaisContext _localctx = new DeclaraVariaveisGlobaisContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaraVariaveisGlobais);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			tipo();
			setState(97);
			((DeclaraVariaveisGlobaisContext)_localctx).a = listaIDs();
			((DeclaraVariaveisGlobaisContext)_localctx).t = ((DeclaraVariaveisGlobaisContext)_localctx).a.t;
			setState(99);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaraVariaveisLocaisContext extends ParserRuleContext {
		public String t;
		public ListaIDsContext a;
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public ListaIDsContext listaIDs() {
			return getRuleContext(ListaIDsContext.class,0);
		}
		public DeclaraVariaveisLocaisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaraVariaveisLocais; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterDeclaraVariaveisLocais(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitDeclaraVariaveisLocais(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDeclaraVariaveisLocais(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaraVariaveisLocaisContext declaraVariaveisLocais() throws RecognitionException {
		DeclaraVariaveisLocaisContext _localctx = new DeclaraVariaveisLocaisContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declaraVariaveisLocais);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			tipo();
			setState(102);
			((DeclaraVariaveisLocaisContext)_localctx).a = listaIDs();
			((DeclaraVariaveisLocaisContext)_localctx).t = ((DeclaraVariaveisLocaisContext)_localctx).a.t;
			setState(104);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaraParametrosContext extends ParserRuleContext {
		public String t;
		public TipoContext a;
		public List<ListaIDsContext> listaIDs() {
			return getRuleContexts(ListaIDsContext.class);
		}
		public ListaIDsContext listaIDs(int i) {
			return getRuleContext(ListaIDsContext.class,i);
		}
		public List<TipoContext> tipo() {
			return getRuleContexts(TipoContext.class);
		}
		public TipoContext tipo(int i) {
			return getRuleContext(TipoContext.class,i);
		}
		public DeclaraParametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaraParametros; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterDeclaraParametros(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitDeclaraParametros(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDeclaraParametros(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaraParametrosContext declaraParametros() throws RecognitionException {
		DeclaraParametrosContext _localctx = new DeclaraParametrosContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declaraParametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			((DeclaraParametrosContext)_localctx).a = tipo();
			setState(107);
			listaIDs();
			((DeclaraParametrosContext)_localctx).t = ((DeclaraParametrosContext)_localctx).a.t;
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(109);
				match(T__4);
				setState(110);
				((DeclaraParametrosContext)_localctx).a = tipo();
				setState(111);
				listaIDs();
				((DeclaraParametrosContext)_localctx).t = ((DeclaraParametrosContext)_localctx).a.t;
				}
				}
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public String t;
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitTipo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitTipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_tipo);
		try {
			setState(127);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				match(T__6);
				((TipoContext)_localctx).t =  "int";
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				match(T__7);
				((TipoContext)_localctx).t =  "string";
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 3);
				{
				setState(123);
				match(T__8);
				((TipoContext)_localctx).t =  "real";
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 4);
				{
				setState(125);
				match(T__9);
				((TipoContext)_localctx).t =  "bool";
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListaIDsContext extends ParserRuleContext {
		public String t;
		public List<TerminalNode> ID() { return getTokens(GramaticaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(GramaticaParser.ID, i);
		}
		public ListaIDsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaIDs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterListaIDs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitListaIDs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitListaIDs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListaIDsContext listaIDs() throws RecognitionException {
		ListaIDsContext _localctx = new ListaIDsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_listaIDs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(ID);
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(130);
				match(T__10);
				setState(131);
				match(ID);
				}
				}
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaraFuncaoContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(GramaticaParser.ID, 0); }
		public DeclaraParametrosContext declaraParametros() {
			return getRuleContext(DeclaraParametrosContext.class,0);
		}
		public List<DeclaraVariaveisLocaisContext> declaraVariaveisLocais() {
			return getRuleContexts(DeclaraVariaveisLocaisContext.class);
		}
		public DeclaraVariaveisLocaisContext declaraVariaveisLocais(int i) {
			return getRuleContext(DeclaraVariaveisLocaisContext.class,i);
		}
		public List<ComandosContext> comandos() {
			return getRuleContexts(ComandosContext.class);
		}
		public ComandosContext comandos(int i) {
			return getRuleContext(ComandosContext.class,i);
		}
		public DeclaraFuncaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaraFuncao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterDeclaraFuncao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitDeclaraFuncao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDeclaraFuncao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaraFuncaoContext declaraFuncao() throws RecognitionException {
		DeclaraFuncaoContext _localctx = new DeclaraFuncaoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_declaraFuncao);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			tipo();
			setState(138);
			match(ID);
			setState(139);
			match(T__11);
			setState(141);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9))) != 0)) {
				{
				setState(140);
				declaraParametros();
				}
			}

			setState(143);
			match(T__12);
			setState(144);
			match(T__1);
			setState(148);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(145);
					declaraVariaveisLocais();
					}
					} 
				}
				setState(150);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__13) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__31) | (1L << T__35) | (1L << T__36) | (1L << ID) | (1L << INT) | (1L << REAL) | (1L << STRING) | (1L << BOOLEANO))) != 0)) {
				{
				{
				setState(151);
				comandos();
				}
				}
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(157);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComandosContext extends ParserRuleContext {
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public AtribuicaoContext atribuicao() {
			return getRuleContext(AtribuicaoContext.class,0);
		}
		public LeituraContext leitura() {
			return getRuleContext(LeituraContext.class,0);
		}
		public ImpressaoContext impressao() {
			return getRuleContext(ImpressaoContext.class,0);
		}
		public SeContext se() {
			return getRuleContext(SeContext.class,0);
		}
		public ParaContext para() {
			return getRuleContext(ParaContext.class,0);
		}
		public EnquantoContext enquanto() {
			return getRuleContext(EnquantoContext.class,0);
		}
		public SairContext sair() {
			return getRuleContext(SairContext.class,0);
		}
		public RetornoContext retorno() {
			return getRuleContext(RetornoContext.class,0);
		}
		public ChamadaFuncaoContext chamadaFuncao() {
			return getRuleContext(ChamadaFuncaoContext.class,0);
		}
		public DeclaraFuncaoContext declaraFuncao() {
			return getRuleContext(DeclaraFuncaoContext.class,0);
		}
		public ComandosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterComandos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitComandos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitComandos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComandosContext comandos() throws RecognitionException {
		ComandosContext _localctx = new ComandosContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_comandos);
		try {
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				bool(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(160);
				atribuicao();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(161);
				leitura();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(162);
				impressao();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(163);
				se();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(164);
				para();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(165);
				enquanto();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(166);
				sair();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(167);
				retorno();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(168);
				chamadaFuncao();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(169);
				declaraFuncao();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ChamadaFuncaoContext extends ParserRuleContext {
		public String t;
		public TerminalNode ID() { return getToken(GramaticaParser.ID, 0); }
		public ListaExpressoesContext listaExpressoes() {
			return getRuleContext(ListaExpressoesContext.class,0);
		}
		public ChamadaFuncaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chamadaFuncao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterChamadaFuncao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitChamadaFuncao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitChamadaFuncao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChamadaFuncaoContext chamadaFuncao() throws RecognitionException {
		ChamadaFuncaoContext _localctx = new ChamadaFuncaoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_chamadaFuncao);
		try {
			setState(183);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				match(ID);
				setState(173);
				match(T__11);
				setState(174);
				listaExpressoes();
				setState(175);
				match(T__12);
				setState(176);
				match(T__4);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
				match(ID);
				setState(179);
				match(T__11);
				setState(180);
				listaExpressoes();
				setState(181);
				match(T__12);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SeContext extends ParserRuleContext {
		public BoolContext ifExprB;
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public List<ComandosContext> comandos() {
			return getRuleContexts(ComandosContext.class);
		}
		public ComandosContext comandos(int i) {
			return getRuleContext(ComandosContext.class,i);
		}
		public SenaoContext senao() {
			return getRuleContext(SenaoContext.class,0);
		}
		public SeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_se; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterSe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitSe(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitSe(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeContext se() throws RecognitionException {
		SeContext _localctx = new SeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_se);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(T__13);
			setState(186);
			match(T__11);
			setState(187);
			((SeContext)_localctx).ifExprB = bool(0);
			setState(188);
			match(T__12);
			setState(189);
			match(T__1);
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__13) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__31) | (1L << T__35) | (1L << T__36) | (1L << ID) | (1L << INT) | (1L << REAL) | (1L << STRING) | (1L << BOOLEANO))) != 0)) {
				{
				{
				setState(190);
				comandos();
				}
				}
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(196);
			match(T__2);
			setState(198);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(197);
				senao();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SenaoContext extends ParserRuleContext {
		public List<ComandosContext> comandos() {
			return getRuleContexts(ComandosContext.class);
		}
		public ComandosContext comandos(int i) {
			return getRuleContext(ComandosContext.class,i);
		}
		public SenaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_senao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterSenao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitSenao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitSenao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SenaoContext senao() throws RecognitionException {
		SenaoContext _localctx = new SenaoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_senao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(T__14);
			setState(201);
			match(T__1);
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__13) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__31) | (1L << T__35) | (1L << T__36) | (1L << ID) | (1L << INT) | (1L << REAL) | (1L << STRING) | (1L << BOOLEANO))) != 0)) {
				{
				{
				setState(202);
				comandos();
				}
				}
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(208);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParaContext extends ParserRuleContext {
		public Token initVarID;
		public BoolContext intVar;
		public BoolContext endVar;
		public BoolContext stepVar;
		public TerminalNode ID() { return getToken(GramaticaParser.ID, 0); }
		public List<BoolContext> bool() {
			return getRuleContexts(BoolContext.class);
		}
		public BoolContext bool(int i) {
			return getRuleContext(BoolContext.class,i);
		}
		public List<ComandosContext> comandos() {
			return getRuleContexts(ComandosContext.class);
		}
		public ComandosContext comandos(int i) {
			return getRuleContext(ComandosContext.class,i);
		}
		public ParaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_para; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterPara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitPara(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitPara(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParaContext para() throws RecognitionException {
		ParaContext _localctx = new ParaContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_para);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(T__15);
			setState(211);
			match(T__11);
			setState(212);
			((ParaContext)_localctx).initVarID = match(ID);
			setState(213);
			match(T__3);
			setState(214);
			((ParaContext)_localctx).intVar = bool(0);
			setState(215);
			match(T__16);
			setState(216);
			((ParaContext)_localctx).endVar = bool(0);
			setState(219);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
				setState(217);
				match(T__17);
				setState(218);
				((ParaContext)_localctx).stepVar = bool(0);
				}
			}

			setState(221);
			match(T__12);
			setState(222);
			match(T__1);
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__13) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__31) | (1L << T__35) | (1L << T__36) | (1L << ID) | (1L << INT) | (1L << REAL) | (1L << STRING) | (1L << BOOLEANO))) != 0)) {
				{
				{
				setState(223);
				comandos();
				}
				}
				setState(228);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(229);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnquantoContext extends ParserRuleContext {
		public BoolContext whileExprB;
		public AtribuicaoContext whileIncr;
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public AtribuicaoContext atribuicao() {
			return getRuleContext(AtribuicaoContext.class,0);
		}
		public List<ComandosContext> comandos() {
			return getRuleContexts(ComandosContext.class);
		}
		public ComandosContext comandos(int i) {
			return getRuleContext(ComandosContext.class,i);
		}
		public EnquantoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enquanto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterEnquanto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitEnquanto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitEnquanto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnquantoContext enquanto() throws RecognitionException {
		EnquantoContext _localctx = new EnquantoContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_enquanto);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(T__18);
			setState(232);
			match(T__11);
			setState(233);
			((EnquantoContext)_localctx).whileExprB = bool(0);
			setState(234);
			match(T__12);
			setState(235);
			match(T__1);
			setState(239);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(236);
					comandos();
					}
					} 
				}
				setState(241);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			setState(242);
			((EnquantoContext)_localctx).whileIncr = atribuicao();
			setState(243);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LeituraContext extends ParserRuleContext {
		public ListaIDsContext listaIDs() {
			return getRuleContext(ListaIDsContext.class,0);
		}
		public LeituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterLeitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitLeitura(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitLeitura(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LeituraContext leitura() throws RecognitionException {
		LeituraContext _localctx = new LeituraContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_leitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			match(T__19);
			setState(246);
			match(T__11);
			setState(247);
			listaIDs();
			setState(248);
			match(T__12);
			setState(249);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImpressaoContext extends ParserRuleContext {
		public ListaExpressoesContext listaExpressoes() {
			return getRuleContext(ListaExpressoesContext.class,0);
		}
		public ImpressaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_impressao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterImpressao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitImpressao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitImpressao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImpressaoContext impressao() throws RecognitionException {
		ImpressaoContext _localctx = new ImpressaoContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_impressao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(T__20);
			setState(252);
			match(T__11);
			setState(253);
			listaExpressoes();
			setState(254);
			match(T__12);
			setState(255);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SairContext extends ParserRuleContext {
		public SairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterSair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitSair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitSair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SairContext sair() throws RecognitionException {
		SairContext _localctx = new SairContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_sair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			match(T__21);
			setState(258);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressoesContext extends ParserRuleContext {
		public String t;
		public BoolContext a;
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public ExpressoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressoes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterExpressoes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitExpressoes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExpressoes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressoesContext expressoes() throws RecognitionException {
		ExpressoesContext _localctx = new ExpressoesContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_expressoes);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			((ExpressoesContext)_localctx).a = bool(0);
			((ExpressoesContext)_localctx).t =  ((ExpressoesContext)_localctx).a.t;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolContext extends ParserRuleContext {
		public String t;
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
	 
		public BoolContext() { }
		public void copyFrom(BoolContext ctx) {
			super.copyFrom(ctx);
			this.t = ctx.t;
		}
	}
	public static class BoolJoinContext extends BoolContext {
		public JoinContext a;
		public JoinContext join() {
			return getRuleContext(JoinContext.class,0);
		}
		public BoolJoinContext(BoolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterBoolJoin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitBoolJoin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitBoolJoin(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OuContext extends BoolContext {
		public BoolContext a;
		public JoinContext b;
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public JoinContext join() {
			return getRuleContext(JoinContext.class,0);
		}
		public OuContext(BoolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterOu(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitOu(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitOu(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		return bool(0);
	}

	private BoolContext bool(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BoolContext _localctx = new BoolContext(_ctx, _parentState);
		BoolContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_bool, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new BoolJoinContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(264);
			((BoolJoinContext)_localctx).a = join(0);
			((BoolJoinContext)_localctx).t =  ((BoolJoinContext)_localctx).a.t;
			}
			_ctx.stop = _input.LT(-1);
			setState(274);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new OuContext(new BoolContext(_parentctx, _parentState));
					((OuContext)_localctx).a = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_bool);
					setState(267);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(268);
					match(T__22);
					setState(269);
					((OuContext)_localctx).b = join(0);
					((OuContext)_localctx).t =  "bool";
					}
					} 
				}
				setState(276);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class JoinContext extends ParserRuleContext {
		public String t;
		public JoinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join; }
	 
		public JoinContext() { }
		public void copyFrom(JoinContext ctx) {
			super.copyFrom(ctx);
			this.t = ctx.t;
		}
	}
	public static class AndContext extends JoinContext {
		public JoinContext a;
		public EqualityContext b;
		public JoinContext join() {
			return getRuleContext(JoinContext.class,0);
		}
		public EqualityContext equality() {
			return getRuleContext(EqualityContext.class,0);
		}
		public AndContext(JoinContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolEqualityContext extends JoinContext {
		public EqualityContext a;
		public EqualityContext equality() {
			return getRuleContext(EqualityContext.class,0);
		}
		public BoolEqualityContext(JoinContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterBoolEquality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitBoolEquality(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitBoolEquality(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JoinContext join() throws RecognitionException {
		return join(0);
	}

	private JoinContext join(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		JoinContext _localctx = new JoinContext(_ctx, _parentState);
		JoinContext _prevctx = _localctx;
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_join, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new BoolEqualityContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(278);
			((BoolEqualityContext)_localctx).a = equality(0);
			((BoolEqualityContext)_localctx).t =  ((BoolEqualityContext)_localctx).a.t;
			}
			_ctx.stop = _input.LT(-1);
			setState(288);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AndContext(new JoinContext(_parentctx, _parentState));
					((AndContext)_localctx).a = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_join);
					setState(281);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(282);
					match(T__23);
					setState(283);
					((AndContext)_localctx).b = equality(0);
					((AndContext)_localctx).t =  "bool";
					}
					} 
				}
				setState(290);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class EqualityContext extends ParserRuleContext {
		public String t;
		public EqualityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality; }
	 
		public EqualityContext() { }
		public void copyFrom(EqualityContext ctx) {
			super.copyFrom(ctx);
			this.t = ctx.t;
		}
	}
	public static class DifLogContext extends EqualityContext {
		public EqualityContext a;
		public RelContext b;
		public EqualityContext equality() {
			return getRuleContext(EqualityContext.class,0);
		}
		public RelContext rel() {
			return getRuleContext(RelContext.class,0);
		}
		public DifLogContext(EqualityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterDifLog(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitDifLog(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDifLog(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IgualLogContext extends EqualityContext {
		public EqualityContext a;
		public RelContext b;
		public EqualityContext equality() {
			return getRuleContext(EqualityContext.class,0);
		}
		public RelContext rel() {
			return getRuleContext(RelContext.class,0);
		}
		public IgualLogContext(EqualityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterIgualLog(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitIgualLog(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitIgualLog(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolRelContext extends EqualityContext {
		public RelContext a;
		public RelContext rel() {
			return getRuleContext(RelContext.class,0);
		}
		public BoolRelContext(EqualityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterBoolRel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitBoolRel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitBoolRel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityContext equality() throws RecognitionException {
		return equality(0);
	}

	private EqualityContext equality(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EqualityContext _localctx = new EqualityContext(_ctx, _parentState);
		EqualityContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_equality, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new BoolRelContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(292);
			((BoolRelContext)_localctx).a = rel();
			((BoolRelContext)_localctx).t =  ((BoolRelContext)_localctx).a.t;
			}
			_ctx.stop = _input.LT(-1);
			setState(307);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(305);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new IgualLogContext(new EqualityContext(_parentctx, _parentState));
						((IgualLogContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_equality);
						setState(295);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(296);
						match(T__24);
						setState(297);
						((IgualLogContext)_localctx).b = rel();
						((IgualLogContext)_localctx).t =  "bool";
						}
						break;
					case 2:
						{
						_localctx = new DifLogContext(new EqualityContext(_parentctx, _parentState));
						((DifLogContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_equality);
						setState(300);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(301);
						match(T__25);
						setState(302);
						((DifLogContext)_localctx).b = rel();
						((DifLogContext)_localctx).t =  "bool";
						}
						break;
					}
					} 
				}
				setState(309);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class RelContext extends ParserRuleContext {
		public String t;
		public RelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rel; }
	 
		public RelContext() { }
		public void copyFrom(RelContext ctx) {
			super.copyFrom(ctx);
			this.t = ctx.t;
		}
	}
	public static class MenorQContext extends RelContext {
		public ExprContext a;
		public ExprContext b;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MenorQContext(RelContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterMenorQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitMenorQ(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitMenorQ(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MaiorIqContext extends RelContext {
		public ExprContext a;
		public ExprContext b;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MaiorIqContext(RelContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterMaiorIq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitMaiorIq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitMaiorIq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolExprContext extends RelContext {
		public ExprContext a;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BoolExprContext(RelContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterBoolExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitBoolExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitBoolExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MaiorQContext extends RelContext {
		public ExprContext a;
		public ExprContext b;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MaiorQContext(RelContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterMaiorQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitMaiorQ(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitMaiorQ(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MenorIqContext extends RelContext {
		public ExprContext a;
		public ExprContext b;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MenorIqContext(RelContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterMenorIq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitMenorIq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitMenorIq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelContext rel() throws RecognitionException {
		RelContext _localctx = new RelContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_rel);
		try {
			setState(333);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				_localctx = new MenorQContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(310);
				((MenorQContext)_localctx).a = expr(0);
				setState(311);
				match(T__26);
				setState(312);
				((MenorQContext)_localctx).b = expr(0);
				((MenorQContext)_localctx).t =  "bool";
				}
				break;
			case 2:
				_localctx = new MenorIqContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(315);
				((MenorIqContext)_localctx).a = expr(0);
				setState(316);
				match(T__27);
				setState(317);
				((MenorIqContext)_localctx).b = expr(0);
				((MenorIqContext)_localctx).t =  "bool";
				}
				break;
			case 3:
				_localctx = new MaiorIqContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(320);
				((MaiorIqContext)_localctx).a = expr(0);
				setState(321);
				match(T__28);
				setState(322);
				((MaiorIqContext)_localctx).b = expr(0);
				((MaiorIqContext)_localctx).t =  "bool";
				}
				break;
			case 4:
				_localctx = new MaiorQContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(325);
				((MaiorQContext)_localctx).a = expr(0);
				setState(326);
				match(T__29);
				setState(327);
				((MaiorQContext)_localctx).b = expr(0);
				((MaiorQContext)_localctx).t =  "bool";
				}
				break;
			case 5:
				_localctx = new BoolExprContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(330);
				((BoolExprContext)_localctx).a = expr(0);
				((BoolExprContext)_localctx).t =  ((BoolExprContext)_localctx).a.t;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public String t;
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
			this.t = ctx.t;
		}
	}
	public static class MenosContext extends ExprContext {
		public ExprContext a;
		public TermContext b;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public MenosContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterMenos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitMenos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitMenos(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprTermContext extends ExprContext {
		public TermContext a;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ExprTermContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterExprTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitExprTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExprTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MaisContext extends ExprContext {
		public ExprContext a;
		public TermContext b;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public MaisContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterMais(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitMais(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitMais(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ExprTermContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(336);
			((ExprTermContext)_localctx).a = term(0);
			((ExprTermContext)_localctx).t = ((ExprTermContext)_localctx).a.t;
			}
			_ctx.stop = _input.LT(-1);
			setState(347);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(345);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
					case 1:
						{
						_localctx = new MaisContext(new ExprContext(_parentctx, _parentState));
						((MaisContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(339);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(340);
						match(T__30);
						setState(341);
						((MaisContext)_localctx).b = term(0);
						}
						break;
					case 2:
						{
						_localctx = new MenosContext(new ExprContext(_parentctx, _parentState));
						((MenosContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(342);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(343);
						match(T__31);
						setState(344);
						((MenosContext)_localctx).b = term(0);
						}
						break;
					}
					} 
				}
				setState(349);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public String t;
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	 
		public TermContext() { }
		public void copyFrom(TermContext ctx) {
			super.copyFrom(ctx);
			this.t = ctx.t;
		}
	}
	public static class TermUnaryContext extends TermContext {
		public UnaryContext a;
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public TermUnaryContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterTermUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitTermUnary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitTermUnary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DivContext extends TermContext {
		public TermContext a;
		public UnaryContext b;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public DivContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpoContext extends TermContext {
		public TermContext a;
		public UnaryContext b;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public ExpoContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterExpo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitExpo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExpo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulContext extends TermContext {
		public TermContext a;
		public UnaryContext b;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public MulContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterMul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitMul(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitMul(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new TermUnaryContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(351);
			((TermUnaryContext)_localctx).a = unary();
			((TermUnaryContext)_localctx).t = ((TermUnaryContext)_localctx).a.t;
			}
			_ctx.stop = _input.LT(-1);
			setState(365);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(363);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
					case 1:
						{
						_localctx = new ExpoContext(new TermContext(_parentctx, _parentState));
						((ExpoContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(354);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(355);
						match(T__32);
						setState(356);
						((ExpoContext)_localctx).b = unary();
						}
						break;
					case 2:
						{
						_localctx = new MulContext(new TermContext(_parentctx, _parentState));
						((MulContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(357);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(358);
						match(T__33);
						setState(359);
						((MulContext)_localctx).b = unary();
						}
						break;
					case 3:
						{
						_localctx = new DivContext(new TermContext(_parentctx, _parentState));
						((DivContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(360);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(361);
						match(T__34);
						setState(362);
						((DivContext)_localctx).b = unary();
						}
						break;
					}
					} 
				}
				setState(367);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UnaryContext extends ParserRuleContext {
		public String t;
		public UnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary; }
	 
		public UnaryContext() { }
		public void copyFrom(UnaryContext ctx) {
			super.copyFrom(ctx);
			this.t = ctx.t;
		}
	}
	public static class FactorUnaryContext extends UnaryContext {
		public FactorContext a;
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public FactorUnaryContext(UnaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterFactorUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitFactorUnary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitFactorUnary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegLogContext extends UnaryContext {
		public UnaryContext a;
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public NegLogContext(UnaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterNegLog(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitNegLog(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitNegLog(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MenusUnaContext extends UnaryContext {
		public UnaryContext a;
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public MenusUnaContext(UnaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterMenusUna(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitMenusUna(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitMenusUna(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryContext unary() throws RecognitionException {
		UnaryContext _localctx = new UnaryContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_unary);
		try {
			setState(379);
			switch (_input.LA(1)) {
			case T__35:
				_localctx = new NegLogContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(368);
				match(T__35);
				setState(369);
				((NegLogContext)_localctx).a = unary();
				((NegLogContext)_localctx).t =  "bool";
				}
				break;
			case T__31:
				_localctx = new MenusUnaContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(372);
				match(T__31);
				setState(373);
				((MenusUnaContext)_localctx).a = unary();
				((MenusUnaContext)_localctx).t =  ((MenusUnaContext)_localctx).a.t;
				}
				break;
			case T__11:
			case ID:
			case INT:
			case REAL:
			case STRING:
			case BOOLEANO:
				_localctx = new FactorUnaryContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(376);
				((FactorUnaryContext)_localctx).a = factor();
				((FactorUnaryContext)_localctx).t =  ((FactorUnaryContext)_localctx).a.t;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public String t;
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	 
		public FactorContext() { }
		public void copyFrom(FactorContext ctx) {
			super.copyFrom(ctx);
			this.t = ctx.t;
		}
	}
	public static class VariavelContext extends FactorContext {
		public TerminalNode ID() { return getToken(GramaticaParser.ID, 0); }
		public VariavelContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterVariavel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitVariavel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitVariavel(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprParemContext extends FactorContext {
		public BoolContext a;
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public ExprParemContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterExprParem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitExprParem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExprParem(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RealContext extends FactorContext {
		public TerminalNode REAL() { return getToken(GramaticaParser.REAL, 0); }
		public RealContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterReal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitReal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitReal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ChaFuncaoContext extends FactorContext {
		public ChamadaFuncaoContext a;
		public ChamadaFuncaoContext chamadaFuncao() {
			return getRuleContext(ChamadaFuncaoContext.class,0);
		}
		public ChaFuncaoContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterChaFuncao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitChaFuncao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitChaFuncao(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringContext extends FactorContext {
		public TerminalNode STRING() { return getToken(GramaticaParser.STRING, 0); }
		public StringContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InteiroContext extends FactorContext {
		public TerminalNode INT() { return getToken(GramaticaParser.INT, 0); }
		public InteiroContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterInteiro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitInteiro(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitInteiro(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolTrueOrFalseContext extends FactorContext {
		public TerminalNode BOOLEANO() { return getToken(GramaticaParser.BOOLEANO, 0); }
		public BoolTrueOrFalseContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterBoolTrueOrFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitBoolTrueOrFalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitBoolTrueOrFalse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_factor);
		try {
			setState(399);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				_localctx = new ExprParemContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(381);
				match(T__11);
				setState(382);
				((ExprParemContext)_localctx).a = bool(0);
				setState(383);
				match(T__12);
				((ExprParemContext)_localctx).t =  ((ExprParemContext)_localctx).a.t;
				}
				break;
			case 2:
				_localctx = new VariavelContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(386);
				match(ID);
				((VariavelContext)_localctx).t =  "id";
				}
				break;
			case 3:
				_localctx = new InteiroContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(388);
				match(INT);
				((InteiroContext)_localctx).t =  "int";
				}
				break;
			case 4:
				_localctx = new RealContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(390);
				match(REAL);
				((RealContext)_localctx).t =  "real";
				}
				break;
			case 5:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(392);
				match(STRING);
				((StringContext)_localctx).t =  "string";
				}
				break;
			case 6:
				_localctx = new BoolTrueOrFalseContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(394);
				match(BOOLEANO);
				((BoolTrueOrFalseContext)_localctx).t =  "bool";
				}
				break;
			case 7:
				_localctx = new ChaFuncaoContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(396);
				((ChaFuncaoContext)_localctx).a = chamadaFuncao();
				((ChaFuncaoContext)_localctx).t =  ((ChaFuncaoContext)_localctx).a.t;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListaExpressoesContext extends ParserRuleContext {
		public String t;
		public BoolContext a;
		public List<BoolContext> bool() {
			return getRuleContexts(BoolContext.class);
		}
		public BoolContext bool(int i) {
			return getRuleContext(BoolContext.class,i);
		}
		public ListaExpressoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaExpressoes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterListaExpressoes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitListaExpressoes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitListaExpressoes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListaExpressoesContext listaExpressoes() throws RecognitionException {
		ListaExpressoesContext _localctx = new ListaExpressoesContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_listaExpressoes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(401);
			((ListaExpressoesContext)_localctx).a = bool(0);
			((ListaExpressoesContext)_localctx).t =  ((ListaExpressoesContext)_localctx).a.t;
			setState(409);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(403);
				match(T__10);
				setState(404);
				((ListaExpressoesContext)_localctx).a = bool(0);
				((ListaExpressoesContext)_localctx).t =  ((ListaExpressoesContext)_localctx).a.t;
				}
				}
				setState(411);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RetornoContext extends ParserRuleContext {
		public ExpressoesContext expressoes() {
			return getRuleContext(ExpressoesContext.class,0);
		}
		public RetornoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_retorno; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterRetorno(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitRetorno(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitRetorno(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RetornoContext retorno() throws RecognitionException {
		RetornoContext _localctx = new RetornoContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_retorno);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(412);
			match(T__36);
			setState(413);
			match(T__11);
			setState(414);
			expressoes();
			setState(415);
			match(T__12);
			setState(416);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 19:
			return bool_sempred((BoolContext)_localctx, predIndex);
		case 20:
			return join_sempred((JoinContext)_localctx, predIndex);
		case 21:
			return equality_sempred((EqualityContext)_localctx, predIndex);
		case 23:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 24:
			return term_sempred((TermContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean bool_sempred(BoolContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean join_sempred(JoinContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean equality_sempred(EqualityContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 4);
		case 7:
			return precpred(_ctx, 3);
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3/\u01a5\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\2\3\2\3\2"+
		"\7\2B\n\2\f\2\16\2E\13\2\3\2\7\2H\n\2\f\2\16\2K\13\2\3\2\7\2N\n\2\f\2"+
		"\16\2Q\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\7\7u\n\7\f\7\16\7x\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0082"+
		"\n\b\3\t\3\t\3\t\7\t\u0087\n\t\f\t\16\t\u008a\13\t\3\n\3\n\3\n\3\n\5\n"+
		"\u0090\n\n\3\n\3\n\3\n\7\n\u0095\n\n\f\n\16\n\u0098\13\n\3\n\7\n\u009b"+
		"\n\n\f\n\16\n\u009e\13\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\5\13\u00ad\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\5\f\u00ba\n\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00c2\n\r\f\r\16\r"+
		"\u00c5\13\r\3\r\3\r\5\r\u00c9\n\r\3\16\3\16\3\16\7\16\u00ce\n\16\f\16"+
		"\16\16\u00d1\13\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\5\17\u00de\n\17\3\17\3\17\3\17\7\17\u00e3\n\17\f\17\16\17\u00e6\13"+
		"\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00f0\n\20\f\20\16\20"+
		"\u00f3\13\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\7\25\u0113\n\25\f\25\16\25\u0116\13\25\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u0121\n\26\f\26\16\26\u0124"+
		"\13\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\7\27\u0134\n\27\f\27\16\27\u0137\13\27\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\5\30\u0150\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\7\31\u015c\n\31\f\31\16\31\u015f\13\31\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u016e\n\32\f\32"+
		"\16\32\u0171\13\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3"+
		"\33\5\33\u017e\n\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0192\n\34\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\7\35\u019a\n\35\f\35\16\35\u019d\13\35\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\2\7(*,\60\62\37\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\668:\2\2\u01ba\2<\3\2\2\2\4T\3\2\2\2\6Z\3\2\2"+
		"\2\bb\3\2\2\2\ng\3\2\2\2\fl\3\2\2\2\16\u0081\3\2\2\2\20\u0083\3\2\2\2"+
		"\22\u008b\3\2\2\2\24\u00ac\3\2\2\2\26\u00b9\3\2\2\2\30\u00bb\3\2\2\2\32"+
		"\u00ca\3\2\2\2\34\u00d4\3\2\2\2\36\u00e9\3\2\2\2 \u00f7\3\2\2\2\"\u00fd"+
		"\3\2\2\2$\u0103\3\2\2\2&\u0106\3\2\2\2(\u0109\3\2\2\2*\u0117\3\2\2\2,"+
		"\u0125\3\2\2\2.\u014f\3\2\2\2\60\u0151\3\2\2\2\62\u0160\3\2\2\2\64\u017d"+
		"\3\2\2\2\66\u0191\3\2\2\28\u0193\3\2\2\2:\u019e\3\2\2\2<=\7\3\2\2=>\7"+
		"(\2\2>C\7\4\2\2?B\5\b\5\2@B\5\6\4\2A?\3\2\2\2A@\3\2\2\2BE\3\2\2\2CA\3"+
		"\2\2\2CD\3\2\2\2DI\3\2\2\2EC\3\2\2\2FH\5\22\n\2GF\3\2\2\2HK\3\2\2\2IG"+
		"\3\2\2\2IJ\3\2\2\2JO\3\2\2\2KI\3\2\2\2LN\5\24\13\2ML\3\2\2\2NQ\3\2\2\2"+
		"OM\3\2\2\2OP\3\2\2\2PR\3\2\2\2QO\3\2\2\2RS\7\5\2\2S\3\3\2\2\2TU\7(\2\2"+
		"UV\7\6\2\2VW\5&\24\2WX\b\3\1\2XY\7\7\2\2Y\5\3\2\2\2Z[\7\b\2\2[\\\5\16"+
		"\b\2\\]\7(\2\2]^\7\6\2\2^_\5\66\34\2_`\b\4\1\2`a\7\7\2\2a\7\3\2\2\2bc"+
		"\5\16\b\2cd\5\20\t\2de\b\5\1\2ef\7\7\2\2f\t\3\2\2\2gh\5\16\b\2hi\5\20"+
		"\t\2ij\b\6\1\2jk\7\7\2\2k\13\3\2\2\2lm\5\16\b\2mn\5\20\t\2nv\b\7\1\2o"+
		"p\7\7\2\2pq\5\16\b\2qr\5\20\t\2rs\b\7\1\2su\3\2\2\2to\3\2\2\2ux\3\2\2"+
		"\2vt\3\2\2\2vw\3\2\2\2w\r\3\2\2\2xv\3\2\2\2yz\7\t\2\2z\u0082\b\b\1\2{"+
		"|\7\n\2\2|\u0082\b\b\1\2}~\7\13\2\2~\u0082\b\b\1\2\177\u0080\7\f\2\2\u0080"+
		"\u0082\b\b\1\2\u0081y\3\2\2\2\u0081{\3\2\2\2\u0081}\3\2\2\2\u0081\177"+
		"\3\2\2\2\u0082\17\3\2\2\2\u0083\u0088\7(\2\2\u0084\u0085\7\r\2\2\u0085"+
		"\u0087\7(\2\2\u0086\u0084\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2"+
		"\2\2\u0088\u0089\3\2\2\2\u0089\21\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u008c"+
		"\5\16\b\2\u008c\u008d\7(\2\2\u008d\u008f\7\16\2\2\u008e\u0090\5\f\7\2"+
		"\u008f\u008e\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092"+
		"\7\17\2\2\u0092\u0096\7\4\2\2\u0093\u0095\5\n\6\2\u0094\u0093\3\2\2\2"+
		"\u0095\u0098\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u009c"+
		"\3\2\2\2\u0098\u0096\3\2\2\2\u0099\u009b\5\24\13\2\u009a\u0099\3\2\2\2"+
		"\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009f"+
		"\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a0\7\5\2\2\u00a0\23\3\2\2\2\u00a1"+
		"\u00ad\5(\25\2\u00a2\u00ad\5\4\3\2\u00a3\u00ad\5 \21\2\u00a4\u00ad\5\""+
		"\22\2\u00a5\u00ad\5\30\r\2\u00a6\u00ad\5\34\17\2\u00a7\u00ad\5\36\20\2"+
		"\u00a8\u00ad\5$\23\2\u00a9\u00ad\5:\36\2\u00aa\u00ad\5\26\f\2\u00ab\u00ad"+
		"\5\22\n\2\u00ac\u00a1\3\2\2\2\u00ac\u00a2\3\2\2\2\u00ac\u00a3\3\2\2\2"+
		"\u00ac\u00a4\3\2\2\2\u00ac\u00a5\3\2\2\2\u00ac\u00a6\3\2\2\2\u00ac\u00a7"+
		"\3\2\2\2\u00ac\u00a8\3\2\2\2\u00ac\u00a9\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac"+
		"\u00ab\3\2\2\2\u00ad\25\3\2\2\2\u00ae\u00af\7(\2\2\u00af\u00b0\7\16\2"+
		"\2\u00b0\u00b1\58\35\2\u00b1\u00b2\7\17\2\2\u00b2\u00b3\7\7\2\2\u00b3"+
		"\u00ba\3\2\2\2\u00b4\u00b5\7(\2\2\u00b5\u00b6\7\16\2\2\u00b6\u00b7\58"+
		"\35\2\u00b7\u00b8\7\17\2\2\u00b8\u00ba\3\2\2\2\u00b9\u00ae\3\2\2\2\u00b9"+
		"\u00b4\3\2\2\2\u00ba\27\3\2\2\2\u00bb\u00bc\7\20\2\2\u00bc\u00bd\7\16"+
		"\2\2\u00bd\u00be\5(\25\2\u00be\u00bf\7\17\2\2\u00bf\u00c3\7\4\2\2\u00c0"+
		"\u00c2\5\24\13\2\u00c1\u00c0\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3"+
		"\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c6\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6"+
		"\u00c8\7\5\2\2\u00c7\u00c9\5\32\16\2\u00c8\u00c7\3\2\2\2\u00c8\u00c9\3"+
		"\2\2\2\u00c9\31\3\2\2\2\u00ca\u00cb\7\21\2\2\u00cb\u00cf\7\4\2\2\u00cc"+
		"\u00ce\5\24\13\2\u00cd\u00cc\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3"+
		"\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d2\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2"+
		"\u00d3\7\5\2\2\u00d3\33\3\2\2\2\u00d4\u00d5\7\22\2\2\u00d5\u00d6\7\16"+
		"\2\2\u00d6\u00d7\7(\2\2\u00d7\u00d8\7\6\2\2\u00d8\u00d9\5(\25\2\u00d9"+
		"\u00da\7\23\2\2\u00da\u00dd\5(\25\2\u00db\u00dc\7\24\2\2\u00dc\u00de\5"+
		"(\25\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\3\2\2\2\u00df"+
		"\u00e0\7\17\2\2\u00e0\u00e4\7\4\2\2\u00e1\u00e3\5\24\13\2\u00e2\u00e1"+
		"\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5"+
		"\u00e7\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00e8\7\5\2\2\u00e8\35\3\2\2"+
		"\2\u00e9\u00ea\7\25\2\2\u00ea\u00eb\7\16\2\2\u00eb\u00ec\5(\25\2\u00ec"+
		"\u00ed\7\17\2\2\u00ed\u00f1\7\4\2\2\u00ee\u00f0\5\24\13\2\u00ef\u00ee"+
		"\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2"+
		"\u00f4\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00f5\5\4\3\2\u00f5\u00f6\7\5"+
		"\2\2\u00f6\37\3\2\2\2\u00f7\u00f8\7\26\2\2\u00f8\u00f9\7\16\2\2\u00f9"+
		"\u00fa\5\20\t\2\u00fa\u00fb\7\17\2\2\u00fb\u00fc\7\7\2\2\u00fc!\3\2\2"+
		"\2\u00fd\u00fe\7\27\2\2\u00fe\u00ff\7\16\2\2\u00ff\u0100\58\35\2\u0100"+
		"\u0101\7\17\2\2\u0101\u0102\7\7\2\2\u0102#\3\2\2\2\u0103\u0104\7\30\2"+
		"\2\u0104\u0105\7\7\2\2\u0105%\3\2\2\2\u0106\u0107\5(\25\2\u0107\u0108"+
		"\b\24\1\2\u0108\'\3\2\2\2\u0109\u010a\b\25\1\2\u010a\u010b\5*\26\2\u010b"+
		"\u010c\b\25\1\2\u010c\u0114\3\2\2\2\u010d\u010e\f\4\2\2\u010e\u010f\7"+
		"\31\2\2\u010f\u0110\5*\26\2\u0110\u0111\b\25\1\2\u0111\u0113\3\2\2\2\u0112"+
		"\u010d\3\2\2\2\u0113\u0116\3\2\2\2\u0114\u0112\3\2\2\2\u0114\u0115\3\2"+
		"\2\2\u0115)\3\2\2\2\u0116\u0114\3\2\2\2\u0117\u0118\b\26\1\2\u0118\u0119"+
		"\5,\27\2\u0119\u011a\b\26\1\2\u011a\u0122\3\2\2\2\u011b\u011c\f\4\2\2"+
		"\u011c\u011d\7\32\2\2\u011d\u011e\5,\27\2\u011e\u011f\b\26\1\2\u011f\u0121"+
		"\3\2\2\2\u0120\u011b\3\2\2\2\u0121\u0124\3\2\2\2\u0122\u0120\3\2\2\2\u0122"+
		"\u0123\3\2\2\2\u0123+\3\2\2\2\u0124\u0122\3\2\2\2\u0125\u0126\b\27\1\2"+
		"\u0126\u0127\5.\30\2\u0127\u0128\b\27\1\2\u0128\u0135\3\2\2\2\u0129\u012a"+
		"\f\5\2\2\u012a\u012b\7\33\2\2\u012b\u012c\5.\30\2\u012c\u012d\b\27\1\2"+
		"\u012d\u0134\3\2\2\2\u012e\u012f\f\4\2\2\u012f\u0130\7\34\2\2\u0130\u0131"+
		"\5.\30\2\u0131\u0132\b\27\1\2\u0132\u0134\3\2\2\2\u0133\u0129\3\2\2\2"+
		"\u0133\u012e\3\2\2\2\u0134\u0137\3\2\2\2\u0135\u0133\3\2\2\2\u0135\u0136"+
		"\3\2\2\2\u0136-\3\2\2\2\u0137\u0135\3\2\2\2\u0138\u0139\5\60\31\2\u0139"+
		"\u013a\7\35\2\2\u013a\u013b\5\60\31\2\u013b\u013c\b\30\1\2\u013c\u0150"+
		"\3\2\2\2\u013d\u013e\5\60\31\2\u013e\u013f\7\36\2\2\u013f\u0140\5\60\31"+
		"\2\u0140\u0141\b\30\1\2\u0141\u0150\3\2\2\2\u0142\u0143\5\60\31\2\u0143"+
		"\u0144\7\37\2\2\u0144\u0145\5\60\31\2\u0145\u0146\b\30\1\2\u0146\u0150"+
		"\3\2\2\2\u0147\u0148\5\60\31\2\u0148\u0149\7 \2\2\u0149\u014a\5\60\31"+
		"\2\u014a\u014b\b\30\1\2\u014b\u0150\3\2\2\2\u014c\u014d\5\60\31\2\u014d"+
		"\u014e\b\30\1\2\u014e\u0150\3\2\2\2\u014f\u0138\3\2\2\2\u014f\u013d\3"+
		"\2\2\2\u014f\u0142\3\2\2\2\u014f\u0147\3\2\2\2\u014f\u014c\3\2\2\2\u0150"+
		"/\3\2\2\2\u0151\u0152\b\31\1\2\u0152\u0153\5\62\32\2\u0153\u0154\b\31"+
		"\1\2\u0154\u015d\3\2\2\2\u0155\u0156\f\5\2\2\u0156\u0157\7!\2\2\u0157"+
		"\u015c\5\62\32\2\u0158\u0159\f\4\2\2\u0159\u015a\7\"\2\2\u015a\u015c\5"+
		"\62\32\2\u015b\u0155\3\2\2\2\u015b\u0158\3\2\2\2\u015c\u015f\3\2\2\2\u015d"+
		"\u015b\3\2\2\2\u015d\u015e\3\2\2\2\u015e\61\3\2\2\2\u015f\u015d\3\2\2"+
		"\2\u0160\u0161\b\32\1\2\u0161\u0162\5\64\33\2\u0162\u0163\b\32\1\2\u0163"+
		"\u016f\3\2\2\2\u0164\u0165\f\6\2\2\u0165\u0166\7#\2\2\u0166\u016e\5\64"+
		"\33\2\u0167\u0168\f\5\2\2\u0168\u0169\7$\2\2\u0169\u016e\5\64\33\2\u016a"+
		"\u016b\f\4\2\2\u016b\u016c\7%\2\2\u016c\u016e\5\64\33\2\u016d\u0164\3"+
		"\2\2\2\u016d\u0167\3\2\2\2\u016d\u016a\3\2\2\2\u016e\u0171\3\2\2\2\u016f"+
		"\u016d\3\2\2\2\u016f\u0170\3\2\2\2\u0170\63\3\2\2\2\u0171\u016f\3\2\2"+
		"\2\u0172\u0173\7&\2\2\u0173\u0174\5\64\33\2\u0174\u0175\b\33\1\2\u0175"+
		"\u017e\3\2\2\2\u0176\u0177\7\"\2\2\u0177\u0178\5\64\33\2\u0178\u0179\b"+
		"\33\1\2\u0179\u017e\3\2\2\2\u017a\u017b\5\66\34\2\u017b\u017c\b\33\1\2"+
		"\u017c\u017e\3\2\2\2\u017d\u0172\3\2\2\2\u017d\u0176\3\2\2\2\u017d\u017a"+
		"\3\2\2\2\u017e\65\3\2\2\2\u017f\u0180\7\16\2\2\u0180\u0181\5(\25\2\u0181"+
		"\u0182\7\17\2\2\u0182\u0183\b\34\1\2\u0183\u0192\3\2\2\2\u0184\u0185\7"+
		"(\2\2\u0185\u0192\b\34\1\2\u0186\u0187\7)\2\2\u0187\u0192\b\34\1\2\u0188"+
		"\u0189\7*\2\2\u0189\u0192\b\34\1\2\u018a\u018b\7+\2\2\u018b\u0192\b\34"+
		"\1\2\u018c\u018d\7,\2\2\u018d\u0192\b\34\1\2\u018e\u018f\5\26\f\2\u018f"+
		"\u0190\b\34\1\2\u0190\u0192\3\2\2\2\u0191\u017f\3\2\2\2\u0191\u0184\3"+
		"\2\2\2\u0191\u0186\3\2\2\2\u0191\u0188\3\2\2\2\u0191\u018a\3\2\2\2\u0191"+
		"\u018c\3\2\2\2\u0191\u018e\3\2\2\2\u0192\67\3\2\2\2\u0193\u0194\5(\25"+
		"\2\u0194\u019b\b\35\1\2\u0195\u0196\7\r\2\2\u0196\u0197\5(\25\2\u0197"+
		"\u0198\b\35\1\2\u0198\u019a\3\2\2\2\u0199\u0195\3\2\2\2\u019a\u019d\3"+
		"\2\2\2\u019b\u0199\3\2\2\2\u019b\u019c\3\2\2\2\u019c9\3\2\2\2\u019d\u019b"+
		"\3\2\2\2\u019e\u019f\7\'\2\2\u019f\u01a0\7\16\2\2\u01a0\u01a1\5&\24\2"+
		"\u01a1\u01a2\7\17\2\2\u01a2\u01a3\7\7\2\2\u01a3;\3\2\2\2 ACIOv\u0081\u0088"+
		"\u008f\u0096\u009c\u00ac\u00b9\u00c3\u00c8\u00cf\u00dd\u00e4\u00f1\u0114"+
		"\u0122\u0133\u0135\u014f\u015b\u015d\u016d\u016f\u017d\u0191\u019b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}