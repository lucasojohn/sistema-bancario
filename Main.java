package banco;

import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int opcaoDesejada;
        
        Agencia agencia = new Agencia(1234);
        
        do{
            // apresenta menu inicial para o usuï¿½rio fazer a escolha de qual operaï¿½ï¿½o realizar 
            Menu menu = new Menu();
            menu.inicial();

            // usuario passa valor da opï¿½ï¿½o desejada
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
                            		agencia.cadastrarConta(cliente, 123456);
                            		System.out.println("Conta cadastrada\n");  
                            		
                            	} catch (NullPointerException e) {
                            		System.out.println("Cliente não localizado, favor realizar cadastro do cliente\n");
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
                    menu.gerirClientes();                    
                    opcaoDesejada = s.nextInt();
                    
                    do{
                        switch(opcaoDesejada){                          
                                
                            case 1:
                                
                                agencia.cadastrarCliente("444", "Pedro", "Pedroso");
                                agencia.cadastrarConta(agencia.mapaDeClientes.get("444"), 130055);
                                menu.gerirClientes();                    
                                opcaoDesejada = s.nextInt();
                                break;
                                
                            case 2:
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
