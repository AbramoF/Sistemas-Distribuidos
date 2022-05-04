package model.dao;

import infrastructure.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Usuario;

public class UsuarioDAO {

    public void create(Usuario u) {
        Connection con = DbConnection.getMySqlConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO user (username, password) VALUES (?,?)");
            stmt.setString(1, u.getUsername());
            stmt.setString(2, u.getPassword());

            stmt.executeUpdate(); // executa

            // FAZER
            // RETORNAR ALGO DE SUCESSO
        } catch (SQLException ex) {
            System.out.println(ex);
            // FAZER
            // RETORNAR ALGO DE ERRO
        } finally {
            DbConnection.closeConnection(con, stmt);
        }
    }

    public List<Usuario> read() {
        Connection con = DbConnection.getMySqlConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Usuario> usuarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM user");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Usuario usuario = new Usuario();

                usuario.setIduser(rs.getInt("iduser"));
                usuario.setUsername(rs.getString("username"));
                usuario.setPassword(rs.getString("password"));
                usuarios.add(usuario);
            }

            // FAZER
            // RETORNAR ALGO DE SUCESSO
        } catch (SQLException ex) {
            System.out.println(ex);
            // FAZER
            // RETORNAR ALGO DE ERRO
        } finally {
            DbConnection.closeConnection(con, stmt, rs);
        }

        return usuarios;
    }

    public void update(Usuario u) {
        Connection con = DbConnection.getMySqlConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE user SET username = ? ,password = ? WHERE iduser = ?");
            stmt.setString(1, u.getUsername());
            stmt.setString(2, u.getPassword());
            stmt.setInt(3, u.getIduser());

            stmt.executeUpdate();

            // FAZER
            // RETORNAR ALGO DE SUCESSO
        } catch (SQLException ex) {
            System.out.println(ex);
            // FAZER
            // RETORNAR ALGO DE ERRO
        } finally {
            DbConnection.closeConnection(con, stmt);
        }
    }

    public void delete(Usuario u) {
        Connection con = DbConnection.getMySqlConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM user WHERE iduser = ?");
            stmt.setInt(1, u.getIduser());

            stmt.executeUpdate();

            // FAZER
            // RETORNAR ALGO DE SUCESSO
        } catch (SQLException ex) {
            // FAZER
            // RETORNAR ALGO DE ERRO
        } finally {
            DbConnection.closeConnection(con, stmt);
        }
    }

    public boolean checkLogin(String username, String senha) {

        Connection con = DbConnection.getMySqlConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;

        try {

            stmt = con.prepareStatement("SELECT * FROM user WHERE username = ? and password = ?");
            stmt.setString(1, username);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {
                check = true;
                // FAZER
                // RETORNAR ALGO DE SUCESSO
            }

        } catch (SQLException ex) {
            // FAZER
            // RETORNAR ALGO DE ERRO
        } finally {
            DbConnection.closeConnection(con, stmt, rs);
        }

        return check;

    }
}
