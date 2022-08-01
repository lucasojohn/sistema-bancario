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
    	
    	System.out.println("Digite o n�mero da conta: ");
        int nrConta = s.nextInt();
        Conta conta;
        conta = mapaDeContas.get(nrConta);
        conta.setSaldo(getSaldo()*(taxa/100));

    }

    @Override
    public double calculaTributos() {
    	return 0;
    }
    
    @Override
    public String toString() {
    	return "Conta poupan�a | numero: "+ this.numeroConta +" | saldo: "+ this.saldo;
    }
}
