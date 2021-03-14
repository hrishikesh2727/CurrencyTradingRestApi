package com.currancytrading.service;

import com.currancytrading.documents.Currency;
import com.currancytrading.documents.CurrencyExchangeHistorical;
import com.currancytrading.repository.CurrencyExchangeHistoricalRepository;
import com.currancytrading.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CurrencyExchangeHistoricalService {

    @Autowired
    CurrencyExchangeHistoricalRepository currencyExchangeHistoricalRepository;

    public Iterable<CurrencyExchangeHistorical> getAllCurrencyExchangeHistory(){
        return currencyExchangeHistoricalRepository.findAll();
    }

    public CurrencyExchangeHistorical addAllCurrencyExchangeHistory(CurrencyExchangeHistorical currencyExchangeHistorical){
        return currencyExchangeHistoricalRepository.save(currencyExchangeHistorical);
    }
}