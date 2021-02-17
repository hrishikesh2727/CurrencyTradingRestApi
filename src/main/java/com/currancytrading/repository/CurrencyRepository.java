package com.currancytrading.repository;

import com.currancytrading.documents.Currency;
import org.springframework.data.couchbase.core.query.N1qlSecondaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.repository.CrudRepository;

@ViewIndexed(designDoc="currency")
@N1qlSecondaryIndexed(indexName="currencySecondaryIndex")
public interface CurrencyRepository extends CrudRepository<Currency, String> {

}