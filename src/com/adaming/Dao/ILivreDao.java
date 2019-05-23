package com.adaming.Dao;


import java.util.List;

import com.adaming.model.Livre;

public interface ILivreDao {
	
	public void ajouterLivre(Livre l);
	public void supprimerLivre(Livre l);
	public void modifierLivre(int id, Livre l2);
	public Livre getByTitre(String titre);
	public List<Livre> getAll();

}
