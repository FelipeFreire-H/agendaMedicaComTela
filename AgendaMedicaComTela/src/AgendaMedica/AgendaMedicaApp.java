
package AgendaMedica;

import Persistencia.BuildDeTabelas;
import View.TelaLogin;

public class AgendaMedicaApp {
    
    public static void main(String[] args) {
        
        BuildDeTabelas build = new BuildDeTabelas();
        
        build.construirTabelas();
        build.inserirDadosIniciais();
        
        
        
        TelaLogin telaLogin = new TelaLogin();
        telaLogin.setVisible(true);
        
        
        
    }
    
}
