import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		// apresenta menu inicial para o usuário fazer a escolha de qual operação realizar 
		MenuInicial menuInicial = new MenuInicial();
		menuInicial.apresentarMenu();
	
		// usuario passa valor da opção desejada
		int opcaoDesejada = s.nextInt();

		// retorna menu da opção desejada
		RetornaMenuDesejado retornaMenuDesejado = new RetornaMenuDesejado();
		retornaMenuDesejado.retornaMenuEscolhido(opcaoDesejada);
		
		// executa opção desejada
		
		
		
		
	}

}
