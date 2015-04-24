package main.java.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import main.java.metier.Manager;
import main.java.model.Gout;

public class AjouterGoutServlet extends HttpServlet {

	private static final long serialVersionUID = 4122467283462037480L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Gson gson = new Gson();
		String json = gson.toJson(Manager.getInstance().listerGout());
		PrintWriter out = response.getWriter();
		out.append(json);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		/////////////////A synchroniser aver les balises sur android/////////////////////////////////////////////
		Integer idgenre=Integer.parseInt(request.getParameter("genre"));
		String nomActivite=request.getParameter("nomActivite");
		String lieu=request.getParameter("lieu");
		
		
		Gout nouveauGout= new Gout(null,nomActivite, idgenre, lieu);
		Manager.getInstance().ajouterGout(nouveauGout);
		
	}
}
