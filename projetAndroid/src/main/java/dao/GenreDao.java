package main.java.dao;

import java.util.List;
import main.java.model.Genre;

public interface GenreDao {

	public List<Genre> listerGenre(); //permet de lister tous les genres
	public void ajouterChoixGenre(Integer idUtilisateur, Integer idGenre); //permet à l'utilisateur de choisir ces preferences de genre
	
}
