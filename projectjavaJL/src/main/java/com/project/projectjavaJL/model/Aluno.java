package com.project.projectjavaJL.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(columnDefinition = "TEXT")
	private String nome;
	private Integer turma;

	public Aluno() {
	}

	public Aluno(Aluno aluno) {
		this.id = aluno.getId();
		this.nome = aluno.getNome();
		this.turma = aluno.getTurma();
	}

	public Aluno(Long id, String nome, Integer turma) {
		this.id = id;
		this.nome = nome;
		this.turma = turma;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getTurma() {
		return turma;
	}

	public void setTurma(Integer turma) {
		this.turma = turma;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nome=" + nome + ", turma=" + turma + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(id, other.id);
	}
}
