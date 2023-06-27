package com.ame.ame.requests;

import java.util.List;

import com.ame.ame.domain.Pizza;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@Setter
@AllArgsConstructor
public class OrderDetailReponse {

  private Long id;

  private List<PizzaDetailReponse> pizzas;

  private String total;
}
