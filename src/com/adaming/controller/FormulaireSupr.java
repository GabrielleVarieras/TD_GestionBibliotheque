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

@WebServlet("/formSupr")
public class FormulaireSupr extends HttpServlet {

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
		String titreSupr=request.getParameter("titreSupr");
		 
		ILivreDao dao=new LivreDao();
		Livre l1=new Livre(); // livre recherché pour être modifié
		l1= dao.getByTitre(titreSupr);
		
		
		//supprimer le livre dans la base de données
		dao.supprimerLivre(l1);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("retour.jsp");
		dispatcher.forward(request, response);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
