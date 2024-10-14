package ast;

import java.util.ArrayList;

public class CChamadaFun extends Comando{
	public int linha;
	public String fun;
	public ArrayList<Exp> args;
	
	public CChamadaFun(int linha,String fun, ArrayList<Exp> args)
	{
	  this.linha = linha;
	  this.fun = fun;
	  this.args = args;
	} 

    @Override
    public String toStringIndentado(int nivelIndentacao) {
        String indentacaoAtual = "    ".repeat(nivelIndentacao);
        String result = indentacaoAtual + fun + "(";

        for (int i = 0; i < args.size(); i++) {
            result += args.get(i).toString(); 

            if (i < args.size() - 1) {
                result += ", ";
            }
        }

        result += ")";
        return result;
    }
}
