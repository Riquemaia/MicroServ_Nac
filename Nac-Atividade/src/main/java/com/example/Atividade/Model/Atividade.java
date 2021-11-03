package com.example.Atividade.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_atividade")
public class Atividade {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rm;

	private String nome;
	private String urlGitHub;
	private String numeroAtividade;

	public Atividade() {
	}

	public Long getRm() {
		return rm;
	}

	public void setRm(Long rm) {
		this.rm = rm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUrlGitHub() {
		return urlGitHub;
	}

	public void setUrlGitHub(String urlGitHub) {
		this.urlGitHub = urlGitHub;
	}

	public String getNumeroAtividade() {
		return numeroAtividade;
	}

	public void setNumeroAtividade(String numeroAtividade) {
		this.numeroAtividade = numeroAtividade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rm == null) ? 0 : rm.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atividade other = (Atividade) obj;
		if (rm == null) {
			if (other.rm != null)
				return false;
		} else if (!rm.equals(other.rm))
			return false;
		return true;
	}

	
}
