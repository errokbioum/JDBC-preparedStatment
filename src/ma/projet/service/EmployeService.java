/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ma.projet.beans.Developpeur;
import ma.projet.beans.Manager;
import ma.projet.beans.Perssone;
import ma.projet.connexion.Connexion;
import ma.service.dao.dao;

/**
 *
 * @author OUMAIMA
 */
public class EmployeService implements dao<Developpeur> {
     ManagerService ss=null;
    @Override
    public Boolean creat(Developpeur o) {
        Manager m=null;
         Boolean r=false;
        try {
            String req= "INSERT into developpeur (nom,salaire,manager)VALUES(?,?,null)";
            PreparedStatement st= Connexion.getCn().prepareStatement(req);
            st.setString(1, o.getNom());
            st.setDouble(2, o.getSalaire());
            
           
             int n =st.executeUpdate();
             if (n==1){
                 r=true;
             }
            
       } catch (SQLException ex) {
            Logger.getLogger(EmployeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    @Override
    public Boolean delete(Developpeur o) {
       Boolean r=false;
        try {
            String req= "DELETE FROM  Developpeur   VALUES(?,?)";
            PreparedStatement st= Connexion.getCn().prepareStatement(req);
            st.setString(1, o.getNom());
            st.setDouble(2, o.getSalaire());
             int n =st.executeUpdate();
             if (n==1){
                 r=true;
             }
            
       } catch (SQLException ex) {
            Logger.getLogger(EmployeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    
   public Boolean update(Developpeur  o ) { 
       
         Boolean r=false;
                try {
            String req= "UPDATE Developpeur  SET manager = ? WHERE id = ?";
            PreparedStatement st= Connexion.getCn().prepareStatement(req);
            st.setInt(1,o.getM().getId());
            st.setInt(2,o.getId()) ;
             int n =st.executeUpdate();
             if (n==1){
                 r=true;
                 System.out.println("manager inserer");
              } else
                 System.out.println("manager not inserer");
             
                
            
       } catch (SQLException ex) {
            Logger.getLogger(EmployeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    @Override
    public Developpeur findById(int o) {
      
       try {
           System.out.println("Requête pour l'ID : " + o);
           String req ="Select * from developpeur where id= ? ";
           PreparedStatement st = Connexion.getCn().prepareStatement(req);
           st.setInt(1, o);
           ResultSet n=st.executeQuery();
            Manager manager = null;
           if (n.next()) {
               
                int managerId = n.getInt("manager");
               if (managerId > 0) {  // Vérifie que l'ID du manager est valide
                  manager = ss.findById(managerId);  // Récupère le manager si l'ID est correct
                 }
              return new Developpeur(n.getInt("id"), n.getString("nom"), n.getDouble("salaire"), manager);
                //  // an andi muchkul hna hint khass nskhl wahd manager donc anmchi n3yt service huwa li ay9di liy ahdhci o ay9ra liy ala ligne   
               }else
               return new Developpeur(n.getInt("id"), n.getString("nom"), n.getDouble("salaire"), manager);
                
           
       } catch (SQLException ex) {
            Logger.getLogger(EmployeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
//    public List<Developpeur> getAll() {
//          List<Developpeur> developpeurs = new ArrayList<>();
//            ManagerService pp=null;
//        try {
//            String req = "select * from developpeur";
//            PreparedStatement st = Connexion.getCn().prepareStatement(req);
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                developpeurs.add(new Developpeur(rs.getInt("id"), rs.getString(2), rs.getDouble(3), pp.findById(rs.getInt(4))));
//            }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(EmployeService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return developpeurs;
//    }

    @Override
    public List<Developpeur> getAll() {
       List<Developpeur> dev = new ArrayList<>();
        ManagerService pp = new ManagerService();
        try {
            String req = "select * from manager";
            PreparedStatement st = Connexion.getCn().prepareStatement(req);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                dev.add(new Developpeur(rs.getInt("id"), rs.getString(2), rs.getDouble(3), pp.findById(rs.getInt(4))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dev;
      } 
    }

   
  
  
    

