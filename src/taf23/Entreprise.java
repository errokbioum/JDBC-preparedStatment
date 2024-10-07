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
public class Entreprise {
     public static void main(String[] args) {
          EmployeService pp = new EmployeService();
        ManagerService mm = new ManagerService();
      Perssone d3 = new Developpeur("seli", 2500);
        Developpeur d4 = new Developpeur("omorad", 13500);
        Developpeur d5 = new Developpeur("omd", 1700);
      ////} pp.creat(d5);
        Developpeur p = new Developpeur("bensitl", 2345);
 
    ////} pp.creat(d4);
       ////} ////} pp.creat(d3);
     Manager m1 =new Manager("wiam", 4034);
     
     
        
       
//          Developpeur d1=new Developpeur(46, "omd", 1700);
//           Developpeur d2=new Developpeur(48, "omorad", 13500);
//           Manager m2=new Manager(11, "wiam", 4034);
            Manager m3=new Manager(12, "wiam", 4034);
           Developpeur c1=new Developpeur(46, "omd", 1700, m3);
           pp.update(c1);
              
//               pp.update(d1,m2);
//               pp.update(d2,m2);
                Developpeur d6=new Developpeur(47, "omd", 1700);
              
//               mm.update(m2,m3);
//               pp.update(d6,m3);
//               
      ////}
                mm.getHierar();
        }
     }
    

