package main.java.dao;

import java.util.List;

import main.java.model.Utilisateur;

public interface UtilisateurDao {

	public List<Utilisateur> listerUtilisateur(); //inutil dans notre cas
	public List<Utilisateur> listerAuthentifiant(); //permet de recupérer tous les triplet email, pseudo, password (connection par email ou par pseudo?)
	public boolean utilisateurExiste(String mail, String password); //verifie qu'un utilisateur existe bien
	public Utilisateur getUtilisateur(Integer idUtilisateur); //recupère les informations d'un utilisateur
	public void ajouterUtilisateur(Utilisateur utilisateur); //création d'un profil
	
}
