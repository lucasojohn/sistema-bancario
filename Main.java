import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		// apresenta menu inicial para o usuário fazer a escolha de qual operação realizar 
		Menu menuInicial = new Menu();
		menuInicial.inicial();
	
		// usuario passa valor da opção desejada
		int opcaoDesejada = s.nextInt();

		// retorna menu da opção desejada
		Menu retornaMenuDesejado = new Menu();
		retornaMenuDesejado.submenu(opcaoDesejada);
		
		// executa opção desejada
		
	}

}
