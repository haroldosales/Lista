package controle;

import dao.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Controle {

  public static void insere(String nome, int tipo) {
    String sql =
      "INSERT INTO item (nome,tipo ) VALUES ('" + nome + "','" + tipo + "');";
    Conexao conn = new Conexao();
    int res = conn.executeUpdate(sql);
    if (res >= 1) {
      System.out.println("adcionado com sucesso!");
    } else {
      System.err.println("Erro , nao foi possivel");
    }
  }

  public static void mostrar() {
    String sql = "SELECT * FROM item";
    Conexao conn = new Conexao();

    System.out.println("nome - tipo");
    try {
      ResultSet consulta = conn.executeQuery(sql);
      while (consulta.next()) {
        String nome = consulta.getString("nome");
        int tipo = consulta.getInt("tipo");
        System.out.println(nome + " - " + tipo);
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public static void deletar(String nome) {
    String sql = "DELETE  FROM item WHERE nome = ('" + nome + "');";

    Conexao conn = new Conexao();
    int res = conn.executeUpdate(sql);

    if (res >= 1) {
      System.out.println("Removido com sucesso!");
    } else {
      System.err.println("Erro , nao foi possivel");
    }
  }
}
