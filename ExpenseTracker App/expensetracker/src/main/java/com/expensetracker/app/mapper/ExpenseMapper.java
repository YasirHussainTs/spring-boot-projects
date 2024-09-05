package com.expensetracker.app.mapper;

import com.expensetracker.app.dto.CategoryDto;
import com.expensetracker.app.dto.ExpenseDto;
import com.expensetracker.app.entity.Category;
import com.expensetracker.app.entity.Expense;

public class ExpenseMapper {

    //Map Expense entity to ExpenseDto
    public static ExpenseDto mapToExpenseDto(Expense expense) {

        return new ExpenseDto(
                expense.getId(),
                expense.getAmount(),
                expense.getExpenseDate(),
                new CategoryDto(
                        expense.getCategory().getId(),
                        expense.getCategory().getName()
                )
        );
    }
    
    //Map ExpenseDto to Expense Entity
    public static Expense mapToExpense(ExpenseDto expenseDto) {
        Category category = new Category();
        category.setId(expenseDto.categoryDto().id());
        
        return new Expense(
                expenseDto.id(),
                expenseDto.amount(),
                expenseDto.expenseDate(),
                category
        );
    }
}
