package com.project.projectjavaJL.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.projectjavaJL.model.Aluno;
import com.project.projectjavaJL.projections.AlunoProjection;
import com.project.projectjavaJL.repositories.AlunoRepository;
import com.project.projectjavaJL.responses.ResponseMessage;




@Service
public class AlunoService {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	@Transactional(readOnly = true)
	public ResponseEntity<?> findAllTurma(int turma){
		List<AlunoProjection> AlunoProjection = alunoRepository.searchAllAlunosTurma(turma);
		
		return ResponseEntity.status(HttpStatus.OK).body(AlunoProjection);
	}

	@Transactional(readOnly = true)
	public ResponseEntity<?> findAllAlunos(){
		List<Aluno> aluno = alunoRepository.findAll();
		
		return ResponseEntity.status(HttpStatus.OK).body(aluno);
	}
	
	@Transactional(readOnly = true)
	public ResponseEntity<?> findByIdAluno(Long id){
		Optional<Aluno> alunoOptional = alunoRepository.findById(id);
		
		if (!alunoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage("User não encontrado."));
		}
		Aluno aluno = new Aluno(alunoOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body(aluno);
	}


	@Transactional
	public ResponseEntity<?> saveAluno(Aluno aluno){
		alunoRepository.save(new Aluno(aluno));
		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage("Aluno criado com sucesso."));
	}
	
	@Transactional
	public ResponseEntity<?> updateAluno(Long id, Aluno aluno){
		Optional<Aluno> alunoOptional = alunoRepository.findById(id);
		
		if (!alunoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage("Aluno não encontrado."));
		}

		Aluno result = alunoOptional.get();
		
		result.setNome(aluno.getNome());
		result.setTurma(aluno.getTurma());
		
		alunoRepository.save(result);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseMessage("Aluno alterado com sucesso."));
	}
	
	@Transactional
	public ResponseEntity<?> deleteAluno(Long id){
		Optional<Aluno>  alunoOptional = alunoRepository.findById(id);

		if (!alunoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage("Aluno não encontrado."));
		}
		
		alunoRepository.deleteById(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Aluno excluído com sucesso."));
	}
}
