package banco;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class ContaPoupanca extends Conta {
	
	Scanner s = new Scanner(System.in);
	Map<Integer, Conta> mapaDeContas = new HashMap<>();
	
    public ContaPoupanca(Cliente cliente, int numeroConta) {
        super(cliente, numeroConta);
    }

    public void atualiza(double taxa) {
    	
    	System.out.println("Digite o número da conta: ");
        int nrConta = s.nextInt();
        Conta conta;
        conta = mapaDeContas.get(nrConta);
        conta.setSaldo(getSaldo()*(taxa/100));

    }

    @Override
    public double calculaTributos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
