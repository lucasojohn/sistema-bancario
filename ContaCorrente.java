package banco;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContaCorrente extends Conta {

	Scanner s = new Scanner(System.in);
	Map<Integer, Conta> mapaDeContas = new HashMap<>();
	
    public ContaCorrente(Cliente cliente, int numeroConta) {
        super(cliente, numeroConta);
    }

    @Override
    public void atualiza(double taxa) {
    	
    	System.out.println("Digite o número da conta: ");
        int nrConta = s.nextInt();
        Conta conta;
        conta = mapaDeContas.get(nrConta);
        conta.setSaldo(conta.getSaldo() - taxa);

    }

    @Override
    public double calculaTributos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
