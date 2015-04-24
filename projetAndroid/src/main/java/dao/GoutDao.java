package main.java.dao;

import java.util.List;
import main.java.model.Gout;

public interface GoutDao {
	
	public List<Gout> listerGout(); // permet de lister tous les gouts
	public void ajouterGout(Gout gout); //permet d'ajouter un nouveau gout
	public void voteGout(Integer idUtilisateur, Integer idGout, Integer valeur); //permet d'ajouter la note du gout de l'utilisateur
	public Gout getGoutByName(String nomGout); //permet de recupérer les info d'un gout par son nom
	public void incrementeVoteOui(Integer idGout); //permet d'ajouter 1 au vote oui
	public void incrementeVoteNon(Integer idGout); //permet d'ajouter 1 au vote non
}
