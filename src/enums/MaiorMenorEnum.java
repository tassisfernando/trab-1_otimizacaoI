package enums;

import static java.util.Arrays.stream;

public enum MaiorMenorEnum {
    MENOR_IGUAL(1),
    MENOR(2),
    MAIOR_IGUAL(3),
    MAIOR(4);

    private Integer opcao;

    MaiorMenorEnum(Integer opcao) {
        this.opcao = opcao;
    }

    public static MaiorMenorEnum getMaiorMenorPorOpcao(Integer opcao) {
        return stream(values()).filter(valor -> valor.opcao.equals(opcao)).findFirst().orElse(MENOR_IGUAL);
    }
}
