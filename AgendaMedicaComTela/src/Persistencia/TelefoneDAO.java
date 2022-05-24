package Persistencia;

import Entidades.Telefone;
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
public class TelefoneDAO
        extends ConexaoComOBancoDeDados
        implements InterfaceDAO<Integer, Telefone> {

    private TipoTelefoneDAO daoTipoTelefone
            = new TipoTelefoneDAO();

    @Override
    public void salvar(Telefone telefone) {

        String sql = "INSERT INTO TELEFONE "
                + "(DDD,NUMERO,TIPO_TELEFONE) VALUES "
                + "(?,?,?);";

        conectar();

        try {

            PreparedStatement pstm
                    = conexao.prepareStatement(sql);

            pstm.setInt(1, telefone.getDdd());
            pstm.setString(2, telefone.getNumero());
            pstm.setInt(3, telefone.
                    getTipoTelefone().getIdentificador());

            pstm.execute();
            conexao.commit();
            desconectar();

        } catch (SQLException ex) {

            System.out.println(ex);
        }

    }

    @Override
    public void modificar(Telefone telefone) {

        String sql = "UPDATE TELEFONE SET "
                + "DDD = ?, "
                + "NUMERO = ?, "
                + "TIPO_TELEFONE = ? "
                + "WHERE IDENTIFICADOR = ?;";

        conectar();
        try {

            PreparedStatement pstm
                    = conexao.prepareStatement(sql);
            pstm.setInt(1, telefone.getDdd());
            pstm.setString(2, telefone.getNumero());
            pstm.setInt(3, telefone.
                    getTipoTelefone().getIdentificador());
            pstm.setInt(4, telefone.getIdentificador());
            pstm.execute();
            conexao.commit();
            desconectar();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public void deletar(Telefone telefone) {

        String sql = "DELETE FROM TELEFONE "
                + "WHERE IDENTIFICADOR = ?;";

        try {
            conectar();

            PreparedStatement pstm
                    = conexao.prepareStatement(sql);
            pstm.setInt(1, telefone.getIdentificador());
            pstm.execute();
            conexao.commit();
            desconectar();

        } catch (SQLException ex) {

            System.out.println(ex);
        }

    }

    @Override
    public Telefone buscarPorId(Integer id) {

        Telefone telefone = new Telefone();

        String sql = "SELECT * FROM TELEFONE "
                + "WHERE IDENTIFICADOR = ?";

        conectar();
        try {

            PreparedStatement pstm
                    = conexao.prepareStatement(sql);

            pstm.setInt(1, id);

            ResultSet lista = pstm.executeQuery();

            while (lista.next()) {

                telefone.setIdentificador(lista.
                        getInt("IDENTIFICADOR"));

                telefone.setDdd(lista.getInt("DDD"));
                telefone.setNumero(lista.getString("NUMERO"));
                telefone.setTipoTelefone(daoTipoTelefone.buscarPorId(
                        lista.getInt("TIPO_TELEFONE")));

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return telefone;

    }

    @Override
    public List<Telefone> listarTodos() {

        List<Telefone> listaDeTelefone
                = new ArrayList<Telefone>();

        String sql = "SELECT * FROM TELEFONE;";

        try {
            conectar();

            PreparedStatement pstm
                    = conexao.prepareStatement(sql);
            ResultSet lista = pstm.executeQuery();

            while (lista.next()) {

                Telefone telefone = new Telefone();

                telefone.setIdentificador(lista.
                        getInt("IDENTIFICADOR"));

                telefone.setDdd(lista.getInt("DDD"));
                telefone.setNumero(lista.getString("NUMERO"));
                telefone.setTipoTelefone(daoTipoTelefone.buscarPorId(
                        lista.getInt("TIPO_TELEFONE")));
                listaDeTelefone.add(telefone);

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return listaDeTelefone;

    }

}
