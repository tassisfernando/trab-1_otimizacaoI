package service;

import model.Restricao;
import java.util.List;

public class RestricaoService {

    public List<Restricao> restricoes;

    public RestricaoService(List<Restricao> restricoes) {
        this.restricoes = restricoes;
    }

    public boolean verificaRestricoes(Double varA, Double varB) {
        if(restricoes != null && !restricoes.isEmpty()) {
            for(Restricao restricao : restricoes) {
                if(!verificaRestricao(restricao, varA, varB)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean verificaRestricao(Restricao restricao, Double varA, Double varB) {
        return restricao.verifica(varA, varB);
    }
}
