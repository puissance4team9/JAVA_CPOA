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
import metier.PhotoVip;
import metier.VIP;

/**
 *
 * @author p1406759
 */
public class DaoPhotoVip {
    
    private final Connection connexion;

    public DaoPhotoVip(Connection connexion) throws SQLException {
        this.connexion = connexion;     
    }

    public void lireLesPhotos(List<PhotoVip> lesPhotoVip) throws SQLException {    
        String requete = "select * from PHOTOVIP";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        while (rset.next()) {       // traitement du résulat
            int numVip = rset.getInt(1);
            int numeroSequentid = rset.getInt(2);
            Date date = rset.getDate(3);
            String lieu = rset.getString(4);
 
            PhotoVip temp = new PhotoVip(numVip, numeroSequentid, date, lieu);
            lesPhotoVip.add(temp);
        }
        rset.close();
        pstmt.close();     
    }

    public void supprimerPhoto(int numVip,int numeroSequentid) throws SQLException {
        String requete = "delete from PHOTOVIP where numVip = ? and numeroSenquentid= ?";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, numVip);
        pstmt.setInt(2, numeroSequentid);
        pstmt.executeUpdate();
        pstmt.close();
    }

   public void insererPhoto(PhotoVip laPhotoVip) throws SQLException {
        String requete = "insert into PHOTOVIP  values(?,?,?,?)";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, laPhotoVip.getNumVip());
        pstmt.setInt(2, laPhotoVip.getNumeroSequentid());
        pstmt.setDate(3, laPhotoVip.getDate());
        pstmt.setString(4, laPhotoVip.getLieu());
        pstmt.executeUpdate();
        pstmt.close();
    }
   
//   public int maxSequentIdPhoto(int numVip) throws SQLException {
//       int numeroSequentid=0;
//        String requete = "select MAX(NumeroSequentid) FROM PHOTOVIP  WHERE numVip= ?";
//        PreparedStatement pstmt = connexion.prepareStatement(requete);
//        pstmt.setInt(1,numVip);
//       
//        ResultSet rset = pstmt.executeQuery(requete);
//        while (rset.next()) {       // traitement du résulat
//            
//             numeroSequentid = rset.getInt(1);
//            
//        }
//        rset.close();
//        pstmt.close();  
//        return numeroSequentid++;
//    }
}

    
    
    

