/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import accesAuxDonnees.DaoEmp;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import metier.VIP;

/**
 *
 * @author p1406759
 */

public class ModeleJTableNumVipPhoto extends AbstractTableModel {
    // le conteneur de données

    private List<VIP> leConteneur;
    // le titre des champs du conteneur
    private String[] titre;
    // l'objet DAO pour mettre à jour le conteneur
    private DaoEmp leDaoEmp;

    public ModeleJTableNumVipPhoto(DaoEmp leDaoEmp) {
        // définition du conteneur d'étudiants
        this.leConteneur = new ArrayList<>();
        // définition des noms du champ
        this.titre = new String[]{"numVip", "nomVip", "prenomVip"};
        // l'objet DAO utilisé
        this.leDaoEmp = leDaoEmp;
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
        VIP VIP = leConteneur.get(row);
        if (column == 0) {
            return VIP.getNumVip();
        } else if (column == 1) {
            return VIP.getNomVip();
        } else{
            return VIP.getPrenomVip();
        } 

    }

    @Override
    public String getColumnName(int column) {
        return titre[column];
    }

    public void chargerLesVips2() throws SQLException {
        leDaoEmp.lireLesEmployes(leConteneur);
        fireTableDataChanged();  // notification de modification des données à la vue
    }
    
     public int maxSequentPhoto(int numVip) throws SQLException {
        return leDaoEmp.maxSequentIdPhoto(numVip);
         
    }
    
      public void clear() throws SQLException {
        leConteneur.clear();  // notification de modification des données à la vue
    }
}
