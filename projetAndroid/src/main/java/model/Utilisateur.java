package main.java.model;

public class Utilisateur {

	private Integer idUtilisateur;
	private String password;
	private String pseudo;
	private Integer age;
	private Integer sexe;
	private String email;
	private String domicile;
	private String position;
	private String image;
	private boolean communication;
	
	public Utilisateur(Integer idUser, String pass, String pseudo, String mail, Integer sexe, Integer age, String origine, String pos, String logo, boolean comm){
		this.idUtilisateur=idUser;
		this.password=pass;
		this.pseudo=pseudo;
		this.email=mail;
		this.sexe=sexe;
		this.age=age;
		this.domicile=origine;
		this.position=pos;
		this.image=logo;
		this.communication=comm;
	}
	
	public Utilisateur(String mail, String pseudo, String password){
		this.email=mail;
		this.pseudo=pseudo;
		this.password=password;
	}
	
	public Integer getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Integer idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSexe() {
		return sexe;
	}

	public void setSexe(Integer sexe) {
		this.sexe = sexe;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDomicile() {
		return domicile;
	}

	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isCommunication() {
		return communication;
	}

	public void setCommunication(boolean communication) {
		this.communication = communication;
	}
}
