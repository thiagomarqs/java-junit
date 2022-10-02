package br.com.alura.tdd.service;

import br.com.alura.tdd.enums.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReajusteServiceTest {

    private final ReajusteService reajusteService = new ReajusteService();

    @Test
    public void readjustmentShouldBeOfThreePercentIfPerformanceLeftMuchToBeDesired() {
        var funcionario = new Funcionario("Mariazinha", LocalDate.now(), new BigDecimal("1000"));
        reajusteService.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void readjustmentShouldBeOfFifteenPercentIfPerformanceIsGood() {
        var funcionario = new Funcionario("Mariazinha", LocalDate.now(), new BigDecimal("1000"));
        reajusteService.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void readjustmentShouldBeOfTwentyPercentIfPerformanceIsGreat() {
        var funcionario = new Funcionario("Mariazinha", LocalDate.now(), new BigDecimal("1000"));
        reajusteService.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }

}
