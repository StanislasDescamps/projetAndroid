package main.java.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import main.java.dao.DataSourceProvider;
import main.java.dao.GenreDao;
import main.java.model.Genre;

public class GenreDaoImpl implements GenreDao{

	public List<Genre> listerGenre() {
		List<Genre> listeGenre = new ArrayList<Genre>();
	    try {
	    	Connection connection = DataSourceProvider.getDataSource().getConnection();
	    	Statement stmt = connection.createStatement();
	    	ResultSet results = stmt.executeQuery("SELECT * FROM genre");
	    while (results.next()) {
	    	Genre genre = new Genre(results.getInt("idGenre"),
	                results.getString("nomGenre"));
	    	listeGenre.add(genre);
	    }
		connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return listeGenre;
	}

	public void ajouterChoixGenre(Integer idUtilisateur, Integer idGenre) {
		try {
	        Connection connection = 
	            DataSourceProvider.getDataSource().getConnection();
	
	        // Utiliser la connexion
	        PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(
	                  "INSERT INTO `doubletGenre`( `idGenre`,`idUtilisateur`) VALUES(?, ?)"); 
	        
	        stmt.setInt(1,idGenre);
	        stmt.setInt(2,idUtilisateur);
	        stmt.executeUpdate();
	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}
