package com.ame.ame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ame.ame.domain.Pizza;
import com.ame.ame.domain.PizzaOrder;

@Repository
public interface PizzaOrderRepository extends JpaRepository<PizzaOrder, Long> {

}
