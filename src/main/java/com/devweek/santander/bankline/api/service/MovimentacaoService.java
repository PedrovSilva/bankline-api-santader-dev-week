package com.devweek.santander.bankline.api.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devweek.santander.bankline.api.dto.NovaMovimentacao;
import com.devweek.santander.bankline.api.model.Correntista;
import com.devweek.santander.bankline.api.model.Movimentacao;
import com.devweek.santander.bankline.api.model.MovimentacaoTipo;
import com.devweek.santander.bankline.api.repository.ICorrentistaRepository;
import com.devweek.santander.bankline.api.repository.IMovimentacaoRepository;

@Service
public class MovimentacaoService {
	@Autowired
	private IMovimentacaoRepository repository;
	
	@Autowired
	private ICorrentistaRepository correntistaRepository;
	public void save(NovaMovimentacao novaMovimentacao) {
		Movimentacao movimentacao = new Movimentacao();
		
		Double valor = novaMovimentacao.getTipo() == MovimentacaoTipo.RECEITA ? novaMovimentacao.getValor() : novaMovimentacao.getValor() * -1;
				
		movimentacao.setDataHora(LocalDateTime.now());
		movimentacao.setDescricao(novaMovimentacao.getDescricao());
		movimentacao.setIdConta(novaMovimentacao.getIdConta());
		movimentacao.setTipo(novaMovimentacao.getTipo());
		movimentacao.setValor(valor);
		
		Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
		if(correntista != null) {
			correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
			correntistaRepository.save(correntista);
		}
		
		repository.save(movimentacao);
	}

}
