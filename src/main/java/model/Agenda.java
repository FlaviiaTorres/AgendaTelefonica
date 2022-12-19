package model;

public class Agenda {	
	
	Long id;
	String nome;
	int numeroTel;
	
	public Agenda() {
		
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(int numeroTel) {
		this.numeroTel = numeroTel;
	}


	@Override
	public String toString() {
		return "agenda [id=" + id + ", nome=" + nome + ", numeroTel=" + numeroTel + "]";
	}
	
}