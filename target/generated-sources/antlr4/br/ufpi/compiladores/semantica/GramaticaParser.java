// Generated from Gramatica.g4 by ANTLR 4.4

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
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__38=1, T__37=2, T__36=3, T__35=4, T__34=5, T__33=6, T__32=7, T__31=8, 
		T__30=9, T__29=10, T__28=11, T__27=12, T__26=13, T__25=14, T__24=15, T__23=16, 
		T__22=17, T__21=18, T__20=19, T__19=20, T__18=21, T__17=22, T__16=23, 
		T__15=24, T__14=25, T__13=26, T__12=27, T__11=28, T__10=29, T__9=30, T__8=31, 
		T__7=32, T__6=33, T__5=34, T__4=35, T__3=36, T__2=37, T__1=38, T__0=39, 
		ID=40, INT=41, REAL=42, STRING=43, BOOLEANO=44, WS=45, LINE_COMMENT=46, 
		COMMENT=47;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "'return'", "'!='", "'Bool'", "'||'", "'while'", "';'", 
		"'{'", "'&&'", "'='", "'}'", "'^'", "'for'", "'if'", "'<='", "'break'", 
		"'print'", "'('", "'*'", "','", "'Static'", "'Real'", "'Int'", "'to'", 
		"'FALSE'", "'>='", "'scan'", "'=='", "'<'", "'String'", "'>'", "'Prog'", 
		"'!'", "'else'", "')'", "'+'", "'step'", "'-'", "'TRUE'", "ID", "INT", 
		"REAL", "STRING", "BOOLEANO", "WS", "LINE_COMMENT", "COMMENT"
	};
	public static final int
		RULE_program = 0, RULE_declaraConstantes = 1, RULE_declaraVariaveisGlobais = 2, 
		RULE_declaraVariaveisLocais = 3, RULE_declaraParametros = 4, RULE_tipo = 5, 
		RULE_listaIDs = 6, RULE_declaraFuncao = 7, RULE_comandos = 8, RULE_chamadaFuncao = 9, 
		RULE_se = 10, RULE_senao = 11, RULE_para = 12, RULE_enquanto = 13, RULE_atribuicao = 14, 
		RULE_leitura = 15, RULE_sair = 16, RULE_impressao = 17, RULE_expressoes = 18, 
		RULE_expr = 19, RULE_fator = 20, RULE_op_n9 = 21, RULE_op_n8 = 22, RULE_op_n7 = 23, 
		RULE_op_n6 = 24, RULE_op_n5 = 25, RULE_op_n4 = 26, RULE_op_n3 = 27, RULE_op_n2 = 28, 
		RULE_op_n1 = 29, RULE_listaExpressoes = 30, RULE_retorno = 31;
	public static final String[] ruleNames = {
		"program", "declaraConstantes", "declaraVariaveisGlobais", "declaraVariaveisLocais", 
		"declaraParametros", "tipo", "listaIDs", "declaraFuncao", "comandos", 
		"chamadaFuncao", "se", "senao", "para", "enquanto", "atribuicao", "leitura", 
		"sair", "impressao", "expressoes", "expr", "fator", "op_n9", "op_n8", 
		"op_n7", "op_n6", "op_n5", "op_n4", "op_n3", "op_n2", "op_n1", "listaExpressoes", 
		"retorno"
	};

	@Override
	public String getGrammarFileName() { return "Gramatica.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

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
		public List<DeclaraFuncaoContext> declaraFuncao() {
			return getRuleContexts(DeclaraFuncaoContext.class);
		}
		public TerminalNode ID() { return getToken(GramaticaParser.ID, 0); }
		public ComandosContext comandos(int i) {
			return getRuleContext(ComandosContext.class,i);
		}
		public DeclaraConstantesContext declaraConstantes(int i) {
			return getRuleContext(DeclaraConstantesContext.class,i);
		}
		public DeclaraVariaveisGlobaisContext declaraVariaveisGlobais(int i) {
			return getRuleContext(DeclaraVariaveisGlobaisContext.class,i);
		}
		public List<DeclaraConstantesContext> declaraConstantes() {
			return getRuleContexts(DeclaraConstantesContext.class);
		}
		public List<ComandosContext> comandos() {
			return getRuleContexts(ComandosContext.class);
		}
		public DeclaraFuncaoContext declaraFuncao(int i) {
			return getRuleContext(DeclaraFuncaoContext.class,i);
		}
		public List<DeclaraVariaveisGlobaisContext> declaraVariaveisGlobais() {
			return getRuleContexts(DeclaraVariaveisGlobaisContext.class);
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
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(64); match(T__7);
			setState(65); match(ID);
			setState(66); match(T__31);
			setState(71);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(69);
					switch (_input.LA(1)) {
					case T__35:
					case T__17:
					case T__16:
					case T__9:
						{
						setState(67); declaraVariaveisGlobais();
						}
						break;
					case T__18:
						{
						setState(68); declaraConstantes();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(73);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(77);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(74); declaraFuncao();
					}
					} 
				}
				setState(79);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__37) | (1L << T__35) | (1L << T__33) | (1L << T__26) | (1L << T__25) | (1L << T__23) | (1L << T__22) | (1L << T__21) | (1L << T__17) | (1L << T__16) | (1L << T__14) | (1L << T__12) | (1L << T__9) | (1L << T__6) | (1L << T__1) | (1L << T__0) | (1L << ID) | (1L << INT) | (1L << REAL) | (1L << STRING) | (1L << BOOLEANO))) != 0)) {
				{
				{
				setState(80); comandos();
				}
				}
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(86); match(T__28);
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
		public FatorContext a;
		public TerminalNode ID() { return getToken(GramaticaParser.ID, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public FatorContext fator() {
			return getRuleContext(FatorContext.class,0);
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
	}

	public final DeclaraConstantesContext declaraConstantes() throws RecognitionException {
		DeclaraConstantesContext _localctx = new DeclaraConstantesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaraConstantes);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88); match(T__18);
			setState(89); tipo();
			setState(90); match(ID);
			setState(91); match(T__29);
			setState(92); ((DeclaraConstantesContext)_localctx).a = fator();
			((DeclaraConstantesContext)_localctx).t = ((DeclaraConstantesContext)_localctx).a.t;
			setState(94); match(T__32);
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
	}

	public final DeclaraVariaveisGlobaisContext declaraVariaveisGlobais() throws RecognitionException {
		DeclaraVariaveisGlobaisContext _localctx = new DeclaraVariaveisGlobaisContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaraVariaveisGlobais);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96); tipo();
			setState(97); ((DeclaraVariaveisGlobaisContext)_localctx).a = listaIDs();
			((DeclaraVariaveisGlobaisContext)_localctx).t = ((DeclaraVariaveisGlobaisContext)_localctx).a.t;
			setState(99); match(T__32);
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
	}

	public final DeclaraVariaveisLocaisContext declaraVariaveisLocais() throws RecognitionException {
		DeclaraVariaveisLocaisContext _localctx = new DeclaraVariaveisLocaisContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaraVariaveisLocais);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101); tipo();
			setState(102); ((DeclaraVariaveisLocaisContext)_localctx).a = listaIDs();
			((DeclaraVariaveisLocaisContext)_localctx).t = ((DeclaraVariaveisLocaisContext)_localctx).a.t;
			setState(104); match(T__32);
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
		public ListaIDsContext a;
		public List<TipoContext> tipo() {
			return getRuleContexts(TipoContext.class);
		}
		public ListaIDsContext listaIDs(int i) {
			return getRuleContext(ListaIDsContext.class,i);
		}
		public TipoContext tipo(int i) {
			return getRuleContext(TipoContext.class,i);
		}
		public List<ListaIDsContext> listaIDs() {
			return getRuleContexts(ListaIDsContext.class);
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
	}

	public final DeclaraParametrosContext declaraParametros() throws RecognitionException {
		DeclaraParametrosContext _localctx = new DeclaraParametrosContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declaraParametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106); tipo();
			setState(107); ((DeclaraParametrosContext)_localctx).a = listaIDs();
			((DeclaraParametrosContext)_localctx).t = ((DeclaraParametrosContext)_localctx).a.t;
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__32) {
				{
				{
				setState(109); match(T__32);
				setState(110); tipo();
				setState(111); ((DeclaraParametrosContext)_localctx).a = listaIDs();
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
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_tipo);
		try {
			setState(127);
			switch (_input.LA(1)) {
			case T__16:
				enterOuterAlt(_localctx, 1);
				{
				setState(119); match(T__16);
				((TipoContext)_localctx).t =  "int";
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(121); match(T__9);
				((TipoContext)_localctx).t =  "string";
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 3);
				{
				setState(123); match(T__17);
				((TipoContext)_localctx).t =  "real";
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 4);
				{
				setState(125); match(T__35);
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
	}

	public final ListaIDsContext listaIDs() throws RecognitionException {
		ListaIDsContext _localctx = new ListaIDsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_listaIDs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129); match(ID);
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(130); match(T__19);
				setState(131); match(ID);
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
		public TerminalNode ID() { return getToken(GramaticaParser.ID, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public ComandosContext comandos(int i) {
			return getRuleContext(ComandosContext.class,i);
		}
		public DeclaraVariaveisLocaisContext declaraVariaveisLocais(int i) {
			return getRuleContext(DeclaraVariaveisLocaisContext.class,i);
		}
		public List<ComandosContext> comandos() {
			return getRuleContexts(ComandosContext.class);
		}
		public DeclaraParametrosContext declaraParametros() {
			return getRuleContext(DeclaraParametrosContext.class,0);
		}
		public List<DeclaraVariaveisLocaisContext> declaraVariaveisLocais() {
			return getRuleContexts(DeclaraVariaveisLocaisContext.class);
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
	}

	public final DeclaraFuncaoContext declaraFuncao() throws RecognitionException {
		DeclaraFuncaoContext _localctx = new DeclaraFuncaoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_declaraFuncao);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(137); tipo();
			setState(138); match(ID);
			setState(139); match(T__21);
			setState(141);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__35) | (1L << T__17) | (1L << T__16) | (1L << T__9))) != 0)) {
				{
				setState(140); declaraParametros();
				}
			}

			setState(143); match(T__4);
			setState(144); match(T__31);
			setState(148);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(145); declaraVariaveisLocais();
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__37) | (1L << T__35) | (1L << T__33) | (1L << T__26) | (1L << T__25) | (1L << T__23) | (1L << T__22) | (1L << T__21) | (1L << T__17) | (1L << T__16) | (1L << T__14) | (1L << T__12) | (1L << T__9) | (1L << T__6) | (1L << T__1) | (1L << T__0) | (1L << ID) | (1L << INT) | (1L << REAL) | (1L << STRING) | (1L << BOOLEANO))) != 0)) {
				{
				{
				setState(151); comandos();
				}
				}
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(157); match(T__28);
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
		public DeclaraFuncaoContext declaraFuncao() {
			return getRuleContext(DeclaraFuncaoContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParaContext para() {
			return getRuleContext(ParaContext.class,0);
		}
		public LeituraContext leitura() {
			return getRuleContext(LeituraContext.class,0);
		}
		public SairContext sair() {
			return getRuleContext(SairContext.class,0);
		}
		public SeContext se() {
			return getRuleContext(SeContext.class,0);
		}
		public EnquantoContext enquanto() {
			return getRuleContext(EnquantoContext.class,0);
		}
		public AtribuicaoContext atribuicao() {
			return getRuleContext(AtribuicaoContext.class,0);
		}
		public RetornoContext retorno() {
			return getRuleContext(RetornoContext.class,0);
		}
		public ImpressaoContext impressao() {
			return getRuleContext(ImpressaoContext.class,0);
		}
		public ChamadaFuncaoContext chamadaFuncao() {
			return getRuleContext(ChamadaFuncaoContext.class,0);
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
	}

	public final ComandosContext comandos() throws RecognitionException {
		ComandosContext _localctx = new ComandosContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_comandos);
		try {
			setState(170);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(159); expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(160); atribuicao();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(161); leitura();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(162); impressao();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(163); se();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(164); para();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(165); enquanto();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(166); sair();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(167); retorno();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(168); chamadaFuncao();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(169); declaraFuncao();
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
	}

	public final ChamadaFuncaoContext chamadaFuncao() throws RecognitionException {
		ChamadaFuncaoContext _localctx = new ChamadaFuncaoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_chamadaFuncao);
		try {
			setState(183);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(172); match(ID);
				setState(173); match(T__21);
				setState(174); listaExpressoes();
				setState(175); match(T__4);
				setState(176); match(T__32);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(178); match(ID);
				setState(179); match(T__21);
				setState(180); listaExpressoes();
				setState(181); match(T__4);
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
		public ExprContext ifExprB;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ComandosContext comandos(int i) {
			return getRuleContext(ComandosContext.class,i);
		}
		public List<ComandosContext> comandos() {
			return getRuleContexts(ComandosContext.class);
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
	}

	public final SeContext se() throws RecognitionException {
		SeContext _localctx = new SeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_se);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185); match(T__25);
			setState(186); match(T__21);
			setState(187); ((SeContext)_localctx).ifExprB = expr(0);
			setState(188); match(T__4);
			setState(189); match(T__31);
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__37) | (1L << T__35) | (1L << T__33) | (1L << T__26) | (1L << T__25) | (1L << T__23) | (1L << T__22) | (1L << T__21) | (1L << T__17) | (1L << T__16) | (1L << T__14) | (1L << T__12) | (1L << T__9) | (1L << T__6) | (1L << T__1) | (1L << T__0) | (1L << ID) | (1L << INT) | (1L << REAL) | (1L << STRING) | (1L << BOOLEANO))) != 0)) {
				{
				{
				setState(190); comandos();
				}
				}
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(196); match(T__28);
			setState(198);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(197); senao();
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
		public ComandosContext comandos(int i) {
			return getRuleContext(ComandosContext.class,i);
		}
		public List<ComandosContext> comandos() {
			return getRuleContexts(ComandosContext.class);
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
	}

	public final SenaoContext senao() throws RecognitionException {
		SenaoContext _localctx = new SenaoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_senao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200); match(T__5);
			setState(201); match(T__31);
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__37) | (1L << T__35) | (1L << T__33) | (1L << T__26) | (1L << T__25) | (1L << T__23) | (1L << T__22) | (1L << T__21) | (1L << T__17) | (1L << T__16) | (1L << T__14) | (1L << T__12) | (1L << T__9) | (1L << T__6) | (1L << T__1) | (1L << T__0) | (1L << ID) | (1L << INT) | (1L << REAL) | (1L << STRING) | (1L << BOOLEANO))) != 0)) {
				{
				{
				setState(202); comandos();
				}
				}
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(208); match(T__28);
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
		public ExprContext intVar;
		public ExprContext endVar;
		public ExprContext stepVar;
		public TerminalNode ID() { return getToken(GramaticaParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ComandosContext comandos(int i) {
			return getRuleContext(ComandosContext.class,i);
		}
		public List<ComandosContext> comandos() {
			return getRuleContexts(ComandosContext.class);
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
	}

	public final ParaContext para() throws RecognitionException {
		ParaContext _localctx = new ParaContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_para);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210); match(T__26);
			setState(211); match(T__21);
			setState(212); ((ParaContext)_localctx).initVarID = match(ID);
			setState(213); match(T__29);
			setState(214); ((ParaContext)_localctx).intVar = expr(0);
			setState(215); match(T__15);
			setState(216); ((ParaContext)_localctx).endVar = expr(0);
			setState(219);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(217); match(T__2);
				setState(218); ((ParaContext)_localctx).stepVar = expr(0);
				}
			}

			setState(221); match(T__4);
			setState(222); match(T__31);
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__37) | (1L << T__35) | (1L << T__33) | (1L << T__26) | (1L << T__25) | (1L << T__23) | (1L << T__22) | (1L << T__21) | (1L << T__17) | (1L << T__16) | (1L << T__14) | (1L << T__12) | (1L << T__9) | (1L << T__6) | (1L << T__1) | (1L << T__0) | (1L << ID) | (1L << INT) | (1L << REAL) | (1L << STRING) | (1L << BOOLEANO))) != 0)) {
				{
				{
				setState(223); comandos();
				}
				}
				setState(228);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(229); match(T__28);
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
		public ExprContext whielExprB;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ComandosContext comandos(int i) {
			return getRuleContext(ComandosContext.class,i);
		}
		public List<ComandosContext> comandos() {
			return getRuleContexts(ComandosContext.class);
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
	}

	public final EnquantoContext enquanto() throws RecognitionException {
		EnquantoContext _localctx = new EnquantoContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_enquanto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231); match(T__33);
			setState(232); match(T__21);
			setState(233); ((EnquantoContext)_localctx).whielExprB = expr(0);
			setState(234); match(T__4);
			setState(235); match(T__31);
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__37) | (1L << T__35) | (1L << T__33) | (1L << T__26) | (1L << T__25) | (1L << T__23) | (1L << T__22) | (1L << T__21) | (1L << T__17) | (1L << T__16) | (1L << T__14) | (1L << T__12) | (1L << T__9) | (1L << T__6) | (1L << T__1) | (1L << T__0) | (1L << ID) | (1L << INT) | (1L << REAL) | (1L << STRING) | (1L << BOOLEANO))) != 0)) {
				{
				{
				setState(236); comandos();
				}
				}
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(242); match(T__28);
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
		public ExprContext exprAtri;
		public TerminalNode ID() { return getToken(GramaticaParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
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
	}

	public final AtribuicaoContext atribuicao() throws RecognitionException {
		AtribuicaoContext _localctx = new AtribuicaoContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_atribuicao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244); ((AtribuicaoContext)_localctx).atriID = match(ID);
			setState(245); match(T__29);
			setState(246); ((AtribuicaoContext)_localctx).exprAtri = expr(0);
			((AtribuicaoContext)_localctx).t =  ((AtribuicaoContext)_localctx).exprAtri.t;
			setState(248); match(T__32);
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
	}

	public final LeituraContext leitura() throws RecognitionException {
		LeituraContext _localctx = new LeituraContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_leitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250); match(T__12);
			setState(251); match(T__21);
			setState(252); listaIDs();
			setState(253); match(T__4);
			setState(254); match(T__32);
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
	}

	public final SairContext sair() throws RecognitionException {
		SairContext _localctx = new SairContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_sair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256); match(T__23);
			setState(257); match(T__32);
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
	}

	public final ImpressaoContext impressao() throws RecognitionException {
		ImpressaoContext _localctx = new ImpressaoContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_impressao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259); match(T__22);
			setState(260); match(T__21);
			setState(261); listaExpressoes();
			setState(262); match(T__4);
			setState(263); match(T__32);
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
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
	}

	public final ExpressoesContext expressoes() throws RecognitionException {
		ExpressoesContext _localctx = new ExpressoesContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_expressoes);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265); expr(0);
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
	public static class IqualContext extends ExprContext {
		public ExprContext a;
		public ExprContext b;
		public Op_n6Context op_n6() {
			return getRuleContext(Op_n6Context.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public IqualContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterIqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitIqual(this);
		}
	}
	public static class ExpoContext extends ExprContext {
		public ExprContext a;
		public ExprContext b;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Op_n1Context op_n1() {
			return getRuleContext(Op_n1Context.class,0);
		}
		public ExpoContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterExpo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitExpo(this);
		}
	}
	public static class MulDivContext extends ExprContext {
		public ExprContext a;
		public ExprContext b;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public Op_n4Context op_n4() {
			return getRuleContext(Op_n4Context.class,0);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MulDivContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterMulDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitMulDiv(this);
		}
	}
	public static class OuContext extends ExprContext {
		public ExprContext a;
		public ExprContext b;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public Op_n9Context op_n9() {
			return getRuleContext(Op_n9Context.class,0);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public OuContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterOu(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitOu(this);
		}
	}
	public static class EndContext extends ExprContext {
		public ExprContext a;
		public ExprContext b;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public Op_n8Context op_n8() {
			return getRuleContext(Op_n8Context.class,0);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EndContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitEnd(this);
		}
	}
	public static class FatorExprContext extends ExprContext {
		public FatorContext fator() {
			return getRuleContext(FatorContext.class,0);
		}
		public FatorExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterFatorExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitFatorExpr(this);
		}
	}
	public static class NegLogContext extends ExprContext {
		public ExprContext b;
		public Op_n3Context op_n3() {
			return getRuleContext(Op_n3Context.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NegLogContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterNegLog(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitNegLog(this);
		}
	}
	public static class SomSubContext extends ExprContext {
		public ExprContext a;
		public ExprContext b;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public Op_n5Context op_n5() {
			return getRuleContext(Op_n5Context.class,0);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public SomSubContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterSomSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitSomSub(this);
		}
	}
	public static class MenusUnaContext extends ExprContext {
		public ExprContext b;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Op_n2Context op_n2() {
			return getRuleContext(Op_n2Context.class,0);
		}
		public MenusUnaContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterMenusUna(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitMenusUna(this);
		}
	}
	public static class CompContext extends ExprContext {
		public ExprContext a;
		public ExprContext b;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public Op_n7Context op_n7() {
			return getRuleContext(Op_n7Context.class,0);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CompContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterComp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitComp(this);
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
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			switch (_input.LA(1)) {
			case T__6:
				{
				_localctx = new NegLogContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(268); op_n3();
				setState(269); ((NegLogContext)_localctx).b = expr(4);
				}
				break;
			case T__1:
				{
				_localctx = new MenusUnaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(271); op_n2();
				setState(272); ((MenusUnaContext)_localctx).b = expr(3);
				}
				break;
			case T__21:
			case T__14:
			case T__0:
			case ID:
			case INT:
			case REAL:
			case STRING:
			case BOOLEANO:
				{
				_localctx = new FatorExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(274); fator();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(307);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(305);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new OuContext(new ExprContext(_parentctx, _parentState));
						((OuContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(277);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(278); op_n9();
						setState(279); ((OuContext)_localctx).b = expr(11);
						}
						break;
					case 2:
						{
						_localctx = new EndContext(new ExprContext(_parentctx, _parentState));
						((EndContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(281);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(282); op_n8();
						setState(283); ((EndContext)_localctx).b = expr(10);
						}
						break;
					case 3:
						{
						_localctx = new CompContext(new ExprContext(_parentctx, _parentState));
						((CompContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(285);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(286); op_n7();
						setState(287); ((CompContext)_localctx).b = expr(9);
						}
						break;
					case 4:
						{
						_localctx = new IqualContext(new ExprContext(_parentctx, _parentState));
						((IqualContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(289);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(290); op_n6();
						setState(291); ((IqualContext)_localctx).b = expr(8);
						}
						break;
					case 5:
						{
						_localctx = new SomSubContext(new ExprContext(_parentctx, _parentState));
						((SomSubContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(293);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(294); op_n5();
						setState(295); ((SomSubContext)_localctx).b = expr(7);
						}
						break;
					case 6:
						{
						_localctx = new MulDivContext(new ExprContext(_parentctx, _parentState));
						((MulDivContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(297);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(298); op_n4();
						setState(299); ((MulDivContext)_localctx).b = expr(6);
						}
						break;
					case 7:
						{
						_localctx = new ExpoContext(new ExprContext(_parentctx, _parentState));
						((ExpoContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(301);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(302); op_n1();
						setState(303); ((ExpoContext)_localctx).b = expr(3);
						}
						break;
					}
					} 
				}
				setState(309);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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

	public static class FatorContext extends ParserRuleContext {
		public String t;
		public FatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator; }
	 
		public FatorContext() { }
		public void copyFrom(FatorContext ctx) {
			super.copyFrom(ctx);
			this.t = ctx.t;
		}
	}
	public static class ExpresaoContext extends FatorContext {
		public ExprContext a;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExpresaoContext(FatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterExpresao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitExpresao(this);
		}
	}
	public static class BoolContext extends FatorContext {
		public TerminalNode BOOLEANO() { return getToken(GramaticaParser.BOOLEANO, 0); }
		public BoolContext(FatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitBool(this);
		}
	}
	public static class RealContext extends FatorContext {
		public TerminalNode REAL() { return getToken(GramaticaParser.REAL, 0); }
		public RealContext(FatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterReal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitReal(this);
		}
	}
	public static class CamadaFucaoContext extends FatorContext {
		public ChamadaFuncaoContext chamadaFuncao() {
			return getRuleContext(ChamadaFuncaoContext.class,0);
		}
		public CamadaFucaoContext(FatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterCamadaFucao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitCamadaFucao(this);
		}
	}
	public static class IdContext extends FatorContext {
		public TerminalNode ID() { return getToken(GramaticaParser.ID, 0); }
		public IdContext(FatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitId(this);
		}
	}
	public static class StringContext extends FatorContext {
		public TerminalNode STRING() { return getToken(GramaticaParser.STRING, 0); }
		public StringContext(FatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitString(this);
		}
	}
	public static class InteiroContext extends FatorContext {
		public TerminalNode INT() { return getToken(GramaticaParser.INT, 0); }
		public InteiroContext(FatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterInteiro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitInteiro(this);
		}
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_fator);
		try {
			setState(332);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				_localctx = new ExpresaoContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(310); match(T__21);
				setState(311); ((ExpresaoContext)_localctx).a = expr(0);
				setState(312); match(T__4);
				((ExpresaoContext)_localctx).t =  "expressao";
				}
				break;
			case 2:
				_localctx = new CamadaFucaoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(315); chamadaFuncao();
				((CamadaFucaoContext)_localctx).t =  "chamadaFuncao";
				}
				break;
			case 3:
				_localctx = new InteiroContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(318); match(INT);
				((InteiroContext)_localctx).t =  "int";
				}
				break;
			case 4:
				_localctx = new RealContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(320); match(REAL);
				((RealContext)_localctx).t =  "real";
				}
				break;
			case 5:
				_localctx = new IdContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(322); match(ID);
				((IdContext)_localctx).t =  "id";
				}
				break;
			case 6:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(324); match(STRING);
				((StringContext)_localctx).t =  "string";
				}
				break;
			case 7:
				_localctx = new BoolContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(326); match(BOOLEANO);
				((BoolContext)_localctx).t =  "bool";
				}
				break;
			case 8:
				_localctx = new BoolContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(328); match(T__0);
				((BoolContext)_localctx).t =  "bool";
				}
				break;
			case 9:
				_localctx = new BoolContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(330); match(T__14);
				((BoolContext)_localctx).t =  "bool";
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

	public static class Op_n9Context extends ParserRuleContext {
		public Op_n9Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_n9; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterOp_n9(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitOp_n9(this);
		}
	}

	public final Op_n9Context op_n9() throws RecognitionException {
		Op_n9Context _localctx = new Op_n9Context(_ctx, getState());
		enterRule(_localctx, 42, RULE_op_n9);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334); match(T__34);
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

	public static class Op_n8Context extends ParserRuleContext {
		public Op_n8Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_n8; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterOp_n8(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitOp_n8(this);
		}
	}

	public final Op_n8Context op_n8() throws RecognitionException {
		Op_n8Context _localctx = new Op_n8Context(_ctx, getState());
		enterRule(_localctx, 44, RULE_op_n8);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336); match(T__30);
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

	public static class Op_n7Context extends ParserRuleContext {
		public Op_n7Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_n7; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterOp_n7(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitOp_n7(this);
		}
	}

	public final Op_n7Context op_n7() throws RecognitionException {
		Op_n7Context _localctx = new Op_n7Context(_ctx, getState());
		enterRule(_localctx, 46, RULE_op_n7);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << T__13) | (1L << T__10) | (1L << T__8))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class Op_n6Context extends ParserRuleContext {
		public Op_n6Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_n6; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterOp_n6(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitOp_n6(this);
		}
	}

	public final Op_n6Context op_n6() throws RecognitionException {
		Op_n6Context _localctx = new Op_n6Context(_ctx, getState());
		enterRule(_localctx, 48, RULE_op_n6);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			_la = _input.LA(1);
			if ( !(_la==T__36 || _la==T__11) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class Op_n5Context extends ParserRuleContext {
		public Op_n5Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_n5; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterOp_n5(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitOp_n5(this);
		}
	}

	public final Op_n5Context op_n5() throws RecognitionException {
		Op_n5Context _localctx = new Op_n5Context(_ctx, getState());
		enterRule(_localctx, 50, RULE_op_n5);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			_la = _input.LA(1);
			if ( !(_la==T__3 || _la==T__1) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class Op_n4Context extends ParserRuleContext {
		public Op_n4Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_n4; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterOp_n4(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitOp_n4(this);
		}
	}

	public final Op_n4Context op_n4() throws RecognitionException {
		Op_n4Context _localctx = new Op_n4Context(_ctx, getState());
		enterRule(_localctx, 52, RULE_op_n4);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			_la = _input.LA(1);
			if ( !(_la==T__38 || _la==T__20) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class Op_n3Context extends ParserRuleContext {
		public Op_n3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_n3; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterOp_n3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitOp_n3(this);
		}
	}

	public final Op_n3Context op_n3() throws RecognitionException {
		Op_n3Context _localctx = new Op_n3Context(_ctx, getState());
		enterRule(_localctx, 54, RULE_op_n3);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346); match(T__6);
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

	public static class Op_n2Context extends ParserRuleContext {
		public Op_n2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_n2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterOp_n2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitOp_n2(this);
		}
	}

	public final Op_n2Context op_n2() throws RecognitionException {
		Op_n2Context _localctx = new Op_n2Context(_ctx, getState());
		enterRule(_localctx, 56, RULE_op_n2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348); match(T__1);
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

	public static class Op_n1Context extends ParserRuleContext {
		public Op_n1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_n1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterOp_n1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitOp_n1(this);
		}
	}

	public final Op_n1Context op_n1() throws RecognitionException {
		Op_n1Context _localctx = new Op_n1Context(_ctx, getState());
		enterRule(_localctx, 58, RULE_op_n1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350); match(T__27);
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
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
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
	}

	public final ListaExpressoesContext listaExpressoes() throws RecognitionException {
		ListaExpressoesContext _localctx = new ListaExpressoesContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_listaExpressoes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352); expr(0);
			setState(357);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(353); match(T__19);
				setState(354); expr(0);
				}
				}
				setState(359);
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
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
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
	}

	public final RetornoContext retorno() throws RecognitionException {
		RetornoContext _localctx = new RetornoContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_retorno);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(360); match(T__37);
			setState(361); expr(0);
			setState(362); match(T__32);
			setState(369);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(363); match(T__37);
					setState(364); expr(0);
					setState(365); match(T__32);
					}
					} 
				}
				setState(371);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 19: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 10);
		case 1: return precpred(_ctx, 9);
		case 2: return precpred(_ctx, 8);
		case 3: return precpred(_ctx, 7);
		case 4: return precpred(_ctx, 6);
		case 5: return precpred(_ctx, 5);
		case 6: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\61\u0177\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\2\3\2\3\2\7\2H\n\2\f\2\16\2K\13\2\3\2\7\2N\n\2\f\2\16\2"+
		"Q\13\2\3\2\7\2T\n\2\f\2\16\2W\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\7\6u\n\6\f\6\16\6x\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0082"+
		"\n\7\3\b\3\b\3\b\7\b\u0087\n\b\f\b\16\b\u008a\13\b\3\t\3\t\3\t\3\t\5\t"+
		"\u0090\n\t\3\t\3\t\3\t\7\t\u0095\n\t\f\t\16\t\u0098\13\t\3\t\7\t\u009b"+
		"\n\t\f\t\16\t\u009e\13\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\5\n\u00ad\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\5\13\u00ba\n\13\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00c2\n\f\f\f\16\f\u00c5"+
		"\13\f\3\f\3\f\5\f\u00c9\n\f\3\r\3\r\3\r\7\r\u00ce\n\r\f\r\16\r\u00d1\13"+
		"\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00de\n\16"+
		"\3\16\3\16\3\16\7\16\u00e3\n\16\f\16\16\16\u00e6\13\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\7\17\u00f0\n\17\f\17\16\17\u00f3\13\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\5\25\u0116\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u0134\n\25\f\25\16\25\u0137\13"+
		"\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u014f\n\26\3\27\3\27"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36"+
		"\3\37\3\37\3 \3 \3 \7 \u0166\n \f \16 \u0169\13 \3!\3!\3!\3!\3!\3!\3!"+
		"\7!\u0172\n!\f!\16!\u0175\13!\3!\2\3(\"\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\668:<>@\2\6\6\2\21\21\34\34\37\37!!\4\2\5"+
		"\5\36\36\4\2&&((\4\2\3\3\25\25\u0186\2B\3\2\2\2\4Z\3\2\2\2\6b\3\2\2\2"+
		"\bg\3\2\2\2\nl\3\2\2\2\f\u0081\3\2\2\2\16\u0083\3\2\2\2\20\u008b\3\2\2"+
		"\2\22\u00ac\3\2\2\2\24\u00b9\3\2\2\2\26\u00bb\3\2\2\2\30\u00ca\3\2\2\2"+
		"\32\u00d4\3\2\2\2\34\u00e9\3\2\2\2\36\u00f6\3\2\2\2 \u00fc\3\2\2\2\"\u0102"+
		"\3\2\2\2$\u0105\3\2\2\2&\u010b\3\2\2\2(\u0115\3\2\2\2*\u014e\3\2\2\2,"+
		"\u0150\3\2\2\2.\u0152\3\2\2\2\60\u0154\3\2\2\2\62\u0156\3\2\2\2\64\u0158"+
		"\3\2\2\2\66\u015a\3\2\2\28\u015c\3\2\2\2:\u015e\3\2\2\2<\u0160\3\2\2\2"+
		">\u0162\3\2\2\2@\u016a\3\2\2\2BC\7\"\2\2CD\7*\2\2DI\7\n\2\2EH\5\6\4\2"+
		"FH\5\4\3\2GE\3\2\2\2GF\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JO\3\2\2\2"+
		"KI\3\2\2\2LN\5\20\t\2ML\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2PU\3\2\2"+
		"\2QO\3\2\2\2RT\5\22\n\2SR\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2VX\3\2"+
		"\2\2WU\3\2\2\2XY\7\r\2\2Y\3\3\2\2\2Z[\7\27\2\2[\\\5\f\7\2\\]\7*\2\2]^"+
		"\7\f\2\2^_\5*\26\2_`\b\3\1\2`a\7\t\2\2a\5\3\2\2\2bc\5\f\7\2cd\5\16\b\2"+
		"de\b\4\1\2ef\7\t\2\2f\7\3\2\2\2gh\5\f\7\2hi\5\16\b\2ij\b\5\1\2jk\7\t\2"+
		"\2k\t\3\2\2\2lm\5\f\7\2mn\5\16\b\2nv\b\6\1\2op\7\t\2\2pq\5\f\7\2qr\5\16"+
		"\b\2rs\b\6\1\2su\3\2\2\2to\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2w\13\3"+
		"\2\2\2xv\3\2\2\2yz\7\31\2\2z\u0082\b\7\1\2{|\7 \2\2|\u0082\b\7\1\2}~\7"+
		"\30\2\2~\u0082\b\7\1\2\177\u0080\7\6\2\2\u0080\u0082\b\7\1\2\u0081y\3"+
		"\2\2\2\u0081{\3\2\2\2\u0081}\3\2\2\2\u0081\177\3\2\2\2\u0082\r\3\2\2\2"+
		"\u0083\u0088\7*\2\2\u0084\u0085\7\26\2\2\u0085\u0087\7*\2\2\u0086\u0084"+
		"\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\17\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u008c\5\f\7\2\u008c\u008d\7*\2\2"+
		"\u008d\u008f\7\24\2\2\u008e\u0090\5\n\6\2\u008f\u008e\3\2\2\2\u008f\u0090"+
		"\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\7%\2\2\u0092\u0096\7\n\2\2\u0093"+
		"\u0095\5\b\5\2\u0094\u0093\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094\3\2"+
		"\2\2\u0096\u0097\3\2\2\2\u0097\u009c\3\2\2\2\u0098\u0096\3\2\2\2\u0099"+
		"\u009b\5\22\n\2\u009a\u0099\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3"+
		"\2\2\2\u009c\u009d\3\2\2\2\u009d\u009f\3\2\2\2\u009e\u009c\3\2\2\2\u009f"+
		"\u00a0\7\r\2\2\u00a0\21\3\2\2\2\u00a1\u00ad\5(\25\2\u00a2\u00ad\5\36\20"+
		"\2\u00a3\u00ad\5 \21\2\u00a4\u00ad\5$\23\2\u00a5\u00ad\5\26\f\2\u00a6"+
		"\u00ad\5\32\16\2\u00a7\u00ad\5\34\17\2\u00a8\u00ad\5\"\22\2\u00a9\u00ad"+
		"\5@!\2\u00aa\u00ad\5\24\13\2\u00ab\u00ad\5\20\t\2\u00ac\u00a1\3\2\2\2"+
		"\u00ac\u00a2\3\2\2\2\u00ac\u00a3\3\2\2\2\u00ac\u00a4\3\2\2\2\u00ac\u00a5"+
		"\3\2\2\2\u00ac\u00a6\3\2\2\2\u00ac\u00a7\3\2\2\2\u00ac\u00a8\3\2\2\2\u00ac"+
		"\u00a9\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ab\3\2\2\2\u00ad\23\3\2\2"+
		"\2\u00ae\u00af\7*\2\2\u00af\u00b0\7\24\2\2\u00b0\u00b1\5> \2\u00b1\u00b2"+
		"\7%\2\2\u00b2\u00b3\7\t\2\2\u00b3\u00ba\3\2\2\2\u00b4\u00b5\7*\2\2\u00b5"+
		"\u00b6\7\24\2\2\u00b6\u00b7\5> \2\u00b7\u00b8\7%\2\2\u00b8\u00ba\3\2\2"+
		"\2\u00b9\u00ae\3\2\2\2\u00b9\u00b4\3\2\2\2\u00ba\25\3\2\2\2\u00bb\u00bc"+
		"\7\20\2\2\u00bc\u00bd\7\24\2\2\u00bd\u00be\5(\25\2\u00be\u00bf\7%\2\2"+
		"\u00bf\u00c3\7\n\2\2\u00c0\u00c2\5\22\n\2\u00c1\u00c0\3\2\2\2\u00c2\u00c5"+
		"\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c6\3\2\2\2\u00c5"+
		"\u00c3\3\2\2\2\u00c6\u00c8\7\r\2\2\u00c7\u00c9\5\30\r\2\u00c8\u00c7\3"+
		"\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\27\3\2\2\2\u00ca\u00cb\7$\2\2\u00cb\u00cf"+
		"\7\n\2\2\u00cc\u00ce\5\22\n\2\u00cd\u00cc\3\2\2\2\u00ce\u00d1\3\2\2\2"+
		"\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d2\3\2\2\2\u00d1\u00cf"+
		"\3\2\2\2\u00d2\u00d3\7\r\2\2\u00d3\31\3\2\2\2\u00d4\u00d5\7\17\2\2\u00d5"+
		"\u00d6\7\24\2\2\u00d6\u00d7\7*\2\2\u00d7\u00d8\7\f\2\2\u00d8\u00d9\5("+
		"\25\2\u00d9\u00da\7\32\2\2\u00da\u00dd\5(\25\2\u00db\u00dc\7\'\2\2\u00dc"+
		"\u00de\5(\25\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\3\2"+
		"\2\2\u00df\u00e0\7%\2\2\u00e0\u00e4\7\n\2\2\u00e1\u00e3\5\22\n\2\u00e2"+
		"\u00e1\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2"+
		"\2\2\u00e5\u00e7\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00e8\7\r\2\2\u00e8"+
		"\33\3\2\2\2\u00e9\u00ea\7\b\2\2\u00ea\u00eb\7\24\2\2\u00eb\u00ec\5(\25"+
		"\2\u00ec\u00ed\7%\2\2\u00ed\u00f1\7\n\2\2\u00ee\u00f0\5\22\n\2\u00ef\u00ee"+
		"\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2"+
		"\u00f4\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00f5\7\r\2\2\u00f5\35\3\2\2"+
		"\2\u00f6\u00f7\7*\2\2\u00f7\u00f8\7\f\2\2\u00f8\u00f9\5(\25\2\u00f9\u00fa"+
		"\b\20\1\2\u00fa\u00fb\7\t\2\2\u00fb\37\3\2\2\2\u00fc\u00fd\7\35\2\2\u00fd"+
		"\u00fe\7\24\2\2\u00fe\u00ff\5\16\b\2\u00ff\u0100\7%\2\2\u0100\u0101\7"+
		"\t\2\2\u0101!\3\2\2\2\u0102\u0103\7\22\2\2\u0103\u0104\7\t\2\2\u0104#"+
		"\3\2\2\2\u0105\u0106\7\23\2\2\u0106\u0107\7\24\2\2\u0107\u0108\5> \2\u0108"+
		"\u0109\7%\2\2\u0109\u010a\7\t\2\2\u010a%\3\2\2\2\u010b\u010c\5(\25\2\u010c"+
		"\'\3\2\2\2\u010d\u010e\b\25\1\2\u010e\u010f\58\35\2\u010f\u0110\5(\25"+
		"\6\u0110\u0116\3\2\2\2\u0111\u0112\5:\36\2\u0112\u0113\5(\25\5\u0113\u0116"+
		"\3\2\2\2\u0114\u0116\5*\26\2\u0115\u010d\3\2\2\2\u0115\u0111\3\2\2\2\u0115"+
		"\u0114\3\2\2\2\u0116\u0135\3\2\2\2\u0117\u0118\f\f\2\2\u0118\u0119\5,"+
		"\27\2\u0119\u011a\5(\25\r\u011a\u0134\3\2\2\2\u011b\u011c\f\13\2\2\u011c"+
		"\u011d\5.\30\2\u011d\u011e\5(\25\f\u011e\u0134\3\2\2\2\u011f\u0120\f\n"+
		"\2\2\u0120\u0121\5\60\31\2\u0121\u0122\5(\25\13\u0122\u0134\3\2\2\2\u0123"+
		"\u0124\f\t\2\2\u0124\u0125\5\62\32\2\u0125\u0126\5(\25\n\u0126\u0134\3"+
		"\2\2\2\u0127\u0128\f\b\2\2\u0128\u0129\5\64\33\2\u0129\u012a\5(\25\t\u012a"+
		"\u0134\3\2\2\2\u012b\u012c\f\7\2\2\u012c\u012d\5\66\34\2\u012d\u012e\5"+
		"(\25\b\u012e\u0134\3\2\2\2\u012f\u0130\f\4\2\2\u0130\u0131\5<\37\2\u0131"+
		"\u0132\5(\25\5\u0132\u0134\3\2\2\2\u0133\u0117\3\2\2\2\u0133\u011b\3\2"+
		"\2\2\u0133\u011f\3\2\2\2\u0133\u0123\3\2\2\2\u0133\u0127\3\2\2\2\u0133"+
		"\u012b\3\2\2\2\u0133\u012f\3\2\2\2\u0134\u0137\3\2\2\2\u0135\u0133\3\2"+
		"\2\2\u0135\u0136\3\2\2\2\u0136)\3\2\2\2\u0137\u0135\3\2\2\2\u0138\u0139"+
		"\7\24\2\2\u0139\u013a\5(\25\2\u013a\u013b\7%\2\2\u013b\u013c\b\26\1\2"+
		"\u013c\u014f\3\2\2\2\u013d\u013e\5\24\13\2\u013e\u013f\b\26\1\2\u013f"+
		"\u014f\3\2\2\2\u0140\u0141\7+\2\2\u0141\u014f\b\26\1\2\u0142\u0143\7,"+
		"\2\2\u0143\u014f\b\26\1\2\u0144\u0145\7*\2\2\u0145\u014f\b\26\1\2\u0146"+
		"\u0147\7-\2\2\u0147\u014f\b\26\1\2\u0148\u0149\7.\2\2\u0149\u014f\b\26"+
		"\1\2\u014a\u014b\7)\2\2\u014b\u014f\b\26\1\2\u014c\u014d\7\33\2\2\u014d"+
		"\u014f\b\26\1\2\u014e\u0138\3\2\2\2\u014e\u013d\3\2\2\2\u014e\u0140\3"+
		"\2\2\2\u014e\u0142\3\2\2\2\u014e\u0144\3\2\2\2\u014e\u0146\3\2\2\2\u014e"+
		"\u0148\3\2\2\2\u014e\u014a\3\2\2\2\u014e\u014c\3\2\2\2\u014f+\3\2\2\2"+
		"\u0150\u0151\7\7\2\2\u0151-\3\2\2\2\u0152\u0153\7\13\2\2\u0153/\3\2\2"+
		"\2\u0154\u0155\t\2\2\2\u0155\61\3\2\2\2\u0156\u0157\t\3\2\2\u0157\63\3"+
		"\2\2\2\u0158\u0159\t\4\2\2\u0159\65\3\2\2\2\u015a\u015b\t\5\2\2\u015b"+
		"\67\3\2\2\2\u015c\u015d\7#\2\2\u015d9\3\2\2\2\u015e\u015f\7(\2\2\u015f"+
		";\3\2\2\2\u0160\u0161\7\16\2\2\u0161=\3\2\2\2\u0162\u0167\5(\25\2\u0163"+
		"\u0164\7\26\2\2\u0164\u0166\5(\25\2\u0165\u0163\3\2\2\2\u0166\u0169\3"+
		"\2\2\2\u0167\u0165\3\2\2\2\u0167\u0168\3\2\2\2\u0168?\3\2\2\2\u0169\u0167"+
		"\3\2\2\2\u016a\u016b\7\4\2\2\u016b\u016c\5(\25\2\u016c\u0173\7\t\2\2\u016d"+
		"\u016e\7\4\2\2\u016e\u016f\5(\25\2\u016f\u0170\7\t\2\2\u0170\u0172\3\2"+
		"\2\2\u0171\u016d\3\2\2\2\u0172\u0175\3\2\2\2\u0173\u0171\3\2\2\2\u0173"+
		"\u0174\3\2\2\2\u0174A\3\2\2\2\u0175\u0173\3\2\2\2\32GIOUv\u0081\u0088"+
		"\u008f\u0096\u009c\u00ac\u00b9\u00c3\u00c8\u00cf\u00dd\u00e4\u00f1\u0115"+
		"\u0133\u0135\u014e\u0167\u0173";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}