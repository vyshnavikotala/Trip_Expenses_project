package com.wipro.Project_TripExpenses.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.Project_TripExpenses.Model.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository <User,Long>{
    Optional<User> findByUsername(String username);
}
