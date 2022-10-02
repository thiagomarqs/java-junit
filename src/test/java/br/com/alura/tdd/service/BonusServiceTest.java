package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    private final BonusService bonusService = new BonusService();

    @Test
    void bonusShouldBeZeroIfEmployeeHasSalaryTooHigh() {
        Funcionario f = new Funcionario("Teste", LocalDate.now(), new BigDecimal("11000"));
        var bonus = bonusService.calcularBonus(f);
        assertEquals(BigDecimal.ZERO, bonus);
    }

    @Test
    void bonusShouldBeZeroIfEmployeeHasSalaryOfZero() {
        Funcionario f = new Funcionario("Teste", LocalDate.now(), new BigDecimal("0"));
        var bonus = bonusService.calcularBonus(f);
        assertEquals(new BigDecimal("0.0"), bonus);
    }

    @Test
    void bonusShouldBeNegativeIfProvidedSalaryIsNegative() {
        Funcionario f = new Funcionario("Teste", LocalDate.now(), new BigDecimal("-10000"));
        var bonus = bonusService.calcularBonus(f);
        assertEquals(new BigDecimal("-1000.0"), bonus);
    }

    @Test
    void bonusShouldBeOneThousandIfSalaryIsEqualToTenThousand() {
        Funcionario f = new Funcionario("Teste", LocalDate.now(), new BigDecimal("10000"));
        var bonus = bonusService.calcularBonus(f);
        assertEquals(new BigDecimal("1000.0"), bonus);
    }

    @Test
    void bonusShouldBeTenPercent() {
        Funcionario f = new Funcionario("Teste", LocalDate.now(), new BigDecimal("2500"));
        var bonus = bonusService.calcularBonus(f);
        assertEquals(new BigDecimal("250.0"), bonus);
    }

}