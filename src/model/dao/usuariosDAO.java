/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import controler.conectaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.usuario;


/**
 *
 * @author conductor
 */
public class usuariosDAO {
    Connection conn;
    PreparedStatement stmt;
    ResultSet resultset;
    
    public void cadastrarUsuario (usuario usuarios){
        
        
        conn = new conectaDAO().connectDB();
        
        try {
            stmt = conn.prepareStatement("INSERT INTO usuario (login,senha)VALUES(?,?)");
            stmt.setString(1, usuarios.getLogin());
            stmt.setString(2, usuarios.getSenha());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar" +ex);
        }
        
    }

}
