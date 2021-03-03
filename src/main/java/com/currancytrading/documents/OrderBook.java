package com.currancytrading.documents;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Document
@Getter
@Setter
public class OrderBook extends BaseDocument {

    @Field
    private String currencyName;

    @Field
    private String currentRate;

    @Field
    private String position;

    @Field
    private String unit;

    @Field
    private String totalAmount;

    @Field
    private String endAction;

    @Field
    private String orderAction;
}
