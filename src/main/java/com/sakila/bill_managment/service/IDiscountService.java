package com.sakila.bill_managment.service;

import com.sakila.bill_managment.dto.request.DiscountRequestDTO;
import com.sakila.bill_managment.dto.response.DiscountResponseDTO;

import java.util.List;

public interface IDiscountService {

    DiscountResponseDTO createDiscount(DiscountRequestDTO discountRequestDTO);

    List<DiscountResponseDTO> getAllDiscounts();

    DiscountResponseDTO getDiscountById(Long id);

    DiscountResponseDTO updateDiscount(Long id, DiscountRequestDTO discountRequestDTO);

    void deleteDiscount(Long id);
}
