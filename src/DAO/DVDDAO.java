/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class DVDDAO extends ExecuteSQL {

    public DVDDAO(Connection con) {
        super(con);
    }
    
    
    //Testar DVD
    public boolean Testar_DVD(int cod) {
        boolean teste = false;
        try {
            
            String sql = "select iddvd from dvd where iddvd =" + cod + "";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {                    
                    teste = true;
                }
            }
        } catch (Exception ex) {
        }
        
        return teste;
    }
    
    
    //Testar situação
    public boolean Testar_Situacao(int cod) {
        boolean teste = false;
        try {
            
            
            String sql =  "select iddvd from dvd where iddvd =" + cod + ""
                    + "and situacao = 'Disponivel'";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {                    
                    teste = true;
                }
            }
        } catch (Exception ex) {
        }
        return teste;
    }
    
    
}
