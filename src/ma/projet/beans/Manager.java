/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;
import ma.projet.beans.Manager;

/**
 *
 * @author OUMAIMA
 */
public class Manager extends Perssone {
    private Manager  managerId;

    public Manager getManagerId() {
        return managerId;
    }

    public void setManagerId(Manager managerId) {
        this.managerId = managerId;
    }
    
    public Manager(int id, String nom, double salaire, Manager managerId) {
        super(id, nom, salaire);
        this.managerId=managerId;
    }

   

    public Manager(String nom, double salaire  ) {
        super(nom, salaire);
    }
    
    

    public Manager(int id, String nom, double salaire) {
        super(id, nom, salaire);
    }

    public Manager() {
    }

    @Override
    public String toString() {
        return "Manager{" + id +" "+ nom +" " + salaire + " "+ managerId+")" ;
    }

  
  
    
    
    
}
