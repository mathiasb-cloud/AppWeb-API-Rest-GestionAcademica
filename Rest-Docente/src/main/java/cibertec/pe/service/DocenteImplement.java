package cibertec.pe.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cibertec.pe.entity.Curso;
import cibertec.pe.feignclient.CursoFeignClient;
import cibertec.pe.model.Docente;
import cibertec.pe.repository.IDocenteRepository;

@Service
public class DocenteImplement implements IDocenteService {
	
	@Autowired
	private IDocenteRepository docenteRepository;
	
	@Autowired
	private CursoFeignClient cursoFeign;
	
	@Override
	public List<Docente> listarDocentes() {
		return docenteRepository.findAll();
	}
	
	@Override
	public Docente crearDocente(Docente docente) {
		return docenteRepository.save(docente);
	}
	
	@Override
	public Optional<Docente> buscarDocente(int codigo) {
		return docenteRepository.findById(codigo);
	}
	
	@Override
	public String editarDocente(int codigo, Docente docente) {
		Docente doc = docenteRepository.findById(codigo).get();
		if(doc != null) {
			doc.setNomDocente(docente.getNomDocente());
			doc.setApeDocente(docente.getApeDocente());
			doc.setEmaDocente(docente.getEmaDocente());
			doc.setEspecialidad(docente.getEspecialidad());
			
			docenteRepository.save(doc);
			return "Docente actualizado";
		} else return "Error";
	}
	
	@Override
	public void eliminarDocente(int codigo) {
		docenteRepository.deleteById(codigo);	
	}
	
	@Override
	public Curso crearCurso(int codDocente, Curso curso) {
		curso.setCodDocente(codDocente);
		return cursoFeign.crearCurso(curso);
	}
}