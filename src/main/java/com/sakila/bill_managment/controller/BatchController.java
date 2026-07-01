package com.sakila.bill_managment.controller;

import com.sakila.bill_managment.dto.request.BatchRequestDTO;
import com.sakila.bill_managment.dto.response.BatchResponseDTO;
import com.sakila.bill_managment.service.IBatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/batches")
public class BatchController {

    private final IBatchService batchService;

    public BatchController(IBatchService batchService) {
        this.batchService = batchService;
    }

    @PostMapping
    public ResponseEntity<BatchResponseDTO> createBatch(@RequestBody BatchRequestDTO batchRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(batchService.createBatch(batchRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<BatchResponseDTO>> getAllBatches() {
        return ResponseEntity.ok(batchService.getAllBatches());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BatchResponseDTO> getBatchById(@PathVariable Long id) {
        return ResponseEntity.ok(batchService.getBatchById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BatchResponseDTO> updateBatch(@PathVariable Long id,
                                                        @RequestBody BatchRequestDTO batchRequestDTO) {
        return ResponseEntity.ok(batchService.updateBatch(id, batchRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBatch(@PathVariable Long id) {
        batchService.deleteBatch(id);
        return ResponseEntity.ok("Batch deleted successfully");
    }
}
