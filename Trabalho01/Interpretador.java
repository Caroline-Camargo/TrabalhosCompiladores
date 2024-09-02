class Interpretador {

    int interpretador(ArvoreSintatica arv) {
        return interpretador2(arv);
    }

    int interpretador2(ArvoreSintatica arv) {
        if (arv instanceof Mult) {
            return interpretador2(((Mult) arv).arg1) * interpretador2(((Mult) arv).arg2);
        }

        if (arv instanceof Div) {
            return interpretador2(((Div) arv).arg1) / interpretador2(((Div) arv).arg2);
        }

        if (arv instanceof Soma) {
            return interpretador2(((Soma) arv).arg1) + interpretador2(((Soma) arv).arg2);
        }

        if (arv instanceof Sub) {
            return interpretador2(((Sub) arv).arg1) - interpretador2(((Sub) arv).arg2);
        }

        if (arv instanceof Num) {
            return ((Num) arv).num;
        }

		System.out.println("Erro no interpretador!");
        return 0;
    }
}
