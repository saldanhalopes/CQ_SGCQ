/*
 * Copyright (C) 2018 rafael.lopes
 *
 * Este programa Ã© um software livre: vocÃª pode redistribuÃ­-lo e / ou modificar
 * sob os termos da GNU General Public License, conforme publicado pela
 * a Free Software Foundation, seja a versÃ£o 3 da LicenÃ§a, quanto
 * qualquer versÃ£o posterior.
 *
 * Este programa Ã© distribuÃ­do na esperanÃ§a de que seja Ãºtil,
 * mas SEM QUALQUER GARANTIA; sem a garantia implÃ­cita de
 * COMERCIALIZAÃ‡ÃƒO OU APTIDÃƒO PARA UM PROPÃ“SITO PARTICULAR. Veja o
 * GNU General Public License para obter mais detalhes.
 *
 * VocÃª deve ter recebido uma cÃ³pia da GNU General Public License
 *  juntamente com este programa. Caso contrÃ¡rio, veja <http://www.gnu.org/licenses/>.
 */
package prati_sgcq.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TransactionRequiredException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import prati_sgcq.connection.ConnectionFactory;
import prati_sgcq.model.Padroes;
import prati_sgcq.model.PadroesConfig;


/**
 *
 * @author rafael
 */
public class PadroesConfigDAO extends GenenicoDAO<PadroesConfig> {

    public List<PadroesConfig> readHistoricoByID(Integer id) {
        EntityManager em = ConnectionFactory.em(true);
        try {
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<PadroesConfig> criteria = builder.createQuery(PadroesConfig.class);
            Root<PadroesConfig> from = criteria.from(PadroesConfig.class);
            criteria.select(from);
            criteria.where(builder.equal(from.get("id"), id));
            TypedQuery<PadroesConfig> myQuery = em.createQuery(criteria);
            return myQuery.getResultList();
        } finally {
            em.close();
        }
    }
    
//    public void atualizarPadroesConfig(PadroesConfig padrConfig) throws TransactionRequiredException {
//        EntityManager em = ConnectionFactory.em(true);
//        try {
//            em.getTransaction().begin();
//            if (em.find(PadroesConfig.class, padrConfig.getId()) == null) {
//                throw new TransactionRequiredException("Erro ao Atualizar!");
//            }
//            String update = "UPDATE PadroesConfig p SET p.codigoSap = :sap WHERE p.id = :id";
//            em.createQuery(update)
//                    .setParameter("sap", padrConfig.getCodigoSap())
//                    .setParameter("id", padrConfig.getId())
//                    .executeUpdate();
//            em.getTransaction().commit();
//        } catch (TransactionRequiredException ex) {
//            em.getTransaction().rollback();
//            throw new TransactionRequiredException("Erro ao Atualizar!");
//        } finally {
//            em.close();
//        }
//    }

}
