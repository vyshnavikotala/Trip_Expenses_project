package com.wipro.Project_TripExpenses.Repository;


import com.wipro.Project_TripExpenses.Model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepo extends JpaRepository<Expense,Long> {
}
