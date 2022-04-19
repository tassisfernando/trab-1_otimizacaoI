package main;

import enums.MaiorMenorEnum;
import enums.MaxMinEnum;
import model.Objetivo;
import model.Response;
import model.Restricao;
import repository.ObjetivoRepository;
import service.ObjetivoService;
import service.RestricaoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static enums.SimNaoEnum.SIM;
import static util.Constants.*;

public class Main {
    private static final Scanner scn = new Scanner(System.in);
    private static ObjetivoService objetivoService;
    private static RestricaoService restricaoService;

    private static Double coefA;
    private static Double coefB;
    private static MaxMinEnum objetivoMod;
    private static List<Restricao> restricoes;

    public static void main(String[] args) {
        System.out.println("-------------PROGRAMAÇÃO LINEAR - MAX/MIN DE UM MODELO-------------\n\n");
        preencheObjetivoModelo();
        preencheRestricoesModelo();

        Objetivo objetivo = new Objetivo(coefA, coefB, objetivoMod, restricoes);
        objetivoService = new ObjetivoService(new ObjetivoRepository(), objetivo);
        restricaoService = new RestricaoService(restricoes);

        calculaRestricoes();

        Response response = objetivoService.getMaiorMenorObjetivo();

        System.out.println("-------------------------------------------------------------------\n");

        if(response == null) {
            System.out.println("O modelo não possui solução!");
        } else {
            System.out.printf("O valor de %s do modelo é %s, no ponto (%s, %s) %n",
                    objetivo.getObjetivo(),
                    response.getMaxMinValor(),
                    response.getX(),
                    response.getY()
            );
        }
    }

    private static void calculaRestricoes() {
        for(Double x = ZERO; x < MAX_VALUE_X; x += PASSO) {
            for (Double y = ZERO; y < MAX_VALUE_Y; y += PASSO) {
                if (restricaoService.verificaRestricoes(x, y)) {
                    objetivoService.saveObjetivo(x, y);
                }
            }
        }
    }

    private static void preencheObjetivoModelo() {
        System.out.println("Informando o modelo: L = A * x1 + B * x2\n");

        System.out.println("\nA = ");
        coefA = scn.nextDouble();

        System.out.println("\nB = ");
        coefB = scn.nextDouble();

        System.out.println("Objetivo: \n1 -> Max \n2 -> Min");
        Integer opcaoMaxMin = scn.nextInt();

        while(!MaxMinEnum.verificaOpcao(opcaoMaxMin)) {
            System.out.println("Informe um valor válido!");
            System.out.println("Objetivo: \n1 -> Max \n 2 -> Min");
            opcaoMaxMin = scn.nextInt();
        }

        objetivoMod = MaxMinEnum.getMaxMinPorOpcao(opcaoMaxMin);
    }

    private static void preencheRestricoesModelo() {
        System.out.println("Informando as restrições do tipo: C * x1 + D * x2 (<=, <, >=, >) E \n");
        restricoes = new ArrayList<>();

        System.out.println("\nC = ");
        Double coefC = scn.nextDouble();

        System.out.println("\nD = ");
        Double coefD = scn.nextDouble();

        System.out.println("Condição da restrição: ");
        System.out.println("\n1 - Menor ou igual (<=): ");
        System.out.println("\n2 - Menor que (<): ");
        System.out.println("\n3 - Maior ou igual (>=): ");
        System.out.println("\n4 - Maior que (>): ");
        Integer opcaoRestricao = scn.nextInt();
        MaiorMenorEnum opcaoRestricaoEnum = MaiorMenorEnum.getMaiorMenorPorOpcao(opcaoRestricao);

        System.out.println("\nValor da restrição E = ");
        Double valorE = scn.nextDouble();

        restricoes.add(new Restricao(coefC, coefD, valorE, opcaoRestricaoEnum));

        System.out.println("Deseja inserir outra restrição? (máximo 3) \n1- Sim / 2 - Não");
        Integer nextRestricao = scn.nextInt();

        while(nextRestricao.equals(Integer.valueOf(SIM.toString())) && restricoes.size() < MAX_RESTRICOES) {
            System.out.println("\nC = ");
            coefC = scn.nextDouble();

            System.out.println("\nD = ");
            coefD = scn.nextDouble();

            System.out.println("Condição da restrição: ");
            System.out.println("\n1 - Menor ou igual (<=): ");
            System.out.println("\n2 - Menor que (<): ");
            System.out.println("\n3 - Maior ou igual (>=): ");
            System.out.println("\n4 - Maior que (>): ");
            opcaoRestricao = scn.nextInt();
            opcaoRestricaoEnum = MaiorMenorEnum.getMaiorMenorPorOpcao(opcaoRestricao);

            System.out.println("\nValor da restrição E = ");
            valorE = scn.nextDouble();

            restricoes.add(new Restricao(coefC, coefD, valorE, opcaoRestricaoEnum));

            System.out.println("Deseja inserir outra restrição? (máximo 3) \n 1- Sim / 2 - Não");
            nextRestricao = scn.nextInt();
        }
    }
}
