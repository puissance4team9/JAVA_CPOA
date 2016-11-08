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
public class PhotoVip {
     int numVip;
     int numeroSequentid;
     Date date;
     String lieu;

    public PhotoVip(int numVip, int numeroSequentid, Date date, String lieu) {
        this.numVip = numVip;
        this.numeroSequentid = numeroSequentid;
        this.date = date;
        this.lieu = lieu;
    }

    public PhotoVip() {
    }

    public int getNumVip() {
        return numVip;
    }

    public int getNumeroSequentid() {
        return numeroSequentid;
    }

    public Date getDate() {
        return date;
    }

    public String getLieu() {
        return lieu;
    }

    public void setNumVip(int numVip) {
        this.numVip = numVip;
    }

    public void setNumeroSequentid(int numeroSequentid) {
        this.numeroSequentid = numeroSequentid;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    
     
}
