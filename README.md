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


### Executando Trabalho 2 e 3

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
