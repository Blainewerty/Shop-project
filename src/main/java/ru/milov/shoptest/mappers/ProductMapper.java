package ru.milov.shoptest.mappers;

import org.mapstruct.Mapper;
import ru.milov.shoptest.dto.ProductDto;
import ru.milov.shoptest.entity.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto toDto(Product product);
}
