package main.java.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import main.java.dao.DataSourceProvider;
import main.java.dao.GoutDao;
import main.java.model.Gout;

public class GoutDaoImpl implements GoutDao{

	public List<Gout> listerGout() {
		List<Gout> listeGout = new ArrayList<Gout>();
	    try {
	    	Connection connection = DataSourceProvider.getDataSource().getConnection();
	    	Statement stmt = connection.createStatement();
	    	ResultSet results = stmt.executeQuery("SELECT * FROM activite");
	    while (results.next()) {
	    	Gout gout = new Gout(results.getInt("idActivite"),
	    			results.getString("libelleActivite"),
	    			results.getInt("idGenre"),
	    			results.getString("lieu"),
	                results.getInt("voteOui"),
	                results.getInt("voteNon"));
	    	listeGout.add(gout);
	    }
		connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return listeGout;
	}

	public void ajouterGout(Gout gout) {
		try {
	        Connection connection = 
	            DataSourceProvider.getDataSource().getConnection();
	
	        // Utiliser la connexion
	        PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(
	                  "INSERT INTO `activite`(`libelleActivite`, `idGenre`, `lieu`, `voteOui`, `voteNon`) VALUES(?, ?, ?, ?, ?)"); 
	        stmt.setString(1,gout.getLibelleGout());
	        stmt.setInt(2,gout.getIdGenre());
	        stmt.setString(3,gout.getLieu());
	        stmt.setInt(4,0);
	        stmt.setInt(5,0);
	        stmt.executeUpdate();
	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}

}
