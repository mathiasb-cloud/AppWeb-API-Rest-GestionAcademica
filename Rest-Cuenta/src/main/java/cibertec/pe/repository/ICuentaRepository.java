package cibertec.pe.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import cibertec.pe.model.Cuenta;

public interface ICuentaRepository extends JpaRepository<Cuenta, String> {
	Cuenta findByCodAlumno(int codAlumno);
	Cuenta findByCodUsuarioAndContrasena(String codUsuario, String contrasena);
}