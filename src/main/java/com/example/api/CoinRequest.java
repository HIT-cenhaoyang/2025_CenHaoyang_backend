package com.example.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;

import java.math.BigDecimal;
import java.util.List;

public class CoinRequest {
    @JsonProperty
    @DecimalMin(value = "0.0", message = "Target amount must be greater than or equal to 0")
    @DecimalMax(value = "10000.00", message = "Target amount must be less than or equal to 10000.00")
    private BigDecimal targetAmount;

    @JsonProperty
    private List<BigDecimal> coinDenominations;

    public BigDecimal getTargetAmount() {
        return targetAmount;
    }

    public List<BigDecimal> getCoinDenominations() {
        return coinDenominations;
    }
}