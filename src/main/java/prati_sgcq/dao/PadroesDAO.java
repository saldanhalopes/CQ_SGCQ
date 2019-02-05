/*
 * Copyright (C) 2018 rafael.lopes
 *
 * Este programa é um software livre: você pode redistribuí-lo e / ou modificar
 * sob os termos da GNU General Public License, conforme publicado pela
 * a Free Software Foundation, seja a versão 3 da Licença, quanto
 * qualquer versão posterior.
 *
 * Este programa é distribuído na esperança de que seja útil,
 * mas SEM QUALQUER GARANTIA; sem a garantia implícita de
 * COMERCIALIZAÇÃO OU APTIDÃO PARA UM PROPÓSITO PARTICULAR. Veja o
 * GNU General Public License para obter mais detalhes.
 *
 * Você deve ter recebido uma cópia da GNU General Public License
 *  juntamente com este programa. Caso contrário, veja <http://www.gnu.org/licenses/>.
 */
package prati_sgcq.dao;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import prati_sgcq.connection.ConnectionFactory;
import prati_sgcq.model.Padroes;

/**
 *
 * @author rafael
 */
public class PadroesDAO extends GenenicoDAO<Padroes> {

    public List<Padroes> findList() {
        EntityManager em = ConnectionFactory.em(true);
        try {
            return AuditReaderFactory.get(em)
                    .createQuery()
                    .forRevisionsOfEntity(Padroes.class, true, true)
                    .add(AuditEntity.id().eq(1))
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Padroes> findListNumber(Padroes padr) {
        EntityManager em = ConnectionFactory.em(true);
        
        
        
        try {
            AuditReader auditReader = AuditReaderFactory.get(em);
            AuditQuery q = auditReader.createQuery().forRevisionsOfEntity(Padroes.class, true, true);
            q.add(AuditEntity.id().eq(padr.getId()));
            List<Padroes> audit = q.getResultList();
            
            
//            List<Number> revisionNumbers = auditReader.getRevisions(Padroes.class, padr.getId());
//            List<Padroes> auditedPadroes = new ArrayList<>();
//            for (Number rev : revisionNumbers) {
//                auditedPadroes.add(auditReader.find(Padroes.class, padr.getId(), rev));
//            }
            return audit;
        } finally {
            em.close();
        }
    }

}
