import java.io.*;
import java.util.Stack;

class MaquinaPilha {
    BufferedReader arquivoEntrada;
    Stack<Integer> pilha = new Stack<>();

    public static void main(String args[]) {
        MaquinaPilha maquinaPilha = new MaquinaPilha();
        
        try {
            maquinaPilha.arquivoEntrada = new BufferedReader(new FileReader(args[0]));
        } catch (Exception e) {
            System.out.println("Erro ao abrir o arquivo \n");
        }

        String linha = "";
        while (true) {
            try {
                linha = maquinaPilha.arquivoEntrada.readLine();
            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo \n");
            }

            if (linha == null) {
                break;
            }

            String[] tokens = linha.split(" ");
            if (tokens[0].equals("SUM")) {
                int numA = maquinaPilha.pilha.pop();
                int numB = maquinaPilha.pilha.pop();
                maquinaPilha.pilha.push(numA + numB);

            } else if (tokens[0].equals("SUB")) {
                int numA = maquinaPilha.pilha.pop();
                int numB = maquinaPilha.pilha.pop();
                maquinaPilha.pilha.push(numB - numA);
                
            } else if (tokens[0].equals("MULT")) {
                int numA = maquinaPilha.pilha.pop();
                int numB = maquinaPilha.pilha.pop();
                maquinaPilha.pilha.push(numA * numB);

            } else if (tokens[0].equals("DIV")) {
                int numA = maquinaPilha.pilha.pop();
                int numB = maquinaPilha.pilha.pop();
                maquinaPilha.pilha.push(numB / numA);

            } else if (tokens[0].equals("PRINT")) {
                System.out.println(maquinaPilha.pilha.pop());

            } else { //PUSH
                maquinaPilha.pilha.push(Integer.parseInt(tokens[1]));
            }
        }
    }
}
