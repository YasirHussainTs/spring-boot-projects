package com.expensetracker.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = true)
    private LocalDate expenseDate;

    //ManyToMany relationship - Many expenses belongs to One Category
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false) //foreign key in expense table
    private Category category;
}
