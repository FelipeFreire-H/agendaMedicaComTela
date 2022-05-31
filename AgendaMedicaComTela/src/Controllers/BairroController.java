
package Controllers;

import Entidades.Estado;
import Persistencia.EstadoDAO;
import java.util.List;
import lombok.Getter;

public class BairroController {
    
    private EstadoDAO daoEstado;
    @Getter
    private List<Estado> listaDeEstados;
    
    
    public BairroController(){
        
        setup();
    }
    
     public void setup() {

        daoEstado = new EstadoDAO();
        listaDeEstados = daoEstado.listarTodos();
        
    }
    
}
