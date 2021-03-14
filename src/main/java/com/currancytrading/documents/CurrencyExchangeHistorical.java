package com.currancytrading.documents;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import java.util.List;

@Document
@Getter
@Setter
public class CurrencyExchangeHistorical extends BaseDocument {

    @Field
    private String currencyExchange;
    /*
    private String currencyExchange;
    //private List<HistoricalData> historicalData;

    public String getCurrencyExchange() {
        return currencyExchange;
    }

    public void setCurrencyExchange(String currencyExchange) {
        this.currencyExchange = currencyExchange;
    }


    public List<HistoricalData> getHistoricalData() {
        return historicalData;
    }

    public void setHistoricalData(List<HistoricalData> historicalData) {
        this.historicalData = historicalData;
    }*/
}

/*
@Document
@Getter
@Setter
class HistoricalData extends BaseDocument
{
    private  String years;
    private List<CurrencyRate> currencysRate;

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public List<CurrencyRate> getCurrencysRate() {
        return currencysRate;
    }

    public void setCurrencysRate(List<CurrencyRate> currencysRate) {
        this.currencysRate = currencysRate;
    }
}

@Document
@Getter
@Setter
class CurrencyRate extends BaseDocument{
    private String rate;

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
*/