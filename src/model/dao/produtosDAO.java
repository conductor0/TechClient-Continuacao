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
import model.bean.produtos;

/**
 *
 * @author conductor
 */
public class produtosDAO {
    Connection conn;
    PreparedStatement stmt;
    ResultSet resultset;

    
    public List<produtos> listarProdutos(){

        try {
            conn = new conectaDAO().connectDB();
            
            String sql;
            sql = "SELECT * FROM projeto_integrador.produtos;";
            stmt = conn.prepareStatement(sql);
            resultset = stmt.executeQuery(sql);
            
            List<produtos> lista = new ArrayList<>();
            
            while(resultset.next()){
                produtos produtosDTO = new produtos();
                produtosDTO.setProdutos_id(resultset.getInt(1));
                produtosDTO.setNome_produto(resultset.getString(2));
                produtosDTO.setQuantidade(resultset.getString(3));
                produtosDTO.setValor(resultset.getString(4));
                produtosDTO.setMarca(resultset.getString(5));


                lista.add(produtosDTO);
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
}