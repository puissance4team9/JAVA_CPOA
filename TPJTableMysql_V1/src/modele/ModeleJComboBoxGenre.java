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
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author p1406759
 */
public class ModeleJComboBoxGenre extends DefaultComboBoxModel<String> {
    
     private List<String> listeItems;
     private DaoFilm leDaoFilmGenre;

    public ModeleJComboBoxGenre(DaoFilm leDaoFilmGenre) {
        super();
        this.listeItems = new ArrayList<>();
        this.leDaoFilmGenre = leDaoFilmGenre;
    }

    public void addElement(String uneChaine) {
        super.addElement(uneChaine);
    }

    @Override
    public String getElementAt(int i) {
        return listeItems.get(i);
    }

    @Override
    public int getSize() {
        return listeItems.size();
    }
    
    public void chargerlesGenres(/*List<String> listeItems2*/) throws SQLException{
        leDaoFilmGenre.chargerlesGenres(listeItems);
//        listeItems.add(listeItems2);
     
        
        
    }
    
    
}
