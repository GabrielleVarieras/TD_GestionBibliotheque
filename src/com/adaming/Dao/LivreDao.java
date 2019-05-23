package com.adaming.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.adaming.model.Livre;
import com.adaming.util.ConnectionDB;

public class LivreDao implements ILivreDao{
	
	Connection con;
	PreparedStatement ps;
	
	

//	public LivreDao() {
//		super();
//		// TODO Auto-generated constructor stub
//	}

	public LivreDao() throws ClassNotFoundException {
		super();
		this.con= ConnectionDB.getconnection();
	}

	@Override
	public void ajouterLivre(Livre l) {
		try {
			ps=con.prepareStatement("Insert into livre (titre, auteur, prix) values(?,?,?);");
			ps.setString(1, l.getTitre());
			ps.setString(2, l.getAuteur());
			ps.setFloat(3, l.getPrix());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void supprimerLivre(Livre l) {
		try {
			ps=con.prepareStatement("delete from livre where id=?;");
			ps.setInt(1, l.getId());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void modifierLivre(int id, Livre l2) {
		try {
			ps=con.prepareStatement("update livre set titre =?, auteur =?, prix=? where id=?;");
			ps.setString(1, l2.getTitre());
			ps.setString(2, l2.getAuteur());
			ps.setFloat(3, l2.getPrix());
			ps.setInt(4, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Livre getByTitre(String titre) {
		try {
			ps=con.prepareStatement("select * from livre where titre=?;");
			ps.setString(1, titre);
			ResultSet rs= ps.executeQuery();
			rs.next();
			Livre l=new Livre(rs.getInt("id"), rs.getString("titre"), rs.getString("auteur"), rs.getFloat("prix"));
			System.out.println(l);
			return l;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Livre> getAll() {
		List<Livre> l= new ArrayList<>();
		try {
			ps=con.prepareStatement("select * from livre;");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				l.add(new Livre(rs.getInt("id"), rs.getString("titre"), rs.getString("auteur"), rs.getFloat("prix")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	
	

}
