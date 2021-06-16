/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

import java.sql.Date;

/**
 *
 * @author papad
 */
public class Prod {
    
    private int produsID;
    private String denumire;
    private float stoc;
    private Date dataAparitiei;
    private String descriere;
    private float pret;
    private String imagine;
    private int categID;

    public Prod() {
    }

    public Prod(int produsID, String denumire, float stoc, Date dataAparitiei, String descriere, float pret, String imagine, int categID) {
        this.produsID = produsID;
        this.denumire = denumire;
        this.stoc = stoc;
        this.dataAparitiei = dataAparitiei;
        this.descriere = descriere;
        this.pret = pret;
        this.imagine = imagine;
        this.categID = categID;
    }

    public int getProdusID() {
        return produsID;
    }

    public void setProdusID(int produsID) {
        this.produsID = produsID;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public float getStoc() {
        return stoc;
    }

    public void setStoc(float stoc) {
        this.stoc = stoc;
    }

    public Date getDataAparitiei() {
        return dataAparitiei;
    }

    public void setDataAparitiei(Date dataAparitiei) {
        this.dataAparitiei = dataAparitiei;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public String getImagine() {
        return imagine;
    }

    public void setImagine(String imagine) {
        this.imagine = imagine;
    }

    public int getCategID() {
        return categID;
    }

    public void setCategID(int categID) {
        this.categID = categID;
    }
    
    
    
    
}
