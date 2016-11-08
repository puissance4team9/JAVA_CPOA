/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import accesAuxDonnees.DaoFilm;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import metier.Film;

/**
 *
 * @author p1406759
 */
public class modeleJTableFilm extends AbstractTableModel {

//  // le conteneur de données

    private List<Film> leConteneur;
    // le titre des champs du conteneur
    private String[] titre;
    // l'objet DAO pour mettre à jour le conteneur
    private DaoFilm leDaoFilm;

    public modeleJTableFilm(DaoFilm daoFilm) {
        // définition du conteneur d'étudiants
        this.leConteneur = new ArrayList<>();
        // définition des noms du champ
        this.titre = new String[]{"numVisa", "titre", "genre","annee"};
        // l'objet DAO utilisé
        this.leDaoFilm = daoFilm;
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
        Film Film = leConteneur.get(row);
        if (column == 0) {
            return Film.getNumVisa();
        } else if (column == 1) {
            return Film.getTitre();
        } else if (column == 2) {
            return Film.getGenre();
        } else {
            return Film.getAnnee();
        }

    }

    @Override
    public String getColumnName(int column) {
        return titre[column];
    }

    public void insererFilm(Film film) throws SQLException {
        leDaoFilm.insererFilm(film);
        leConteneur.add(film);
        this.fireTableDataChanged();
    }

    public void supprimerFilm(int ligne) throws SQLException {
        int numVisa = (int) getValueAt(ligne, 0);
        leDaoFilm.supprimerFilm(numVisa);
        leConteneur.remove(ligne);
        this.fireTableDataChanged();
    }

    public void chargerLesFilms() throws SQLException {
        leDaoFilm.lirelesFilms(leConteneur);
        fireTableDataChanged();  // notification de modification des données à la vue
    }
    
}
