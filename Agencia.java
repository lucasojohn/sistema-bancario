import java.util.HashMap;
import java.util.Map;

public class Agencia {
	
	Map<Integer, Conta> mapaDeContas = new HashMap<>();
	Map<String, Cliente> mapaDeClientes = new HashMap<>();
	private int numeroAG;

	public Agencia(int numeroAG) {
		super();
		this.numeroAG = numeroAG;
		cadastrarCliente("123", "joao", "silva");
	}

	public Map<Integer, Conta> getMapaDeContas() {
		return mapaDeContas;
	}
	
	public void cadastrarCliente(String cpf, String nome, String sobrenome) {
		
		mapaDeClientes = new HashMap<>();
		Cliente cliente = new Cliente(cpf, nome, sobrenome);
		mapaDeClientes.put(cpf, cliente);
	
	}
	
	public void setMapaDeContas(Map<Integer, Conta> mapaDeContas) {
		this.mapaDeContas = mapaDeContas;
	}
	
	public Map<String, Cliente> getMapaDeClientes() {
		return mapaDeClientes;
	}
	
	public void setMapaDeClientes(Map<String, Cliente> mapaDeClientes) {
		this.mapaDeClientes = mapaDeClientes;
	}
	
	public int getNumeroAG() {
		return numeroAG;
	}
	
	public void setNumeroAG(int numeroAG) {
		this.numeroAG = numeroAG;
	}
	
	
	
}
