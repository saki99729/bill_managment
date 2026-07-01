package com.sakila.bill_managment.modal;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "batch")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Batch {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "batch_name", nullable = false)
    private String batchName;

    @Column(name = "batch_number", nullable = false)
    private String batchNumber;

    @Column(name = "bar_code_value", nullable = false)
    private String barCode;

    @Column(name = "qr_code_value", nullable = false)
    private String qrCode;

    @Column(name="total_price",nullable = false)
    private double totalPrice;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "manufacture_date",nullable = false)
    private Date manufactureDate;

    @Column(name = "expiry_date",nullable = false)
    private Date expiryDate;

    @Column(name = "created_at",nullable = false)
    private Date createdAt;

    @Column(name = "updated_at",nullable = false)
    private Date updatedAt;

    @Column(name = "created_by",nullable = false)
    private int createdBy;

    @Column(name = "updated_by",nullable = false)
    private int updatedBy;
}
