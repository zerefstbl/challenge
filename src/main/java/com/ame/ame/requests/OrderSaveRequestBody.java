package com.ame.ame.requests;

import java.util.List;

import com.ame.ame.domain.Pizza;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class OrderSaveRequestBody {
    @NotEmpty(message = "The pizza cannot be empty")
    private List<Pizza> pizza;

}