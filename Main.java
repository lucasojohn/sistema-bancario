import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		// apresenta menu inicial para o usu�rio fazer a escolha de qual opera��o realizar 
		MenuInicial menuInicial = new MenuInicial();
		menuInicial.apresentarMenu();
	
		// usuario passa valor da op��o desejada
		int opcaoDesejada = s.nextInt();

		// retorna menu da op��o desejada
		RetornaMenuDesejado retornaMenuDesejado = new RetornaMenuDesejado();
		retornaMenuDesejado.retornaMenuEscolhido(opcaoDesejada);
		
		// executa op��o desejada
		
		
		
		
	}

}
