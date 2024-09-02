# TrabalhosCompiladores
Trabalhos práticos elaborados na disciplina de Projeto de Compiladores


## Comando de Execução

*OBS*: Os comandos devem ser executados dentro da pasta do trabalho

### Trabalho 1

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


### Trabalho 2 e Trabalho 3

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