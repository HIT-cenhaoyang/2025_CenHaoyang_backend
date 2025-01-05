package com.example.resource;

import com.example.api.CoinRequest;
import com.example.service.CoinCalculatorService;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.math.BigDecimal;
import java.util.List;

@Path("/coins")
@Produces(MediaType.APPLICATION_JSON)
public class CoinCalculatorResource {
    private final CoinCalculatorService service;

    public CoinCalculatorResource(CoinCalculatorService service) {
        this.service = service;
    }

    @POST
    @Path("/calculate")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<BigDecimal> calculateMinCoins(@Valid CoinRequest request) {
        return service.calculateMinCoins(request.getTargetAmount(), request.getCoinDenominations());
    }
}