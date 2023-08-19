package com.techelevator.locations.controllers;

import com.techelevator.locations.Model.Location;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LocationController {

    private List<Location> locations = new ArrayList<>();

//    public Location getLocationById() {
//        for (Location location : locations) {
//            if (location.getId() == id) {
//                return location;
//            }
//        }
//        return null;
//    }

    public LocationController() {
        locations.add(new Location(1,
                "Baker Electric Building",
                "7100 Euclid Ave",
                "Cleveland",
                "OH",
                "44103"));
        locations.add(new Location(2,
                "Rev1 Ventures",
                "1275 Kinnear Rd",
                "Columbus",
                "OH",
                "43212"));
        locations.add(new Location(3,
                "HCDC Business Center",
                "1776 Mentor Ave",
                "Cincinnati",
                "OH",
                "45212"));
        locations.add(new Location(4,
                "House of Metal",
                "901 Pennsylvania Ave",
                "Pittsburgh",
                "PA",
                "15233"));
        locations.add(new Location(5,
                "TechTown Detroit",
                "440 Burroughs St",
                "Detroit",
                "MI",
                "48202"));
        locations.add(new Location(6,
                "Duane Morris Plaza",
                "30 S 17th St",
                "Philadelphia",
                "PA",
                "19103"));
    }

    //Step 4 - Get a list of locations - method returns a list of locations as an array of JSON objects
    @RequestMapping(path = "/locations", method = RequestMethod.GET)
    public List<Location> list() {
        return locations;
    }

    //Step 5 - Add a location - Method accepts "RequestMethod.POST" instead of "RequestMethod.GET
    @RequestMapping(path = "/locations", method = RequestMethod.POST)
    public Location add(@RequestBody Location location) {
        if (location != null) {
            locations.add(location);
            return location;
        }
        return null;
    }

    //Step 6 - Return a specific location by ID
    @RequestMapping(path = "/locations/{id}", method = RequestMethod.GET)
    public Location get(@PathVariable int id) {
        for (Location location : locations) {
            if (location.getId() == id) {
                return location;
            }
        }
        return null;
    }

}

