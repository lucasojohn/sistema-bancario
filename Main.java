package banco;

import java.util.Scanner;

public class Main {

	Scanner s = new Scanner(System.in);
	
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int opcaoDesejada;

        Agencia agencia = new Agencia();
        
        do {
            // apresenta menu inicial para o usu�rio fazer a escolha de qual opera��o realizar 
            Menu menu = new Menu();
            menu.inicial();

            // usuario passa valor da op��o desejada
            opcaoDesejada = s.nextInt();

            switch (opcaoDesejada) {

                case 1:
                    do {
                        menu.gerirContas();
                        opcaoDesejada = s.nextInt();

                        switch (opcaoDesejada) {

                            case 1:
                                agencia.cadastrarConta();
                                break;

                            case 2:
                                agencia.atualizarConta();
                                break;

                            case 3:
                                agencia.listarContas();
                                break;

                            case 4:
                                agencia.listarUmaConta();
                                break;

                            case 5:
                                agencia.excluirConta();
                                break;

                            case 6:
                                break;

                            default:
                                System.out.println("Selecione uma opção válida!\n\n");
                                break;
                        }
                    } while (opcaoDesejada != 6);
                    break;

                case 2:

                    do {
                        menu.gerirClientes();
                        opcaoDesejada = s.nextInt();
                        switch (opcaoDesejada) {

                            case 1:
                                agencia.cadastrarCliente();
                                break;

                            case 2:
                                agencia.atualizarCliente();
                                break;

                            case 3:
                                agencia.listarClientes();
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
                                System.out.println("Selecione uma opção válida!\n\n");
                                break;
                        }
                    } while (opcaoDesejada != 6);
                    break;

                case 3:
                    do {
                        menu.acoesConta();
                        opcaoDesejada = s.nextInt();

                        switch (opcaoDesejada) {

                            case 1:
                            	System.out.println("Informe a conta que deseja realizar o saque:");
                            	int contaBanco = s.nextInt();
                            	Conta conta = agencia.mapaDeContas.get(contaBanco); 
                            	try {
                            		System.out.println("Conta número " + conta.getNumeroConta() + " selecionada");
                                	System.out.println("Informe o valor que deseja sacar da conta:");
                                	double valor = s.nextInt();
                                	if(valor < 0) {
                                		throw new IllegalArgumentException();
                                	}
                                	conta.saca(valor);
                            	} catch (NullPointerException a) {
                                    System.out.println("Conta informada não existe");
                                } catch (SaldoInsuficienteException a) {
                                	System.out.println("Saldo insuficiente");
                                } catch(IllegalArgumentException a) {
                                	System.out.println("Valor informado n�o � aceito");
                                }
                            	
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
                    } while (opcaoDesejada != 4);
                    break;

                case 4:
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Selecione uma opção válida!\n\n");
                    break;
            }

        } while (opcaoDesejada != 5);

    }

}
