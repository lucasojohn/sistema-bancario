package banco;

import java.util.Scanner;

public abstract class Conta implements Tributavel {

    private static int NUMERO_DE_CONTAS = 0;
    protected int numeroConta;
    private Cliente titular;
    protected double saldo;
    Scanner s = new Scanner(System.in);

    public Conta(Cliente cliente, int numeroConta, double saldo) {
        this.titular = cliente;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        NUMERO_DE_CONTAS++;
    }
    
    
    public void saca(double valor) {
    	
    	if(this.saldo > valor) {
    		saldo = this.saldo - valor;
    		System.out.println("Saldo atual: R$ " + saldo);
    		s.nextLine();
    	} else {
    		throw new SaldoInsuficienteException();
    	}
    }

    public void deposita(double valor) {
    	if(valor > 0) {
    		saldo += valor;
    		System.out.println("Saldo atual: R$ " + saldo);
    		s.nextLine();
    	} else {
    		throw new IllegalArgumentException();
    	}
    }

    public void transfere(Conta contaRecebedora, double valor) {
    	
    	if(valor > 0) {
    		this.saca(valor);
    		contaRecebedora.deposita(valor);
    		s.nextLine();
    	}
    }

    public abstract void atualiza(double taxa);

    public static int getNUMERO_DE_CONTAS() {
        return NUMERO_DE_CONTAS;
    }

    public static void setNUMERO_DE_CONTAS(int nUMERO_DE_CONTAS) {
        NUMERO_DE_CONTAS = nUMERO_DE_CONTAS;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Cliente getTitular() {
        return titular;
        
       
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

	
}
