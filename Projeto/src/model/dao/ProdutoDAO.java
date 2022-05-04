package model.dao;

import infrastructure.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Produto;
import model.bean.Usuario;

public class ProdutoDAO {

    public void create(Produto p, Usuario u) {
        Connection con = DbConnection.getMySqlConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO product (name, value, description, user_iduser) VALUES (?,?,?,?)");
            stmt.setString(1, p.getName());
            stmt.setFloat(2, p.getValue());
            stmt.setString(3, p.getDescription());
            stmt.setInt(4, u.getIduser()); // passa o id do usuario

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

    public List<Produto> read() {

        Connection con = DbConnection.getMySqlConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM product");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto();

                produto.setIdproduct(rs.getInt("idproduct"));
                produto.setName(rs.getString("name"));
                produto.setValue(rs.getFloat("value"));
                produto.setDescription(rs.getString("description"));
                //produto.setUser_iduser(rs.getInt("user_iduser")); 
                produtos.add(produto);
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

        return produtos;

    }

    public List<Produto> readForUser(int id) {
        Connection con = DbConnection.getMySqlConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM product WHERE user_iduser = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto();

                produto.setIdproduct(rs.getInt("idproduct"));
                produto.setName(rs.getString("name"));
                produto.setValue(rs.getFloat("value"));
                produto.setDescription(rs.getString("description"));
                //produto.setUser_iduser(rs.getInt("user_iduser")); 
                produtos.add(produto);

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

        return produtos;
    }

    public void update(Produto p) {

        Connection con = DbConnection.getMySqlConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE product SET name = ? ,value = ?,description = ? WHERE idproduct = ?");
            stmt.setString(1, p.getName());
            stmt.setFloat(2, p.getValue());
            stmt.setString(3, p.getDescription());
            stmt.setInt(4, p.getIdproduct());

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
    
    public void delete(Produto p) {

        Connection con = DbConnection.getMySqlConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM product WHERE idproduct = ?");
            stmt.setInt(1, p.getIdproduct());

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
}
