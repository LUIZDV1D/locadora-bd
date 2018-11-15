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
import java.sql.SQLException;
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
    
    
    
//Coisas do DVDDAO

public boolean Teste_DVD(int cod) {
        
        boolean teste = false;
        
        try {
            
            String sql = "select iddvd from dvd where iddvd = "+ cod +"";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();   
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    teste = true;
                    
                }
                
            }
            
        } catch (SQLException e) {
       
            e.getMessage();
            
        }
        
        return teste;
        
    }

    
    
    //Testar situação
     public boolean Testar_Situacao(int cod) {
        
        boolean teste = false;
        
        try {
            
            String sql = "select iddvd from dvd where iddvd = "+ cod +" and situacao = 'Disponivel'";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();   
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    teste = true;
                    
                }
                
            }
            
        } catch (SQLException e) {
       
            e.getMessage();
            
        }
        
        return teste;
        
    }
    
    
    
    public String Inserir_DVD(DVD a) {
        String sql = "insert into dvd values(0,?,?,?,?)";
        
        try {
           
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setInt(1, a.getCod_filme());
            ps.setDouble(2, a.getPreco());
            ps.setString(3, a.getData_compra());
            ps.setString(4, a.getSituacao());
            
            
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso";
            }else {
                return "Erro ao inserir";
            }
            
            
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    
    
    //Listar os DVD   
    public List<DVD> ListarDVD() {
        String sql = "select iddvd,idfilme,preco_compra,data_compra,situacao from dvd";
        List<DVD> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (ps != null) {
                while (rs.next()) {                    
                    DVD a = new DVD();
                    a.setCodigo(rs.getInt(1));
                    a.setCod_filme(rs.getInt(2));
                    a.setPreco(rs.getDouble(3));
                    a.setData_compra(rs.getString(4));
                    a.setSituacao(rs.getString(5));
                    
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
    
    
    
    //Pesquisar por Codigo de DVD
    public List<DVD> Pesquisar_Cod_DVD(int cod) {
        String sql = "select iddvd,idfilme,preco_compra,data_compra,situacao "
                + "from dvd where iddvd = "+cod;
        List<DVD> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (ps != null) {
                while (rs.next()) {                    
                    DVD a = new DVD();
                    a.setCodigo(rs.getInt(1));
                    a.setCod_filme(rs.getInt(2));
                    a.setPreco(rs.getDouble(3));
                    a.setData_compra(rs.getString(4));
                    a.setSituacao(rs.getString(5));
                    
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
    
    
    
    //Pesquisar por Codigo de Filme
    public List<DVD> Pesquisar_Cod_Filme(int cod) {
        String sql = "select iddvd,idfilme,preco_compra,data_compra,situacao "
                + "from dvd where idfilme = "+cod;
        List<DVD> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (ps != null) {
                while (rs.next()) {                    
                    DVD a = new DVD();
                    a.setCodigo(rs.getInt(1));
                    a.setCod_filme(rs.getInt(2));
                    a.setPreco(rs.getDouble(3));
                    a.setData_compra(rs.getString(4));
                    a.setSituacao(rs.getString(5));
                    
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
    
    
    public String Excluir_DVD(DVD a) {
        String sql = "delete from dvd where iddvd = ?";
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCodigo());
            
            if (ps.executeUpdate() > 0) {
                return "Excluido com sucesso";
            } else {
                return "Erro ao excluir";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    
    
    public List<DVD> ConsultarCodigoDVD(int cod) {
        String sql = "select iddvd from dvd where iddvd = '" + cod + "'";
        List<DVD> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {                    
                    DVD a = new DVD();
                    a.setCodigo(rs.getInt(1));
                    lista.add(a);
                }
                return lista;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    
    
    //Capturar o dvd
    public List<DVD> CapturarDVD(int cod) {
        String sql = "select * from dvd where iddvd =" + cod + " ";
        List<DVD> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {                    
                    DVD a = new DVD();
                    a.setCodigo(rs.getInt(1));
                    a.setCod_filme(rs.getInt(2));
                    a.setPreco(rs.getDouble(3));
                    a.setData_compra(rs.getString(4));
                    a.setSituacao(rs.getString(5));
                    lista.add(a);
                }
                return lista;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    
    
    
    //Alterar dvd
    public String Alterar_DVD(DVD a) {
        String sql = "update dvd set preco_compra = ?, data_compra = ?, situacao = ? where iddvd = ?";
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setDouble(1, a.getPreco());
            ps.setString(2, a.getData_compra());
            ps.setString(3, a.getSituacao());
            ps.setInt(4, a.getCodigo());
            
            if (ps.executeUpdate() > 0) {
                return "Atualizado com sucesso";
            } else {
                return "Erro ao atualizar";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    
    public List<DVD> ListarCodFilme(int cod){
        
        String sql = "select idfilme from dvd where iddvd = "+ cod +"";
        List<DVD> lista = new ArrayList<>();
        
        try {
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps .executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    DVD a = new DVD();
                    a.setCod_filme(rs.getInt(1));
                    
                    lista.add(a);
                    
                }
            
                return lista;
                
            } else {
                
                return null;
                
            }
            
        } catch (SQLException e) {
            
            return null;
            
        }
        
    }
    
    
    public List<DVD> ListarComboDVD() {
        String sql = "select iddvd from dvd order by iddvd asc";
        List<DVD> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {                    
                    DVD a = new DVD();
                    a.setCodigo(rs.getInt(1));
                    lista.add(a);
                }
                return lista;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    
    
}
