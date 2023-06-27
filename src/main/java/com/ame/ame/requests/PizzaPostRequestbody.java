package com.ame.ame.requests;

import lombok.Data;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Data
public class PizzaPostRequestbody {
    @NotEmpty(message = "The pizza name cannot be empty")
    private String name;

    @NotNull(message = "The pizza price cannot be empty")
    private Double price;
}
