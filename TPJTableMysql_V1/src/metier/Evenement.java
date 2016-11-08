/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.sql.Date;

/**
 *
 * @author p1406759
 */
public class Evenement {
    int numVip;
    Date dateMariage;
    int numVipConjoint;
    String lieuMariage;
    Date dateDivorce;

    public Evenement(int numVip, Date dateMariage, int numVipConjoint, String lieuMariage, Date dateDivorce) {
        this.numVip = numVip;
        this.dateMariage = dateMariage;
        this.numVipConjoint = numVipConjoint;
        this.lieuMariage = lieuMariage;
        this.dateDivorce = dateDivorce;
    }

    public Evenement() {
    }

    public int getNumVip() {
        return numVip;
    }

    public Date getDateMariage() {
        return dateMariage;
    }

    public int getNumVipConjoint() {
        return numVipConjoint;
    }

    public String getLieuMariage() {
        return lieuMariage;
    }

    public Date getDateDivorce() {
        return dateDivorce;
    }

    public void setNumVip(int numVip) {
        this.numVip = numVip;
    }

    public void setDateMariage(Date dateMariage) {
        this.dateMariage = dateMariage;
    }

    public void setNumVipConjoint(int numVipConjoint) {
        this.numVipConjoint = numVipConjoint;
    }

    public void setLieuMariage(String lieuMariage) {
        this.lieuMariage = lieuMariage;
    }

    public void setDateDivorce(Date dateDivorce) {
        this.dateDivorce = dateDivorce;
    }
    
       @Override
    public String toString() {
        return "Evenement{" + "numVip=" + numVip + ", dateMariage=" + dateMariage + ", numVipConjoint=" + numVipConjoint + ", lieuMariage="+lieuMariage+", dateDivorce="+dateDivorce+'}';
    }
    
    

    
}
