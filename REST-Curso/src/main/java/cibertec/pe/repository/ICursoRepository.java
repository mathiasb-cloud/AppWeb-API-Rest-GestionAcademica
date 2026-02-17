package cibertec.pe.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import cibertec.pe.model.Curso;

public interface ICursoRepository extends JpaRepository<Curso, Integer> {
	List<Curso> findByCodDocente(Integer codDocente);	
}