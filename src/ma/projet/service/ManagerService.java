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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ma.projet.beans.Developpeur;
import ma.projet.beans.Manager;
import ma.projet.beans.Perssone;
import ma.projet.connexion.Connexion;
import ma.service.dao.dao;
import org.omg.CORBA.MARSHAL;

/**
 *
 * @author OUMAIMA
 */
public class ManagerService implements dao<Manager> {

    EmployeService p = null;

    @Override
    public Boolean creat(Manager o) {
        Boolean r = false;
        try {
            String req = "INSERT into manager(nom,salaire, managerId)  VALUES(?,?,null)";
            PreparedStatement st = Connexion.getCn().prepareStatement(req);
            st.setString(1, o.getNom());
            st.setDouble(2, o.getSalaire());
            int n = st.executeUpdate();
            if (n == 1) {
                r = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    @Override
    public Boolean delete(Manager o) {
        Boolean r = false;
        Perssone p = null;
        try {
            String req = "DELETE FROM  manager  where id=?";
            PreparedStatement st = Connexion.getCn().prepareStatement(req);
            st.setInt(1, p.getId());
            int n = st.executeUpdate();
            if (n == 1) {
                r = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;

    }

    @Override
    public Boolean update(Manager o) {

        Boolean r = false;
        try {
            String req = "UPDATE Manager SET managerId = ? WHERE id = ?";
            PreparedStatement st = Connexion.getCn().prepareStatement(req);
            st.setInt(1, o.getManagerId().getId());
            st.setInt(2, o.getId());
            int n = st.executeUpdate();
            if (n == 1) {
                r = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    @Override
    public Manager findById(int o) {
        try {

            String req = "Select * from manager where id= ? ";
            PreparedStatement st = Connexion.getCn().prepareStatement(req);
            st.setInt(1, o);
            ResultSet n = st.executeQuery();
            if (n.next()) {

                return new Manager(n.getInt("id"), n.getString("nom"), n.getDouble("salaire")); // kan andi muchkul hna hint khass nskhl wahd manager donc anmchi n3yt service huwa li ay9di liy ahdhci o ay9ra liy ala ligne   
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Manager> getAll() {
        List<Manager> managers = new ArrayList<>();
        ManagerService pp = new ManagerService();
        try {
            String req = "select * from manager";
            PreparedStatement st = Connexion.getCn().prepareStatement(req);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                managers.add(new Manager(rs.getInt("id"), rs.getString(2), rs.getDouble(3), pp.findById(rs.getInt(4))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return managers;
    }


    public void getHierar() {
        ManagerService ms = new ManagerService();
        Manager m = null;
        try {
            String req = "select * from manager where managerId IS NULL";
            PreparedStatement st = Connexion.getCn().prepareStatement(req);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                m = new Manager(rs.getInt(1), rs.getString(2), rs.getDouble(3));
                System.out.println("Le directeur: " + m.getNom() + " a un salaire de:"
                        + " " + m.getSalaire());
            }
            req = "select *  from developpeur where manager=? ";
            st = Connexion.getCn().prepareStatement(req);
            st.setInt(1, m.getId());
            rs = st.executeQuery();
            while (rs.next()) {
                System.out.println(" " + rs.getString(2) + " a un salire de :"
                        + rs.getDouble(3));
            }
            req = "SELECT * FROM manager WHERE managerId IS NOT NULL";
            st = Connexion.getCn().prepareStatement(req);
            rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                System.out.println(" " + rs.getString(2) + " a un salaire de: "
                        + "" + rs.getDouble(3));
                String reqDev = "SELECT * FROM developpeur WHERE manager=?";
                PreparedStatement stDev = Connexion.getCn().prepareStatement(reqDev);
                stDev.setInt(1, id);
                ResultSet rsDev = stDev.executeQuery();
                while (rsDev.next()) {
                    System.out.println(" " + rsDev.getString(2) + " a un salaire de "
                            + ":" + rsDev.getDouble(3));
                }
            }

        } catch (SQLException e) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, e);

        }
    }

}
