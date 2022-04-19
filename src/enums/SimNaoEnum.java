package enums;

import java.util.Arrays;

public enum SimNaoEnum {

    SIM(1),
    NAO(2);

    private Integer opcao;

    SimNaoEnum(Integer opcao) {
        this.opcao = opcao;
    }

    public static boolean verificaOpcao(Integer opcao) {
        return Arrays.stream(values()).anyMatch(t -> t.opcao.equals(opcao));
    }

    @Override
    public String toString() {
        return opcao.toString();
    }
}
