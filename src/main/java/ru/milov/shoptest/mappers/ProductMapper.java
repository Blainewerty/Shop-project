package ru.milov.shoptest.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.milov.shoptest.dto.ProductDto;
import ru.milov.shoptest.entity.Product;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto toDto(Product product);
}
