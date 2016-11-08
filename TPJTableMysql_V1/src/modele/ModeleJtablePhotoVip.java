/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import accesAuxDonnees.DaoPhotoVip;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import metier.PhotoVip;

/**
 *
 * @author p1406759
 */

public class ModeleJtablePhotoVip extends AbstractTableModel {
    // le conteneur de données

    private List<PhotoVip> leConteneur;
    // le titre des champs du conteneur
    private String[] titre;
    // l'objet DAO pour mettre à jour le conteneur
    private DaoPhotoVip leDaoPhotoVip;

    public ModeleJtablePhotoVip(DaoPhotoVip leDaoPhotoVip) {
        // définition du conteneur d'étudiants
        this.leConteneur = new ArrayList<>();
        // définition des noms du champ
        this.titre = new String[]{"numVip", "numeroSequentid", "date","lieu"};
        // l'objet DAO utilisé
        this.leDaoPhotoVip = leDaoPhotoVip;
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
        PhotoVip laPhotoVip = leConteneur.get(row);
        if (column == 0) {
            return laPhotoVip.getNumVip();
        } else if (column == 1) {
            return laPhotoVip.getNumeroSequentid();
        } else if (column == 2) {
            return laPhotoVip.getDate();
        } else {
            return laPhotoVip.getLieu();
        }

    }

    @Override
    public String getColumnName(int column) {
        return titre[column];
    }

    public void insererPhoto(PhotoVip laPhotoVip) throws SQLException {
        leDaoPhotoVip.insererPhoto(laPhotoVip);
        leConteneur.add(laPhotoVip);
        this.fireTableDataChanged();
    }

    public void supprimerPhotoVip(int ligne) throws SQLException {
        int numVip = (int) getValueAt(ligne, 0);
        int numeroSequentid = (int) getValueAt(ligne, 1);
        leDaoPhotoVip.supprimerPhoto(numVip,numeroSequentid);
        leConteneur.remove(ligne);
        this.fireTableDataChanged();
    }
  

    public void chargerLesPhotos() throws SQLException {
        leDaoPhotoVip.lireLesPhotos(leConteneur);
        fireTableDataChanged();  // notification de modification des données à la vue
    }

      public void clear() throws SQLException {
        leConteneur.clear();  // notification de modification des données à la vue
    }
}
