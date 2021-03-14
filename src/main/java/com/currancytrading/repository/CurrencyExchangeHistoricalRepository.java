package com.currancytrading.repository;

import com.currancytrading.documents.Currency;
import com.currancytrading.documents.CurrencyExchangeHistorical;
import org.springframework.data.couchbase.core.query.N1qlSecondaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.repository.CrudRepository;


@ViewIndexed(designDoc="CurrencyExchangeHistorical")
@N1qlSecondaryIndexed(indexName="currencySecondaryIndex")
public interface CurrencyExchangeHistoricalRepository extends CrudRepository<CurrencyExchangeHistorical, String> {

}