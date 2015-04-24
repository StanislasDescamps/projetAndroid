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
import main.java.model.Genre;
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
	
	public List<Utilisateur> listerUtilisateur(){
		return utilisateurDao.listerUtilisateur();
	}
	
	public List<Utilisateur> listerAuthentifiant(){
		return utilisateurDao.listerAuthentifiant();
	}
	public boolean utilisateurtExiste(String mail, String password){
		return utilisateurDao.utilisateurExiste(mail, password);
	}
	public void ajouterUtilisateur(Utilisateur utilisateur) {
		utilisateurDao.ajouterUtilisateur(utilisateur);
	}
	public Utilisateur getUtilisateur(Integer idUtilisateur){
		return utilisateurDao.getUtilisateur(idUtilisateur);
	}
	
	//Langue
	public List<Langue> listerLangue(){
		return langueDao.listerLangue();
	}
	
	public void ajouterChoixLangue(Integer idUtilisateur, Integer idLangue){
		langueDao.ajouterChoixLangue(idUtilisateur,idLangue);
	}
	
	public List<Langue> listerLangueByUtilisateur(Integer idUtilisateur){
		return langueDao.listerLangueByUtilisateur(idUtilisateur);
	}
	//Gout
	public List<Gout> listerGout(){
		return goutDao.listerGout();
	}
	
	public List<Gout> listerGoutByLieu(String lieu){
		return goutDao.listerGoutByLieu(lieu);
	}
	
	public void ajouterGout(Gout gout){
		goutDao.ajouterGout(gout);
	}
	
	public void voteGout(Integer idUtilisateur, Integer idGout, Integer valeur){
		goutDao.voteGout(idUtilisateur,idGout, valeur);
	}
	
	public Gout getGoutByName(String nomGout){
		return goutDao.getGoutByName(nomGout);
	}
	
	public void incrementeVoteOui(Integer idGout){
		goutDao.incrementeVoteOui(idGout);
	}
	
	public void incrementeVoteNon(Integer idGout){
		goutDao.incrementeVoteNon(idGout);
	}
	
	//Genre
	public List<Genre> listerGenre(){
		return genreDao.listerGenre();
	}
	
	public void ajouterChoixGenre(Integer idUtilisateur, Integer idGenre){
		genreDao.ajouterChoixGenre(idUtilisateur,idGenre);
	}
}
