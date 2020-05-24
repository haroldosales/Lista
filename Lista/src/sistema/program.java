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

		String nome = sc.next();
		int numero = sc.nextInt();

		l.setNome(nome);

		l.setQuantidade(numero);
		

		contro.insere(nome, numero);
		
		//contro.mostrar();

	}

	
}
