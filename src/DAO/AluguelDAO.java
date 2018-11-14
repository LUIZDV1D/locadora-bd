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
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class AluguelDAO extends ExecuteSQL {
    
    public AluguelDAO(Connection con) {
        super(con);
    }
    
    
    
    public String Inserir_Aluguel(Aluguel a) {
        String sql = "insert into aluguel values(0,?,?,?,?,?)";
        
        try {
           
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setInt(1, a.getCoddvd());
            ps.setDouble(2, a.getCodcliente());
            ps.setString(3, a.getHorario());
            ps.setString(4, a.getData_aluguel());
            ps.setString(5, a.getData_devolucao());
            
            
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso";
            }else {
                return "Erro ao inserir";
            }
            
            
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    
    
    //Alterar dvd
    public void Atualizar_Situacao(String situacao, int cod) {
        String sql = "update dvd set situacao = " + situacao + " where iddvd =" + cod;
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {                    
                    DVD a = new DVD();
                    a.setSituacao(rs.getString(1));
                }
            }
            
        } catch (Exception e) {
        }
    }
    
}
