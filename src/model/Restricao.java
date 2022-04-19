package model;

import enums.MaiorMenorEnum;

public class Restricao {
    private final Double coefA;
    private final Double coefB;
    private final Double valor;
    private final MaiorMenorEnum maiorMenor;

    public Restricao(Double coefA, Double coefB, Double valor, MaiorMenorEnum maiorMenor) {
        this.coefA = coefA;
        this.coefB = coefB;
        this.valor = valor;
        this.maiorMenor = maiorMenor;
    }

    public boolean verifica(Double varA, Double varB) {
        Double result = findResult(varA, varB);

        switch (maiorMenor) {
            case MAIOR:
                return result > valor;
            case MENOR:
                return result < valor;
            case MAIOR_IGUAL:
                return result >= valor;
            case MENOR_IGUAL:
                return result <= valor;
        }
        return true;
    }

    private Double findResult(Double varA, Double varB) {
        return (varA * coefA) + (varB * coefB);
    }
}
