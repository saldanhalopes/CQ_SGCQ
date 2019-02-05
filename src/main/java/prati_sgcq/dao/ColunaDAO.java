package prati_sgcq.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import prati_sgcq.model.Coluna;
import prati_sgcq.connection.ConnectionFactory;
//import prati_sgcq.model.Coluna_;
import prati_sgcq.model.Setor;
//import prati_sgcq.model.Setor_;

/**
 *
 * @author rafael
 */
public class ColunaDAO extends GenenicoDAO<Coluna> {

    public List<Coluna> readColuna(String setor, int status) {
//        EntityManager em = ConnectionFactory.em(true);
//        try {
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<Coluna> criteria = cb.createQuery(Coluna.class);
//            Root<Coluna> rootColuna = criteria.from(Coluna.class);
//            Join<Coluna, Setor> joinSetor = rootColuna.join(Coluna_.setor);
//            // Join<Team, League> league = team.join(Team_.league);
//
//            criteria.where(cb.or(
//                    status == 1 ? rootColuna.get(Coluna_.dataDescarteColuna).isNull()
//                            : (status == 2 ? rootColuna.get(Coluna_.dataDescarteColuna).isNotNull()
//                                    : rootColuna.get(Coluna_.dataPerformance).isNull()),
//                    cb.equal(joinSetor.get(Setor_.siglaSetor), "LIKE CONCAT('%'" + setor + "'%')")
//            ));
//            //cq.select(player).distinct(true);
//            criteria.select(rootColuna);
//            TypedQuery<Coluna> myQuery = em.createQuery(criteria);
//            return myQuery.getResultList();
//
//            //return (ArrayList<Coluna>) myQuery.getResultList();
//        } finally {
//            em.close();
//        }
        return null;
    }

//    public void salvarColuna(Coluna col) throws Exception {
//        EntityManager em = ConnectionFactory.em(true);
//        try {
//            em.getTransaction().begin();
//            if (em.find(Coluna.class, col.getId()) == null) {
//                throw new Exception("Erro ao Atualizar!");
//            }
//            em.createQuery("UPDATE Coluna col SET col.analise.id,    "
//                    + "col.analiseFinalidade = :analiseFinalidade, "
//                    + "col.codColuna = :verificacao, "
//                    + "col.codigoSapColuna = :codigoSapColuna, "
//                    + "col.dataAtivacaoColuna = :dataAtivacaoColuna, "
//                    + "col.dataDescarteColuna = :dataDescarteColuna, "
//                    + "col.dataPerformance = :dataPerformance, "
//                    + "col.dataVerificacao = :dataVerificacao, "
//                    + "col.diametroColuna = :diametroColuna, "
//                    + "col.fabricanteColuna = :fabricanteColuna, "
//                    + "col.faseColuna = :faseColuna, "
//                    + "col.marcaColuna = :marcaColuna, "
//                    + "col.metodoVersao = :metodoVersao, "
//                    + "col.metodologia = :metodologia, "
//                    + "col.obsColuna = :obsColuna, "
//                    + "col.obsVerificacao = :obsVerificacao, "
//                    + "col.setor.id = :setor_id, "
//                    + "col.tamanhoColuna = :tamanhoColuna, "
//                    + "col.tipoColuna = :tipoColuna, "
//                    + "col.userNameAtivacao = :userNameAtivacao, "
//                    + "col.userNameDescarte = :userNameDescarte, "
//                    + "col.userNamePerformance = :userNamePerformance, "
//                    + "col.userVerificacao = :userVerificacao, "
//                    + "col.vagaColuna = :vagaColuna, "
//                    + "col.metodologia.id = :metodologia_id"
//                    + "WHERE col.id = :id")
//                    .setParameter("id", col.getId())
//                    .setParameter("setor_id", col.getSetor().getId())
//                    .setParameter("metodologia_id", col.getMetodologia().getId())
//                    .setParameter("", col.getAnalise().getId())
//                    .setParameter("", col.getCodigoSapColuna())
//                    .setParameter("", col.getTipoColuna())
//                    .setParameter("", col.getFabricanteColuna())
//                    .setParameter("", col.getMarcaColuna())
//                    .setParameter("", col.getFaseColuna())
//                    .setParameter("", col.getTamanhoColuna())
//                    .setParameter("", col.getDiametroColuna())
//                    .setParameter("", col)
//                    .setParameter("", col)
//                    .setParameter("", col)
//                    .setParameter("", col)
//                    .setParameter("", col)
//                    .setParameter("", col)
//                    .setParameter("", col)
//                    .setParameter("", col)
//                    .setParameter("", col)
//                    .setParameter("", col)
//                    .setParameter("", col)
//                    .setParameter("", col)
//                    .setParameter("", col)
//                    .setParameter("", col)
//                    .setParameter("", col)
//                    .setParameter("", col)
//                    .setParameter("", col)
//                    .setParameter("", col)
//                    
//                    .executeUpdate();
//            em.getTransaction().commit();
//        } catch (Exception ex) {
//            em.getTransaction().rollback();
//            throw new Exception(ex);
//        } finally {
//            em.close();
//        }
//    }
//    
//    
//    public void updateColuna(Coluna col) {
//        Connection conn = ConnectionFactory.getConnection();
//        PreparedStatement stmt = null;
//        try {
//            stmt = conn.prepareStatement("UPDATE tb_coluna SET "
//                    + "codigo_sap_coluna = ?, setor_id = ?, metodo_id = ?, analise_id = ?, "
//                    + "tipo_coluna = ?, fabricante_coluna = ?, marca_coluna = ?, fase_coluna = ?, "
//                    + "tamanho_coluna = ?, diametro_coluna = ?, particula_coluna = ?, part_number_coluna = ?, "
//                    + "serial_number_coluna = ?, vaga_coluna_id = ?, obs_coluna = ?, analise_finalidade_id = ?, "
//                    + "data_performance = ?, user_name_performance = ?, metodo_versao = ?, "
//                    + "data_verificacao = ?, user_verificacao = ?, obs_verificacao = ? "
//                    + "WHERE coluna_id = ?");
//            stmt.setString(1, col.getCodigo_sap_coluna());
//            stmt.setInt(2, col.getSetor().getSetor_id());
//            stmt.setInt(3, col.getMetodologia().getMetodo_id());
//            stmt.setInt(4, col.getAnalise().getAnalise_id());
//            stmt.setString(5, col.getTipo_coluna());
//            stmt.setString(6, col.getFabricanteColuna());
//            stmt.setString(7, col.getMarcaColuna());
//            stmt.setString(8, col.getFaseColuna());
//            stmt.setString(9, col.getTamanhoColuna());
//            stmt.setString(10, col.getDiametroColuna());
//            stmt.setString(11, col.getParticula_coluna());
//            stmt.setString(12, col.getPart_number_coluna());
//            stmt.setString(13, col.getSerial_number_coluna());
//            stmt.setInt(14, col.getVaga_coluna());
//            stmt.setString(15, col.getObs_coluna());
//            stmt.setInt(16, col.getAnalise().getAnalise_finalidade_id());
//            stmt.setTimestamp(17, col.getData_performance());
//            stmt.setString(18, col.getUser_performance().getUser());
//            stmt.setInt(19, col.getMetodologia().getVersao());
//            stmt.setTimestamp(20, col.getData_verificacao());
//            stmt.setString(21, col.getUser_verificacao().getUser());
//            stmt.setString(22, col.getObs_verificacao());
//            stmt.setInt(23, col.getColuna_id());
//            stmt.executeUpdate();
//        } catch (SQLException ex) {
//            LogDAO logDAO = new LogDAO();
//            logDAO.logSQLException(ex, "updateColuna");
//        } finally {
//            ConnectionFactory.closeConection(conn, stmt);
//        }
//    }
//
//    public void updateDescarteColuna(Coluna col) {
//        Connection conn = ConnectionFactory.getConnection();
//        PreparedStatement stmt = null;
//        try {
//            stmt = conn.prepareStatement("UPDATE tb_coluna SET user_name_descarte = ?, "
//                    + "data_descarte_coluna = ?, vaga_coluna_id = ? "
//                    + "WHERE coluna_id = ?");
//            stmt.setString(1, col.getUser_descarte().getUser());
//            stmt.setTimestamp(2, col.getData_descarte_coluna());
//            stmt.setInt(3, col.getVaga_coluna());
//            stmt.setInt(4, col.getColuna_id());
//            stmt.executeUpdate();
//
//        } catch (SQLException ex) {
//            LogDAO logDAO = new LogDAO();
//            logDAO.logSQLException(ex, "updateDescarteColuna");
//        } finally {
//            ConnectionFactory.closeConection(conn, stmt);
//        }
//    }
//
//    public void updateRealocarColuna(Coluna col) {
//        Connection conn = ConnectionFactory.getConnection();
//        PreparedStatement stmt = null;
//        try {
//            stmt = conn.prepareStatement("UPDATE tb_coluna SET user_name_descarte = NULL, "
//                    + "data_descarte_coluna = NULL, vaga_coluna_id = ? "
//                    + "WHERE coluna_id = ?");
//            stmt.setInt(1, col.getVaga_coluna());
//            stmt.setInt(2, col.getColuna_id());
//            stmt.executeUpdate();
//
//        } catch (SQLException ex) {
//            LogDAO logDAO = new LogDAO();
//            logDAO.logSQLException(ex, "updateRealocarColuna");
//        } finally {
//            ConnectionFactory.closeConection(conn, stmt);
//        }
//    }
//
//    public void selectColuna(Coluna col) {
//        Connection conn = ConnectionFactory.getConnection();
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        try {
//            stmt = conn.prepareStatement("SELECT tb_coluna.*, "
//                    + "tb_metodologia.cod_metodo, tb_analise.analise, "
//                    + "tb_setor.sigla_setor, tb_analise_finalidade.analise_finalidade "
//                    + "FROM tb_coluna "
//                    + "LEFT JOIN tb_metodologia "
//                    + "ON tb_coluna.metodo_id = tb_metodologia.metodo_id "
//                    + "LEFT JOIN tb_analise "
//                    + "ON tb_coluna.analise_id = tb_analise.analise_id "
//                    + "LEFT JOIN tb_analise_finalidade "
//                    + "ON tb_coluna.analise_finalidade_id = tb_analise_finalidade.analise_finalidade_id "
//                    + "LEFT JOIN tb_setor "
//                    + "ON tb_coluna.setor_id = tb_setor.setor_id  "
//                    + "WHERE coluna_id = ?");
//            stmt.setInt(1, col.getColuna_id());
//            rs = stmt.executeQuery();
//            while (rs.next()) {
//                Analise anls = new Analise();
//                Setor setor = new Setor();
//                Metodologia mtd = new Metodologia();
//                Usuario userAtivacao = new Usuario();
//                Usuario userPerformance = new Usuario();
//                Usuario userDescarte = new Usuario();
//                Usuario userVerificacao = new Usuario();
//                col.setColuna_id(rs.getInt("coluna_id"));
//                col.setCodigo_coluna(rs.getInt("cod_coluna"));
//                col.setCodigo_sap_coluna(rs.getString("codigo_sap_coluna"));
//                setor.setSetor_id(rs.getInt("setor_id"));
//                setor.setSigla_setor(rs.getString("sigla_setor"));
//                col.setSetor(setor);
//                mtd.setMetodo_id(rs.getInt("metodo_id"));
//                mtd.setVersao(rs.getInt("metodo_versao"));
//                mtd.setCod_metodo(rs.getInt("metodo_id") == 0 ? "MULTIPROPÓSITO" : rs.getString("cod_metodo"));
//                col.setMetodologia(mtd);
//                anls.setAnalise_id(rs.getInt("analise_id"));
//                anls.setAnalise(rs.getInt("analise_id") == 0 ? "MULTIPROPÓSITO" : rs.getString("analise"));
//                anls.setAnalise_finalidade_id(rs.getInt("analise_finalidade_id"));
//                anls.setAnalise_finalidade(rs.getInt("analise_finalidade_id") == 0 ? "MULTIPROPÓSITO" : rs.getString("analise_finalidade"));
//                col.setAnalise(anls);
//                col.setTipo_coluna(rs.getString("tipo_coluna"));
//                col.setFabricante_coluna(rs.getString("fabricante_coluna"));
//                col.setMarca_coluna(rs.getString("marca_coluna"));
//                col.setFase_coluna(rs.getString("fase_coluna"));
//                col.setTamanho_coluna(rs.getString("tamanho_coluna"));
//                col.setDiametro_coluna(rs.getString("diametro_coluna"));
//                col.setParticula_coluna(rs.getString("particula_coluna"));
//                col.setPart_number_coluna(rs.getString("part_number_coluna"));
//                col.setSerial_number_coluna(rs.getString("serial_number_coluna"));
//                col.setData_ativacao_coluna(rs.getTimestamp("data_ativacao_coluna"));
//                col.setData_descarte_coluna(rs.getTimestamp("data_descarte_coluna"));
//                col.setData_performance(rs.getTimestamp("data_performance"));
//                userAtivacao.setUser(rs.getString("user_name_ativacao"));
//                col.setUser_ativacao(userAtivacao);
//                userDescarte.setUser(rs.getString("user_name_descarte"));
//                col.setUser_descarte(userDescarte);
//                userPerformance.setUser(rs.getString("user_name_performance"));
//                col.setUser_performance(userPerformance);
//                col.setVaga_coluna(rs.getInt("vaga_coluna_id"));
//                col.setObs_coluna(rs.getString("obs_coluna"));
//                col.setData_verificacao(rs.getTimestamp("data_verificacao"));
//                userVerificacao.setUser(rs.getString("user_verificacao"));
//                col.setUser_verificacao(userVerificacao);
//                col.setObs_verificacao(rs.getString("obs_verificacao"));
//            }
//        } catch (SQLException ex) {
//            LogDAO logDAO = new LogDAO();
//            logDAO.logSQLException(ex, "selectColuna");
//        } finally {
//            ConnectionFactory.closeConection(conn, stmt, rs);
//        }
//    }
//
//    public void selectUltimaColuna(Coluna col) {
//        Connection conn = ConnectionFactory.getConnection();
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        try {
//            stmt = conn.prepareStatement("SELECT TOP(1) tb_coluna.cod_coluna "
//                    + "FROM tb_coluna WHERE tb_coluna.tipo_coluna = ? "
//                    + "ORDER BY tb_coluna.cod_coluna DESC ");
//            stmt.setString(1, col.getTipo_coluna());
//            rs = stmt.executeQuery();
//            if (rs.next()) {
//                col.setCodigo_coluna(rs.getInt("cod_coluna") + 1);
//            } else {
//                col.setCodigo_coluna(1);
//            }
//        } catch (SQLException ex) {
//            LogDAO logDAO = new LogDAO();
//            logDAO.logSQLException(ex, "selectUltimaColuna");
//        } finally {
//            ConnectionFactory.closeConection(conn, stmt, rs);
//        }
//    }
//
//    public void deleteColuna(Coluna col) {
//        Connection conn = ConnectionFactory.getConnection();
//        PreparedStatement stmt = null;
//        try {
//            stmt = conn.prepareStatement("DELETE FROM tb_coluna WHERE coluna_id = ?");
//            stmt.setInt(1, col.getColuna_id());
//            stmt.executeUpdate();
//        } catch (SQLException ex) {
//            LogDAO logDAO = new LogDAO();
//            logDAO.logSQLException(ex, "deleteColuna");
//        } finally {
//            ConnectionFactory.closeConection(conn, stmt);
//        }
//    }
}
