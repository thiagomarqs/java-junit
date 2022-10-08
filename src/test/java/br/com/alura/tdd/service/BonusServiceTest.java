package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    private final BonusService bonusService = new BonusService();
    private final Funcionario funcionario = new Funcionario("Teste", LocalDate.now(), null);

    @Test
    void bonusShouldBeZeroIfEmployeeHasSalaryTooHigh() {
        funcionario.setSalario(new BigDecimal("11000"));
        assertThrows(IllegalArgumentException.class, () -> bonusService.calcularBonus(funcionario));
    }

    @Test
    void bonusShouldBeZeroIfEmployeeHasSalaryOfZero() {
        funcionario.setSalario(new BigDecimal("0"));
        var bonus = bonusService.calcularBonus(funcionario);
        assertEquals(new BigDecimal("0.0"), bonus);
    }

    @Test
    void bonusShouldBeNegativeIfProvidedSalaryIsNegative() {
        funcionario.setSalario(new BigDecimal("-10000"));
        var bonus = bonusService.calcularBonus(funcionario);
        assertEquals(new BigDecimal("-1000.0"), bonus);
    }

    @Test
    void bonusShouldBeOneThousandIfSalaryIsEqualToTenThousand() {
        funcionario.setSalario(new BigDecimal("10000"));
        var bonus = bonusService.calcularBonus(funcionario);
        assertEquals(new BigDecimal("1000.0"), bonus);
    }

    @Test
    void bonusShouldBeTenPercent() {
        funcionario.setSalario(new BigDecimal("2500"));
        var bonus = bonusService.calcularBonus(funcionario);
        assertEquals(new BigDecimal("250.0"), bonus);
    }

}