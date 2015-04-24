package main.java.metier;

import java.util.List;

import main.java.dao.GenreDao;
import main.java.dao.GoutDao;
import main.java.dao.LangueDao;
import main.java.dao.UtilisateurDao;
import main.java.dao.impl.GenreDaoImpl;
import main.java.dao.impl.GoutDaoImpl;
import main.java.dao.impl.LangueDaoImpl;
import main.java.dao.impl.UtilisateurDaoImpl;
import main.java.model.Gout;
import main.java.model.Langue;
import main.java.model.Utilisateur;

public class Manager {

	private static Manager instance;
	
	private GenreDao genreDao = (GenreDao) new GenreDaoImpl();
	private GoutDao goutDao = (GoutDao) new GoutDaoImpl();
	private LangueDao langueDao = (LangueDao) new LangueDaoImpl();
	private UtilisateurDao utilisateurDao = (UtilisateurDao) new UtilisateurDaoImpl();
	
	public static Manager getInstance() {
		if(instance == null) {
			instance = new Manager();
		}
		return instance;
	}
	
	//Utilisateur
	
	public List<Utilisateur> listerAuthentifiant(){
		return utilisateurDao.listerAuthentifiant();
	}
	public boolean utilisateurtExiste(String mail, String password){
		return utilisateurDao.utilisateurExiste(mail, password);
	}
	public void ajouterUtilisateur(Utilisateur utilisateur) {
		utilisateurDao.ajouterUtilisateur(utilisateur);
	}
	
	//Langue
	public List<Langue> listerLangue(){
		return langueDao.listerLangue();
	}
	
	public void ajouterChoixLangue(Integer idUtilisateur, Integer idLangue){
		langueDao.ajouterChoixLangue(idUtilisateur,idLangue);
	}
	
	//Gout
	public List<Gout> listerGout(){
		return goutDao.listerGout();
	}
	
	public void ajouterGout(Gout gout){
		goutDao.ajouterGout(gout);
	}
}
