package main.java.dao;

import java.util.List;
import main.java.model.Langue;

public interface LangueDao {

	public List<Langue> listerLangue(); //permet de lister toutes les langues
	public void ajouterChoixLangue(Integer idUtilisateur, Integer idLangue); //permet d'attibuer une langue à un utiisateur
	public List<Langue> listerLangueByUtilisateur(Integer idUtilisateur); //permet de recupérer les langues de l'utilisateur
}
