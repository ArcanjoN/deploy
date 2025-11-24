package com.project.projectjavaJL.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.projectjavaJL.service.AlunoService;
import com.project.projectjavaJL.model.Aluno;

@RestController
@RequestMapping(value = "/users")
public class AlunoController {
	
	@Autowired
	AlunoService alunoService;
	
	@GetMapping
	public ResponseEntity<?> findAllAlunos(){
		return alunoService.findAllAlunos();
	}

	@GetMapping(value = "/turma/{turma}")
	public ResponseEntity<?> findAllTurma(@PathVariable int turma){
		return alunoService.findAllTurma(turma);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findByIdAluno(@PathVariable Long id){
		return alunoService.findByIdAluno(id);
	}
	
	@PostMapping
	public ResponseEntity<?> saveAluno(@RequestBody Aluno aluno){
		return alunoService.saveAluno(aluno);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateAluno(@PathVariable Long id, @RequestBody Aluno aluno){
		return alunoService.updateAluno(id, aluno);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteAluno(@PathVariable Long id){
		return alunoService.deleteAluno(id);
	}
}