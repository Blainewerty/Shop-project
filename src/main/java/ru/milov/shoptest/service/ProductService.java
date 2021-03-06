package ru.milov.shoptest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.milov.shoptest.dto.ProductDto;
import ru.milov.shoptest.mappers.ProductMapper;
import ru.milov.shoptest.repository.ProductRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService{

    private final ProductRepository productRepository;

    public List<ProductDto> findAll() {
        return productRepository.findAll().stream()
                .map(ProductMapper.INSTANCE::toDto).collect(Collectors.toList());
    }
}
