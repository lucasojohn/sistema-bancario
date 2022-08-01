/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 *
 * @author Aluno
 */
public class GerenciadorIRPF {
    private double total;
    private double totalDeSaldo;
    
    public void adicionaTributos(double saldo){
    	double totalDeSaldo =+ saldo;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

	public double getTotalDeSaldo() {
		return totalDeSaldo;
	}

	public void setTotalDeSaldo(double totalDeSaldo) {
		this.totalDeSaldo = totalDeSaldo;
	}
    
    
    
    
}
