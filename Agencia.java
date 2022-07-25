package banco;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Agencia {

	Map<Integer, Conta> mapaDeContas = new HashMap<>();
	Map<String, Cliente> mapaDeClientes = new HashMap<>();
	private int numeroAG;
        Scanner s = new Scanner(System.in);

//	public Agencia(int numeroAG) {
//		this.numeroAG = numeroAG;
//		cadastrarCliente();
//	}

	public void cadastrarCliente() {
                
                System.out.print("Digite o número do CPF: ");
                String cpf = s.next();
                System.out.print("Digite o nome: ");
                String nome = s.next();
                System.out.print("Digite o sobrenome: ");
                String sobrenome = s.next();
            
		mapaDeClientes = new HashMap<>();
		Cliente cliente = new Cliente(cpf, nome, sobrenome);
		mapaDeClientes.put(cpf, cliente);
                
                
                cadastrarConta(mapaDeClientes.get(cpf));
	}
        
        public void atualizarCliente(){
            try{
                System.out.println("Digite o CPF: ");
                String cpf = s.next();
                Cliente cliente;
                cliente = mapaDeClientes.get(cpf);
                System.out.println("Cliente de CPF " + cliente.getCpf() + " selecionado");
                System.out.println("Digite o novo nome: ");
                cliente.setNome(s.next());
                System.out.println("Digite o novo sobrenome: ");
                cliente.setSobrenome(s.next());
            } catch(NullPointerException a) {
                System.out.println("Cliente informado não existe!\n");
            }
        }
        
	public void cadastrarConta(Cliente titular) {
                
                int opcao;
                Conta conta;
                mapaDeContas = new HashMap<>();
                int numeroConta;
                        
                do{
                System.out.println("Selecione o tipo de conta:\n");
                
		System.out.println("1. Conta Corrente");
		System.out.println("2. Conta Poupança");
                
                opcao = s.nextInt();
                
                switch(opcao){
                    
                    case 1:
                        System.out.print("Digite o número da conta: ");
                        numeroConta = s.nextInt();
                        conta = new ContaCorrente(titular, numeroConta);
                        mapaDeContas.put(numeroConta, conta);
                        break;
                    case 2:
                        System.out.print("Digite o número da conta: ");
                        numeroConta = s.nextInt();
                        conta = new ContaPoupanca(titular, numeroConta);
                        mapaDeContas.put(numeroConta, conta);
                        break;
                    default:
                        System.out.println("Digite uma opção válida!");
                }
		
                
                }while(opcao != 1 && opcao != 2);
	}

	public Map<Integer, Conta> getMapaDeContas() {
		return mapaDeContas;
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
