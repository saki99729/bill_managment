package com.sakila.bill_managment.repository;

import com.sakila.bill_managment.modal.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatchRepository extends JpaRepository<Batch, Long> {
}
