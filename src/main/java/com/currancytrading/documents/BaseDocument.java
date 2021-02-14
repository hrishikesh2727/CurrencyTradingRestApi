package com.currancytrading.documents;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import java.util.Date;

@Document
@Getter
@Setter
public class BaseDocument {

    @Field
    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    private String  id;

    @Field
    private boolean isDelete;

    @Field
    @CreatedBy
    private String createdUserId;

    @Field
    @LastModifiedBy
    private String modifiedUserId;

    @Field
    @CreatedDate
    private Date createdTimestamp;

    @Field
    @LastModifiedDate
    private Date modifiedTimestamp;

    @Version
    private long version;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(String createdUserId) {
        this.createdUserId = createdUserId;
    }

    public String getModifiedUserId() {
        return modifiedUserId;
    }

    public void setModifiedUserId(String modifiedUserId) {
        this.modifiedUserId = modifiedUserId;
    }

    public Date getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Date createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public Date getModifiedTimestamp() {
        return modifiedTimestamp;
    }

    public void setModifiedTimestamp(Date modifiedTimestamp) {
        this.modifiedTimestamp = modifiedTimestamp;
    }
}
