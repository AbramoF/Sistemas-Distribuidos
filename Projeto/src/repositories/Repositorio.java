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
    
    // FUNCOES DE USUARIO -----------------------------------------------------------------------

    public int registrarUsuario(String username, String senha) {
        if (username.equals("") || senha.equals("")) {
            return 0;
        } else if (existeUsuario(username)) {
            return 1;
        } else {
            usuarios.add(new Usuario(username, senha));
            System.out.println("Registrou " + username);
            return 2;
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
        if (!usuariosOnline.contains(username)) // ver se ta funcionando
        {
            usuariosOnline.add(username);
        }
    }

    public void saiuOnline(String username) {
        if (usuariosOnline.contains(username)) // ver se ta funcionando
        {
            usuariosOnline.remove(username);
        }
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

    public void printUsers() {
        for (int i = 0; i < getUsuarios().size(); i++) {
            System.out.println(getUsuarios().get(i).getUsername());
        }
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    // FUNCOES DE PRODUTO ----------------------------------------------------------------------
    
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public boolean inserirProduto(String nome, float valor, String descricao, String username) {
        if(!nome.equals("") && !descricao.equals("") && (new Float(valor) != null)) 
        {
        Produto novoProduto = new Produto(proxIdProduto(), nome, valor, descricao, username);
        produtos.add(novoProduto);
        return true;
        } else {
            return false;
        }
    }

    public int proxIdProduto() {
        if (produtos.size() == 0) {
            return 1;
        } else {
            int aux = produtos.get(0).getIdproduct();
            for (int i = 0; i < produtos.size(); i++) {
                if(produtos.get(i).getIdproduct() > aux)
                    aux = produtos.get(i).getIdproduct();
            }
            return aux + 1;
        }
    }
}
