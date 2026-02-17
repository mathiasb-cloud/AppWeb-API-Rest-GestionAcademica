package cibertec.pe.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import cibertec.pe.model.Alumno;

public interface IAlumnoRepository extends JpaRepository<Alumno, Integer> {
}