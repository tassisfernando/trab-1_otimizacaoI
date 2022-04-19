package repository;

import model.Response;

import java.util.ArrayList;
import java.util.List;

public class ObjetivoRepository {

    private List<Response> responses;

    public ObjetivoRepository() {
        this.responses = new ArrayList<>();
    }

    public List<Response> getResponses() {
        return responses;
    }

    public void setResponse(Double maxMinValor, Double x, Double y) {
        this.responses.add(new Response(maxMinValor, x, y));
    }
}
