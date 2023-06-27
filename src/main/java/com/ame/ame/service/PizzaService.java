package com.ame.ame.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ame.ame.domain.Pizza;
import com.ame.ame.exception.PizzaAlreadyExistException;
import com.ame.ame.mapper.PizzaMapper;
import com.ame.ame.repository.PizzaRepository;
import com.ame.ame.requests.PizzaPostRequestbody;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PizzaService {
    private final PizzaRepository pizzaRepository;

    public Pizza save(PizzaPostRequestbody pizza) {
        if (pizzaRepository.findByName(pizza.getName()) != null) {
            throw new PizzaAlreadyExistException("Pizza with this name already exist");
        }
        return pizzaRepository.save(PizzaMapper.INSTANCE.toPizza(pizza));
    }

    public List<Pizza> listAll() {
        return pizzaRepository.findAll();
    }
}
