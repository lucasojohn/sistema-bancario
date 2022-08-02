package banco;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContaCorrente extends Conta {

	Scanner s = new Scanner(System.in);
	Map<Integer, Conta> mapaDeContas = new HashMap<>();
	
    public ContaCorrente(Cliente cliente, int numeroConta, double saldo) {
        super(cliente, numeroConta, saldo);
    }

    @Override
    public void atualiza(double taxa) {
    	
    	System.out.println("Digite o n�mero da conta: ");
        int nrConta = s.nextInt();
        Conta conta;
        conta = mapaDeContas.get(nrConta);
        conta.setSaldo(conta.getSaldo() - taxa);

    }

    @Override
    public double calculaTributos() {
    	double result = saldo * (10/100);
        return result; 
    }
    
    @Override
    public String toString() {
    	return "Conta corrente | numero: "+ this.numeroConta +" | saldo: "+ this.saldo;
    }
}
