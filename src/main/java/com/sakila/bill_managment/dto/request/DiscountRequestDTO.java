package com.sakila.bill_managment.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscountRequestDTO {

    private Long batchId;
    private double discountPercentage;
    private double amount;
}
