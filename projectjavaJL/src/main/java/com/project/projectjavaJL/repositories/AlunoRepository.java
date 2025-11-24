package com.project.projectjavaJL.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.projectjavaJL.model.Aluno;
import com.project.projectjavaJL.projections.AlunoProjection;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	@Query(nativeQuery = true, value = """
			SELECT tb_user.id, tb_user.nome, tb_user.turma
			FROM tb_user
			WHERE tb_user.turma = :turma
			ORDER BY tb_user.turma
				""") 
	List<AlunoProjection> searchAllAlunosTurma(int turma);
}
