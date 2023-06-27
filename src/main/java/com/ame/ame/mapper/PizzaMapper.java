package com.ame.ame.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ame.ame.domain.Pizza;
import com.ame.ame.requests.PizzaPostRequestbody;

@Mapper(componentModel = "spring")
public abstract class PizzaMapper {
    public static final PizzaMapper INSTANCE = Mappers.getMapper(PizzaMapper.class);

    public abstract Pizza toPizza(PizzaPostRequestbody pizzaPostRequestBody);
}
