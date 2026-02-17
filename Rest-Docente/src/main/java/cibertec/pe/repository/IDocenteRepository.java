package cibertec.pe.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import cibertec.pe.model.Docente;

public interface IDocenteRepository extends JpaRepository<Docente, Integer> {
}