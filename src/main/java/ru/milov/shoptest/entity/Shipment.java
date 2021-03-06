package ru.milov.shoptest.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode
@Accessors(chain = true)
@Table(name = "shipment")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Product product;

    @Column(name = "barcode")
    private String barcode;

    @Column(name = "weight")
    private BigDecimal weight;

    @ElementCollection(targetClass = Measure.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "measure", joinColumns = @JoinColumn(name = "measure_id"))
    @Enumerated(EnumType.STRING)
    private Set<Measure> measures;
}
