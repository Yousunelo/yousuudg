package com.example.yousuudg.controllers;

import com.example.yousuudg.models.FootballerModel;
import com.example.yousuudg.services.FootballerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/footballer")
public class FootballerController {
    @Autowired
    FootballerService footballerService;

    //get
    @GetMapping()
    public List<FootballerModel> findAllFootballers(){
        return footballerService.FindAllFootballers();
    }

    //post

    //@PostMapping()
    //public FootballerModel saveFootballer(@RequestBody FootballerModel footballer){
    //    return footballerService.saveFootballer(footballer);
    //}

    //editar

    @PutMapping("/updateByRegistrationNum={registrationNum}")
    public FootballerModel updateFootballerByRegistrationNum(@PathVariable long registrationNum, @RequestBody FootballerModel footballer){
        return footballerService.updateFootballerByRegistrationNum(registrationNum, footballer);
    }

    @GetMapping("findByRegistrationNum={registrationNum}") //localhost:8080/car/find-by-registrationNum?
    public Optional<FootballerModel> findFootballerByRegistrationNum(@PathVariable long registrationNum){
        return footballerService.findFootballerByRegistrationNum(registrationNum);
    }

    @GetMapping("/findByName={name}") //localhost:8080/car/find-by-name?
    public Optional<FootballerModel> findFootballerByName(@PathVariable String name){
        return footballerService.findFootballerByName(name);
    }

    @DeleteMapping("/deleteByRegistrationNum={registrationNum}")
    public String deleteFootballerByRegistrationNum(@PathVariable long registrationNum){
        return footballerService.deleteFootballerByRegistrationNum(registrationNum);
    }

    @PostMapping()
    public ResponseEntity<String> saveFootballer(@RequestBody FootballerModel footballer) {
        if (footballerService.existsByRegistrationNum(footballer.getRegistrationNum())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Registration number already exists");
        }

        footballerService.saveFootballer(footballer);
        return ResponseEntity.status(HttpStatus.CREATED).body("Footballer created successfully");
    }


}
