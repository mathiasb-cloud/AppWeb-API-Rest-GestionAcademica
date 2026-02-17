package cibertec.pe.entity;

public class Curso {
	private int nroCurso;
	private String nomCurso;
	private String ciclo;
	private int codDocente;

	public Curso() {
	}

	public Curso(int nroCurso, String nomCurso, String ciclo, int codDocente) {
		this.nroCurso = nroCurso;
		this.nomCurso = nomCurso;
		this.ciclo = ciclo;
		this.codDocente = codDocente;
	}

	public Curso(String nomCurso, String ciclo, int codDocente) {
		this.nomCurso = nomCurso;
		this.ciclo = ciclo;
		this.codDocente = codDocente;
	}

	public int getNroCurso() {
		return nroCurso;
	}

	public void setNroCurso(int nroCurso) {
		this.nroCurso = nroCurso;
	}

	public String getNomCurso() {
		return nomCurso;
	}

	public void setNomCurso(String nomCurso) {
		this.nomCurso = nomCurso;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public int getCodDocente() {
		return codDocente;
	}

	public void setCodDocente(int codDocente) {
		this.codDocente = codDocente;
	}
}