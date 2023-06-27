package com.ame.ame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ame.ame.domain.Pizza;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    Pizza findByName(String name);

    List<Pizza> findByNameIn(List<String> pizzas);
}
