/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import modele.ModeleJTable;
import ihm.FenetreIdentification;
import ihm.FenetreApplication;
import accesAuxDonnees.DaoEmp;
import accesAuxDonnees.DaoEvenement;
import accesAuxDonnees.DaoFilm;
import accesAuxDonnees.DaoPhotoVip;
import accesAuxDonnees.SourceMySql;
import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import modele.ModelJTableEvenement;
import modele.ModeleJComboBoxGenre;
import modele.ModeleJComboboxPays;
import modele.ModeleJTableNumVipPhoto;
import modele.ModeleJtablePhotoVip;
import modele.modeleJTableFilm;
import modele.modeleVipEvenement;

/**
 *
 * @author Alain
 */
public class Appli {

    private static DataSource laSourceDeDonnees;
    private static Connection laConnexion;
    private static DaoEmp daoEmp;
    private static DaoEvenement DaoEvent;
    private static DaoFilm leDaoFilm;
    private static DaoPhotoVip leDaoPhotoVip;
    
    public static void main(String[] args) {

        // Look and Feel windows
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.print(e.getMessage());
        }

        // Etablissement de la connexion à la base MySql avec affichage de la fenetre d'identification 
        boolean etat = false;
        do {
            FenetreIdentification fi = new FenetreIdentification(null);
            PasswordAuthentication login = fi.identifier();
            try {
                laSourceDeDonnees = SourceMySql.getSource(login);
                laConnexion = laSourceDeDonnees.getConnection();
                etat = true;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "login incorrect : " + ex.getMessage(),
                        "avertissement", JOptionPane.WARNING_MESSAGE);
            }
        } while (etat == false);

        // Instanciation des objets nécessaires à l'application
        try {
            // les DAO nécessaires
            daoEmp = new DaoEmp(laConnexion);
            DaoEvent = new DaoEvenement(laConnexion);
            leDaoFilm = new DaoFilm(laConnexion);
            leDaoPhotoVip = new DaoPhotoVip(laConnexion);
            // les modèles de données avec le DAO à partir duquel se feront les échanges de données
            final ModeleJTable leModele = new ModeleJTable(daoEmp);
             final ModelJTableEvenement leModeleEvent = new ModelJTableEvenement(DaoEvent);
//             final modeleVipEvenement lemodeleVipEvenement = new modeleVipEvenement(daoEmp);
              final modeleJTableFilm leModeleFilm = new modeleJTableFilm(leDaoFilm);
              final ModeleJComboBoxGenre leModeleJComboBoxGenre = new ModeleJComboBoxGenre(leDaoFilm);
              final ModeleJComboboxPays leModeleJComboboxPays = new ModeleJComboboxPays(daoEmp);
              final ModeleJtablePhotoVip leModeleJtablePhotoVip = new ModeleJtablePhotoVip(leDaoPhotoVip);
              final ModeleJTableNumVipPhoto leModeleJTableNumVipPhoto = new ModeleJTableNumVipPhoto(daoEmp);
//              leModeleFilm.chargerLesFilms();p
            // la fenetre principale de l'application qui tourne dans l'EDT
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new FenetreApplication(leModele, leModeleEvent, leModeleFilm, leModeleJComboboxPays, leModeleJComboBoxGenre, leModeleJtablePhotoVip, leModeleJTableNumVipPhoto).setVisible(true);
                }
            });
             //les DAO nécessaires
//            DaoEvent = new DaoEvenement(laConnexion);
//            // les modèles de données avec le DAO à partir duquel se feront les échanges de données
//            final ModelJTableEvenement leModele = new ModelJTableEvenement(DaoEvent);
//            // la fenetre principale de l'application qui tourne dans l'EDT
//            javax.swing.SwingUtilities.invokeLater(new Runnable() {
//                @Override
//                public void run() {
//                    new FenetreEvenement(leModele).setVisible(true);
//                }
//            });
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "problème dans la création des objets nécessaires" + ex.getMessage(),
                    "avertissement", JOptionPane.WARNING_MESSAGE);
        }
    }
}
