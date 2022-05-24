package Controllers;

import Entidades.Usuario;
import Persistencia.UsuarioDAO;
import javax.swing.JOptionPane;

public class LoginController {

    private Usuario usuario;
    private StringBuilder menssagemErro;
    private UsuarioDAO daoUsuario;

    public void setup() {

        usuario = new Usuario();
        menssagemErro = new StringBuilder();
        daoUsuario = new UsuarioDAO();
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
            //Percorre a lista e verifica se o usuario e a senha estão corretos
            for (Usuario usuarioDoBD : daoUsuario.listarTodos()) {

                if (usuarioDoBD.getUserName().equals(usuario.getUserName())) {

                    if (usuarioDoBD.getSenha().equals(usuario.getSenha())) {
                        
                        usuario = usuarioDoBD;
                        
                        JOptionPane.showMessageDialog(null, "Login com sucesso");

                    }
                }
            }

        } else {

            JOptionPane.showMessageDialog(null, menssagemErro.toString());

        }

        return usuario;
    }

}
