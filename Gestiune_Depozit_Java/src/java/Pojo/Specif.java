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
public class Specif {
    
    private int specifID;
    private String culoare;
    private String utiliz;
    private String material;
    private int produsID;
    

    public Specif() {
    }

    public Specif(int specifID, String culoare, String utiliz, String material, int produsID) {
        this.specifID = specifID;
        this.culoare = culoare;
        this.utiliz = utiliz;
        this.material = material;
        this.produsID = produsID;
        
    }

    public int getSpecifID() {
        return specifID;
    }

    public void setSpecifID(int specifID) {
        this.specifID = specifID;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public String getUtiliz() {
        return utiliz;
    }

    public void setUtiliz(String utiliz) {
        this.utiliz = utiliz;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getProdusID() {
        return produsID;
    }

    public void setProdusID(int produsID) {
        this.produsID = produsID;
    }

    
    
    
}
