package Persistencia;

/**
 *
 * @author Ioliveira
 */
public class TestaBanco {

    public static void main(String[] args) {

        BuildDeTabelas build = new BuildDeTabelas();

        build.construirTabelas();
        build.inserirDadosIniciais();

    }

}
