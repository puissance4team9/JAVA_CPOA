/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesAuxDonnees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import metier.Film;

/**
 *
 * @author p1406759
 */
public class DaoFilm {
    
     private final Connection connexion;

    public DaoFilm(Connection connexion) throws SQLException {
        this.connexion = connexion;     
    }

    public void lirelesFilms(List<Film> lesFilms) throws SQLException {    
        String requete = "select * from FILM";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        while (rset.next()) {       // traitement du résulat
            int numVisa = rset.getInt(1);
            String titre = rset.getString(2);
            String genre = rset.getString(3);
            int annee = rset.getInt(4);
            
            Film temp = new Film(numVisa, titre, genre, annee);
//            System.out.println("FILM : "+temp);
            lesFilms.add(temp);
        }
        rset.close();
        pstmt.close();     
    }

    public void supprimerFilm(int numVisa) throws SQLException {
        String requete = "delete from FILM where numVisa = ?";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, numVisa);
        pstmt.executeUpdate();
        pstmt.close();
    }

   public void insererFilm(Film Film) throws SQLException {
        String requete = "insert into FILM values(?,?,?,?)";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, Film.getNumVisa());
        pstmt.setString(2, Film.getTitre());
        pstmt.setString(3, Film.getGenre());
        pstmt.setInt(4, Film.getAnnee());
        pstmt.executeUpdate();
        pstmt.close();
    }
   
     public void chargerlesGenres(List<String> lesGenres) throws SQLException {    
        String requete = "select * from GENRE";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        while (rset.next()) {       // traitement du résulat
            String genre = rset.getString(1);
//            System.out.println("FILM : "+temp);
            lesGenres.add(genre);
        }
        rset.close();
        pstmt.close();     
    }
    
}
