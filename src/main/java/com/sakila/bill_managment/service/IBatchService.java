package com.sakila.bill_managment.service;

import com.sakila.bill_managment.dto.request.BatchRequestDTO;
import com.sakila.bill_managment.dto.response.BatchResponseDTO;

import java.util.List;

public interface IBatchService {

    BatchResponseDTO createBatch(BatchRequestDTO batchRequestDTO);

    List<BatchResponseDTO> getAllBatches();

    BatchResponseDTO getBatchById(Long id);

    BatchResponseDTO updateBatch(Long id, BatchRequestDTO batchRequestDTO);

    void deleteBatch(Long id);
}
