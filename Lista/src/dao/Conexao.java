package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Conexao {

	private String url;
	private String user;
	private String pass;

	public Conexao() {
		url = "jdbc:postgresql://localhost:5432/Pessoa";
		user = "postgres";
		pass = "toor";
	}

	private Connection getConnection() {

		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			return conn;
		} catch (SQLException ex) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Problema com a conexao\n" + ex.getMessage(), "ERRO",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	public int executeUpdate(String query) {
		try {
			Connection con = getConnection();
			Statement stm = con.createStatement();
			System.out.println(query);
			int res = stm.executeUpdate(query);
			con.close();
			return res;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Problemas com a conexão\n" + ex.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
			return 0;
		}
	}

	public ResultSet executeQuery(String query) {
		try {
			Connection conn = getConnection();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(query);
			// conn.close();
			return rs;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Problema com a conexao\n" + ex.getMessage(), "ERRO",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}

	}
	
	

}
