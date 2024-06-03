package com.wipro.Project_TripExpenses.Service;

import com.wipro.Project_TripExpenses.Model.Expense;
import com.wipro.Project_TripExpenses.Model.Trip;
import com.wipro.Project_TripExpenses.Repository.ExpenseRepo;
import com.wipro.Project_TripExpenses.Repository.TripRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepo expenseRepo;
    @Autowired
    private TripRepo tripRepo;

    /*public Expense save(Expense expense) {
        return expenseRepo.save(expense);
    }*/
    public Expense createExpense(Expense expense) {
        Optional<Trip> tripOptional = tripRepo.findById(expense.getId());
        if (tripOptional.isPresent()) {
            Expense expenses = new Expense();
            expenses.setDescription(expense.getDescription());
            expenses.setAmount(expense.getAmount());
            expenses.setTrip(tripOptional.get());
            return expenseRepo.save(expense);
        } else {
            throw new RuntimeException("Trip not found with id: " + expense.getId());
        }
    }

    public List<Expense> findAll() {
        return expenseRepo.findAll();
    }

    public Expense updateById(Long id, Expense expenseDetails) {
        Expense expense = expenseRepo.findById(id).orElseThrow();
        expense.setDescription(expenseDetails.getDescription());
        expense.setAmount(expenseDetails.getAmount());
        return expenseRepo.save(expense);
    }

    public void deleteById(Long id) {
        expenseRepo.deleteById(id);
    }
}