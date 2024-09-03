package com.expensetracker.app.repository;

import com.expensetracker.app.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    //Spring data JPA implementation for this interface
    //CRUD Methods to perform CRUD database operations on Expense Entity
    //Spring Data JPA provides transactions for all the CRUD methods.
}
