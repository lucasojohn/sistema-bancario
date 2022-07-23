package banco;

public abstract class Conta {
	
	private static int NUMERO_DE_CONTAS;
	private int numeroConta;
	private Cliente titular;
	protected double saldo;
	
	public Conta(Cliente cliente, int numeroConta) {
            this.titular = cliente;
            this.numeroConta = numeroConta;
            this.saldo = 0.0;
            NUMERO_DE_CONTAS++; 
	}
	
	public void saca(double valor) {
		
	}
	
	public void deposita(double valor) {
		
	}
	
	public void transfere(Conta destino, double valor) {
		
	}
	
	
	public void atualiza(double taxa) {
		
	}


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
