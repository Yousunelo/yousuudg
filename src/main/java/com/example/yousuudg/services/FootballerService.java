package com.example.yousuudg.services;

import com.example.yousuudg.models.FootballerModel;
import com.example.yousuudg.repositories.FootballerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FootballerService {
    @Autowired
    FootballerRepository footballerRepository;


    //obtener
    public List<FootballerModel> FindAllFootballers(){
        return (List<FootballerModel>) footballerRepository.findAll();
    }

    //guardar
    public FootballerModel saveFootballer(FootballerModel footballer){
        return footballerRepository.save(footballer);
    }

    //buscar por numero
public Optional<FootballerModel> findFootballerByRegistrationNum(Long registrationNum){
    return footballerRepository.findByRegistrationNum(registrationNum);
    }
    //buscar por nombre
    public Optional<FootballerModel> findFootballerByName(String name){
        return footballerRepository.findByName(name);
    }

    public String deleteFootballerByRegistrationNum(long registrationNum){
        String response = "";
        Optional<FootballerModel> foundFootballer = findFootballerByRegistrationNum(registrationNum);
        if (foundFootballer.isPresent()){
            footballerRepository.delete(foundFootballer.get());
            response = "Car deleted succesfully";
        }
        else{
            response = "Car not found";
        }
        return response;
    }

    public FootballerModel updateFootballerByRegistrationNum(long registrationNum, FootballerModel footballer){
        return findFootballerByRegistrationNum(registrationNum).isPresent() ? footballerRepository.save(footballer) : new FootballerModel(0L,0L,"","","",0L);
    }

    public boolean existsByRegistrationNum(Long registrationNum) {
        return footballerRepository.existsByRegistrationNum(registrationNum);
    }



}


