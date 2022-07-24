package banco;

import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int opcaoDesejada;
        
        Agencia agencia = new Agencia(1234);
        
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
                            	// AQUI
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
                                System.out.println("Selecione uma opção válida!\n\n");
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
                                System.out.println("Selecione uma opção válida!\n\n");
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
                                System.out.println("Selecione uma opção válida!\n\n");
                                break;    
                        }
                    }while(opcaoDesejada != 6);
                    break;
                
                case 4:
                    break;
                    
                case 5:
                    break;
                    
                default:
                    System.out.println("Selecione uma opção válida!\n\n");
                    break;
            }
   
        }while(opcaoDesejada != 5);

    }

}
