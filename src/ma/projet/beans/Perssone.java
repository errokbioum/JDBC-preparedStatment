/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

/**
 *
 * @author OUMAIMA
 */
public abstract class Perssone    {
    protected int id;
    protected String nom;
    protected double salaire;

    public  Perssone(String nom, double salaire) {
        this.nom = nom;
        this.salaire = salaire;
      
    }

   

    public Perssone(int id, String nom, double salaire) {
        this.id = id;
        this.nom = nom;
        this.salaire = salaire;
      
    }

   

    
    public Perssone() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }
   
    @Override
    public abstract  String toString();
    
    
}
