package Controllers;

import Entidades.Usuario;
import javax.swing.JOptionPane;

public class LoginController {

    private Usuario usuario;
    private StringBuilder menssagemErro;

    public void setup() {

        usuario = new Usuario();
        menssagemErro = new StringBuilder();

    }

    public boolean validarCampos(Usuario usuario) {
        //se o campo estiver com espaços, vazio ou
        if (usuario.getUserName() == null || usuario.getUserName().equals("") || usuario.getUserName().isEmpty()) {
            menssagemErro.append("UserName não pode ser nulo \n");

            return false;
        }
        if (usuario.getSenha() == null || usuario.getSenha().equals("") || usuario.getSenha().isEmpty()) {
            menssagemErro.append("Senha não pode ser nulo \n");

            return false;
        }
        return true;
    }

    public Usuario login(String userName, String senha) {
        setup();
        usuario.setUserName(userName);
        usuario.setSenha(senha);

        if (validarCampos(usuario)) {
            //consultar DAO
            
            JOptionPane.showMessageDialog(null, "Login com sucesso");

        } else {
            JOptionPane.showMessageDialog(null, menssagemErro.toString());

        }

        return usuario;
    }

}
