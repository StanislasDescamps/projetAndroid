package main.java.model;

public class Langue {

	private Integer idLangue;
	private String nomLangue;
	
	public Langue(Integer idlangue, String nomlangue){
		this.idLangue=idlangue;
		this.nomLangue=nomlangue;
	}

	public Integer getIdLangue() {
		return idLangue;
	}

	public void setIdLangue(Integer idLangue) {
		this.idLangue = idLangue;
	}

	public String getNomLangue() {
		return nomLangue;
	}

	public void setNomLangue(String nomLangue) {
		this.nomLangue = nomLangue;
	}
	
	
}
