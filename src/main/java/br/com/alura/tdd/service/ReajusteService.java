package br.com.alura.tdd.service;

import br.com.alura.tdd.enums.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ReajusteService {
    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
        Double porcentagemReajuste = obterPorcentagemReajuste(desempenho);
        BigDecimal novoSalario = calcularSalarioReajustado(funcionario.getSalario(), porcentagemReajuste);
        funcionario.setSalario(novoSalario);
    }

    private Double obterPorcentagemReajuste(Desempenho desempenho) {
        switch (desempenho) {
            case A_DESEJAR: return 0.03;
            case BOM: return 0.15;
            case OTIMO: return 0.20;
            default: return 0.0;
        }
    }

    private BigDecimal calcularSalarioReajustado(BigDecimal salario, Double porcentagemReajuste) {
        return salario.multiply(new BigDecimal(1 + porcentagemReajuste)).setScale(2, RoundingMode.HALF_UP);
    }

}
