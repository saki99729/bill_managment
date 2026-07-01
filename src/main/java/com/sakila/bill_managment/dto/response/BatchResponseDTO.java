package com.sakila.bill_managment.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatchResponseDTO {

    private Long id;
    private String batchName;
    private String batchNumber;
    private String barCode;
    private String qrCode;
    private double totalPrice;
    private int quantity;
    private Date manufactureDate;
    private Date expiryDate;
    private Date createdAt;
    private Date updatedAt;
    private int createdBy;
    private int updatedBy;
}
