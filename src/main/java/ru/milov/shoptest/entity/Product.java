package ru.milov.shoptest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.function.Consumer;

@Data
@Entity
@EqualsAndHashCode
@Accessors(chain = true)
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    private User user;

    @Column(name = "name")
    private String name;

    @Column(name = "vendor_code")
    private String vendorCode;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "deleting_sign")
    private boolean deletingSign;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "shipment", joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private List<Shipment> Shipments;



}
