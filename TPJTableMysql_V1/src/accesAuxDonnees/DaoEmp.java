/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesAuxDonnees;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import metier.VIP;

/**
 *
 * @author Alain
 */
public class DaoEmp {

    private final Connection connexion;

    public DaoEmp(Connection connexion) throws SQLException {
        this.connexion = connexion;     
    }

    public void lireLesEmployes(List<VIP> lesVIP) throws SQLException {    
        String requete = "select * from VIP";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        while (rset.next()) {       // traitement du résulat
            int numVip = rset.getInt(1);
            String nomVip = rset.getString(2);
            String prenomVip = rset.getString(3);
            String civilite = rset.getString(4);
            Date dateNaissance = rset.getDate(5);
            String lieuNaissance = rset.getString(6);
            String codeRole = rset.getString(7);
            String nomPays = rset.getString(8);
            String codeStatut = rset.getString(9);
            
            
            
            VIP temp = new VIP(numVip, nomVip, prenomVip, civilite, dateNaissance, lieuNaissance, codeRole, nomPays, codeStatut);
            lesVIP.add(temp);
        }
        rset.close();
        pstmt.close();     
    }
    
//    public void lireLesVIPs(List<VIP> lesVIP) throws SQLException {    
//        String requete = "select numVip, nomVip, PrenomVip, codeStatut from VIP where codeStatut!="+"Marié";
//        PreparedStatement pstmt = connexion.prepareStatement(requete);
//        ResultSet rset = pstmt.executeQuery(requete);
//        while (rset.next()) {       // traitement du résulat
//            int numVip = rset.getInt(1);
//            String nomVip = rset.getString(2);
//            String prenomVip = rset.getString(3);
//            String codeStatut = rset.getString(4);
//            
//            
//            
//            VIP temp = new VIP(numVip, nomVip, prenomVip,codeStatut);
//            lesVIP.add(temp);
//        }
//        rset.close();
//        pstmt.close();     
//    }
    
//    public void lireLesVIPs2(List<VIP> lesVIP, int numVip) throws SQLException {    
//        String requete = "select numVip, nomVip, PrenomVip, codeStatut from VIP where codeStatut!=? and numVip!=?";
//        PreparedStatement pstmt = connexion.prepareStatement(requete);
//        pstmt.setString(1, "Marié");
//        pstmt.setInt(2, numVip);
//        ResultSet rset = pstmt.executeQuery(requete);
//        while (rset.next()) {       // traitement du résulat
//            int numVip2 = rset.getInt(1);
//            String nomVip = rset.getString(2);
//            String prenomVip = rset.getString(3);
//            String codeStatut = rset.getString(4);
//            
//            
//            
//            VIP temp = new VIP(numVip2, nomVip, prenomVip,codeStatut);
//            lesVIP.add(temp);
//        }
//        rset.close();
//        pstmt.close();     
//    }

    public void supprimerEmploye(int numVip) throws SQLException {
        String requete = "delete from VIP where numVip = ?";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, numVip);
        pstmt.executeUpdate();
        pstmt.close();
    }

   public void insererEmploye(VIP vip) throws SQLException {
        String requete = "insert into VIP(NumVip, NomVip, PrenomVip, Civilite, DateNaissance, LieuNaissance, CodeRole, NomPays, CodeStatut)  values(?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, vip.getNumVip());
        pstmt.setString(2, vip.getNomVip());
        pstmt.setString(3, vip.getPrenomVip());
        pstmt.setString(4, vip.getCivilite());
        pstmt.setDate(5, vip.getDateNaissance());
        pstmt.setString(6, vip.getLieuNaissance());
        pstmt.setString(7, vip.getCodeRole());
        pstmt.setString(8, vip.getNomPays());
        pstmt.setString(9, vip.getCodeStatut());
        pstmt.executeUpdate();
        pstmt.close();
    }
   
     public void modifierVip(VIP newVip) throws SQLException {
        String requete = "update VIP set nomVip =?, prenomVip =?, civilite=?, dateNaissance =?, lieuNaissance =?, codeRole=?, nomPays =?, CodeStatut =? WHERE numVip=? ";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setString(1, newVip.getNomVip());
        pstmt.setString(2, newVip.getPrenomVip());
        pstmt.setString(3, newVip.getCivilite());
        pstmt.setDate(4, newVip.getDateNaissance());
        pstmt.setString(5, newVip.getLieuNaissance());
        pstmt.setString(6, newVip.getCodeRole());
        pstmt.setString(7, newVip.getNomPays());
        pstmt.setString(8, newVip.getCodeStatut());
        pstmt.setInt(9, newVip.getNumVip());
        pstmt.executeUpdate();
        pstmt.close();
    }
     
     public int maxNumVip() throws SQLException {
       int numeroVip=0;
        String requete = "select MAX(numVip) FROM VIP";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
      //  pstmt.setInt(1,numVip);
       
        ResultSet rset = pstmt.executeQuery(requete);
        while (rset.next()) {       // traitement du résulat
            
             numeroVip = rset.getInt(1);
            
        }
        rset.close();
        pstmt.close();
        numeroVip++;
        return numeroVip;
    }
     
     public int maxSequentIdPhoto(int numVip) throws SQLException {
       int numeroSequentid=0;
        String requete = "select MAX(NumeroSenquentid) FROM PHOTOVIP  WHERE numVip= " + numVip;
        PreparedStatement pstmt = connexion.prepareStatement(requete);
      //  pstmt.setInt(1,numVip);
       
        ResultSet rset = pstmt.executeQuery(requete);
        while (rset.next()) {       // traitement du résulat
            
             numeroSequentid = rset.getInt(1);
            
        }
        rset.close();
        pstmt.close();
        numeroSequentid++;
        return numeroSequentid;
    }
     
    public void chargerLesPays(List<String> lesPays) throws SQLException {    
        String requete = "select * from PAYS";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        while (rset.next()) {       // traitement du résulat
            String pays = rset.getString(1);
//            System.out.println("pays : "+temp);
            lesPays.add(pays);
        }
        rset.close();
        pstmt.close();     
    }
    
    
}
