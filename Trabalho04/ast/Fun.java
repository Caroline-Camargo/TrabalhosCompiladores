package ast;

import java.util.ArrayList;

public class Fun{
	public String nome;
	public ArrayList<ParamFormalFun> params;
	public String retorno;
	public ArrayList<VarDecl> vars;
	public ArrayList<Comando> body;
	
	public Fun(String nome,ArrayList<ParamFormalFun> params, String retorno,ArrayList<VarDecl> vars,ArrayList<Comando> body)
	{
		this.nome = nome;
		this.params = params;
		this.retorno = retorno;
		this.vars = vars;
		this.body = body;
	}

	@Override
    public String toString() {
        String result = "def " + nome + "(";

        for (int i = 0; i < params.size(); i++) {
            result += params.get(i).toString(); 
            if (i < params.size() - 1) {
                result += ", "; 
            }
        }

        result += ")";

        if (retorno != null && !retorno.isEmpty()) {
            result += " -> " + retorno;
        }

        result += ":\n";

		for (int i = 0; i < vars.size(); i++) {
			result += "    " + vars.get(i).toString() + "\n";
		}

		for (int i = 0; i < body.size(); i++) {
			result += "    " + body.get(i).toStringIndentado(0) + "\n";
		}

        return result; 
    }
}
