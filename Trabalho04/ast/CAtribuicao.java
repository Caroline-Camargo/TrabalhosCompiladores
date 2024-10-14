package ast;


public class CAtribuicao extends Comando{
	public int linha;
	public String var;
	public Exp exp;
	
	public CAtribuicao(int linha,String var, Exp exp)
	{
	  this.linha = linha;	
	  this.var = var;
	  this.exp = exp;
	} 

	@Override
	public String toStringIndentado(int nivelIndentacao) {
        String indentacaoAtual = "    ".repeat(nivelIndentacao); 
        return indentacaoAtual + var + " = " + exp.toString(); 
    }

}
