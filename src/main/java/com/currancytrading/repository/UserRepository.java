package com.currancytrading.repository;

import com.currancytrading.documents.User;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.N1qlSecondaryIndexed;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@N1qlPrimaryIndexed
@N1qlSecondaryIndexed(indexName = "User")
public interface UserRepository extends CrudRepository<User, String> {

    Optional<User> findDistinctUserByUserNameOrPassword(String userName, String password);
    List<User> findByuserName(String userName);

    /*@Query("Select meta().id as id, username from  #{#n1ql.bucket} where #{#n1ql.filter} " +
            " and userName = $1 and password = $2")*/
    @Query("#{#n1ql.selectEntity} WHERE #{#n1ql.filter} AND #{[0]} = $2")
    public Optional<User> findUsersByDynamicCriteria(String criteriaField, Object criteriaValue);

    Optional<User> findByuserNameAndPassword(String userName, String password);

}