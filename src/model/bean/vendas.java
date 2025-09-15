/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

/**
 *
 * @author conductor
 */
public class vendas {
    private int vendas_id;
    private String data_realizada;
    private int cliente_id;
    private int produto_id;

    public int getVendas_id() {
        return vendas_id;
    }

    public void setVendas_id(int vendas_id) {
        this.vendas_id = vendas_id;
    }

    public String getData_realizada() {
        return data_realizada;
    }

    public void setData_realizada(String data_realizada) {
        this.data_realizada = data_realizada;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public int getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(int produto_id) {
        this.produto_id = produto_id;
    }
    
    
}
