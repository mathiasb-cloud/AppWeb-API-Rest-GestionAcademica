package cibertec.pe.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import cibertec.pe.model.Nota;

public interface INotaRepository extends JpaRepository<Nota, Integer> {
	List<Nota> findByCodMatricula(int codMatricula);
}