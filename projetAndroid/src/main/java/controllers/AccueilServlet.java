package main.java.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.metier.Manager;

import com.google.gson.Gson;

public class AccueilServlet extends HttpServlet{

	private static final long serialVersionUID = -6490722321849315871L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		Gson gson1 = new Gson();
		//Gson gson2 = new Gson();
		
		String pos="geolocalisation";
		
		String json1 = gson1.toJson(Manager.getInstance().listerGoutByLieu(pos));
		//String json2 = gson2.toJson(Manager.getInstance().listerUtilisateurArround());
		
		PrintWriter out = response.getWriter();
		out.append(json1);
		//out.append(json2);
		
	}
}
