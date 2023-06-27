package com.ame.ame.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ame.ame.requests.OrderDetailReponse;
import com.ame.ame.requests.OrderPostRequestBody;
import com.ame.ame.service.OrderService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<String> newOrder(@RequestBody @Valid OrderPostRequestBody orderPostRequestBody) {
        orderService.save(orderPostRequestBody);
        return new ResponseEntity<>("PO", HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<OrderDetailReponse> getOrderDetails(@PathVariable long id) {
        return ResponseEntity.ok(orderService.orderDetails(id));
    }
}
