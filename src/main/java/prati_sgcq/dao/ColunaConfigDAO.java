package prati_sgcq.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import prati_sgcq.model.ColunaConfig;
import prati_sgcq.connection.ConnectionFactory;


/**
 *
 * @author rafael
 */
public class ColunaConfigDAO extends GenenicoDAO<ColunaConfig> {

    public List<ColunaConfig> readColunaConfig(String value) {
        EntityManager em = ConnectionFactory.em(true);
        try {
            Query myQuery = em.createQuery("SELECT colconfig FROM ColunaConfig colconfig WHERE  "
                    + "colconfig.tipoColunaConfig LIKE :tipo "
                    + "ORDER BY colconfig.colunaConfig DESC")
                    .setParameter("tipo", value);
            return (ArrayList<ColunaConfig>) myQuery.getResultList();
        } finally {
            em.close();
        }
    }

}
