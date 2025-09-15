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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.cliente;

/**
 *
 * @author conductor
 */
public class clientesDAO {
    Connection conn;
    PreparedStatement stmt;
    ResultSet resultset;
    
    public List<cliente> listarClientes(){

        try {
            conn = new conectaDAO().connectDB();
            
            String sql;
            sql = "SELECT * FROM projeto_integrador.cliente;";
            stmt = conn.prepareStatement(sql);
            resultset = stmt.executeQuery(sql);
            
            List<cliente> lista = new ArrayList<>();
            
            while(resultset.next()){
                cliente clientesDTO = new cliente();
                clientesDTO.setCliente_id(resultset.getInt(1));
                clientesDTO.setNome(resultset.getString(2));
                clientesDTO.setEndereco(resultset.getString(3));
                clientesDTO.setCpf(resultset.getString(4));
                clientesDTO.setTelefone(resultset.getString(5));
                clientesDTO.setEmail(resultset.getString(6));


                lista.add(clientesDTO);
            }
            return lista;
            
        } catch (SQLException ex) {
            return null;
        }finally {
            
            try {
                if (resultset != null) {
                    resultset.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
    } 
}
    
    public void cadastrarCliente (cliente clientes){
        
        
        conn = new conectaDAO().connectDB();
        
        try {
            stmt = conn.prepareStatement("INSERT INTO cliente (nome,endereco,cpf,telefone,email)VALUES(?,?,?,?,?)");
            stmt.setString(1, clientes.getNome());
            stmt.setString(2, clientes.getEndereco());
            stmt.setString(3, clientes.getCpf());
            stmt.setString(4, clientes.getTelefone());
            stmt.setString(5, clientes.getEmail());
            
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar" +ex);
        }
        
    }
}
