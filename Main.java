package banco;

import java.util.Scanner;

public class Main {

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
