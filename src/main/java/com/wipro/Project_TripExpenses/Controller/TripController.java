package com.wipro.Project_TripExpenses.Controller;

import com.wipro.Project_TripExpenses.Model.Trip;
import com.wipro.Project_TripExpenses.Service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import com.wipro.Project_TripExpenses.Model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TripController{
    @Autowired

    private TripService tripService;
    @GetMapping
    public List<Trip> getAllTrips() {
        return tripService.findAll();
    }

    @PostMapping("/register")
    public String addNewUser(@RequestBody User user) {
        return tripService.addUser(user);
    }
    @GetMapping("/trips/login")
    @PreAuthorize("hasAuthority('admin')")
    public List<Trip> getAllThetrips() {
        return tripService.findAll();
    }

    @GetMapping("trips/{id}")
    @PreAuthorize("hasAuthority('user')")
    public Optional<Trip> getTripById(@PathVariable long id) {
        return tripService.findById(id);
    }

    @PostMapping("/trips")
    public Trip createTrip(@RequestBody Trip trip) {
        return tripService.createTrip(trip);
    }

    @PutMapping("trips/{id}")
    public Trip updateTrip(@PathVariable Long id, @RequestBody Trip trip) {
        return tripService.updateById(id, trip);
    }



    @DeleteMapping("trips/{id}")
    public void deleteTrip(@PathVariable Long id) {
        tripService.deleteById(id);

        }

    }
