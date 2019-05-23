package com.adaming.model;

public class Livre {
	
	private int id;
	private String titre;
	private String auteur;
	private Float prix;
	
	//constructeurs
	public Livre(int id, String titre, String auteur, Float prix) {
		super();
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
		this.prix = prix;
	}
	public Livre() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//getters && setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public Float getPrix() {
		return prix;
	}
	public void setPrix(Float prix) {
		this.prix = prix;
	}
	@Override
	public String toString() {
		return "id=" + id + "     titre=" + titre + "     auteur=" + auteur + "   prix=" + prix ;
	}
	
	

}
