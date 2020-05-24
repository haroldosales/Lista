package controle;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.Conexao;

public class Controle {

	public static void insere(String nome, int numero) {
		String sql = "INSERT INTO lista (nome,numero ) VALUES ('" + nome + "','" + numero + "');";
		Conexao conn = new Conexao();
		int res = conn.executeUpdate(sql);
		if (res >= 1) {
			System.out.println("adcionado com sucesso!");
		} else {
			System.err.println("Erro , nao foi possivel");
		}
	}
public	static void mostrar() {
		String sql = "SELECT * FROM lista";
		Conexao conn = new Conexao();
		
		
		System.out.println("nome - numero");
		try {
			ResultSet consulta = conn.executeQuery(sql);
			while(consulta.next()) {
				String nome = consulta.getString("nome");
				int  numero = consulta.getInt("numero");
				System.out.println(nome+" - "+numero);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
