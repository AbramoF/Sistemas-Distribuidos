package repositories;

import java.util.ArrayList;
import model.Produto;
import model.Usuario;

public class Repositorio {

    public Repositorio() {
        this.usuarios = new ArrayList<Usuario>();
        this.produtos = new ArrayList<Produto>();
        this.usuariosOnline = new ArrayList<String>();

    }
    
    // TIRAR
    public int port = 0;
    public String data[][] = {{"101", "Abramo", "670000"},
    {"102", "Matheus", "780000"},
    {"101", "Portela", "700000"}};
    public String column[] = {"ID", "NAME", "SALARY"};
    // ------------------------------------------------------

    private ArrayList<Usuario> usuarios;
    private ArrayList<Produto> produtos;
    public ArrayList<String> usuariosOnline;

    public boolean registrarUsuario(String username, String senha) {
        if (existeUsuario(username)) {
            return false;
        } else {
            usuarios.add(new Usuario(username, senha));
            System.out.println("Registrou " + username);
            return true;
        }
    }

    public boolean login(String username, String senha) {
        ArrayList<Usuario> users = getUsuarios();
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario user = users.get(i);
            if (user.getUsername().equals(username) && user.getPassword().equals(senha)) {
                novoOnline(username);
                System.out.println("Logou " + username);
                return true;
            }
        }
        return false;
    }

    public boolean logOut(String username) {
        if (usuariosOnline.contains(username)) {
            saiuOnline(username);
            System.out.println("Deslogou " + username);
            return true;
        } else {
            return false;
        }
    }

    public void novoOnline(String username) {
        usuariosOnline.add(username);
    }

    public void saiuOnline(String username) {
        usuariosOnline.remove(username);
    }

    public boolean existeUsuario(String username) {
        ArrayList<Usuario> users = getUsuarios();
        for (int i = 0; i < usuarios.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public void printUsers() {
        for (int i = 0; i < getUsuarios().size(); i++) {
            System.out.println(getUsuarios().get(i).getUsername());
        }
    }
}
