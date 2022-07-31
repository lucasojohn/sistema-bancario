package banco;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Agencia {

    Map<Integer, Conta> mapaDeContas = new HashMap<>();
    Map<String, Cliente> mapaDeClientes = new HashMap<>();
    private int numeroAG;
    Scanner s = new Scanner(System.in);

    public void excluirCliente() {
        try {
            System.out.println("Digite o CPF: ");
            String cpf = s.next();
            Cliente cliente = mapaDeClientes.get(cpf);
            System.out.println("Cliente de CPF " + cliente.getCpf() + " selecionado");
            System.out.println("Deseja realmente excluir o cliente?");
            System.out.println("Digite 1 para confirmar");
            int opcao = s.nextInt();

            if (opcao == 1) {
                for (int nrConta : mapaDeContas.keySet()) {
                    if (mapaDeContas.get(nrConta).equals(cliente.mapaDeContas.get(nrConta))) {
                        excluirConta(cliente, nrConta);
                    }
                }
                mapaDeClientes.remove(cpf);
                System.out.println("Cliente excluído com sucesso");
            } else {
                System.out.println("Falha na exclusão do cliente");
            }

        } catch (NullPointerException a) {
            System.out.println("Cliente informado não existe!\n");
        }
    }

    public void listarUmCliente() {
        try {
            System.out.println("Digite o CPF: ");
            String cpf = s.next();
            Cliente cliente;
            cliente = mapaDeClientes.get(cpf);
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Sobrenome: " + cliente.getSobrenome());
        } catch (NullPointerException a) {
            System.out.println("Cliente informado não existe!\n");
        }
    }

    public void listarClientes() {

        for (Map.Entry<String, Cliente> teste : mapaDeClientes.entrySet()) {
            System.out.println("CPF: " + teste.getKey());
            System.out.println("Nome: " + teste.getValue().getNome());
            System.out.println("Sobrenome: " + teste.getValue().getSobrenome() + "\n");
        }
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

        mapaDeContas.remove(nrConta);
        titular.mapaDeContas.remove(nrConta);
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
                mapaDeContas.remove(nrConta);
                cliente.mapaDeContas.remove(nrConta);
                if(cliente.mapaDeContas.isEmpty()) {
                	mapaDeContas.remove(null, cliente);
                }
                System.out.println("Conta excluída com sucesso");
            } else {
                System.out.println("Falha na exclusão da conta");
            }

        } catch (NullPointerException a) {
            System.out.println("Cliente informado não existe!\n");
        }
    }

    public void listarUmaConta() {
        try {
            System.out.println("Digite o número da conta: ");
            int nrConta = s.nextInt();
            Conta conta;
            conta = mapaDeContas.get(nrConta);
            System.out.println("Número da Conta: " + conta.getNumeroConta());
            if (conta instanceof ContaCorrente) {
                System.out.println("Tipo de conta: Corrente");
            } else if (conta instanceof ContaPoupanca) {
                System.out.println("Tipo de conta: Poupança");
            }
            System.out.println("Saldo: " + conta.getSaldo() + "\n");
        } catch (NullPointerException a) {
            System.out.println("Conta informada não existe!\n");
        }
    }

    public void listarContas() {

        for (Map.Entry<Integer, Conta> conta : mapaDeContas.entrySet()) {
            System.out.println("Número da Conta: " + conta.getKey());
            if (conta instanceof ContaCorrente) {
                System.out.println("Tipo de conta: Corrente");
            } else if (conta instanceof ContaPoupanca) {
                System.out.println("Tipo de conta: Poupança");
            }
            System.out.println("Saldo: " + conta.getValue().getSaldo() + "\n");
        }
    }

    public void atualizarConta() {

        try {
            System.out.print("Informe o numero da conta que deseja atualizar: ");
            int nrConta = s.nextInt();
            Conta conta = mapaDeContas.get(nrConta);

            System.out.println("Conta número " + conta.getNumeroConta() + " selecionada");

            System.out.println("Informe novo saldo para a conta:");
            double novoSaldo = s.nextDouble();
            conta.setSaldo(novoSaldo);
            System.out.println("Saldo atualizado com sucesso!");

        } catch (NullPointerException a) {
            System.out.println("Conta informada não existe");
        }
    }

    public void cadastrarConta(Cliente titular) {

        int opcao;
        Conta conta;
        int numeroConta;

        do {
            System.out.println("Selecione o tipo de conta:\n");
            System.out.println("1. Conta Corrente");
            System.out.println("2. Conta Poupança");
            opcao = s.nextInt();

            System.out.print("Digite o número da conta: ");
            numeroConta = s.nextInt();

            switch (opcao) {

                case 1:
                    conta = new ContaCorrente(titular, numeroConta);
                    mapaDeContas.put(numeroConta, conta);
                    titular.mapaDeContas.put(numeroConta, conta);
                    break;

                case 2:
                    conta = new ContaPoupanca(titular, numeroConta);
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

            do {
                System.out.println("Selecione o tipo de conta:\n");
                System.out.println("1. Conta Corrente");
                System.out.println("2. Conta Poupança");
                opcao = s.nextInt();

                System.out.print("Digite o número da conta: ");
                numeroConta = s.nextInt();

                switch (opcao) {

                    case 1:
                        conta = new ContaCorrente(cliente, numeroConta);
                        mapaDeContas.put(numeroConta, conta);
                        cliente.mapaDeContas.put(numeroConta, conta);
                        break;

                    case 2:
                        conta = new ContaPoupanca(cliente, numeroConta);
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
