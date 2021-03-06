package ru.milov.shoptest.entity;

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

    @ManyToOne
    private User user;

    @Column(name = "name")
    private String name;

    @Column(name = "vendor_code")
    private String vendorCode;

    @Column(name = "value")
    private BigDecimal value;

    @Column(name = "deleting_sign")
    private boolean deletingSign;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "shipment", joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private List<Shipment> Shipments;



}
