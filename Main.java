package banco;

import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int opcaoDesejada;
        
        Agencia agencia = new Agencia();
        
        do{
            // apresenta menu inicial para o usu�rio fazer a escolha de qual opera��o realizar 
            Menu menu = new Menu();
            menu.inicial();

            // usuario passa valor da op��o desejada
            opcaoDesejada = s.nextInt();

            switch (opcaoDesejada) {
		
                case 1:                    
                    menu.gerirContas();
                    opcaoDesejada = s.nextInt();
                    
                    do{
                        switch(opcaoDesejada){                          
                                
                            case 1:
                            	
                            	System.out.println("Informe o CPF do cliente:");
                            	String cpf = s.next();
                            	
                            	Cliente cliente = agencia.mapaDeClientes.get(cpf);
                            	
                            	try {
                            		agencia.cadastrarConta(cliente);
                            		System.out.println("Conta cadastrada\n");  
                            		
                            	} catch (NullPointerException e) {
                            		System.out.println("Cliente n�o localizado, favor realizar cadastro do cliente\n");
                            	}
                            		
                                break;
                                
                            case 2:
                            	
                            	System.out.println("Informe o numero da conta que deseja atualizar:");
                            	int nrConta = s.nextInt();
                            	
                            	try {
                            		
                            		Conta conta = agencia.mapaDeContas.get(nrConta);
                            		System.out.println("Informe novo saldo para a conta:");
                            		double novoSaldo = s.nextDouble();
                            		conta.setSaldo(novoSaldo);
                            		System.out.println("Saldo atualizado com sucesso!");
                            		
                            	} catch(NullPointerException a) {
                            		System.out.println("Conta informada nao existe");
                            	}
                            	
                            	menu.gerirContas();
                                opcaoDesejada = s.nextInt();
                                break;
                                
                            case 3:
                                break;
                                
                            case 4:
                                break;
                                
                            case 5:
                                break;
                                
                            case 6:
                                break;
                                
                            default:
                                System.out.println("Selecione uma opcaoo valida!\n\n");
                                break;    
                        }
                    }while(opcaoDesejada != 6);
                    break;

                case 2:
                    
                    do{
                        menu.gerirClientes();                    
                        opcaoDesejada = s.nextInt();
                        switch(opcaoDesejada){                          
                                
                            case 1:
                                agencia.cadastrarCliente();
                                break;
                                
                            case 2:      
                                agencia.atualizarCliente();
                                break;
                                
                            case 3:
                                //Collection<Cliente> c = agencia.mapaDeClientes.values().forEach(action);
                                agencia.listarClientes();
                                //agencia.mapaDeClientes.values().to
                                //https://www.alura.com.br/artigos/iterando-por-um-hashmap-em-java#:~:text=Para%20alcan%C3%A7ar%20tal%20resultado%2C%20precisamos,valor%20respectivamente%20do%20nosso%20mapa.
//                                Cliente[] arrClientes = new Cliente[agencia.mapaDeClientes.size()];
//                                agencia.mapaDeClientes.values().toArray(arrClientes);
                                break;
                                
                            case 4:
                                agencia.listarUmCliente();
                                break;
                                
                            case 5:
                                agencia.excluirCliente();
                                break;
                                
                            case 6:
                                break;
                                
                            default:
                                System.out.println("Selecione uma opcao valida!\n\n");
                                break;    
                        }
                    }while(opcaoDesejada != 6);
                    break;

                case 3:
                    menu.acoesConta();
                    opcaoDesejada = s.nextInt();
                    
                    do{
                        switch(opcaoDesejada){                          
                                
                            case 1:
                                break;
                                
                            case 2:
                                break;
                                
                            case 3:
                                break;
                                
                            case 4:
                                break;                             
                                
                            default:
                                System.out.println("Selecione uma opcao valida!\n\n");
                                break;    
                        }
                    }while(opcaoDesejada != 6);
                    break;
                
                case 4:
                    break;
                    
                case 5:
                    break;
                    
                default:
                    System.out.println("Selecione uma opcao valida!\n\n");
                    break;
            }
   
        }while(opcaoDesejada != 5);

    }

}
