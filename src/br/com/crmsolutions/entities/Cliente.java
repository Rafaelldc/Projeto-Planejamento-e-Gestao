package br.com.crmsolutions.entities;

public class Cliente {
	private int id;
    private String nome, email, telefone;
    private int compras;
    private double totalGasto;

    public Cliente(int id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.compras = 0;
        this.totalGasto = 0.0;
    }
    
    

    public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getTelefone() {
		return telefone;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	public int getCompras() {
		return compras;
	}



	public void setCompras(int compras) {
		this.compras = compras;
	}



	public double getTotalGasto() {
		return totalGasto;
	}



	public void setTotalGasto(double totalGasto) {
		this.totalGasto = totalGasto;
	}



	public void registrarCompra(double valor) {
        compras++;
        totalGasto += valor;
    }

    @Override
    public String toString() {
        return id + ", " + nome + ", " + email + ", " + telefone + ", Compras: " + compras + ", Total Gasto: " + totalGasto;
    }
}
