# Compilador Java Simplificado

JAVA Simplificado é sensível em relação a letras maiúsculas e minúsculas nos nomes das variáveis, funções, procedimentos e palavras reservadas. (i.e. NÃO se pode utilizar “varIAble” ou “VARIABLE” ou “VaRiAbLe” para a variável/função “variable”). A linguagem não deve suportar declarações aninhadas de funções, mas pode conter várias chamadas a funções aninhadas. A linguagem possui funções built-in, utilizadas para realizar IO (print e scan) de usuário através do console, que serão a única forma de se comunicar com o mundo exterior.
Nenhuma característica de outra linguagem deve ser reconhecida pelo compilador.
## Tipos e operadores
JAVA Simplificado é fortemente tipada e dá suporte aos seguintes tipos: Int, Real, String e Bool. Os operadores disponíveis na linguagem são:
* ‘!’: negação, inverte o valor booleano ao qual foi aplicada – unário;
* ‘&&’: AND lógico – binário;
* ‘||’: OR lógico – binário;
* ‘+’: soma – binário;
* ‘-‘: subtração – binário;
* ‘*’: multiplicação – binário;
* ‘/’: divisão inteira – binário;
* ‘^’: exponencial – binário;
* ‘==’: comparação, checa se os operadores são iguais – binário;
* ‘!=’: comparação, checa se os operadores são diferentes – binário;
* ‘>=’: maior ou igual que – binário;
* ‘<=’: menor ou igual que – binário;
* ‘>’: maior que – binário;
* ‘<’: menor que – binário;
## Precedência de operadores
1. Quando dois operadores diferentes forem utilizados ao mesmo tempo, o operador de maior precedência será avaliado primeiro;
1. Operadores de mesma precedência serão avaliados da esquerda para a direita;
1. É possível forçar a precedência de uma operação, colocando-a entre parênteses.
A tabela a seguir apresenta a hierarquia de precedência dos operadores (decrescente decima para baixo), os tipos dos operandos aos quais podem ser aplicados e o tipo do retorno:
### Tabela 1. Precedência de operadores.
Operador|Aridade|Tipos aplicados|Tipo de retorno
----------------|----------------|----------------|----------------
! | 1 | Booleano | boleano
\- | 1 | Inteiro e real | inteiro ou real
\^ | 2 | Inteiro e real | inteiro ou real
\* e \/ | 2 | Inteiro e real | inteiro ou real
\+ e \- | 2 | Inteiro e real | inteiro ou real
\=\=, \!\= | 2 | Booleano, inteiro, real e string | boleano
\>\=, \<\=, \> e \< | 2 | Booleano, inteiro e real | boleano
\&& | 2 | Booleano | boleano
\|\| | 2 | Booleano | boleano
## Identificadores
São os nomes utilizados para identificar variáveis e funções no programa. Identificadores podem ter qualquer tamanho maior que zero e devem obrigatoriamente começar com uma letra. Após isso, podem conter qualquer letra ou digito.
Dentro do mesmo escopo, variáveis não podem ter o mesmo nome de outras variáveis, ou funções. Identificadores nunca podem ter o mesmo nome de uma palavra reservada da linguagem (if, while, for, etc.).
##Variáveis e Constantes
Variáveis são posições de memória que guardarão dados do programa. Em JAVA Simplificado, toda variável tem o tipo definido na sua declaração, que não poderá ser alterado.
Para declarar uma variável, atribui-se um tipo a um identificador válido. O valor padrão da variável definida desta forma será 0 (zero) para inteiros e reais, FALSO para as variáveis do tipo booleano e string vazia para strings.
##Sintaxe de declaração:
```<tipo> <lista_de_identificadores> ;```
Ex:
```Int int1, Int1;
String string1, string2, string3;
Bool boolean1;
Real R1;
```
Como se pode observar, declarações sequenciais são permitidas, em uma mesma linha,porém apenas quando as variáveis forem de um mesmo tipo.Os valores devem ser atribuídos depois da declaração das variáveis. Para isso deve-se usar a atribuição ‘=’. Strings devem estar entre aspas duplas, como pode ser visto nos exemplos abaixo.
Ex:
```
String stringTeste;
...
stringTeste = “Teste”;
```
## Constantes
Constantes são identificadores que armazenam valores fixos em um programa. Em JAVA Simplificado, toda constante tem o tipo e o valor definido na sua declaração, que não poderão ser alterados. Para declarar uma constante, atribui-se um tipo a um identificador válido e o valor da constante da seguinte maneira.
Sintaxe de declaração:
```
‘Static’ <tipo> <identificador> ‘=’ <valor>;
```
Ex:
```
Static Int MAX = 100;
Static String ifes=”UFPI”;
Static Real PI=3.14158;
```
## Escopo das variáveis e constantes
Variáveis podem ser:
1. Locais: conhecidas somente no bloco da função em que foram declaradas e devem
ser declaradas no início do bloco.
1. Globais: conhecidas por todo o programa e devem ser declaradas no início do
programa.

Erros de compilação devem ser gerados caso uma variável seja declarada após o início do bloco ou após o início do programa. Constantes só podem ser globais.
## Funções
Funções têm um nome, uma lista de parâmetros e um tipo de retorno. Nenhuma função poderá ter o mesmo nome que outra função, variável ou constante global, independente da sua assinatura. Funções podem ser chamados recursivamente, criando um contexto novo para suas variáveis locais. Possuem uma lista com zero ou mais parâmetros e todo parâmetro é passado por valor.
Para definir o valor a ser retornado, utiliza-se o comando ‘return’.
Sintaxe de declaração (função):
```
<tipo_retorno> <nome_funcao> ( <lista_parametros> ) {
[<declaração_variaveis>]
...
return (<valor_retorno>);
...
}
```
A lista de parâmetros deve ser declarada de acordo com o a sintaxe:
```
<tipo_param1> <params>; <tipo_param2> <params>; ...
```
EX:
```
Int Soma() { } // Sintaxe da função sem parâmetros
Real media(Real a, b) {
  return((a+b)/2);
}
Bool testaCoisas(Int tipo; String msg; Real n1, n2) {
  if (tipo == 0) {
    print(msg);
    return(TRUE);
  } else {
    print(n1 + n2);
    return(FALSE);
  }
  }
```
## Funções nativas
O compilador deverá reconhecer previamente um conjunto de procedimentos nativos para implementação de IO do usuário.
### PRINT
Envia saída para o console. A cada chamada também é enviada uma quebra de linha,exceto entre os itens de print (lista de expressões). A lista de expressões deve ser separada por vírgulas.
Sintaxe de chamada:
```
print (<lista_expressao>);
```
Ex:
```
print (“Hello ”, “World!”);
print (“A + B = ”, 1+1);
```
Saída:
Hello World
A + B = 2
### SCAN
Requisita a entrada de números inteiros, reais e strings a partir do teclado. O valor fornecido é armazenado na variável passada na chamada do comando scan. A lista de variáveis deve ser especificada de forma similar à lista de expressões do comando print.
O comando scan pára a execução do programa até que o usuário digite um valor para a variável (o valor é confirmado após pressionar a tecla “<Enter>”).
Sintaxe de chamada:
```
scan (<lista_variaveis>);
```
Ex:
```
print(“Digite um número”);
scan(n1);
print(“Digite dois números”);
scan(b, c);
print(“n1 = ”, n1, “ b = ”, b, “ c = ”, c);
```
Saída:
Digite um número
?1
Digite dois números
?2 3
n1 = 1 b = 2 c = 3
## Comandos de controle
O compilador deve reconhecer os seguintes comandos de controle de execução: IF-ELSE, FOR e WHILE. O uso de colchetes nas descrições de sintaxe indica que o termo é opcional.
### IF-ELSE
Sintaxe:
```
if (<teste_logico>){
...
} else {
...
}
```
### FOR
Sintaxe:
```
for (<identificador> = <valorInicial> to <valorFinal>
[step <incremento>]){
...
[break;]
...
}
```
Em caso de omissão do step o incremento é igual a 1. Podem existir decrementos (por exemplo: -1, -5, ...). As tags <valorInicial> e <valorFinal> podem ser variáveis, constantes ou expressões inteiras. O comando break (opcional) interrompe a iteração do laço e transfere o controle para o final da construção do FOR.
### WHILE
Sintaxe (WHILE):
```
while (<teste_logico>) {
…
[break;]
…
}
```
O comando break funciona do mesmo modo que o break do comando FOR – transferindo o controle para o final da construção de loop.
## Programa
Todo programa começa com a declaração Prog seguida do nome do programa e um abre chaves {. Um programa é composto por zero ou mais declarações de variáveis ou constantes globais, zero ou mais declarações de funções e um bloco principal com início
logo depois do bloco de funções seguido de um fecha chaves }. Todo programa deve ser escrito em um arquivo de texto sem formatação com a extensão
“.jav”.
Ex:
```
Prog Testes{
    Static Real PI=3.14158;
    Real num1,num2,num3,num4,num5,num6,num7;
    Int nu1,nu2,nu3,nu4,nu5,nu6,count,count1,count2,count3,count4;
    Bool b1,b2,b3,b4,b5,b6;
    String str1,str2,str3,str4,str5,str6,str7,str8;
    num1 = 1.0;
    num2 = 2.0;
    num3 = 3.0;
    num5 = 5.0;
    nu2 = 2;
    nu3 = 3;
    nu4 = 4;
    nu5 = 5;
    count = 1;
    count1 = count;
    count2 = 10;
    count3 = 1;
    count4 = -1;
    b1 = TRUE;
    b2 = FALSE;
    b3 = TRUE;
    b4 = FALSE;
    str1 = "test";
    str2 = "test2";
    str3 = "test3";
    str4 = "test4";
    str6 = "test";
    str7 = "test";
    
    
    
   //Atribuicao
    nu1 = nu2 + nu3; //Atribuição correta.
    nu1 = nu2 - nu3; //Atribuição correta.
    nu1 = nu2 / nu3; //Atribuição correta.
    nu1 = nu2 * nu3; //Atribuição correta.


  //Somas
   nu1 = nu2 + nu3 + nu4; //Soma correta.
   nu1 = nu2 + nu3 + nu2; //Soma correta.
   nu1 = (nu2 + nu3) + (nu4 + nu5) ; //Soma correta.
   num4 = (num1  +  num2) + num5; //Soma correta.
      
   //Subtrações
   nu1 = nu2 - nu3 - nu4 ; //Subtração correta.
   nu1 = nu2 - nu3 - nu2; //Subtração correta.
   nu1 = (nu2 - nu3) - (nu4 - nu5) ; //Subtração correta.
   num4 = (num1  -  num2) - num5; //Subtração correta.

   
    //Multiplicação
   nu1 = (nu2 * nu3) * nu4; //Multiplicação correta.
   nu1 = (nu2 * nu3) * (nu4 * nu5); //Multiplicação correta.
   num4 = (num1  *  num2) * num5;//Multiplicação correta.
 
   
    //Divisão
   nu1 = (nu2 / nu3) / nu4; //Divisão correta.
   nu1 = (nu2 / nu3) / (nu4 / nu5); //Divisão correta.
   num4 = (num1  /  num2) / num5;//Divisão correta.
   
    //Exponenciação
   nu1 = (nu2 ^ nu3) ^ nu4; //Exponenciação correta.
   nu1 = (nu2 ^ nu3) ^ (nu4 ^ nu5); //Exponenciação correta.
   num4 = (num1  ^  num2) ^ num5;//Exponenciação correta.
      
    //Menus unário
   nu1 = (-nu4); //Menus unário correto.
   num1 = ((-num5)); //Menus unário correto.
   num1 = -((-num5)); //Menus unário correto.
   num1 = -(-(-num5)); //Menus unário correto.
   
    //Operações logicas
    b5 = num3 > num2; //MaiorQ correto.
    
    b5 = num3 >= num2;//MaiorIq correto.
    
    b5 = num3 < num2;//MenorQ correto.
    
    b5 = num3 <= num2;//MenorIq correto.
    
    b5 = b1 == b2; //Igualdade correto.
    
    b5 = num2 == num3;//Igualdade correto.
    
    b5 = nu3 == nu4;//Igualdade correto.
    
    b5 = str1 == str2;//Igualdade correto.
   
    b5 = b1 != b2;//DifLog correto.
   
    b5 = num2 != num3;//DifLog correto.
    
    b5 = nu3 != nu4;//DifLog correta.
    
    b5 = str1 != str2;//DifLog correto.
    
    b5 = !b3;//NegLog correto.
    
    //Operações diversas.
    
    nu1 = nu2 / nu2 + nu3;
    nu1 = nu2 / nu2 * nu3;
    nu1 = nu2 ^ nu2 + nu3;
    nu1 = nu2 - nu2 ^ nu3;
    nu1 = nu2 - nu2 + nu3;
    nu1 = nu2 * nu2 + nu3;
    nu1 = nu2 / nu2 ^ nu3;
    nu1 = nu2 * nu2 / nu3;

    nu1 = nu2 / nu2 + nu3 - nu4;
    nu1 = nu2 / nu2 * nu3 + nu4;
    nu1 = nu2 ^ nu2 + nu3 ^ nu4;
    nu1 = nu2 - nu2 ^ nu3 + nu4;
    nu1 = nu2 - nu2 + nu3 /  nu4;
    nu1 = nu2 * nu2 + nu3 / nu4;
    nu1 = nu2 / nu2 ^ nu3  * nu4;
    nu1 = nu2 * nu2 / nu3 - nu4;

    nu1 = nu2 / nu2 + (nu3 - nu4);
    nu1 = nu2 / nu2 * nu3 + nu4;
    nu1 = (nu2 ^ nu2 + nu3) ^ nu4;
    nu1 = nu2 - nu2 ^ nu3 + nu4;
    nu1 = nu2 - nu2 + (nu3 /  nu4);
    nu1 = nu2 * nu2 + nu3 / nu4;
    nu1 = nu2 / nu2 ^ (nu3  * nu4);
    nu1 = nu2 * (nu2 / nu3) - nu4;

   
    

    print(b1);
    
    print(nu2);
     
    print(nu2,nu3,str3,num3);
    
    
    
    //Leitura
    
    scan(nu2);//Scan correto.
    
    scan(num3,num4);//Scan correto.
    
    scan(b3, str1); //Scan correto.
    
    
   
    //Ifs
   if(TRUE){
    
    nu4 = nu3 - nu2;
    
    }

   if(FALSE){
    
    nu4 = nu3 - nu2;
    
    }
   

    
    if(nu3 > nu2){
    
    nu4 = nu3 - nu2;
    
    }
    
   if(nu2 > nu3){
    
    nu4 = nu3 - nu2;
    
    }
 
 
   
    if(nu3 >= nu2){
    
    nu4 = nu3 - nu2;
    
    }else{
    
    nu4 = nu3 - nu2;
    
    }
    
   if(nu2 < nu3){
    
    nu4 = nu3 - nu2;
    
    }else{
    
    nu4 = nu3 + nu2;
    
    }
    
    if(nu2 <= nu3){
    
    nu4 = nu3 - nu2;
    
    }else{
    
    nu4 = nu3 + nu2;
    
    }
    
    if(nu2 == nu2){
    
    nu4 = nu3 - nu2;
    
    }else{
    
    nu4 = nu3 + nu2;
    
    }
    
   if(nu2 == nu3){
    
    nu4 = nu3 - nu2;
    
    }else{
    
    nu4 = nu3 + nu2;
    
    }
   
    if(nu2 != nu3){
    
    nu4 = nu3 - nu2;
    
    }else{
    
    nu4 = nu3 + nu2;
    
    }

    if(nu2 != nu2){
    
    nu4 = nu3 - nu2;
    
    }else{
    
    nu4 = nu3 + nu2;
    
    }


            
    //Whiles
    
    while(nu2 < nu5){
    
    nu2 = nu2 + count;
    }
    
    while(nu2 <= nu5){
    nu2 = nu2 + count;    
    }
    
    while(nu5 > nu2){
        nu2 = nu2 + count;
    }
    
   while(nu5 >=  nu2){
        nu2 = nu2 + count;
    }
 
   
    //Fors
    for(count1 = 0 to count2 step count3){
        nu2 = nu2 + count;
        print(nu2);    
    }
    
    for(count1 = 10 to count3 step count4){
            nu2 = nu2 + count;
            print(nu2);
    }
    
    
    for(count1 = 10 to count3 step count4){
    
    }
    
    
    //Funções
    Real media1(Real a, b) {
    }
    
   
    String media2(Real a, b; Int c,d) {
    }
    
    Int media3(Real a, b;Int c,d;String str) {
    }
    
    Bool media4(Real a, b;Int c,d; String str;Bool b) {
    }
    
    Real media6(Real a,b){
       return(a + b);
    }
    
   
    Real media7(Real a,b){
     return(a - b);
    }
    
   Real media8(Real a,b){
     return(a / b);
    }
    
   Real media9(Real a,b){
     return(a * b);
    }
    
   Real media10(Real a,b){
     return(a ^ b);
    }
    
   Bool media11(Real a,b){
     return(a > b);
    }
    
   Bool media12(Real a,b){
     return(a < b);
    }
    
   Bool media13(Real a,b){
     return(a >= b);
    }
    
   Bool media14(Real a,b){
     return(a <= b);
    }
    
   Bool media15(Bool a,b){
     return(a || b);
    }
    
   Bool media16(Bool a,b){
     return(a && b);
    }       

   Int media17(Int a,b){
     return((nu2 + nu2) / nu2);
    }
    
    Int media18(){
     return((nu2 * nu2) / nu2);
    }
    
    Int media19(Int a, b){
    Int c4;
    c4 = 2;
    }
    
    Int media199(Int a, b){
    Int c;
    c = 2;
     return((a + b) / c);
    }
    
    Int media20(Int a, b){
    Int c22,c32;
    c22 = 2;
    c32 = (a + b) / c22;
     return(c32);
    }
    
    Int media21(Int a, b){
    Int c2,c3;
    c2 = 2;
    c3 = (a + b) / c2;
         return(c3);
    }
    /*
    //Chamadas de funções.
    
    media19(nu2,nu2);//Chamada correta.
    
    */
}

```
