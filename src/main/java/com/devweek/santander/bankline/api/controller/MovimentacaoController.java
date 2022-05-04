package com.devweek.santander.bankline.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devweek.santander.bankline.api.dto.NovaMovimentacao;
import com.devweek.santander.bankline.api.dto.NovoCorrentista;
import com.devweek.santander.bankline.api.model.Correntista;
import com.devweek.santander.bankline.api.model.Movimentacao;
import com.devweek.santander.bankline.api.repository.ICorrentistaRepository;
import com.devweek.santander.bankline.api.repository.IMovimentacaoRepository;
import com.devweek.santander.bankline.api.service.CorrentistaService;
import com.devweek.santander.bankline.api.service.MovimentacaoService;

@RestController
@RequestMapping("/movimentacoess")
public class MovimentacaoController {
	@Autowired
	private IMovimentacaoRepository repository;
	
	@Autowired
	private MovimentacaoService service;
	
	@GetMapping
	public List<Movimentacao> findAll(){
		return repository.findAll();
	}
	
	@PostMapping
	public void save(@RequestBody NovaMovimentacao movimentacao) {
		service.save(movimentacao);
		
	}
		
	

}
