package com.example.Atividade.Controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Atividade.Model.Atividade;
import com.example.Atividade.Repository.AtividadeRepository;

@RestController
@RequestMapping("/atividade")
public class AtividadeController {

	@Autowired
	AtividadeRepository atividadeRepository;

	@PostMapping("/listar")
	public List<Atividade> getAtividades(@RequestBody Long rm) {
		return atividadeRepository.findByRm(rm);
	}

	@PostMapping("/adicionar")
	public String adicionarAtividade(@RequestBody Atividade atividade) {

		Atividade obj_atv = atividadeRepository.findByRmAndNumeroAtividade(atividade.getRm(),
				atividade.getNumeroAtividade());

		String positivo = "Cadastrado!";

		String negativo = "Cadastro já existente!";

		if (obj_atv == null) {

			Atividade atv = new Atividade();
			atv.setNome(atividade.getNome());
			atv.setNumeroAtividade(atividade.getNumeroAtividade());
			atv.setRm(atividade.getRm());
			atv.setUrlGitHub(atividade.getUrlGitHub());

			atividadeRepository.save(atv);
			return positivo;
		} else {

			return negativo;
		}
	}

	@PutMapping("/editar")
	public ResponseEntity<?> editarAtividade(@RequestBody Atividade atividade, HttpServletResponse response) {

		Atividade obj_atv = atividadeRepository.findByRmAndNumeroAtividade(atividade.getRm(),
				atividade.getNumeroAtividade());

		if (obj_atv != null) {
			obj_atv.setUrlGitHub(atividade.getUrlGitHub());
			atividadeRepository.save(obj_atv);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@DeleteMapping("/deletar")
	public String deletarAtividade(@RequestBody Atividade atividade) {
		Atividade obj_atv = atividadeRepository.findByRmAndNumeroAtividade(atividade.getRm(),
				atividade.getNumeroAtividade());
		if (obj_atv != null) {
			atividadeRepository.delete(obj_atv);
			return "Usuário deletado!";
		} else {
			return "Usuário não existente";
		}
	}

}
