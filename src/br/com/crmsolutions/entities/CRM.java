package br.com.crmsolutions.entities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CRM {
	 private static final String CLIENTES_FILE = "clientes.txt";
	    private static final String PRODUTOS_FILE = "produtos.txt";
	    private static final String VENDAS_FILE = "vendas.txt";
	    private List<Cliente> clientes = new ArrayList<>();
	    private List<Produto> produtos = new ArrayList<>();
	    private List<Venda> vendas = new ArrayList<>();

	    public CRM() {
	        carregarClientes();
	        carregarProdutos();
	        carregarVendas();
	    }
	    
	    
	    
	    public List<Cliente> getClientes() {
			return clientes;
		}



		public void setClientes(List<Cliente> clientes) {
			this.clientes = clientes;
		}



		public List<Produto> getProdutos() {
			return produtos;
		}



		public void setProdutos(List<Produto> produtos) {
			this.produtos = produtos;
		}



		public List<Venda> getVendas() {
			return vendas;
		}



		public void setVendas(List<Venda> vendas) {
			this.vendas = vendas;
		}



		public static String getClientesFile() {
			return CLIENTES_FILE;
		}



		public static String getProdutosFile() {
			return PRODUTOS_FILE;
		}



		public static String getVendasFile() {
			return VENDAS_FILE;
		}



		public Produto buscarProdutoPorId(int id) {
	        try (BufferedReader reader = new BufferedReader(new FileReader(PRODUTOS_FILE))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] dados = line.split(", ");
	                if (dados.length == 3 && Integer.parseInt(dados[0]) == id) {
	                    return new Produto(Integer.parseInt(dados[0]), dados[1], Double.parseDouble(dados[2]));
	                }
	            }
	        } catch (IOException e) {
	            System.out.println("Erro ao buscar produto: " + e.getMessage());
	        }
	        return null; // Retorna null se o produto não for encontrado
	    }
	    
	    public void adicionarCliente(int id, String nome, String email, String telefone) {
	        clientes.add(new Cliente(id, nome, email, telefone));
	        salvarClientes();
	    }

	    public void adicionarProduto(int id, String nome, double preco) {
	        produtos.add(new Produto(id, nome, preco));
	        salvarProdutos();
	    }

	    public void registrarVenda(int clienteId, int produtoId, int qtdProd, double valor) {
	        vendas.add(new Venda(clienteId, produtoId, qtdProd, valor, LocalDate.now()));
	        salvarVendas();
	    }

	    public void listarClientes() {
	        for (Cliente c : clientes) {
	            System.out.println(c);
	        }
	    }

	    public void listarProdutos() {
	        for (Produto p : produtos) {
	            System.out.println(p);
	        }
	    }

	    public void listarVendas() {
	        for (Venda v : vendas) {
	            System.out.println(v);
	        }
	    }

	    private void carregarClientes() {
	        try (BufferedReader reader = new BufferedReader(new FileReader(CLIENTES_FILE))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] dados = line.split(", ");
	                if (dados.length >= 4) {
	                    clientes.add(new Cliente(Integer.parseInt(dados[0]), dados[1], dados[2], dados[3]));
	                }
	            }
	        } catch (IOException e) {
	            System.out.println("Nenhum cliente cadastrado ainda.");
	        }
	    }

	    private void carregarProdutos() {
	        try (BufferedReader reader = new BufferedReader(new FileReader(PRODUTOS_FILE))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] dados = line.split(", ");
	                if (dados.length == 3) {
	                    produtos.add(new Produto(Integer.parseInt(dados[0]), dados[1], Double.parseDouble(dados[2])));
	                }
	            }
	        } catch (IOException e) {
	            System.out.println("Nenhum produto cadastrado ainda.");
	        }
	    }

	    private void carregarVendas() {
	        try (BufferedReader reader = new BufferedReader(new FileReader(VENDAS_FILE))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] dados = line.split(", ");
	                if (dados.length == 4) {
	                    vendas.add(new Venda(Integer.parseInt(dados[0]), Integer.parseInt(dados[1]), Integer.parseInt(dados[2]), Double.parseDouble(dados[3]), LocalDate.parse(dados[4])));
	                }
	            }
	        } catch (IOException e) {
	            System.out.println("Nenhuma venda registrada ainda.");
	        }
	    }

	    private void salvarClientes() {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CLIENTES_FILE))) {
	            for (Cliente c : clientes) {
	                writer.write(c.getId() + ", " + c.getNome() + ", " + c.getEmail() + ", " + c.getTelefone());
	                writer.newLine();
	            }
	        } catch (IOException e) {
	            System.out.println("Erro ao salvar clientes.");
	        }
	    }

	    private void salvarProdutos() {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PRODUTOS_FILE))) {
	            for (Produto p : produtos) {
	                writer.write(p.getId() + ", " + p.getNome() + ", " + p.getPreco());
	                writer.newLine();
	            }
	        } catch (IOException e) {
	            System.out.println("Erro ao salvar produtos.");
	        }
	    }

	    private void salvarVendas() {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(VENDAS_FILE))) {
	            for (Venda v : vendas) {
	                writer.write(v.getClienteId() + ", " + v.getProdutoId() + ", " + v.getQtdProd() + ", " + v.getValor() + ", " + v.getData());
	                writer.newLine();
	            }
	        } catch (IOException e) {
	            System.out.println("Erro ao salvar vendas.");
	        }
	    }
}
