package com.devweek.santander.bankline.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devweek.santander.bankline.api.model.Correntista;

public interface ICorrentistaRepository extends JpaRepository<Correntista, Integer> {

}
