package com.expensetracker.app.controller;

import com.expensetracker.app.dto.ExpenseDto;
import com.expensetracker.app.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    //Inject the ExpenseService using Constructor Based DI
    private ExpenseService expenseService;

    @PostMapping()
    public ResponseEntity<ExpenseDto> createExpense(ExpenseDto expenseDto) {

        ExpenseDto savedExpense = expenseService.createExpense(expenseDto);

        return new ResponseEntity<>(savedExpense, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ExpenseDto> getExpenseById(@PathVariable("id") Long expenseId) {

        ExpenseDto expenseDto = expenseService.getExpenseById(expenseId);

        return ResponseEntity.ok(expenseDto);
    }

    @GetMapping()
    public ResponseEntity<List<ExpenseDto>> getAllExpenses() {

        List<ExpenseDto> expenses = expenseService.getAllExpenses();

        return ResponseEntity.ok(expenses);
    }

    @PutMapping("{id}")
    public ResponseEntity<ExpenseDto> updateExpense(@PathVariable("id") Long expenseId, @RequestBody ExpenseDto expenseDto) {

        ExpenseDto updatedExpense = expenseService.updateExpense(expenseId, expenseDto);

        return ResponseEntity.ok(updatedExpense);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable("id") Long expenseId) {
        expenseService.deleteExpense(expenseId);
        return ResponseEntity.ok("Expense deleted successfully");
    }
}
