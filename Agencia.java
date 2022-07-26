package banco;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Agencia {

	Menu menu = new Menu();
    Map<Integer, Conta> mapaDeContas = new HashMap<>();
    Map<String, Cliente> mapaDeClientes = new HashMap<>();
    private int numeroAG;
    Scanner s = new Scanner(System.in);

    public void excluirCliente() {
        try {
            System.out.print("Digite o CPF: ");
            String cpf = s.next();
            Cliente cliente = mapaDeClientes.get(cpf);
            System.out.println("Cliente de CPF " + cliente.getCpf() + " selecionado");
            System.out.println("Deseja realmente excluir o cliente?");
            System.out.println("Digite 1 para confirmar");
            int opcao = s.nextInt();

            if (opcao == 1) {
                Conta[] contas = new Conta[cliente.mapaDeContas.size()];
                cliente.mapaDeContas.values().toArray(contas);
                for(int i=0; i<contas.length; i++){
                    excluirConta(cliente, contas[i].getNumeroConta());
                }
//                for (int nrConta : mapaDeContas.keySet()) {
//                    if (mapaDeContas.get(nrConta).equals(cliente.mapaDeContas.get(nrConta))) {
//                        excluirConta(cliente, nrConta);
//                    }
//                }
                mapaDeClientes.remove(cpf);
                System.out.println("Cliente excluído com sucesso");
            } else {
                System.out.println("Falha na exclusão do cliente");
            }
            
        } catch (NullPointerException a) {
            System.out.println("Cliente informado não existe!\n");
        }
        s.nextLine();
    }

    public void listarUmCliente() {
        try {
            System.out.print("Digite o CPF: ");
            String cpf = s.next();
            Cliente cliente;
            cliente = mapaDeClientes.get(cpf);
            System.out.println("\nCPF: " + cliente.getCpf());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Sobrenome: " + cliente.getSobrenome());
            System.out.println("Total de contas: " + cliente.mapaDeContas.size());
        } catch (NullPointerException a) {
            System.out.println("Cliente informado não existe!\n");
        }
        s.nextLine();
    }

    public void listarClientes() {

        for (Map.Entry<String, Cliente> conta : mapaDeClientes.entrySet()) {
            System.out.println("CPF: " + conta.getKey());
            System.out.println("Nome: " + conta.getValue().getNome());
            System.out.println("Sobrenome: " + conta.getValue().getSobrenome());
            System.out.println("Total de conta(s): " + conta.getValue().mapaDeContas.size() + "\n");
        }
        s.nextLine();
        //menu.acoesConta();
    }

    public void cadastrarCliente() {

        System.out.print("Digite o número do CPF: ");
        String cpf = s.next();
        System.out.print("Digite o nome: ");
        String nome = s.next();
        System.out.print("Digite o sobrenome: ");
        String sobrenome = s.next();

        Cliente cliente = new Cliente(cpf, nome, sobrenome);
        mapaDeClientes.put(cpf, cliente);

        cadastrarConta(mapaDeClientes.get(cpf));
    }

    public void atualizarCliente() {

        try {
            System.out.println("Digite o CPF: ");
            String cpf = s.next();
            Cliente cliente;
            cliente = mapaDeClientes.get(cpf);
            System.out.println("Cliente de CPF " + cliente.getCpf() + " selecionado");
            System.out.println("Digite o novo nome: ");
            cliente.setNome(s.next());
            System.out.println("Digite o novo sobrenome: ");
            cliente.setSobrenome(s.next());
        } catch (NullPointerException a) {
            System.out.println("Cliente informado não existe!\n");
        }
    }

    public void excluirConta(Cliente titular, int nrConta) {

        Conta conta = mapaDeContas.get(nrConta);
        System.out.println("Conta número " + conta.getNumeroConta() + " selecionada");
        
        titular.mapaDeContas.remove(nrConta);
        mapaDeContas.remove(nrConta);
       
        System.out.println("Conta excluida com sucesso");

    }

    public void excluirConta() {
        try {
            System.out.print("Digite o número da conta: ");
            int nrConta = s.nextInt();
            Conta conta = mapaDeContas.get(nrConta);
            Cliente cliente = conta.getTitular();
            System.out.println("Conta número " + conta.getNumeroConta() + " selecionada");
            System.out.println("Deseja realmente excluir a conta?");
            System.out.println("Digite 1 para confirmar");
            int opcao = s.nextInt();

            if (opcao == 1) {
                
                if(cliente.mapaDeContas.size() == 1) {
                	mapaDeContas.remove(nrConta);
                    cliente.mapaDeContas.remove(nrConta);
                	mapaDeClientes.remove(cliente.getCpf());
                } else {
                	mapaDeContas.remove(nrConta);
                    cliente.mapaDeContas.remove(nrConta);
                }
                
                System.out.println("Conta excluída com sucesso");
            } else {
                System.out.println("Falha na exclusão da conta");
            }
            s.nextLine();
        } catch (NullPointerException a) {
            System.out.println("Cliente informado não existe!");
        }
    }

    public void listarUmaConta() {
        try {
            System.out.print("Digite o número da conta: ");
            int nrConta = s.nextInt();
            Conta conta;
            conta = mapaDeContas.get(nrConta);
            System.out.println("\nNúmero da Conta: " + conta.getNumeroConta());
            if (conta instanceof ContaCorrente) {
                System.out.println("Tipo de conta: Corrente");
            } else if (conta instanceof ContaPoupanca) {
                System.out.println("Tipo de conta: Poupança");
            }
            System.out.println("Saldo: " + conta.getSaldo());
            s.nextLine();
        } catch (NullPointerException a) {
            System.out.println("Conta informada não existe!");
        }
    }

    public void listarContas() {

        for (Map.Entry<Integer, Conta> conta : mapaDeContas.entrySet()) {
            System.out.println(conta.getValue().toString());
        }
        s.nextLine();
    }

    public void atualizarConta() {

        try {
            System.out.print("Informe o numero da conta que deseja atualizar: ");
            int nrConta = s.nextInt();
            Conta conta = mapaDeContas.get(nrConta);            
            System.out.println("Conta número " + conta.getNumeroConta() + " selecionada");

            System.out.print("Informe novo saldo para a conta:");
            double novoSaldo = s.nextDouble();
            conta.setSaldo(novoSaldo);
            System.out.println("Saldo atualizado com sucesso!");
            s.nextLine();

        } catch (NullPointerException a) {
            System.out.println("Conta informada não existe");
        }
    }

    public void cadastrarConta(Cliente titular) {

        int opcao;
        Conta conta;
        int numeroConta;
        double saldo;

        do {
            System.out.println("Selecione o tipo de conta:\n");
            System.out.println("1. Conta Corrente");
            System.out.println("2. Conta Poupança");
            opcao = s.nextInt();

            System.out.print("Digite o número da conta: ");
            numeroConta = s.nextInt();
            
            System.out.print("Digite o saldo inicial da conta: ");
            saldo = s.nextDouble();

            switch (opcao) {

                case 1:
                    conta = new ContaCorrente(titular, numeroConta, saldo);
                    mapaDeContas.put(numeroConta, conta);
                    titular.mapaDeContas.put(numeroConta, conta);
                    break;

                case 2:
                    conta = new ContaPoupanca(titular, numeroConta, saldo);
                    mapaDeContas.put(numeroConta, conta);
                    titular.mapaDeContas.put(numeroConta, conta);
                    break;

                default:
                    System.out.println("Digite uma opção válida!");
            }
        } while (opcao != 1 && opcao != 2);
        System.out.println("Conta cadastrada com sucesso!");
    }

    public void cadastrarConta() {
        try {
            System.out.print("Informe o CPF do cliente: ");
            String cpf = s.next();

            Cliente cliente = mapaDeClientes.get(cpf);
            System.out.println("Cliente de CPF " + cliente.getCpf() + " selecionado");

            int opcao;
            Conta conta;
            int numeroConta;
            double saldo;

            do {
                System.out.println("Selecione o tipo de conta:\n");
                System.out.println("1. Conta Corrente");
                System.out.println("2. Conta Poupança");
                opcao = s.nextInt();

                System.out.print("Digite o número da conta: ");
                numeroConta = s.nextInt();
                
                System.out.print("Digite o saldo inicial da conta: ");
                saldo = s.nextDouble();
            
                switch (opcao) {

                    case 1:
                        conta = new ContaCorrente(cliente, numeroConta, saldo);
                        mapaDeContas.put(numeroConta, conta);
                        cliente.mapaDeContas.put(numeroConta, conta);
                        break;

                    case 2:
                        conta = new ContaPoupanca(cliente, numeroConta, saldo);
                        mapaDeContas.put(numeroConta, conta);
                        cliente.mapaDeContas.put(numeroConta, conta);
                        break;

                    default:
                        System.out.println("Digite uma opção válida!");
                }
            } while (opcao != 1 && opcao != 2);
            System.out.println("Conta cadastrada com sucesso!");
        } catch (NullPointerException e) {
            System.out.println("Cliente não localizado, favor realizar cadastro do cliente\n");
        }
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
