import java.util.HashMap;
import java.util.Map;


public class Cliente {
	private String nome;
	private String sobrenome;
	private String cpf;
	Map<Integer, Conta> mapaDeContas = new HashMap<>();
	
	public Cliente(String cpf, String nome, String sobrenome){
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Map<Integer, Conta> getMapaDeContas() {
		return mapaDeContas;
	}

	public void setMapaDeContas(Map<Integer, Conta> mapaDeContas) {
		this.mapaDeContas = mapaDeContas;
	}
	
}
