package com.currancytrading.controller;

import com.currancytrading.documents.Currency;
import com.currancytrading.repository.UserRepository;
import com.currancytrading.service.CurrencyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class CurrencyController {

    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    CurrencyService currencyService;

    @RequestMapping(value = "/getAllCurrency", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllCurrency() {
        logger.trace("Getting all Currency - getAllCurrency()");
        return ResponseEntity.ok(currencyService.getAllCurrency());
    }

    @RequestMapping(value = "/addCurrency", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addCurrency(Currency currency) {
        logger.trace("Adding Currency - addCurrency()");
        return ResponseEntity.ok(currencyService.addCurrency(currency));
    }
}