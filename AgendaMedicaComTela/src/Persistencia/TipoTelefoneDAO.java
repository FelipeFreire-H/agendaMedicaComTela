package Persistencia;

import Entidades.TipoTelefone;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ioliveira
 */
public class TipoTelefoneDAO
        extends ConexaoComOBancoDeDados implements
        InterfaceDAO<Integer, TipoTelefone> {

    @Override
    public void salvar(TipoTelefone tipoTelefone) {

        String sql = "INSERT INTO ( "
                + "DECRICAO ) VALUES "
                + "(?);";

        try {
            conectar();
            PreparedStatement pstm
                    = conexao.prepareStatement(sql);
            pstm.setString(1, tipoTelefone.getDescricao());
            pstm.execute();
            conexao.commit();
            desconectar();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public void modificar(TipoTelefone tipoTelefone) {

        String sql = "UPDATE TIPO_TELEFONE SET "
                + "DESCRICAO = ? WHERE "
                + "IDENTIFICADOR = ?;";

        try {
            conectar();

            PreparedStatement pstm
                    = conexao.prepareStatement(sql);
            pstm.setString(1, tipoTelefone.getDescricao());
            pstm.setInt(2, tipoTelefone.getIdentificador());
            pstm.execute();
            conexao.commit();
            desconectar();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public void deletar(TipoTelefone tipoTelefone) {

        String sql = "DELETE FROM TIPO_TELEFONE "
                + "WHERE IDENTIFICADOR = ?;";

        try {
            conectar();
            PreparedStatement pstm
                    = conexao.prepareStatement(sql);
            pstm.setInt(1, tipoTelefone.getIdentificador());
            pstm.execute();
            conexao.commit();
            desconectar();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public TipoTelefone buscarPorId(Integer id) {

        TipoTelefone tipoTelefone = new TipoTelefone();

        String sql = "SELECT * FROM TIPO_TELEFONE "
                + "WHERE IDENTIFICADOR = ?;";

        try {
            conectar();
            PreparedStatement pstm
                    = conexao.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet lista = pstm.executeQuery();

            while (lista.next()) {
                tipoTelefone.setIdentificador(lista.getInt("IDENTIFICADOR"));
                tipoTelefone.setDescricao(lista.getString("DESCRICAO"));
            }

            desconectar();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return tipoTelefone;

    }

    @Override
    public List<TipoTelefone> listarTodos() {

        List<TipoTelefone> listaDeTipoTelefone
                = new ArrayList<TipoTelefone>();

        String sql = "SELECT * FROM TIPO_TELEFONE;";
        conectar();
        try {

            PreparedStatement pstm
                    = conexao.prepareStatement(sql);

            ResultSet lista = pstm.executeQuery();

            while (lista.next()) {

    TipoTelefone tipoTelefone = new TipoTelefone();
    tipoTelefone.setIdentificador(lista.getInt("IDENTIFICADOR"));
    tipoTelefone.setDescricao(lista.getString("DESCRICAO"));
    listaDeTipoTelefone.add(tipoTelefone);
            }
        desconectar();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return listaDeTipoTelefone;
    }

}
