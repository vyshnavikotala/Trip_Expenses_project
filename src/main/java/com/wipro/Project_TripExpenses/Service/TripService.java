package com.wipro.Project_TripExpenses.Service;

import com.wipro.Project_TripExpenses.Model.Expense;
import com.wipro.Project_TripExpenses.Model.Trip;
import com.wipro.Project_TripExpenses.Model.User;
import com.wipro.Project_TripExpenses.Repository.TripRepo;
import com.wipro.Project_TripExpenses.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;




import java.util.List;
import java.util.Optional;

@Service
public class TripService {
    @Autowired
    private TripRepo tripRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    /*public Trip save(Trip trip) {
        return tripRepo.save(trip);
    }*/
    public Trip createTrip(Trip trip) {
        Trip trips = new Trip();
        trips.setDestination(trip.getDestination());
        trips.setStartDate(trip.getStartDate());
        trips.setEndDate(trip.getEndDate());
        return tripRepo.save(trips);
    }

    public List<Trip> findAll() {
        return tripRepo.findAll();
    }

    public Trip updateById(Long id, Trip tripDetails) {
        Trip trip = tripRepo.findById(id).orElseThrow();
        trip.setDestination(tripDetails.getDestination());
        trip.setStartDate(tripDetails.getStartDate());
        trip.setEndDate(tripDetails.getEndDate());
        return tripRepo.save(trip);
    }

    public void deleteById(Long id) {
        tripRepo.deleteById(id);
    }


    public Optional<Trip> findById(long id) {
        return tripRepo.findById(id);
    }


    public String addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return "user added to system ";
    }
    public Optional<User> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
