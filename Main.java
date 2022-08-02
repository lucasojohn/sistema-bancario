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
                            	System.out.println("Informe a conta que deseja realizar o dep�sito:");
                            	int contaBancaria = s.nextInt();
                            	Conta contaDep = agencia.mapaDeContas.get(contaBancaria); 
                            	try {
                            		System.out.println("Conta número " + contaDep.getNumeroConta() + " selecionada");
                                	if(contaDep instanceof ContaCorrente) {
                                		System.out.println("Informe o valor que deseja depositar na conta corrente:");
                                	} else {
                                		System.out.println("Informe o valor que deseja depositar na conta poupanca:");
                                	}
                            		
                            		double valor = s.nextInt();
                                	if(valor < 0) {
                                		throw new IllegalArgumentException();
                                	}
                                	contaDep.deposita(valor);
                            	} catch (NullPointerException a) {
                                    System.out.println("Conta informada não existe");
                                } catch(IllegalArgumentException a) {
                                	System.out.println("Valor para dep�sito tem que ser positivo");
                                }
                                break;

                            case 3:
                            	System.out.println("Informe o numero da conta que vai transferir o saldo:\n");
                            	int contaEnvia = s.nextInt();
                            	Conta contaEnviadora = agencia.mapaDeContas.get(contaEnvia); 
                            	try {
                            		System.out.println("Conta número " + contaEnviadora.getNumeroConta() + " selecionada");
                                	
                            		if(contaEnviadora instanceof ContaCorrente) {
                                		System.out.println("Selecionado transferência da conta corrente");
                                	} else {
                                		System.out.println("Selecionado transferência da conta poupanca");
                                	}

                            		System.out.println("Informe o numero da conta de destino:");                            		
                            		int contaRecebe = s.nextInt();
                            		Conta contaRecebedora = agencia.mapaDeContas.get(contaRecebe);
                                	try {
                                		System.out.println("Informe o valor da trasferencia para a conta " + contaRecebedora.getNumeroConta());
                                		double valor = s.nextDouble();
                                		if(valor < 0) {
                                    		throw new IllegalArgumentException();
                                    	}
                                    	contaEnviadora.transfere(contaRecebedora, valor);
                                	} catch (NullPointerException a) {
                                        System.out.println("Conta informada não existe");
                                    }
                            	} catch (NullPointerException a) {
                                    System.out.println("Conta informada não existe");
                                } catch(IllegalArgumentException a) {
                                 	System.out.println("Valor para transferencia tem que ser positivo");
                                 }
                            	
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
                    System.out.println("Informe o CPF do cliente para realizar o calculo de IRPF de todas suas contas:");
                    String cpf = s.next();
                    Cliente cliente = agencia.mapaDeClientes.get(cpf);
                    
                	try {
                		System.out.println("Cliente " + cliente.getNome() + " selecionado");
                		GerenciadorIRPF gerenciador = new GerenciadorIRPF();
                		Conta[] contas = new Conta[cliente.mapaDeContas.size()];
                		cliente.mapaDeContas.values().toArray(contas);
                		
                		for(int i=0; i<contas.length; i++) {
                			gerenciador.adicionaTributos(contas[i].saldo);
                		}
                		
                		if(gerenciador.getTotalDeSaldo() < 1903.98) {
                                    System.out.println("O valor do imposto de renda é R$0");

                		} else if (gerenciador.getTotalDeSaldo() < 2862.65 && gerenciador.getTotalDeSaldo() > 1903.99) {
                                    System.out.println("O valor do imposto de renda é R$142,80");
              			
                		} else if (gerenciador.getTotalDeSaldo() < 3751.05 && gerenciador.getTotalDeSaldo() > 2826.66) {
                                    System.out.println("O valor do imposto de renda é R$354,80");

                		} else if (gerenciador.getTotalDeSaldo() < 4664.68 && gerenciador.getTotalDeSaldo() > 3751.06) {
                                    System.out.println("O valor do imposto de renda é R$636,13");

                		} else if (gerenciador.getTotalDeSaldo() > 4664.68){
                                    System.out.println("O valor do imposto de renda é R$869,36");

                		}
                		
                	} catch (NullPointerException a) {
                        System.out.println("Cliente informado não existe");
                    }
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
