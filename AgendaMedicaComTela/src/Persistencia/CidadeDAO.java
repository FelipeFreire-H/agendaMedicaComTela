
package Persistencia;

import Entidades.Cidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CidadeDAO extends ConexaoComOBancoDeDados implements InterfaceDAO<Integer,Cidade>{

    @Override
    public void salvar(Cidade cidade) {
         String sql = "INSERT INTO ESTADO "
                + "(DESCRICAO, ESTADO) VALUES "
                + "(?,?);";

        try {
            conectar();
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setString(1, cidade.getDescricao());
            //pstm.setString(2, cidade.);
            pstm.execute();
            conexao.commit();
            desconectar();

        } catch (SQLException ex) {

            System.out.println(ex);

        }
    }

    @Override
    public void modificar(Cidade entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Cidade entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cidade buscarPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cidade> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
