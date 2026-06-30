package com.sakila.bill_managment.modal;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "discount")
public class Discount {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "batch_id")
    private Batch batchId;

    @Column(name = "discount_percentage", nullable = false)
    private double discountPercentage;

    @Column(name = "amount", nullable = false)
    private double amount;
}
