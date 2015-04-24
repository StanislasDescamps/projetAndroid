package main.java.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import main.java.dao.DataSourceProvider;
import main.java.dao.UtilisateurDao;
import main.java.model.Utilisateur;

public class UtilisateurDaoImpl implements UtilisateurDao{

	public List<Utilisateur> listerUtilisateur() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Utilisateur> listerAuthentifiant() {
		List<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>();
	    try {
	    	Connection connection = DataSourceProvider.getDataSource().getConnection();
	    	Statement stmt = connection.createStatement();
	    	ResultSet results = stmt.executeQuery("SELECT * FROM utilisateur");
	    while (results.next()) {
	    	Utilisateur utilisateur = new Utilisateur(results.getString("email"), 
	                   results.getString("pseudo"),
	                   results.getString("password"));
	    	listeUtilisateur.add(utilisateur);
	    }
		connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return listeUtilisateur;
	}

	public boolean utilisateurExiste(String mail, String password) {

		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();

// Utiliser la connexion
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement("SELECT * FROM `utilisateur` WHERE `email`=? and `password`=?");
			stmt.setString(1, mail);
			stmt.setString(2, password);

			ResultSet results = stmt.executeQuery();
            	if (results.first())
            	{
            		return true;
            	}
            
        	// Fermer la connexion
            	connection.close();
            } catch (SQLException e) {
            e.printStackTrace();
            }
            return false;
		}
	public Utilisateur getUtilisateur(Integer idUtilisateur) {
		Utilisateur utilisateur= null;
		// Cr�er une nouvelle connexion � la BDD
	    try {
	        Connection connection = 
	            DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = (PreparedStatement) connection
	        		.prepareStatement("SELECT * FROM utilisateur WHERE idUtilisateur =? ");
	        
	        stmt.setInt(1, idUtilisateur);
	        ResultSet results = stmt.executeQuery();
	        if(results.next()){
	        	utilisateur = new Utilisateur(results.getInt("idEtudiant"),
	                    results.getString("password"),
	                    results.getString("pseudo"),
	                    results.getString("email"),
	                    results.getInt("sexe"),
	                    results.getInt("age"),
	                    results.getString("regionOrigine"),
	                    results.getString("position"),
	                    results.getString("image"),
	                    results.getBoolean("communication"));
	        }

	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return utilisateur;
	}
}
