package com.makschornyi.currencyexchangeservice.controller;

import com.makschornyi.currencyexchangeservice.model.ExchangeValue;
import com.makschornyi.currencyexchangeservice.repository.ExchangeValueRepository;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Objects;

@RestController
public class CurrencyExchangeController {

    private final Environment environment;
    private final ExchangeValueRepository exchangeValueRepository;

    public CurrencyExchangeController(Environment environment, ExchangeValueRepository exchangeValueRepository) {
        this.environment = environment;
        this.exchangeValueRepository = exchangeValueRepository;
    }

    @GetMapping("/exchange-currency/from/{from}/to/{to}")
    public ExchangeValue exchangeValue(@PathVariable String from, @PathVariable String to) {
        ExchangeValue exchangeValue = exchangeValueRepository.findByFromAndTo(from, to);
        exchangeValue.setPort(Integer.parseInt(Objects.requireNonNull(environment.getProperty("local.server.port"))));
        return exchangeValue;
    }
}
