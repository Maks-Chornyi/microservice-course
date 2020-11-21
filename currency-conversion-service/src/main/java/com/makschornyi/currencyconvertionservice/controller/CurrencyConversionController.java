package com.makschornyi.currencyconvertionservice.controller;

import com.makschornyi.currencyconvertionservice.model.CurrencyConversionBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convert(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://localhost:8000/exchange-currency/from/{from}/to/{to}";
        Map<String, String> params = new HashMap<>();
        params.put("from", from);
        params.put("to", to);

        CurrencyConversionBean response = restTemplate.getForEntity(fooResourceUrl, CurrencyConversionBean.class, params).getBody();


        return new CurrencyConversionBean(
                response.getId(),
                from,
                to,
                response.getConversionMultiple(),
                quantity,
                quantity.multiply(response.getConversionMultiple()),
                response.getPort());
    }
}
