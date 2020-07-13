package sistema;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import archives.listas;
import controle.Controle;
import dao.Conexao;

public class program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		listas l = new listas();
		Controle contro = new Controle();
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite a quantidade de items");
		int x = sc.nextInt();
		for (int i = 1; i < x; i++) {
			System.out.println("Item #"+i);
			System.out.println("Digite o Nome");
			l.setNome(sc.next());
			System.out.println("Digite a Quantidade");

			l.setQuantidade(sc.nextInt());
		}
		contro.insere(l.getNome(), l.getQuantidade());
	
		System.out.println("Digite A Opcao 1 para Mostrar, 2 para excluir");
		int b = sc.nextInt();
		switch (b) {
		case 1:
			
			break;
		case 2:
			System.out.println("digite um nome para deletar ");
			contro.mostrar();
			String name = sc.next();
				contro.deletar(name);
				contro.mostrar();

			break;
		default:
			System.out.println("Finalizado");
			break;
		}
		

		

		
		
	}

	
}
