package com.currancytrading.service;


import com.currancytrading.documents.OrderBook;
import com.currancytrading.repository.OrderBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderBookService {

    @Autowired
    OrderBookRepository orderBookRepository;

    public Iterable<OrderBook> getAllOrders(){
        return orderBookRepository.findAll();
    }

    public OrderBook addOrderBook(OrderBook orderBook){
        return orderBookRepository.save(orderBook);
    }
}
