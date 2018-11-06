/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Filme;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author aluno
 */
public class FIlmeDAO extends ExecuteSQL{

    public FIlmeDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Filme(Filme a) {
        String sql = "insert into cliente values(0,?,?,?,?,?,?,?,?,?,?)";
        
        try {
           
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso";
            }else {
                return "Erro ao inserir";
            }
            
            
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
