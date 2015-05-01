package main.java.model;

public class Activite {

	private Integer idActivite;
	private String libelleActivite;
	private Integer idGenre;
	private String lieu;
	private Integer voteOui;
	private Integer voteNon;
	
	public Activite(Integer idgout, String nomgout, Integer idgenre, String adresse, Integer oui, Integer non){
		this.idActivite=idgout;
		this.libelleActivite=nomgout;
		this.idGenre=idgenre;
		this.lieu=adresse;
		this.voteOui=oui;
		this.voteNon=non;
	}
	
	public Activite(Integer idgout, String nomgout, Integer idgenre, String adresse){
		this.idActivite=idgout;
		this.libelleActivite=nomgout;
		this.idGenre=idgenre;
		this.lieu=adresse;
	}

	public Integer getIdActivite() {
		return idActivite;
	}

	public void setIdActivite(Integer idActivite) {
		this.idActivite = idActivite;
	}

	public String getLibelleActivite() {
		return libelleActivite;
	}

	public void setLibelleActivite(String libelleActivite) {
		this.libelleActivite = libelleActivite;
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
