package cibertec.pe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cibertec.pe.model.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Integer>{

	List<Matricula> findByCodAlumno(int codAlumno);
    List<Matricula> findByCodCurso(int codCurso);

	
}
