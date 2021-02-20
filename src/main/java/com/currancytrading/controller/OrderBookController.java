package com.currancytrading.controller;

import com.currancytrading.documents.OrderBook;
import com.currancytrading.documents.User;
import com.currancytrading.service.OrderBookService;
import com.currancytrading.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("api/currency-trading")
public class OrderBookController {

    @Autowired
    OrderBookService orderBookService;

    @RequestMapping(value = "/getAllOrderBook", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllOrders(){
        return ResponseEntity.ok(orderBookService.getAllOrders());
    }

    @RequestMapping(value = "/addOrderBook", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> AddOrder(@RequestBody OrderBook orderBook){
        return ResponseEntity.ok(orderBookService.addOrderBook(orderBook));
    }
}