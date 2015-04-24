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

	public void voteGout(Integer idUtilisateur, Integer idGout, Integer valeur) {
		try {
	        Connection connection = 
	            DataSourceProvider.getDataSource().getConnection();
	
	        // Utiliser la connexion
	        PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(
	                  "INSERT INTO `doubletVote`( `idActivite`,`idUtilisateur`,`valeurVote` ) VALUES(?, ?, ?)"); 
	        
	        
	        
	        stmt.setInt(1,idGout);
	        stmt.setInt(2,idUtilisateur);
	        stmt.setInt(3,valeur);
	        stmt.executeUpdate();
	        // Fermer la connexion
	        connection.close();
	        
	        if(valeur==1){
	        	incrementeVoteOui(idGout);
	        }else{
	        	incrementeVoteNon(idGout);
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public Gout getGoutByName(String nomGout) {
		Gout gout = null;
	    try {
	    	Connection connection = DataSourceProvider.getDataSource().getConnection();
	    
	    	PreparedStatement stmt = (PreparedStatement) connection.prepareStatement("SELECT * FROM activite WHERE libelleActivite =?");
	    	stmt.setString(1, nomGout);
	    	ResultSet results = stmt.executeQuery();
	    while (results.next()) {
	    	gout = new Gout(results.getInt("idActivite"), 
	                results.getString("nomActivite"),
	                results.getInt("idGenre"),
	                results.getString("lieu"),
	                results.getInt("voteOui"),
	                results.getInt("voteNon"));
	    }
		connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return gout;
	}

	public void incrementeVoteOui(Integer idGout) {
		try {
	        Connection connection = 
	            DataSourceProvider.getDataSource().getConnection();
	
	        // Utiliser la connexion
	        PreparedStatement stmt1 = (PreparedStatement) connection.prepareStatement(
	                  "UPDATE `activite` SET `voteOui`= voteOui+1 WHERE `idActivite`=?");
	        
	        stmt1.setInt(1,idGout);
	        
	        stmt1.executeUpdate();
	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void incrementeVoteNon(Integer idGout) {
		try {
	        Connection connection = 
	            DataSourceProvider.getDataSource().getConnection();
	
	        // Utiliser la connexion
	        PreparedStatement stmt1 = (PreparedStatement) connection.prepareStatement(
	                  "UPDATE `activite` SET `voteNon`= voteNon+1 WHERE `idActivite`=?");
	        
	        stmt1.setInt(1,idGout);
	        
	        stmt1.executeUpdate();
	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}

}
