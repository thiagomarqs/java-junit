package br.com.alura.tdd.enums;

import java.math.BigDecimal;

public enum Desempenho {
    A_DESEJAR {
        public BigDecimal obterPorcentagemReajuste() {
            return new BigDecimal("0.03");
        }
    },
    BOM {
        public BigDecimal obterPorcentagemReajuste() {
            return new BigDecimal("0.15");
        }
    },
    OTIMO {
        public BigDecimal obterPorcentagemReajuste() {
            return new BigDecimal("0.20");
        }
    };

    public abstract BigDecimal obterPorcentagemReajuste();
}
