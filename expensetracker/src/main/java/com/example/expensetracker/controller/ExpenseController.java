package com.example.expensetracker.controller;

import com.example.expensetracker.entity.Expense;
import com.example.expensetracker.service.ExpenseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping("/post")
    public Expense create(@RequestBody Expense expense) {
        return expenseService.create(expense);
    }

    @GetMapping("/get")
    public List<Expense> getAll() {
        return expenseService.getAll();
    }

    @GetMapping("/get/{id}")
    public Expense getById(@PathVariable Long id) {
        return expenseService.getById(id);
    }

    @PutMapping("/put/{id}")
    public Expense update(@PathVariable Long id, @RequestBody Expense expense) {
        return expenseService.update(id, expense);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        boolean deleted = expenseService.delete(id);

        if (deleted) {
            return "Deleted Successfully";
        } else {
            return "Expense not found";
        }
    }
}
