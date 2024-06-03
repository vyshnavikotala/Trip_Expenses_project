package com.wipro.Project_TripExpenses.Controller;


import com.wipro.Project_TripExpenses.Model.Expense;
import com.wipro.Project_TripExpenses.Service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/expenses")
    public List<Expense> getAllExpenses() {
        return expenseService.findAll();
    }

   /*@PostMapping
    public Expense createExpense(@RequestBody Expense expense) {
        return expenseService.save(expense);
    }*/

    @PostMapping("/expenses")
    public Expense createExpense(@RequestBody Expense expense) {
        return expenseService.createExpense(expense);
    }

    @PutMapping("expenses/{id}")
    public Expense updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
        return expenseService.updateById(id, expense);
    }

    @DeleteMapping("expenses/{id}")
    public void deleteExpense(@PathVariable Long id) {
        expenseService.deleteById(id);
    }
}