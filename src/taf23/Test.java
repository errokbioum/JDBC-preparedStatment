/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taf23;

import ma.projet.beans.Developpeur;
import ma.projet.beans.Manager;
import ma.projet.beans.Perssone;
import ma.projet.service.EmployeService;
import ma.projet.service.ManagerService;

/**
 *
 * @author OUMAIMA
 */
public class Test {
     
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        
       EmployeService pp = new EmployeService();
        ManagerService mm = new ManagerService();
       Perssone d1 = new Developpeur("selma", 25000);
        Developpeur d2 = new Developpeur("oumaima", 13000);
      // // pp.creat(d1);
     // //pp.creat(d2);
        Manager m1 =new Manager("wiam", 4034);
        // // mm.creat(m1);
          
           System.out.println( pp.findById(7));
        
        
    }
    
}
