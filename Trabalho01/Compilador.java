import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.print.DocFlavor.STRING;

class Compilador{

	public static void main(String[]args)
	{	
		ArvoreSintatica arv=null;
	
		try{

			AnaliseLexica al = new AnaliseLexica(args[0]);
			Parser as = new Parser(al);
		
			arv = as.parseProg();
		
			int opBackEnd = 0; // 0 = Compilador, 1 = Interpretador
			if (opBackEnd == 0) 
			{
				CodeGen backend = new CodeGen();
				String codigo = backend.geraCodigo(arv);
				System.out.println(codigo);

				try (BufferedWriter writer = new BufferedWriter(new FileWriter("saidaCompilador.txt"))) {
					writer.write(codigo);
				} catch (IOException e) {
					System.out.println("Erro ao escrever no arquivo");
				}
			}
			else
			{
				Interpretador interpretador = new Interpretador();
				int resultado = interpretador.interpretador(arv);
				System.out.println("Resultado: " + resultado);
			}
			
		} catch(Exception e)
		{			
			System.out.println("Erro de compilação:\n" + e);
		}



	}
}
