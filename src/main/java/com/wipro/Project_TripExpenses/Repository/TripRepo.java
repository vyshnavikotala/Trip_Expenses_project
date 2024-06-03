package com.wipro.Project_TripExpenses.Repository;


import com.wipro.Project_TripExpenses.Model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepo extends JpaRepository <Trip,Long>{

}
