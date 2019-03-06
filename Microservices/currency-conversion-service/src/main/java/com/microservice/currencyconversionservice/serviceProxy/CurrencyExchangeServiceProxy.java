package com.microservice.currencyconversionservice.serviceProxy;

import com.microservice.currencyconversionservice.model.CurrencyConversion;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-exchange-service", url="localhost:8000")
//@FeignClient(name="forex-service")
@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="forex-service")
public interface CurrencyExchangeServiceProxy {
    //@GetMapping("/currency-exchange/from/{from}/to/{to}")
    @GetMapping("/forex-service/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retrieveExchangeValue
    (@PathVariable("from") String from, @PathVariable("to") String to);
}
