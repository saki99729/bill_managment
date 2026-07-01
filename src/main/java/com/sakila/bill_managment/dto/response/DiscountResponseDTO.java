package com.sakila.bill_managment.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscountResponseDTO {

    private Long id;
    private BatchResponseDTO batch;
    private double discountPercentage;
    private double amount;
}
