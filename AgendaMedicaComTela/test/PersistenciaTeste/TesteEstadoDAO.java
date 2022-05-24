package PersistenciaTeste;

import Entidades.Estado;
import Persistencia.BuildDeTabelas;
import Persistencia.EstadoDAO;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ioliveira
 */
public class TesteEstadoDAO {

    private static EstadoDAO daoEstado;
    private static Estado estado;
    private static BuildDeTabelas buildTabelas;

    @BeforeClass
    public static void setUpClass() {

        buildTabelas = new BuildDeTabelas();
        buildTabelas.construirTabelas();
        buildTabelas.inserirDadosIniciais();
        daoEstado = new EstadoDAO();
        estado = new Estado();
        estado.setDescricao("MARANHÃO");
        estado.setSigla("MA");
    }

    @Test
    public void testeDadosIniciais() {

        int numeroDeEstados
                = daoEstado.listarTodos().size();
        assertEquals(27, numeroDeEstados);

    }

    @AfterClass
    public static void tearDownClass() {
    }

}
