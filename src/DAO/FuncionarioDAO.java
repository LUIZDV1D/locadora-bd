package DAO;

import Modelo.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author David O
 */
public class FuncionarioDAO extends ExecuteSQL {
    
    public FuncionarioDAO(Connection con) {
        super(con);
    }
    
    public boolean Logar(String L, String S) {
        boolean finalResult = false;
        
        try {
            String consulta = "SELECT login, senha FROM funcionario "
                + "WHERE login = '"+L+"' AND senha = '"+S+"'";
        
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {                    
                    Funcionario a = new Funcionario();
                    a.setLogin(rs.getString(1));
                    a.setSenha(rs.getString(2));
                    finalResult = true;
                }
            }
            
        } catch (Exception e) {
            e.getMessage();
        }
        return finalResult;
    }
    
}
