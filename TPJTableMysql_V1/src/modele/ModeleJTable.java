/*
 * To change this template, choose Tools | Templates
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
 * @author Alain
 */
public class ModeleJTable extends AbstractTableModel {
    // le conteneur de données

    private List<VIP> leConteneur;
    // le titre des champs du conteneur
    private String[] titre;
    // l'objet DAO pour mettre à jour le conteneur
    private DaoEmp leDaoEmp;

    public ModeleJTable(DaoEmp leDaoEmp) {
        // définition du conteneur d'étudiants
        this.leConteneur = new ArrayList<>();
        // définition des noms du champ
        this.titre = new String[]{"numVip", "nomVip", "prenomVip","civilite", "dateNaissance", "lieuNaissance","codeRole", "nomPays", "codeStatut"};
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
        } else if (column == 2) {
            return VIP.getPrenomVip();
        } else if (column == 3) {
            return VIP.getCivilite();
        } else if (column == 4) {
            return VIP.getDateNaissance();
        } else if (column == 5) {
            return VIP.getLieuNaissance();
        } else if (column == 6) {
            return VIP.getCodeRole();
        } else if (column == 7) {
            return VIP.getNomPays();
        } else {
            return VIP.getCodeStatut();
        }

    }

    @Override
    public String getColumnName(int column) {
        return titre[column];
    }

    public void insererEmploye(VIP vip) throws SQLException {
        leDaoEmp.insererEmploye(vip);
        leConteneur.add(vip);
        this.fireTableDataChanged();
    }

    public void supprimerEmploye(int ligne) throws SQLException {
        int numVip = (int) getValueAt(ligne, 0);
        leDaoEmp.supprimerEmploye(numVip);
        leConteneur.remove(ligne);
        this.fireTableDataChanged();
    }
    public void modifierVip(VIP newVip) throws SQLException {
        leDaoEmp.modifierVip(newVip);
//        leConteneur.add(newVip);
        this.fireTableDataChanged();
    }

    public void chargerLesEmployes() throws SQLException {
        leDaoEmp.lireLesEmployes(leConteneur);
        fireTableDataChanged();  // notification de modification des données à la vue
    }
    
    public int maxNumVip() throws SQLException {
        return leDaoEmp.maxNumVip();
    }
    
      public void clear() throws SQLException {
        leConteneur.clear();  // notification de modification des données à la vue
    }
}
