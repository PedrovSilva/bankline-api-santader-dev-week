package com.devweek.santander.bankline.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devweek.santander.bankline.api.model.Movimentacao;

public interface IMovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {

}
