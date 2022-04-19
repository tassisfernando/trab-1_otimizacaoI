package service;

import enums.MaxMinEnum;
import model.Objetivo;
import model.Response;
import repository.ObjetivoRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ObjetivoService {

    public ObjetivoRepository repository;

    public Objetivo objetivo;

    public ObjetivoService(ObjetivoRepository repository, Objetivo objetivo) {
        this.repository = repository;
        this.objetivo = objetivo;
    }

    public void saveObjetivo(Double varA, Double varB) {
        Double valorObjetivo = objetivo.findValorObjetivo(varA, varB);

        repository.setResponse(valorObjetivo, varA, varB);
    }

    public Response getMaiorMenorObjetivo() {
        List<Response> responses = repository.getResponses();
        if(responses.isEmpty()) {
            return null;
        }

        if(objetivo.getObjetivo().equals(MaxMinEnum.MAX)) {
            return Collections.max(responses, Comparator.comparing(Response::getMaxMinValor));
        }

        return Collections.min(responses, Comparator.comparing(Response::getMaxMinValor));
    }
}
