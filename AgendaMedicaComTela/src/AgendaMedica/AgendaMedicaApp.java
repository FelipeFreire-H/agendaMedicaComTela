
package AgendaMedica;

import Persistencia.BuildDeTabelas;

public class AgendaMedicaApp {
    
    public static void main(String[] args) {
        
        BuildDeTabelas build = new BuildDeTabelas();
        
        build.construirTabelas();
        build.inserirDadosIniciais();
        
        
        
    }
    
}
