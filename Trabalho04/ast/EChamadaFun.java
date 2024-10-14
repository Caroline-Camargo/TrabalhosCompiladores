package ast;

import java.util.ArrayList;

public class EChamadaFun extends Exp{
	public String fun;
	public ArrayList<Exp> args;
	
	public EChamadaFun(String fun, ArrayList<Exp> args)
	{
	  this.fun = fun;
	  this.args = args;
	} 

	@Override
    public String toString() {
        String result = fun + "("; 

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
