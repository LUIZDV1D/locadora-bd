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
public class CategoriaDAO extends ExecuteSQL {
    
    public CategoriaDAO(Connection con) {
        super(con);
    }
    
    
    //Inserir os categoria
    public String Inserir_Categoria(Categoria a) {
        String sql = "insert into categoria values(0,?)";
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, a.getNome());
            
            
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso";
            }else {
                return "Erro ao inserir";
            }
            
            
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    
    public List<Categoria> ConsultarCodigoCategoria(String nome) {
        String sql = "select idcategoria from categoria where nome = '" + nome + "'";
        List<Categoria> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {                    
                    Categoria a = new Categoria();
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
    
    
    
    public List<Categoria> ListarComboCategoria() {
        String sql = "select nome from categoria order by nome asc";
        List<Categoria> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {                    
                    Categoria a = new Categoria();
                    a.setNome(rs.getString(1));
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
    
    
    
    //Listar os categoria   
    public List<Categoria> ListarCategoria() {
        String sql = "select idcategoria,nome from categoria";
        List<Categoria> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (ps != null) {
                while (rs.next()) {                    
                    Categoria a = new Categoria();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    
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
    
    
    //Pesquisar por Nome
    public List<Categoria> Pesquisar_Nome_Categoria(String nome) {
        String sql = "select idcategoria, nome "
                + "from categoria where nome Like '"+ nome + "%'";
        List<Categoria> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (ps != null) {
                while (rs.next()) {                    
                    Categoria a = new Categoria();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    
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
    
    
    
    //Pesquisar porn código
    public List<Categoria> Pesquisar_Cod_Categoria(int cod) {
        String sql = "select idcategoria,nome "
                + "from categoria where idcategoria = '" + cod + "'";
        List<Categoria> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (ps != null) {
                while (rs.next()) {                    
                    Categoria a = new Categoria();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    
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
    
    
    
    public String Excluir_Categoria(Categoria a) {
        String sql = "delete from categoria where idcategoria = ? and nome = ? ";
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCodigo());
            ps.setString(2, a.getNome());
            
            if (ps.executeUpdate() > 0) {
                return "Excluido com sucesso";
            } else {
                return "Erro ao excluir";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    
    //Testar categoria
    public boolean testar_Categoria(int cod) {
        boolean Resultado = false;
        
        try {
            String sql = "select * from categoria where idcategoria = " + cod + "";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {                    
                    Resultado = true;
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        
        return Resultado;
    }
    
    
    
    //Capturar o categoria
    public List<Categoria> CapturarCategoria(int cod) {
        String sql = "select * from categoria where idcategoria =" + cod + " ";
        List<Categoria> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {                    
                    Categoria a = new Categoria();
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
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
    
    
    
    //Alterar categoria
    public String Alterar_Categoria(Categoria a) {
        String sql = "update categoria set nome = ? where idcategoria = ?";
        String msg = "";
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, a.getNome());
            ps.setInt(2, a.getCodigo());
            
            if (ps.executeUpdate() > 0) {
                msg = "Atualizado com sucesso";
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso",
                        "Vídeo Locadora", JOptionPane.INFORMATION_MESSAGE);
            } else {
                msg = "Erro ao atualizar";
                JOptionPane.showMessageDialog(null, "Erro ao atualizar",
                        "Vídeo Locadora", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            return e.getMessage();
        }
        
        return msg;
    }
    
}
