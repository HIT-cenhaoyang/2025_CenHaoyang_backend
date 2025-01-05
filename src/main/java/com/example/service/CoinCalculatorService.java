package com.example.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoinCalculatorService {
    public List<BigDecimal> calculateMinCoins(BigDecimal targetAmount, List<BigDecimal> denominations) {
        int target = targetAmount.multiply(BigDecimal.valueOf(100)).intValue();
        int[] coins = denominations.stream().mapToInt(d -> d.multiply(BigDecimal.valueOf(100)).intValue()).toArray();
        int[] minCoins = new int[target + 1];
        int[] coinUsed = new int[target + 1];

        for (int i = 1; i <= target; i++) {
            minCoins[i] = Integer.MAX_VALUE;
        }
        minCoins[0] = 0;

        // Find minimal coins
        for (int coin : coins) {
            for (int i = coin; i <= target; i++) {
                if (minCoins[i - coin] != Integer.MAX_VALUE && minCoins[i - coin] + 1 < minCoins[i]) {
                    minCoins[i] = minCoins[i - coin] + 1;
                    coinUsed[i] = coin;
                }
            }
        }

        //
        if (minCoins[target] == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Unable to make exact change with given denominations");
        }

        // Retrieve the coins used
        List<BigDecimal> result = new ArrayList<>();
        for (int i = target; i > 0; i -= coinUsed[i]) {
            result.add(BigDecimal.valueOf(coinUsed[i]).divide(BigDecimal.valueOf(100)));
        }

        Collections.sort(result);
        return result;
    }
}