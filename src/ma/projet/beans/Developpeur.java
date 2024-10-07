/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import ma.projet.beans.Perssone;


/**
 *
 * @author OUMAIMA
 */
public class Developpeur extends Perssone {
private Manager m =null;
   
  public Developpeur(int id,String nom, double salaire) {
        super(id,nom, salaire);
    }
  public Developpeur(int id,String nom, double salaire, Manager m) {
        super(id,nom, salaire);
        this.m=m;
    }

    public Manager getM() {
        return m;
    }

    public void setM(Manager m) {
        this.m = m;
    }
  public Developpeur(String nom, double salaire) {
        super(nom, salaire);
    }

    public Developpeur(Perssone p) {
        this.p = p;
    }

   
   
    public Perssone getP() {
        return p;
    }

    public void setP(Perssone p) {
        this.p = p;
    }
    private Perssone p ;

    public Developpeur(String nom ,double salaire,Perssone p) {
        super(nom, salaire);
        this.p = p;
    }

   

    public Developpeur() {
    }

    @Override
   public String toString() {
        return "    Developpeur {" + id +" "+ nom +" " + salaire+ m.getId()+  " )" ;
    }


   
    
    
    
}
