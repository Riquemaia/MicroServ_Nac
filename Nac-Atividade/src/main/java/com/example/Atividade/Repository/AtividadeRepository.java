package com.example.Atividade.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.Atividade.Model.Atividade;

public interface AtividadeRepository extends CrudRepository<Atividade, Long> {

	List<Atividade> findByRm(Long rm);

	Atividade findByRmAndNumeroAtividade(Long rm, String numeroAtividade);
}
