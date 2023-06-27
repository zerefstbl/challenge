package com.ame.ame.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class PizzaDetailReponse {

  private Long id;

  private String pizza;

  private String price;
}
