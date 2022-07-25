package banco;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(Cliente cliente, int numeroConta) {
        super(cliente, numeroConta);
    }
    
    
    public void atualiza(double taxa) {
		// calculo para atualizar o saldo de acordo com a taxa passada no parametro
    	
    	
	}

    @Override
    public double calculaTributos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}