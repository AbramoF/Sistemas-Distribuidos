package repositories;

import java.util.ArrayList;
import model.Produto;
import model.Usuario;

public class Repositorio {

    public Repositorio() {
        this.usuarios = new ArrayList<Usuario>();
    }

    private ArrayList<Usuario> usuarios;
    private ArrayList<Produto> produtos;
    public ArrayList<String> usuariosOnline;

    public boolean registrarUsuario(String username, String senha) {
        if (existeUsuario(username)) {
            return false;
        } else {
            usuarios.add(new Usuario(username, senha));
            return true;
        }
    }
    
    public boolean login(String username, String senha) {
        if (getUsuarios().contains(new Usuario(username,senha))) {
            novoOnline(username);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean logOut(String username) {
        if(usuariosOnline.contains(username)) {
            saiuOnline(username);
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
            if (users.get(i).getUsername() == username) {
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
}
