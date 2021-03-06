package ru.milov.shoptest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.milov.shoptest.dto.ProductDto;
import ru.milov.shoptest.entity.Product;
import ru.milov.shoptest.entity.User;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByVendorCode(String vendorCode);

    @Query(value = "update product set deleting_sign = true where vendor_code = ?", nativeQuery = true)
    void delete(String vendorCode);

    Product findByName(String name);

    List<Product> findByUser(User user);
}
