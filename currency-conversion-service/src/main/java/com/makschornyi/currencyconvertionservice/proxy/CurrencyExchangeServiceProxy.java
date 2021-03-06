package com.makschornyi.currencyconvertionservice.proxy;

import com.makschornyi.currencyconvertionservice.model.CurrencyConversionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
//@FeignClient("currency-exchange-service")
@FeignClient("netflix-zuul-api-gateway-service")
@RibbonClient("currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

//    @GetMapping("/exchange-currency/from/{from}/to/{to}")
    @GetMapping("/currency-exchange-service/exchange-currency/from/{from}/to/{to}")
    CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
