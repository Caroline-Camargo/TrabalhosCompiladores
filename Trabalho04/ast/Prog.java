package ast;

import java.util.ArrayList;

public class Prog{
    public Main main;
    public ArrayList<Fun> fun;
    public Prog(Main main, ArrayList<Fun> fun)
    {
        this.main = main;
        this.fun = fun;
    }

    @Override
    public String toString() {
        String str = "";
        
        for (int i = 0; i < fun.size(); i++) {
            str += fun.get(i).toString() + "\n"; 
        }

        str += main.toString(); 

        return str; 
    }
}

