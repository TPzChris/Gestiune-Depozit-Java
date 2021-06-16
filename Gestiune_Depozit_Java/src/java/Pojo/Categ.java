/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

/**
 *
 * @author papad
 */
public class Categ {
    
    private int idCateg;
    private String den;
    private int idParinte;

    public Categ() {
        this.idCateg = 0;
        this.den = "";
        this.idParinte = 0;
    }

    public Categ(int idCateg, String den, int idParinte) {
        this.idCateg = idCateg;
        this.den = den;
        this.idParinte = idParinte;
    }

    public int getIdCateg() {
        return idCateg;
    }

    public void setIdCateg(int idCateg) {
        this.idCateg = idCateg;
    }

    public String getDen() {
        return den;
    }

    public void setDen(String den) {
        this.den = den;
    }

    public int getIdParinte() {
        return idParinte;
    }

    public void setIdParinte(int idParinte) {
        this.idParinte = idParinte;
    }

    
      
}



