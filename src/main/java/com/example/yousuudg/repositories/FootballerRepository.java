package com.example.yousuudg.repositories;

import com.example.yousuudg.models.FootballerModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface FootballerRepository extends CrudRepository<FootballerModel, Long> {

    //buscar por numero de registro
    public abstract Optional<FootballerModel> findByRegistrationNum(Long registrationNum);
    public abstract Optional<FootballerModel> findByName(String name);
    boolean existsByRegistrationNum(Long registrationNum);

}
