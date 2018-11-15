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
    
    
    
    //atualiza situacao
    public void Atualizar_Situacao(String situacao, int cod) {
        String sql = "update dvd set situacao = '" + situacao + "' where iddvd = " + cod;
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {                    
                    DVD a = new DVD();
                    a.setSituacao(rs.getString(1));
                    a.setCodigo(rs.getInt(2));
                }
            }
            
        } catch (Exception e) {
        }
    }
    
    
    //Listar os alugueis   
    public List<Aluguel> ListarAluguel() {
        String sql = "select idaluguel,iddvd,idcliente,hora_aluguel,data_aluguel,data_devolucao "
                + "from aluguel";
        List<Aluguel> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (ps != null) {
                while (rs.next()) {                    
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
                    a.setCoddvd(rs.getInt(2));
                    a.setCodcliente(rs.getInt(3));
                    a.setHorario(rs.getString(4));
                    a.setData_aluguel(rs.getString(5));
                    a.setData_devolucao(rs.getString(6));
                    
                    lista.add(a);
                }
                
                return lista;
            }else {
                return null;
            }
            
        } catch (Exception e) {
            return null;
        }
    }
    
    
    public void ExcluirAluguel(Listar a) {
        
        String sql = "delete from aluguel where idaluguel = ?";
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCodaluguel());
            
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Exluido com sucesso!",
                "Vídeo Locadora", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro!",
                "Vídeo Locadora", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
}
