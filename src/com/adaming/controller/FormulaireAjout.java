package com.adaming.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adaming.Dao.ILivreDao;
import com.adaming.Dao.LivreDao;
import com.adaming.model.Livre;

@WebServlet("/form")
public class FormulaireAjout extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		//TODO Auto-generated method sub
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		//Créer un livre avec les paramètre entrés dans le formulaire
		Livre l1=new Livre();
		String titre= request.getParameter("titre");
		l1.setTitre(titre);
		String auteur = request.getParameter("auteur");
		l1.setAuteur(auteur);
		String prix1=request.getParameter("prix");
		Float prix= Float.parseFloat(prix1);
		l1.setPrix(prix);
		//J'ai vérifié les paramètres rentrent bien dans l1

		
		//ajout du livre dans la base de données
		ILivreDao dao= new LivreDao();
		dao.ajouterLivre(l1);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("retour.jsp");
		dispatcher.forward(request, response);
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	}

}
