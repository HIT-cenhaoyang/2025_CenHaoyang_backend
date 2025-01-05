package com.example;

import com.example.service.CoinCalculatorService;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class CoinCalculatorServiceTest {
    private final CoinCalculatorService service = new CoinCalculatorService();

    @Test
    public void testCalculateMinCoins_Example1() {
        BigDecimal targetAmount = new BigDecimal("7.03");
        List<BigDecimal> denominations = Arrays.asList(
                new BigDecimal("0.01"),
                new BigDecimal("0.5"),
                new BigDecimal("1"),
                new BigDecimal("5"),
                new BigDecimal("10")
        );

        List<BigDecimal> result = service.calculateMinCoins(targetAmount, denominations);

        List<BigDecimal> expected = Arrays.asList(
                new BigDecimal("0.01"),
                new BigDecimal("0.01"),
                new BigDecimal("0.01"),
                new BigDecimal("1"),
                new BigDecimal("1"),
                new BigDecimal("5")
        );

        assertEquals(expected, result);
    }

    @Test
    public void testCalculateMinCoins_Example2() {
        BigDecimal targetAmount = new BigDecimal("103");
        List<BigDecimal> denominations = Arrays.asList(
                new BigDecimal("1"),
                new BigDecimal("2"),
                new BigDecimal("50")
        );

        List<BigDecimal> result = service.calculateMinCoins(targetAmount, denominations);

        List<BigDecimal> expected = Arrays.asList(
                new BigDecimal("1"),
                new BigDecimal("2"),
                new BigDecimal("50"),
                new BigDecimal("50")
        );

        assertEquals(expected, result);
    }
}
