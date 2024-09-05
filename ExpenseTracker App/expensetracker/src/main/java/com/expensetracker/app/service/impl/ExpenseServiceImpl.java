package com.expensetracker.app.service.impl;

import com.expensetracker.app.dto.ExpenseDto;
import com.expensetracker.app.entity.Category;
import com.expensetracker.app.entity.Expense;
import com.expensetracker.app.exception.ResourceNotFoundException;
import com.expensetracker.app.mapper.ExpenseMapper;
import com.expensetracker.app.repository.CategoryRepository;
import com.expensetracker.app.repository.ExpenseRepository;
import com.expensetracker.app.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final CategoryRepository categoryRepository;
    //Inject ExpenseRepository using constructor based DI
    private ExpenseRepository expenseRepository;

    @Override
    public ExpenseDto createExpense(ExpenseDto expenseDto) {

        //Convert ExpenseDto to Expense Entity
        Expense expense = ExpenseMapper.mapToExpense(expenseDto);

        //Save Expense entity into DB
        Expense savedExpense = expenseRepository.save(expense);

        //Convert saved expense entity into ExpenseDto
        return ExpenseMapper.mapToExpenseDto(savedExpense);
    }

    @Override
    public ExpenseDto getExpenseById(Long expenseId) {

        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(() -> new RuntimeException("Expense Not Found With Id : " + expenseId));

        return ExpenseMapper.mapToExpenseDto(expense);
    }

    @Override
    public List<ExpenseDto> getAllExpenses() {

        List<Expense> expenses = expenseRepository.findAll();

        return expenses.stream()
                .map((expense) -> ExpenseMapper.mapToExpenseDto(expense))
                        .collect(Collectors.toList());
    }

    @Override
    public ExpenseDto updateExpense(Long expenseId, ExpenseDto expenseDto) {
        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(() -> new RuntimeException("Could not found with Id" + expenseId));

        expense.setAmount(expenseDto.amount());

        expense.setExpenseDate(expenseDto.expenseDate());

        //update Category
        if(expenseDto.categoryDto() != null) {

            //get the category entity by id
            Category category = categoryRepository.findById(expenseDto.categoryDto().id())
                    .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + expenseDto.categoryDto().id()));

            expense.setCategory(category);
        }

        //update expense entity into database
        Expense updatedExpense = expenseRepository.save(expense);

        //convert expense entity into expenseDto
        return ExpenseMapper.mapToExpenseDto(updatedExpense);
    }

    @Override
    public void deleteExpense(Long expenseId) {
        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found with id : " + expenseId));

        expenseRepository.delete(expense);
    }
}
