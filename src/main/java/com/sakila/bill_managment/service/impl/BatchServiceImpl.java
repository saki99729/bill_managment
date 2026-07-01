package com.sakila.bill_managment.service.impl;

import com.sakila.bill_managment.dto.request.BatchRequestDTO;
import com.sakila.bill_managment.dto.response.BatchResponseDTO;
import com.sakila.bill_managment.exception.ResourceNotFoundException;
import com.sakila.bill_managment.modal.Batch;
import com.sakila.bill_managment.repository.BatchRepository;
import com.sakila.bill_managment.service.IBatchService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchServiceImpl implements IBatchService {

    private final BatchRepository batchRepository;

    public BatchServiceImpl(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    @Override
    public BatchResponseDTO createBatch(BatchRequestDTO batchRequestDTO) {
        Batch batch = mapToBatch(batchRequestDTO);
        return mapToBatchResponseDTO(batchRepository.save(batch));
    }

    @Override
    public List<BatchResponseDTO> getAllBatches() {
        return batchRepository.findAll()
                .stream()
                .map(this::mapToBatchResponseDTO)
                .toList();
    }

    @Override
    public BatchResponseDTO getBatchById(Long id) {
        Batch batch = batchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Batch not found with id: " + id));
        return mapToBatchResponseDTO(batch);
    }

    @Override
    public BatchResponseDTO updateBatch(Long id, BatchRequestDTO batchRequestDTO) {
        Batch existingBatch = batchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Batch not found with id: " + id));

        existingBatch.setBatchName(batchRequestDTO.getBatchName());
        existingBatch.setBatchNumber(batchRequestDTO.getBatchNumber());
        existingBatch.setBarCode(batchRequestDTO.getBarCode());
        existingBatch.setQrCode(batchRequestDTO.getQrCode());
        existingBatch.setTotalPrice(batchRequestDTO.getTotalPrice());
        existingBatch.setQuantity(batchRequestDTO.getQuantity());
        existingBatch.setManufactureDate(batchRequestDTO.getManufactureDate());
        existingBatch.setExpiryDate(batchRequestDTO.getExpiryDate());
        existingBatch.setCreatedAt(batchRequestDTO.getCreatedAt());
        existingBatch.setUpdatedAt(batchRequestDTO.getUpdatedAt());
        existingBatch.setCreatedBy(batchRequestDTO.getCreatedBy());
        existingBatch.setUpdatedBy(batchRequestDTO.getUpdatedBy());

        return mapToBatchResponseDTO(batchRepository.save(existingBatch));
    }

    @Override
    public void deleteBatch(Long id) {
        Batch batch = batchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Batch not found with id: " + id));
        batchRepository.delete(batch);
    }

    private Batch mapToBatch(BatchRequestDTO batchRequestDTO) {
        Batch batch = new Batch();
        batch.setBatchName(batchRequestDTO.getBatchName());
        batch.setBatchNumber(batchRequestDTO.getBatchNumber());
        batch.setBarCode(batchRequestDTO.getBarCode());
        batch.setQrCode(batchRequestDTO.getQrCode());
        batch.setTotalPrice(batchRequestDTO.getTotalPrice());
        batch.setQuantity(batchRequestDTO.getQuantity());
        batch.setManufactureDate(batchRequestDTO.getManufactureDate());
        batch.setExpiryDate(batchRequestDTO.getExpiryDate());
        batch.setCreatedAt(batchRequestDTO.getCreatedAt());
        batch.setUpdatedAt(batchRequestDTO.getUpdatedAt());
        batch.setCreatedBy(batchRequestDTO.getCreatedBy());
        batch.setUpdatedBy(batchRequestDTO.getUpdatedBy());
        return batch;
    }

    public BatchResponseDTO mapToBatchResponseDTO(Batch batch) {
        return new BatchResponseDTO(
                batch.getId(),
                batch.getBatchName(),
                batch.getBatchNumber(),
                batch.getBarCode(),
                batch.getQrCode(),
                batch.getTotalPrice(),
                batch.getQuantity(),
                batch.getManufactureDate(),
                batch.getExpiryDate(),
                batch.getCreatedAt(),
                batch.getUpdatedAt(),
                batch.getCreatedBy(),
                batch.getUpdatedBy()
        );
    }
}
