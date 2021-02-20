package com.currancytrading.repository;



import com.currancytrading.documents.OrderBook;
import org.springframework.data.repository.CrudRepository;

public interface OrderBookRepository extends CrudRepository<OrderBook, String> {

}
