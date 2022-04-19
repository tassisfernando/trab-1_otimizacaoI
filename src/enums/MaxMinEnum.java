package enums;

import java.util.Arrays;

import static java.util.Arrays.stream;

public enum MaxMinEnum {
    MAX("máximo", 1),
    MIN("mínimo", 2);

    private String objetivo;
    private Integer opcao;

    MaxMinEnum(String objetivo, Integer opcao) {
        this.objetivo = objetivo;
        this.opcao = opcao;
    }

    public static boolean verificaOpcao(Integer opcao) {
        return Arrays.stream(values()).anyMatch(t -> t.opcao.equals(opcao));
    }

    public static MaxMinEnum getMaxMinPorOpcao(Integer opcao) {
        return stream(values()).filter(valor -> valor.opcao.equals(opcao)).findFirst().orElse(MAX);
    }
}
