package main.java.dao;

import java.util.List;
import main.java.model.Activite;

public interface ActiviteDao {
	
	public List<Activite> listerActivite(); // permet de lister tous les gouts
	public List<Activite> listerActiviteByLieu(String lieu); // permet de lister tous les gouts a partir du lieu
	public void ajouterActivite(Activite gout); //permet d'ajouter un nouveau gout
	public void voteActivite(Integer idUtilisateur, Integer idActivite, Integer valeur); //permet d'ajouter la note du gout de l'utilisateur
	public Activite getActiviteByName(String nomActivite); //permet de recupérer les info d'un gout par son nom
	public void incrementeVoteOui(Integer idActivite); //permet d'ajouter 1 au vote oui
	public void incrementeVoteNon(Integer idActivite); //permet d'ajouter 1 au vote non
}
