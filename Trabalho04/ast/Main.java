package ast;

import java.util.ArrayList;

public class Main{

	public ArrayList<VarDecl> vars;
	public ArrayList<Comando> coms;
	
	public Main(ArrayList<VarDecl> vars,ArrayList<Comando> coms)
	{
		this.vars = vars;
		this.coms = coms;
	}

	@Override
    public String toString() {
        String str = "";

		for (int i = 0; i < vars.size(); i++) {
			str += vars.get(i).toString() + "\n"; 
		}
		
		for (int i = 0; i < coms.size(); i++) {
			str += coms.get(i).toStringIndentado(0) + "\n";
		}

        return str; 
    }

}
