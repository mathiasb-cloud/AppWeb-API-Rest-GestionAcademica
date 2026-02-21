package cibertec.pe.repository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import cibertec.pe.model.Asistencia;

public interface IAsistenciaRepository extends JpaRepository<Asistencia, Integer> {
	List<Asistencia> findByCodMatricula(int codMatricula);
	List<Asistencia> findByFecha(LocalDate fecha);
}