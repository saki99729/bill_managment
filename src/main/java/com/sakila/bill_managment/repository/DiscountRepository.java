package com.sakila.bill_managment.repository;

import com.sakila.bill_managment.modal.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
}
