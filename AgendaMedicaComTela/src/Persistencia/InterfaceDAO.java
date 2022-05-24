package Persistencia;

import java.util.List;

/**
 *
 * @author Ioliveira
 */
public interface InterfaceDAO<K, T> {

    public void salvar(T entidade);

    public void modificar(T entidade);

    public void deletar(T entidade);

    public T buscarPorId(K id);

    public List<T> listarTodos();

}
