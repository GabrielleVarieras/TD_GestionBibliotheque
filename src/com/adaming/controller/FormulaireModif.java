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

@WebServlet("/formModif")
public class FormulaireModif extends HttpServlet{

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
		//récupérer le titre du livre à modifier
		String titreModif=request.getParameter("titreModif");

		Livre l1=new Livre(); // livre recherché pour être modifié
		
		ILivreDao dao=new LivreDao();
		l1 = dao.getByTitre(titreModif);
		int id1= l1.getId();
		System.out.println("le livre recherché par titre"+l1.toString());
		
		String nTitre =request.getParameter("nTitre");
		String nAuteur =request.getParameter("nAuteur");
		String prix =request.getParameter("nPrix");
		Float nPrix= Float.parseFloat(prix);
		
		Livre l2=new Livre(); //livre avec les modifications
		l2.setTitre(nTitre);
		l2.setAuteur(nAuteur);
		l2.setPrix(nPrix);
		
		
		//faire les modification du livre 1 avec celles du livre 2
		dao.modifierLivre(id1, l2);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("retour.jsp");
		dispatcher.forward(request, response);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


}
