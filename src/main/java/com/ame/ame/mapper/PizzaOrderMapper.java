package com.ame.ame.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ame.ame.domain.PizzaOrder;
import com.ame.ame.requests.OrderSaveRequestBody;

@Mapper(componentModel = "spring")
public abstract class PizzaOrderMapper {
    public static final PizzaOrderMapper INSTANCE = Mappers.getMapper(PizzaOrderMapper.class);

    public abstract PizzaOrder toPizzaOrder(OrderSaveRequestBody orderSaveRequestBody);

}
