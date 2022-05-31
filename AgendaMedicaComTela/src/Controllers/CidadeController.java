
package Controllers;
import Persistencia.EstadoDAO;
import Entidades.Estado;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

public class CidadeController {
 
    
    private EstadoDAO daoEstado;
    @Getter
    private List<Estado> listaDeEstados;
    
    
    public CidadeController(){
        
        setup();
    }
    
     public void setup() {

        daoEstado = new EstadoDAO();
        listaDeEstados = daoEstado.listarTodos();
        
    }

    
    
}
