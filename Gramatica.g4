/**
 * Define a grammar called Gramatica
 */
grammar Gramatica;

@header {
    package br.ufpi.compiladores.semantica;
    import java.util.*;
}

program: 'Prog' ID '{' (declaraVariaveisGlobais| declaraConstantes)* declaraFuncao* comandos* '}'
	;

atribuicao returns [String t]: atriID=ID '=' exprAtri=expressoes {$t = $exprAtri.t;}';'
	;

declaraConstantes returns [String t]: 'Static' tipo ID '=' a=factor {$t=$a.t;} ';'
    ;
        
declaraVariaveisGlobais returns [String t]: tipo a=listaIDs {$t=$a.t;}  ';'
	;

declaraVariaveisLocais returns [String t]: tipo a=listaIDs{$t=$a.t;} ';'
    ;
    
declaraParametros returns [String t]: a=tipo listaIDs {$t=$a.t;} (';' a=tipo listaIDs {$t=$a.t;})* 
	;
	
tipo returns [String t]
    : 'Int' {$t = "int";}
    | 'String'  {$t = "string";}
    | 'Real'    {$t = "real";}
    | 'Bool'{$t = "bool";}
    ;
    
listaIDs returns [String t]: ID (',' ID)*
	;
		
declaraFuncao: tipo ID '(' declaraParametros? ')' '{' declaraVariaveisLocais* comandos* '}' 
	;
	
comandos: bool | atribuicao | leitura | impressao | se | para | enquanto | sair | retorno | chamadaFuncao | declaraFuncao
	;
	
chamadaFuncao returns [String t]: ID '(' listaExpressoes ')' ';'
	|  ID '(' listaExpressoes ')'
	;

se: 'if' '(' ifExprB=bool ')' '{' comandos* '}' senao? 
	;
	
senao: 'else' '{' comandos* '}'
	;
	
para: 'for''(' initVarID=ID '=' intVar=bool 'to' endVar=bool ('step' stepVar=bool)? ')''{' comandos* '}'  
	;
	
enquanto: 'while' '(' whileExprB=bool ')' '{' comandos*  whileIncr=atribuicao'}' 
	;
		
leitura : 'scan' '(' listaIDs ')' ';'
	;

impressao: 'print' '(' listaExpressoes ')' ';'
	;

sair: 'break' ';'
	;
	
expressoes returns [String t]: a = bool{$t = $a.t;};

bool returns [String t]
    : a = bool '||' b = join{$t = "bool";} # Ou
	| a = join {$t = $a.t;} # BoolJoin
	;

join returns [String t]
    : a = join '&&' b = equality {$t = "bool";} # And
	| a = equality {$t = $a.t;} # BoolEquality
	;

equality returns [String t]
    : a = equality '==' b = rel {$t = "bool";} # IgualLog
	| a = equality '!=' b = rel {$t = "bool";} # DifLog
	| a = rel {$t = $a.t;} # BoolRel
	;

rel returns [String t]
    : a = expr '<' b = expr {$t = "bool";} # MenorQ
	| a = expr '<=' b = expr {$t = "bool";} # MenorIq
	| a = expr '>=' b = expr {$t = "bool";} # MaiorIq
	| a = expr '>' b = expr {$t = "bool";} # MaiorQ
	| a = expr {$t = $a.t;} # BoolExpr
	;

expr returns [String t]
    : a = expr '+' b = term # Mais
	| a = expr '-' b = term # Menos
	| a = term {$t=$a.t;} # ExprTerm
    ;

term returns [String t]
    : a = term '^' b = unary # Expo
	| a = term '*' b = unary # Mul
	| a = term '/' b = unary # Div
	| a = unary {$t=$a.t;} # TermUnary ;

unary returns [String t]
    : '!' a = unary {$t = "bool";} # NegLog
    | '-' a = unary {$t = $a.t;} # MenusUna
	| a = factor {$t = $a.t;} # FactorUnary
	;

factor returns [String t]
    : '(' a = bool ')' {$t = $a.t;} # ExprParem
	| ID {$t = "id";} # Variavel
	| INT {$t = "int";} # Inteiro
	| REAL {$t = "real";} # Real
	| STRING {$t = "string";} # String
	| BOOLEANO {$t = "bool";} # BoolTrueOrFalse
	| a = chamadaFuncao {$t = $a.t;} # ChaFuncao
    ;
	
   
listaExpressoes returns [String t]: a = bool {$t = $a.t;} (',' a = bool {$t = $a.t;})*
	;
	
retorno: 'return' '(' expressoes ')' ';'
	;	
	
ID: [a-zA-Z]([a-zA-Z0-9])*	
	;
	
INT: ('+'|'-')?[0-9]+
	;
	
REAL: [0-9]+('.'[0-9]+)?
	;
	
STRING: '"'.*?'"'
	;
	
BOOLEANO : 'TRUE'|'FALSE'
    ;
WS: [ \t\r\n] -> skip
	;
LINE_COMMENT : '//' .*? '\r'? '\n' -> skip 
    ;
COMMENT : '/*' .*? '*/' -> skip
    ;
