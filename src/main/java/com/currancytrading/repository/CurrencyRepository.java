package com.currancytrading.repository;

import com.currancytrading.documents.Currency;
import com.currancytrading.documents.User;
import org.springframework.data.couchbase.core.query.N1qlSecondaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@ViewIndexed(designDoc="currency")
@N1qlSecondaryIndexed(indexName="currencySecondaryIndex")
public interface CurrencyRepository extends CrudRepository<Currency, String> {

}