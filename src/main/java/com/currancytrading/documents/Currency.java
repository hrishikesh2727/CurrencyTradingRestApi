package com.currancytrading.documents;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;


@Document
@Getter
@Setter
public class Currency extends BaseDocument {

    @Field
    private String currencyName;

    @Field
    private String currencyCode;

    @Field
    private String currencyDescription;

    @Field
    private String currencyRate;
}