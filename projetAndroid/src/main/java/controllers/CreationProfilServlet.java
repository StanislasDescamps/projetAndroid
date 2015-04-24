package main.java.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.metier.Manager;
import main.java.model.Utilisateur;

public class CreationProfilServlet extends HttpServlet{

	private static final long serialVersionUID = -1571916508661409093L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		/////////////////A synchroniser aver les balises sur android/////////////////////////////////////////////
		String pseudo=request.getParameter("pseudo");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		Integer sexe=Integer.parseInt(request.getParameter("sexe"));  
		Integer age=Integer.parseInt(request.getParameter("age"));
		String image=request.getParameter("image");
		String origine=request.getParameter("origine");
		
		//Récupération de tous les étudiant dans une liste
		List<Utilisateur> listUtilisateur = new ArrayList<Utilisateur>();
		listUtilisateur = Manager.getInstance().listerAuthentifiant();
				
		Integer i=0;
		Integer n = listUtilisateur.size();
		Boolean existe=false;
		//Vérification que le mail n'est pas deja utilisé
		while(i<n && !existe)
		{
			if(email.equalsIgnoreCase(listUtilisateur.get(i).getEmail()))
				{
				existe=true;
				}
			else i++;
		}
		//s'il n'existe pas on crée le profil
		if(!existe)
		{
			Utilisateur nouvelUtilisateur = new Utilisateur(null, password, pseudo, email, sexe, age, origine,image,true);
			Manager.getInstance().ajouterUtilisateur(nouvelUtilisateur);
			
/////////////////////////////////////////////Comment recupérer l'id de l'utilisateur/////////////////
			Integer idUtilisateur=0;
			
			//Récupération de tous les éléments cochés et ajout dans une liste de format string
			//Choix des langues
			String[] choixLangue = request.getParameterValues("langues");
			for(int j=0;j<choixLangue.length;j++)
			{
				//Ajout du choix de l'utilisateur dans la base de données
				Integer idLangue=Integer.parseInt(choixLangue[i]);
				Manager.getInstance().ajouterChoixLangue(idUtilisateur,idLangue);
				
			}
			
			//Choix des genres
			String[] choixGenre = request.getParameterValues("genre");
			for(int k=0;k<choixGenre.length;k++)
			{
				//Ajout du choix de l'utilisateur dans la base de données
				Integer idGenre=Integer.parseInt(choixGenre[i]);
				Manager.getInstance().ajouterChoixLangue(idUtilisateur,idGenre);
			}
		}
	}
		
}
