package br.com.crmsolutions.entities;

import java.time.LocalDate;

public class Venda {
	private int clienteId;
    private int produtoId;
    private int qtdProd;
    private double valor;
    private LocalDate data;

    public Venda(int clienteId, int produtoId, int qtdProd, double valor, LocalDate data) {
        this.clienteId = clienteId;
        this.produtoId = produtoId;
        this.qtdProd = qtdProd;
        this.valor = valor;
        this.data = data;
    }
    

    public int getClienteId() {
		return clienteId;
	}



	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}



	public int getProdutoId() {
		return produtoId;
	}



	public void setProdutoId(int produtoId) {
		this.produtoId = produtoId;
	}



	public int getQtdProd() {
		return qtdProd;
	}



	public void setQtdProd(int qtdProd) {
		this.qtdProd = qtdProd;
	}



	public double getValor() {
		return valor;
	}



	public void setValor(double valor) {
		this.valor = valor;
	}



	public LocalDate getData() {
		return data;
	}



	public void setData(LocalDate data) {
		this.data = data;
	}



	@Override
    public String toString() {
        return "Cliente ID: " + clienteId + ", Produto ID: " + produtoId + ", Valor: " + valor + ", Data: " + data;
    }
}