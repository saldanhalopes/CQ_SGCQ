/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prati_sgcq.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import prati_sgcq.connection.ConnectionFactory;
import prati_sgcq.model.Sistema;

/**
 *
 * @author rafael.lopes
 */
public class SistemaDAO extends GenenicoDAO<Sistema> {

    public static boolean isBancoDadosConectado() {
        EntityManager em = ConnectionFactory.em(true);
        boolean isConnected = false;
        try {
            String sql = "SELECT count(*) as db from pg_database where datname like 'db_sgcq'";
            Query query = em.createNativeQuery(sql);
            isConnected = query.getSingleResult().equals(1);
        } finally {
            em.close();
        }
        return isConnected;
    }
   
}
