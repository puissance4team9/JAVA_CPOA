/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author p1406759
 */
public class Film {
    int numVisa;
    String titre;
    String genre;
    int annee;

    public Film(int numVisa, String titre, String genre, int annee) {
        this.numVisa = numVisa;
        this.titre = titre;
        this.genre = genre;
        this.annee = annee;
    }

    public Film() {
    }

    public int getNumVisa() {
        return numVisa;
    }

    public String getTitre() {
        return titre;
    }

    public String getGenre() {
        return genre;
    }

    public int getAnnee() {
        return annee;
    }

    public void setNumVisa(int numVisa) {
        this.numVisa = numVisa;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }
   
       @Override
    public String toString() {
        return "Film{" + "numVisa=" + numVisa + ", titre=" + titre + ", genre=" + genre + ", annee="+annee+'}';
    }   
    
}


