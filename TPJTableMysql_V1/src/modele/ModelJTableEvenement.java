/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;


import accesAuxDonnees.DaoEvenement;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import metier.Evenement;

/**
 *
 * @author p1406759
 */
public class ModelJTableEvenement extends AbstractTableModel {
    // le conteneur de données

    private List<Evenement> leConteneur;
    // le titre des champs du conteneur
    private String[] titre;
    // l'objet DAO pour mettre à jour le conteneur
    private DaoEvenement leDaoEvent;

    public ModelJTableEvenement(DaoEvenement leDaoEvent) {
        // définition du conteneur d'étudiants
        this.leConteneur = new ArrayList<>();
        // définition des noms du champ
        this.titre = new String[]{"numVip", "dateMariage", "numVipConjoint","lieuMariage", "dateDivorce"};
        // l'objet DAO utilisé
        this.leDaoEvent = leDaoEvent;
    }

    @Override
    public int getRowCount() {
        return leConteneur.size();
    }

    @Override
    public int getColumnCount() {
        return titre.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Evenement Event = leConteneur.get(row);
        if (column == 0) {
            return Event.getNumVip();
        } else if (column == 1) {
            return Event.getDateMariage();
        } else if (column == 2) {
            return Event.getNumVipConjoint();
        } else if (column == 3) {
            return Event.getLieuMariage();
        } else {
        return Event.getDateDivorce();
        }

    }

    @Override
    public String getColumnName(int column) {
        return titre[column];
    }

    public void insererMariage(Evenement Event) throws SQLException {
        leDaoEvent.insererMariage(Event);
        leConteneur.add(Event);
        this.fireTableDataChanged();
    }

    public void insererDivorce(Evenement eve) throws SQLException {
        leDaoEvent.insererDivorce(eve);
//        leConteneur.add(eve);
        this.fireTableDataChanged();
    }

    public void chargerLesEvenements() throws SQLException {
        leDaoEvent.lireLesEvenements(leConteneur);
        this.fireTableDataChanged();  // notification de modification des données à la vue
    }
      public void clear() throws SQLException {
        leConteneur.clear();  // notification de modification des données à la vue
    }

}
