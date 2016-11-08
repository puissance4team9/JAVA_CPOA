/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesAuxDonnees;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import metier.Evenement;
/**
 *
 * @author p1406759
 */
public class DaoEvenement {
    private final Connection connexion;

    public DaoEvenement(Connection connexion) throws SQLException {
        this.connexion = connexion;     
    }

    public void lireLesEvenements(List<Evenement> lesEvenements) throws SQLException {    
        String requete = "select * from EVENEMENT ORDER BY dateDivorce, dateMariage DESC";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        while (rset.next()) {       // traitement du résulat
            int numVip = rset.getInt(1);
            Date dateMariage = rset.getDate(2);
            int numVipConjoint = rset.getInt(3);
            String lieuMariage = rset.getString(4); 
            Date dateDivorce = rset.getDate(5);
            
            
            Evenement temp = new Evenement(numVip, dateMariage, numVipConjoint, lieuMariage, dateDivorce);
            lesEvenements.add(temp);
        }
        rset.close();
        pstmt.close();     
    }

//    public void supprimerEmploye(int numVip) throws SQLException {
//        String requete = "delete from VIP where numVip = ?";
//        PreparedStatement pstmt = connexion.prepareStatement(requete);
//        pstmt.setInt(1, numVip);
//        pstmt.executeUpdate();
//        pstmt.close();
//    }

   public void insererMariage(Evenement Event) throws SQLException {
        String requete = "insert into EVENEMENT(numVip, dateMariage, numVipConjoint, lieuMariage) values(?,?,?,?)";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, Event.getNumVip());
        pstmt.setDate(2, Event.getDateMariage());
        pstmt.setInt(3, Event.getNumVipConjoint());
        pstmt.setString(4, Event.getLieuMariage());
        pstmt.executeUpdate();
        pstmt.close();
    }
   
      public void insererDivorce(Evenement eve) throws SQLException {
        String requete = "update EVENEMENT set dateDivorce=? WHERE numVip=? and dateMariage=?";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setDate(1, eve.getDateDivorce());
        pstmt.setInt(2, eve.getNumVip());
        pstmt.setDate(3, eve.getDateMariage());
        pstmt.executeUpdate();
        pstmt.close();
    }
   
   
}
