package com.sakila.bill_managment.service.impl;

import com.sakila.bill_managment.dto.request.DiscountRequestDTO;
import com.sakila.bill_managment.dto.response.BatchResponseDTO;
import com.sakila.bill_managment.dto.response.DiscountResponseDTO;
import com.sakila.bill_managment.exception.ResourceNotFoundException;
import com.sakila.bill_managment.modal.Batch;
import com.sakila.bill_managment.modal.Discount;
import com.sakila.bill_managment.repository.BatchRepository;
import com.sakila.bill_managment.repository.DiscountRepository;
import com.sakila.bill_managment.service.IDiscountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountServiceImpl implements IDiscountService {

    private final DiscountRepository discountRepository;
    private final BatchRepository batchRepository;
    private final BatchServiceImpl batchService;

    public DiscountServiceImpl(DiscountRepository discountRepository,
                               BatchRepository batchRepository,
                               BatchServiceImpl batchService) {
        this.discountRepository = discountRepository;
        this.batchRepository = batchRepository;
        this.batchService = batchService;
    }

    @Override
    public DiscountResponseDTO createDiscount(DiscountRequestDTO discountRequestDTO) {
        Batch batch = batchRepository.findById(discountRequestDTO.getBatchId())
                .orElseThrow(() -> new ResourceNotFoundException("Batch not found with id: " + discountRequestDTO.getBatchId()));

        Discount discount = new Discount();
        discount.setBatch(batch);
        discount.setDiscountPercentage(discountRequestDTO.getDiscountPercentage());
        discount.setAmount(discountRequestDTO.getAmount());

        return mapToDiscountResponseDTO(discountRepository.save(discount));
    }

    @Override
    public List<DiscountResponseDTO> getAllDiscounts() {
        return discountRepository.findAll()
                .stream()
                .map(this::mapToDiscountResponseDTO)
                .toList();
    }

    @Override
    public DiscountResponseDTO getDiscountById(Long id) {
        Discount discount = discountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Discount not found with id: " + id));
        return mapToDiscountResponseDTO(discount);
    }

    @Override
    public DiscountResponseDTO updateDiscount(Long id, DiscountRequestDTO discountRequestDTO) {
        Discount existingDiscount = discountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Discount not found with id: " + id));
        Batch batch = batchRepository.findById(discountRequestDTO.getBatchId())
                .orElseThrow(() -> new ResourceNotFoundException("Batch not found with id: " + discountRequestDTO.getBatchId()));

        existingDiscount.setBatch(batch);
        existingDiscount.setDiscountPercentage(discountRequestDTO.getDiscountPercentage());
        existingDiscount.setAmount(discountRequestDTO.getAmount());

        return mapToDiscountResponseDTO(discountRepository.save(existingDiscount));
    }

    @Override
    public void deleteDiscount(Long id) {
        Discount discount = discountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Discount not found with id: " + id));
        discountRepository.delete(discount);
    }

    private DiscountResponseDTO mapToDiscountResponseDTO(Discount discount) {
        BatchResponseDTO batchResponseDTO = batchService.mapToBatchResponseDTO(discount.getBatch());
        return new DiscountResponseDTO(
                discount.getId(),
                batchResponseDTO,
                discount.getDiscountPercentage(),
                discount.getAmount()
        );
    }
}
