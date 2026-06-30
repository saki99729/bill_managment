package com.sakila.bill_managment.modal;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.annotation.Id;

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

    @NotNull
    @Column(name = "batch_name", nullable = false)
    private String batchName;

    @NotNull
    @Column(name = "batch_number", nullable = false)
    private String batchNumber;

    @NotNull
    @Column(name = "bar_code_value", nullable = false)
    private String barCode;

    @NotNull
    @Column(name = "qr_code_value", nullable = false)
    private String qrCode;

    @NotNull
    @Column(name="total_price",nullable = false)
    private double totalPrice;

    @NotNull
    @Column(name = "quantity", nullable = false)
    private int quantity;

    @NotNull
    @Column(name = "manufacture_date",nullable = false)
    private Date manufactureDate;

    @NotNull
    @Column(name = "expiry_date",nullable = false)
    private Date expiryDate;

    @NotNull
    @Column(name = "created_at",nullable = false)
    private Date createdAt;

    @NotNull
    @Column(name = "updated_at",nullable = false)
    private Date updatedAt;

    @NotNull
    @Column(name = "created_by",nullable = false)
    private int createdBy;

    @NotNull
    @Column(name = "updated_by",nullable = false)
    private int updatedBy;
}
