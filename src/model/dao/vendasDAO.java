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
import model.bean.vendas;

/**
 *
 * @author conductor
 */
public class vendasDAO {
    Connection conn;
    PreparedStatement stmt;
    ResultSet resultset;

    
    public List<vendas> listarVendas(){

        try {
            conn = new conectaDAO().connectDB();
            
            String sql;
            sql = "SELECT * FROM projeto_integrador.vendas;";
            stmt = conn.prepareStatement(sql);
            resultset = stmt.executeQuery(sql);
            
            List<vendas> lista = new ArrayList<>();
            
            while(resultset.next()){
                vendas vendasDTO = new vendas();
                vendasDTO.setVendas_id(resultset.getInt(1));
                vendasDTO.setData_realizada(resultset.getString(2));
                vendasDTO.setCliente_id(resultset.getInt(3));
                vendasDTO.setProduto_id(resultset.getInt(4));


                lista.add(vendasDTO);
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
