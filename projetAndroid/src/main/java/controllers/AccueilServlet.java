package main.java.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.metier.Manager;
import main.java.model.Langue;
import main.java.model.Utilisateur;

import com.google.gson.Gson;

public class AccueilServlet extends HttpServlet{

	private static final long serialVersionUID = -6490722321849315871L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer idUtilisateur=0;
		//Recupération de tous les utilisateur (-l'utilisateurActuel)
		Utilisateur utilisateurActuel=Manager.getInstance().getUtilisateur(idUtilisateur);	
		List<Utilisateur> toutUtilisateur=Manager.getInstance().listerUtilisateur();
		toutUtilisateur.remove(utilisateurActuel);
		
		//liste des utilisateur environnant 
		List<Utilisateur> listeUtilisateurArround=new ArrayList<>();
		Integer rayon=40000; //distance du rayon en m
		
		/*//adapter le code suivant la geolocalisation
		for(Utilisateur utilisateur : toutUtilisateur){
			if(distanceTo(convert(utilisateur.getPosition())) <= rayon){  //voir comment ça marche
				listeUtilisateurArround.add(utilisateur);
			}
		}
		*/
		
		//Initialisation de la liste finale
		List<Utilisateur> newListeUtilisateurArround=new ArrayList<Utilisateur>();
		
		//voir si dans cette nouvelle liste il y a quelqu'un parlant la meme langue
		if(listeUtilisateurArround!=null){
			//récupération des langue de l'utilisateur actuel
			List<Langue> listeLangueUtilisateurActuel=Manager.getInstance().listerLangueByUtilisateur(idUtilisateur);
			
			for(Utilisateur utilisateur2 : listeUtilisateurArround){
				//récupération des langues de l'utilisateur lambda
				List<Langue> listeLangue=Manager.getInstance().listerLangueByUtilisateur(utilisateur2.getIdUtilisateur());
					
				//comparaison de la liste de langue de l'utilisateur actuel et du lambda
					for(Langue langue: listeLangueUtilisateurActuel ){
						if(listeLangue.contains(langue)){
							newListeUtilisateurArround.add(utilisateur2);
						}
					}
			}
		}
		
		
		Gson gson1 = new Gson();
		Gson gson2 = new Gson();
		
		String pos="geolocalisation"; //comment qu'on fait?
		
		String json1 = gson1.toJson(Manager.getInstance().listerActiviteByLieu(pos));
		String json2 = gson2.toJson(newListeUtilisateurArround);
		
		PrintWriter out = response.getWriter();
		out.append(json1);
		out.append(json2);
		
	}
}
