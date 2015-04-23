package main.java.model;

public class Genre {

	private Integer idGenre;
	private String nomGenre;
	
	public Genre(Integer idgenre, String nomgenre){
		this.idGenre=idgenre;
		this.nomGenre=nomgenre;
	}
	
	public Genre(String nomgenre){
		this.nomGenre=nomgenre;
	}
	
	public Integer getIdGenre() {
		return idGenre;
	}

	public void setIdGenre(Integer idGenre) {
		this.idGenre = idGenre;
	}

	public String getNomGenre() {
		return nomGenre;
	}

	public void setNomGenre(String nomGenre) {
		this.nomGenre = nomGenre;
	}
}
