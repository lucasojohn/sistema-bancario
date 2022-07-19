public class Menu {

	
	public void inicial() {
		
		System.out.println("Seja bem vindo!");
		System.out.println("Selecione a op��o desejada:\n");
		
		System.out.println("1. Gerir contas");
		System.out.println("2. Gerir clientes");
		System.out.println("3. Gerir transa��es");
		System.out.println("4. Gerir IRPF");
		System.out.println("5. Sair");
		
	}	

	
	public void submenu(int opcaoDesejada) {
		
		switch (opcaoDesejada) {
		
			case 1:
				Menu menuGerirContas = new Menu();
				menuGerirContas.gerirContas();
				break;
			
			case 2:
				Menu menuGerirClientes = new Menu();
				menuGerirClientes.gerirClientes();
				break;
				
			case 3:
				Menu menuAcoesConta = new Menu();
				menuAcoesConta.acoesConta();
				break;
		}
		
	}	
	
	
	public void gerirContas() {
		
		System.out.println("1. Cadastrar conta");
		System.out.println("2. Atualizar conta");
		System.out.println("3. Listar contas");
		System.out.println("4. Listar uma conta");
		System.out.println("5. Excluir conta");
		System.out.println("6. Voltar");
	
	}	
	
	
	public void gerirClientes() {
		
		System.out.println("1. Cadastrar cliente");
		System.out.println("2. Atualizar cliente");
		System.out.println("3. Listar clientes");
		System.out.println("4. Listar um cliente");
		System.out.println("5. Excluir cliente");
		System.out.println("6. Voltar");
		
	}
	
	
	public void acoesConta() {
		
		System.out.println("1. Saque");
		System.out.println("2. Dep�sito");
		System.out.println("3. Transfer�ncia");
		System.out.println("4. Voltar");
		
	}
	
	
	
}
