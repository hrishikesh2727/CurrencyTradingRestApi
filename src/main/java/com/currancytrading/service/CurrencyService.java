package com.currancytrading.service;

import com.currancytrading.documents.Currency;
import com.currancytrading.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;

    public Iterable<Currency> getAllCurrency(){
        return currencyRepository.findAll();
    }

    public Currency addCurrency(Currency currency){
        return currencyRepository.save(currency);
    }
}
