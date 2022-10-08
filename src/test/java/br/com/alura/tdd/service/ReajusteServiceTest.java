package br.com.alura.tdd.service;

import br.com.alura.tdd.enums.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReajusteServiceTest {

    private final ReajusteService reajusteService = new ReajusteService();
    private Funcionario funcionario;

    @BeforeEach
    public void initialize() {
         this.funcionario = new Funcionario("Mariazinha", LocalDate.now(), new BigDecimal("1000"));
    }

    @Test
    public void readjustmentShouldBeOfThreePercentIfPerformanceLeftMuchToBeDesired() {
        reajusteService.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void readjustmentShouldBeOfFifteenPercentIfPerformanceIsGood() {
        reajusteService.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void readjustmentShouldBeOfTwentyPercentIfPerformanceIsGreat() {
        reajusteService.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }

}
