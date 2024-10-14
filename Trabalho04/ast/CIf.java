package ast;

import java.util.ArrayList;

public class CIf extends Comando{
	public int linha;
	public Exp exp;
	public ArrayList<Comando> bloco;
	
	public CIf(int linha, Exp exp, ArrayList<Comando> bloco)
	{
	  this.linha = linha;
	  this.exp = exp;
	  this.bloco = bloco;
	} 

	@Override
    public String toStringIndentado(int nivelIndentacao) {
        String indentacaoAtual = "    ".repeat(nivelIndentacao);
        String result = indentacaoAtual + "if " + exp.toString() + ":\n"; 

        for (int i = 0; i < bloco.size(); i++) {
            result += bloco.get(i).toStringIndentado(nivelIndentacao + 1); 
            if (i < bloco.size() - 1) {
                result += "\n";
            }
        }

        return result; 
    }

}
