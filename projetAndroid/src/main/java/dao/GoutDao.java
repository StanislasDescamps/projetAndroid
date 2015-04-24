package main.java.dao;

import java.util.List;
import main.java.model.Gout;

public interface GoutDao {
	
	public List<Gout> listerGout(); // permet de lister tous les gouts
	public void ajouterGout(Gout gout); //permet d'ajouter un nouveau gout
}
