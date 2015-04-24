package main.java.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import main.java.dao.DataSourceProvider;
import main.java.dao.LangueDao;
import main.java.model.Langue;

public class LangueDaoImpl implements LangueDao{

	public List<Langue> listerLangue() {
		List<Langue> listeLangue = new ArrayList<Langue>();
	    try {
	    	Connection connection = DataSourceProvider.getDataSource().getConnection();
	    	Statement stmt = connection.createStatement();
	    	ResultSet results = stmt.executeQuery("SELECT * FROM langues");
	    while (results.next()) {
	    	Langue langue = new Langue(results.getInt("idLangue"), 
	                   results.getString("nomLangue"));
	    	listeLangue.add(langue);
	    }
		connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return listeLangue;
	}

	public void ajouterChoixLangue(Integer idUtilisateur, Integer idLangue) {

		try {
	        Connection connection = 
	            DataSourceProvider.getDataSource().getConnection();
	
	        // Utiliser la connexion
	        PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(
	                  "INSERT INTO `doubletLangue`(`idUtilisateur`, `idLangue`) VALUES(?, ?)"); 
	        
	        stmt.setInt(1,idUtilisateur);
	        stmt.setInt(2,idLangue);
	        stmt.executeUpdate();
	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}

	@Override
	public List<Langue> listerLangueByUtilisateur(Integer idUtilisateur) {
		List<Langue> listeLangue = new ArrayList<Langue>();
	    try {
	    	Connection connection = DataSourceProvider.getDataSource().getConnection();
	    	PreparedStatement stmt = (PreparedStatement) connection.prepareStatement("SELECT * FROM langues INNER JOIN doubletLangue ON langue.idLangue=doubletLangue.idLangue WHERE doubletLangue.idUtilisateur=?");
	    	stmt.setInt(1, idUtilisateur);
	    	ResultSet results = stmt.executeQuery();
	    	while (results.next()) {
	    		Langue langue = new Langue(results.getInt("idLangue"),
	                    results.getString("nomLangue"));
	    		listeLangue.add(langue);
	    }
		connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return listeLangue;
	}

}
