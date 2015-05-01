package main.java.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import main.java.dao.DataSourceProvider;
import main.java.dao.ActiviteDao;
import main.java.model.Activite;

public class ActiviteDaoImpl implements ActiviteDao{

	public List<Activite> listerActivite() {
		List<Activite> listeGout = new ArrayList<Activite>();
	    try {
	    	Connection connection = DataSourceProvider.getDataSource().getConnection();
	    	Statement stmt = connection.createStatement();
	    	ResultSet results = stmt.executeQuery("SELECT * FROM activite");
	    while (results.next()) {
	    	Activite gout = new Activite(results.getInt("idActivite"),
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

	public void ajouterActivite(Activite gout) {
		try {
	        Connection connection = 
	            DataSourceProvider.getDataSource().getConnection();
	
	        // Utiliser la connexion
	        PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(
	                  "INSERT INTO `activite`(`libelleActivite`, `idGenre`, `lieu`, `voteOui`, `voteNon`) VALUES(?, ?, ?, ?, ?)"); 
	        stmt.setString(1,gout.getLibelleActivite());
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

	public void voteActivite(Integer idUtilisateur, Integer idGout, Integer valeur) {
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

	public Activite getActiviteByName(String nomGout) {
		Activite gout = null;
	    try {
	    	Connection connection = DataSourceProvider.getDataSource().getConnection();
	    
	    	PreparedStatement stmt = (PreparedStatement) connection.prepareStatement("SELECT * FROM activite WHERE libelleActivite =?");
	    	stmt.setString(1, nomGout);
	    	ResultSet results = stmt.executeQuery();
	    while (results.next()) {
	    	gout = new Activite(results.getInt("idActivite"), 
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

	public List<Activite> listerActiviteByLieu(String lieu) {
		List<Activite> listeGout = new ArrayList<Activite>();
	    try {
	    	Connection connection = DataSourceProvider.getDataSource().getConnection();
	    	PreparedStatement stmt = (PreparedStatement) connection.prepareStatement("SELECT * FROM activite WHERE lieu=?");
	    	stmt.setString(1, lieu);
	    	ResultSet results = stmt.executeQuery();
	    	while (results.next()) {
	    		Activite gout = new Activite(results.getInt("idActivite"), 
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

}
