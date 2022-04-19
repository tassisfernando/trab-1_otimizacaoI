package model;

import enums.MaxMinEnum;

import java.util.List;

public class Objetivo {
    private Double coefA;
    private Double coefB;
    private MaxMinEnum objetivo;
    private List<Restricao> restricoes;

    public Objetivo(Double coefA, Double coefB, MaxMinEnum objetivo, List<Restricao> restricoes) {
        this.coefA = coefA;
        this.coefB = coefB;
        this.objetivo = objetivo;
        this.restricoes = restricoes;
    }

    public Double findValorObjetivo(Double varA, Double varB) {
        return coefA * varA + coefB * varB;
    }

    public MaxMinEnum getObjetivo() {
        return objetivo;
    }
}
