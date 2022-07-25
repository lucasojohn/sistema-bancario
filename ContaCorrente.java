package banco;

public class ContaCorrente extends Conta{
    
    public ContaCorrente(Cliente cliente, int numeroConta) {
        super(cliente, numeroConta);
    }
    
    @Override
    public void atualiza(double taxa) {
		// calculo para atualizar o saldo de acordo com a taxa passada no parametro
    	
	}

    @Override
    public double calculaTributos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}