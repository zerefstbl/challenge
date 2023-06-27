package com.ame.ame.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ame.ame.domain.Pizza;
import com.ame.ame.requests.PizzaPostRequestbody;
import com.ame.ame.service.PizzaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("pizzas")
@RequiredArgsConstructor
public class PizzaController {
    private final PizzaService pizzaService;

    @PostMapping
    public ResponseEntity<Pizza> newPizza(@RequestBody @Valid PizzaPostRequestbody pizzaPostRequestbody) {
        return new ResponseEntity<Pizza>(pizzaService.save(pizzaPostRequestbody), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Pizza>> listAll() {
        return ResponseEntity.ok(pizzaService.listAll());
    }
}
