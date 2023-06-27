package com.ame.ame.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ame.ame.domain.Pizza;
import com.ame.ame.domain.PizzaOrder;
import com.ame.ame.exception.BadRequestException;
import com.ame.ame.repository.PizzaOrderRepository;
import com.ame.ame.repository.PizzaRepository;
import com.ame.ame.requests.OrderDetailReponse;
import com.ame.ame.requests.OrderPostRequestBody;
import com.ame.ame.requests.PizzaDetailReponse;
import com.ame.ame.utils.FormatNumberToPrice;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor
@Log4j2
public class OrderService {
    private final PizzaOrderRepository pizzaOrderRepository;
    private final PizzaRepository pizzaRepository;

    public String teste(String pizza) {
        log.info(pizza);
        return pizza;
    }

    public void save(OrderPostRequestBody order) {
        log.info(order);

        List<Pizza> listPizzas = order.getPizzas().stream().map(pizzaRepository::findByName)
                .collect(Collectors.toList());

        log.info(listPizzas);

        double total = listPizzas.stream().mapToDouble(Pizza::getPrice).sum();

        PizzaOrder pizzaOrder = new PizzaOrder();
        pizzaOrder.setPizzas(listPizzas);
        pizzaOrder.setTotal(total);
        pizzaOrderRepository.save(pizzaOrder);
    }

    public OrderDetailReponse orderDetails(Long id) {
        PizzaOrder pizza = pizzaOrderRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Order with this id does not exist"));

        log.info(pizza);

        List<PizzaDetailReponse> pizzas = pizza.getPizzas().stream().map(
                p -> new PizzaDetailReponse(p.getId(), p.getName(),
                        FormatNumberToPrice.formatterPrice(p.getPrice())))
                .collect(Collectors.toList());

        return new OrderDetailReponse(
                pizza.getId(),
                pizzas,
                FormatNumberToPrice.formatterPrice(pizza.getTotal()));
    }
}
