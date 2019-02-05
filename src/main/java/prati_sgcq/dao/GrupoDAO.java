package prati_sgcq.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import prati_sgcq.connection.ConnectionFactory;
import prati_sgcq.model.Grupo;

/**
 *
 * @author rafael
 */
public class GrupoDAO extends GenenicoDAO<Grupo> {

    public List<Grupo> getListGrupo(String value) {
        EntityManager em = ConnectionFactory.em(true);
        try {
            Query myQuery;
            if (value == null) {
                myQuery = em.createQuery("SELECT g FROM Grupo g ORDER BY g.id DESC");
            } else {
                myQuery = em.createQuery("SELECT g FROM Grupo g WHERE  "
                        + "g.id LIKE CONCAT('%',:id, '%') OR "
                        + "g.grupoNome LIKE CONCAT('%',:grupo, '%') OR "
                        + "g.grupoTipo LIKE CONCAT('%',:tipo, '%') "
                        + "ORDER BY g.id ASC")
                        .setParameter("id", value)
                        .setParameter("grupo", value)
                        .setParameter("tipo", value);
            }
            return (ArrayList<Grupo>) myQuery.getResultList();
        } finally {
            em.close();
        }
    }
    
}
