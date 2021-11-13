package com.amoebiq.product.vehiman.controller;

import com.amoebiq.product.vehiman.model.Vehicle;
import com.amoebiq.product.vehiman.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping()
    public ResponseEntity<List<Vehicle>> getAllVehicles() {

        //code to find the user from the given token

        String emailId = "shukad33@yahoo.com";

        return new ResponseEntity<List<Vehicle>>(vehicleService.getVehiclesByOwner(emailId), HttpStatus.OK);

    }

    @PostMapping()
    public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle) {

        //code to find the user from the given token
        // validate vehicle model
        String emailId = "shukad33@yahoo.com";

        return new ResponseEntity<Vehicle>(vehicleService.addVehiclesToOwner(emailId,vehicle),HttpStatus.CREATED);
    }

}
