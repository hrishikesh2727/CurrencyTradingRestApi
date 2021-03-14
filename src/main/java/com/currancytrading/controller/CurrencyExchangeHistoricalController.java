package com.currancytrading.controller;

import com.currancytrading.documents.Currency;
import com.currancytrading.documents.CurrencyExchangeHistorical;
import com.currancytrading.service.CurrencyExchangeHistoricalService;
import com.currancytrading.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api/currency-trading")
public class CurrencyExchangeHistoricalController {

    @Autowired
    CurrencyExchangeHistoricalService currencyExchangeHistoricalService;

    @RequestMapping(value = "/getAllCurrencyExchangeHistorical", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllCurrency() {
        return ResponseEntity.ok(currencyExchangeHistoricalService.getAllCurrencyExchangeHistory());
    }

    @RequestMapping(value = "/addCurrencyExchangeHistorical", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addCurrency(CurrencyExchangeHistorical currencyExchangeHistorical) {
        return ResponseEntity.ok(currencyExchangeHistoricalService.addAllCurrencyExchangeHistory(currencyExchangeHistorical));
    }
}