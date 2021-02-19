package com.currancytrading.repository;

import com.currancytrading.documents.User;
import org.springframework.data.couchbase.core.query.N1qlSecondaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@ViewIndexed(designDoc="user")
@N1qlSecondaryIndexed(indexName="userSecondaryIndex")
public interface UserRepository extends CrudRepository<User, String> {

    Iterable<User> findDistinctUserByUserNameOrPassword(String userName, String password);
    Iterable<User> findByuserName(String userName);
    Iterable<User> findByEmail(String email);

    /*@Query("Select meta().id as id, username from  #{#n1ql.bucket} where #{#n1ql.filter} " +
            " and userName = $1 and password = $2")*/
    @Query("#{#n1ql.selectEntity} WHERE #{#n1ql.filter} AND #{[0]} = $2")
    Iterable<User> findUsersByDynamicCriteria(String criteriaField, Object criteriaValue);

    Iterable<User> findByuserNameAndPassword(String userName, String password);

}