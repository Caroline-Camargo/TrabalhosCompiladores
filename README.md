# TrabalhosCompiladores
Trabalhos práticos elaborados na disciplina de Projeto de Compiladores


## Comando de Execução

*OBS*: Os comandos devem ser executados dentro da pasta do trabalho

## Trabalho 1
#### Descrição
1. A implementação atual do compilador didático aceita apenas números com um único
dígito. Modificar o compilador para que ele aceite também números naturais com mais
de um dígito
2. A implementação atual do compilador didático aceita apenas as operações de soma e
multiplicação. Modifique o compilador para que aceite também subtração e divisão.
Para essas operações, gerar as instruções SUB e DIV.
3. O compilador didático possui um back-end que gera código para uma máquina de pilha
hipotética:

    CodeGen backend = new CodeGen();
    String codigo = backend.geraCodigo(arv);
   
   O back-end recebe como entrada a árvore sintática e percorre essa árvore gerando código
para uma máquina de pilha. Substituir o back-end desse compilador por um back-end
interpretador, ou seja, ao invés de gerar uma String com código para ser executado na
máquina de pilha, o back-end já devolve o resultado da computação da expressão de
entrada.
4. Implementar em Java, uma máquina de pilha que execute as instruções geradas pelo
compilador didático. A máquina de pilha deve receber como entrada um arquivo texto
com as instruções e devolver como saída o resultado final da execução dessas instruções.
A classe principal deve se chamar MaquinaPilha. Ex:
    ~$ java MaquinaPilha arquivoDeEntrada

### Executando Trabalho 1
Remover arquivos .class:
    
    rm *.class
    

1. Compile os arquivos Java:
    ```
    javac *.java
    ```    

2. Execute o compilador:
    ```
    java Compilador teste
    ```

3. Execute a máquina de pilha:
    ```
    java MaquinaPilha saidaCompilador.txt
    ```

## Trabalho 2
#### Descrição
O objetivo do trabalho é implementar um analisador léxico para a Linguagem Karloff
usando a ferramenta javacc. O aluno deve usar a gramática da linguagem Karloff (que
está disponível em arquivo separado no e-aula) como referência para os possíveis tokens
da linguagem.
Além da implementação do analisador léxico em javacc, o aluno deve também fornecer
2 exemplos novos de programas escritos em Karloff (extensão .kar).

## Trabalho 3
#### Descrição
O objetivo do trabalho é implementar um parser (Analisador Sintático) para a linguagem Karloff. O parser deve ser construído em cima do analisador léxico proposto para a
mesma linguagem no trabalho anterior. Lembrando que o Javacc não aceita recursão à esquerda nem alternativas começando com um mesmo símbolo, dessa forma, essas construções devem ser eliminadas da gramática caso existam. Os alunos devem entregar também dois exemplos de programas que usem uma grande parte das construções sintáticas disponíveis na linguagem.

#### Fatoração e eliminação da recursão a esquerda - Karloff

    KARLOFF -> MAIN FUNC?
    MAIN -> "void" "main" "(" ")" "{" VARDECL SEQCOMANDOS "}"
    
    VARDECL -> "newVar" TIPO TOKEN_id ";" *
    
    TIPO -> "float" | "boolean" | "void"
    
    SEQCOMANDOS -> COMANDO *
    
    COMANDO -> TOKEN_id COMANDO’
    | "if" EXP "then" "{" SEQCOMANDOS "}" ";"
    | "while" EXP "{" SEQCOMANDOS "}" ";"
    | "return" EXP ";" 
    | "printOut" EXP ";"
    
    COMANDO’ -> "=" COMANDO’’ | "(" LISTAEXP? ")" ";" 
    COMANDO’’ -> EXP ";" | readInput "(" ")"
    
    EXP -> "(" EXP OP EXP ")" | FATOR
    
    FATOR -> TOKEN_id FATOR’ | TOKEN_numliteral | "true" | "false"
    FATOR’ -> "(" LISTAEXP? ")" | epsilon
    
    OP -> "+" | "-" | "*" | "/" | "&" | "|" | "<" | ">" | "=="
    
    LISTAEXP -> EXP LISTAEXP’
    LISTAEXP’ -> "," EXP LISTAEXP’ | epsilon
    
    FUNC -> "fun" TIPO TOKEN_id "(" LISTAARG? ")" "{" VARDECL SEQCOMANDOS "}"  FUNC’ 
    FUNC’ -> "fun" TIPO TOKEN_id "(" LISTAARG? ")" "{" VARDECL SEQCOMANDOS "}"  FUNC’ |  epsilon
    
    LISTAARG -> TIPO TOKEN_id LISTAARG’
    LISTAARG’ -> "," TIPO TOKEN_id LISTAARG’ |  epsilon
    
    TOKEN_id -> letra letraoudigito* finalsublinhado*

    TOKEN_numliteral -> digitos facao_opcional expoente_opcional

## Trabalho 3
#### Descrição 
O objetivo do trabalho é implementar um compilador para a Linguagem Karloff, usando tradução dirigida por sintaxe, na ferramenta Javacc. Para realizar esta tarefa, o aluno deve adicionar ações semânticas às regras sintáticas já implementadas em Javacc, para que seja gerada uma árvore sintática do programa Karloff sendo compilado. Em seguida, o programa deve percorrer a árvore sintática gerando código (em qualquer linguagem), semanticamente equivalente ao código Karloff original.

Classes a serem usadas para a árvore sintática:

    classe Prog: representa um programa. Possuí dois atributos: main (o programa principal) e fun (um array de definições de funções)
    
    classe Main: representa o main de um programa. Possuí dois atributos vars (um array de declaração de variáveis) e coms (um array de comandos)
    
    classe VarDecl: representa uma declaração de variável. Possuí dois atributos type (o tipo da variável) e var (a variável sendo declarada)
    
    classe Comando: superclasse de todos os comandos
    
    classe CAtribuicao: representa o comando de atribuição. Possuí dois atributos: var a variável sendo atribuída e exp a expressão sendo atribuída a variável)
    
    classe CChamadaFun: representa uma chamada de função. Possuí dois atributos: fun (a função sendo chamada) e args (os argumentos a serem passados para a função)
    
    classe CIf: representa o comando if. Possuí dois atributos: exp (representa a expressão booleana) e bloco (um array de comandos representando o bloco do then)
    
    classe CPrint: representa o comando de imprimir na saída padrão. Possuí 1 atributo exp, que é a expressão a ser imprimida na tela
    
    classe CReadInput: representa o comando para ler da entrada padrão. Possuí 1 atributo var que é a variável onde será atribuido o valor lido
    
    classe CReturn: representa o comando return. Possuí 1 atributo exp que é a expressão sendo retornada classe CWhile: representa o comando while. Possuí 2 atributos: exp que é a expressão booleana do while e bloco que é o bloco a ser executado pelo while (um ArrayList de comandos)
    
    classe Exp: superclasse de todas as expressões
    
    classe EChamadaFun: representa uma expressão que é uma chamada de função. Possuí dois atributos: fun (a função sendo chamada) e args (que são os argumentos sendo passados para função)
    
    classe EFalse: representa uma expressão que é o valor false
    
    Classe ETrue: representa uma expressão que é o valor true
    
    classe EFloat: representa uma expressão que é um float. Possuí um atributo value que é o valor do float
    
    classe EOpExp: representa uma expressão que é uma operação usando uma operador. Possuí 3 atributos: op (o operador), arg1 (o primeiro argumento) e arg2 (o segundo argumento)
    
    classe EVar: representa uma expressão que é uma variável. Possuí 1 atributo var, a variável
    
    classe Fun: representa uma função. Possuí 5 atributos: nome (o nome da função), params (um array list com os parâmetros declarados para a função), retorno (o tipo de retorno da função), vars (as variáveis declaradas no corpo da função) e body (o corpo da função)
    
    classe ParamFormalFun: contém a declaração de 1 parâmetro de uma função. Possuí 2 atributos var (o nome da variável) e type (o tipo da variável)


### Executando Trabalho 2, 3 e 4

*OBS*: Executar comandos dentro da pasta do Karloff

Remover arquivos .class e .java:  

    
    rm *.class
    rm *.java

1. Gere o parser com o JavaCC:

    ```
    java -cp javacc.jar javacc Karloff.jj
    ```    

2. Compile os arquivos Java:

    ```
    javac *.java
    ```

3. Execute o parser:

    ```
    java Karloff exemplo_1.kar
    ```
