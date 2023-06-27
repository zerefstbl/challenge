package com.ame.ame.requests;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class OrderPostRequestBody {
    @NotEmpty(message = "The pizza cannot be empty")
    private List<String> pizzas;

}
