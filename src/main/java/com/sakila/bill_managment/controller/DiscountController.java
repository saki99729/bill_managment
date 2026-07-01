package com.sakila.bill_managment.controller;

import com.sakila.bill_managment.dto.request.DiscountRequestDTO;
import com.sakila.bill_managment.dto.response.DiscountResponseDTO;
import com.sakila.bill_managment.service.IDiscountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discounts")
public class DiscountController {

    private final IDiscountService discountService;

    public DiscountController(IDiscountService discountService) {
        this.discountService = discountService;
    }

    @PostMapping
    public ResponseEntity<DiscountResponseDTO> createDiscount(@RequestBody DiscountRequestDTO discountRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(discountService.createDiscount(discountRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<DiscountResponseDTO>> getAllDiscounts() {
        return ResponseEntity.ok(discountService.getAllDiscounts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiscountResponseDTO> getDiscountById(@PathVariable Long id) {
        return ResponseEntity.ok(discountService.getDiscountById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiscountResponseDTO> updateDiscount(@PathVariable Long id,
                                                              @RequestBody DiscountRequestDTO discountRequestDTO) {
        return ResponseEntity.ok(discountService.updateDiscount(id, discountRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDiscount(@PathVariable Long id) {
        discountService.deleteDiscount(id);
        return ResponseEntity.ok("Discount deleted successfully");
    }
}
