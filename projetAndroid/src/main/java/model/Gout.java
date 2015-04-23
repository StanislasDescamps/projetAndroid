package main.java.model;

public class Gout {

	private Integer idGout;
	private String libelleGout;
	private Integer idGenre;
	private String lieu;
	private Integer voteOui;
	private Integer voteNon;
	
	public Gout(Integer idgout, String nomgout, Integer idgenre, String adresse, Integer oui, Integer non){
		this.idGout=idgout;
		this.libelleGout=nomgout;
		this.idGenre=idgenre;
		this.lieu=adresse;
		this.voteOui=oui;
		this.voteNon=non;
	}

	public Integer getIdGout() {
		return idGout;
	}

	public void setIdGout(Integer idGout) {
		this.idGout = idGout;
	}

	public String getLibelleGout() {
		return libelleGout;
	}

	public void setLibelleGout(String libelleGout) {
		this.libelleGout = libelleGout;
	}

	public Integer getIdGenre() {
		return idGenre;
	}

	public void setIdGenre(Integer idGenre) {
		this.idGenre = idGenre;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public Integer getVoteOui() {
		return voteOui;
	}

	public void setVoteOui(Integer voteOui) {
		this.voteOui = voteOui;
	}

	public Integer getVoteNon() {
		return voteNon;
	}

	public void setVoteNon(Integer voteNon) {
		this.voteNon = voteNon;
	}
	
}
