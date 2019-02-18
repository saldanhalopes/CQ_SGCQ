/*
 * Copyright (C) 2018 rafael
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package prati_sgcq.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import prati_sgcq.connection.ConnectionFactory;
import prati_sgcq.model.Acesso;
import prati_sgcq.model.Coluna;
import prati_sgcq.model.Form;
import prati_sgcq.model.Grupo;
import prati_sgcq.model.Grupo_;
import prati_sgcq.model.RegraAcesso;
import prati_sgcq.model.RegraAcesso_;

/**
 *
 * @author rafael
 */
public class RegraAcessoDAO extends GenenicoDAO<RegraAcesso> {

    public List<RegraAcesso> getListAcesso(Integer grupo_id) {
        EntityManager em = ConnectionFactory.em(true);
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<RegraAcesso> criteria = cb.createQuery(RegraAcesso.class);
            Root<RegraAcesso> rootColuna = criteria.from(RegraAcesso.class);
            Join<RegraAcesso, Grupo> joinGrupo = rootColuna.join(RegraAcesso_.grupo);
            Join<RegraAcesso, Form> joinForm = rootColuna.join(RegraAcesso_.form);
            Join<RegraAcesso, Acesso> joinAcesso = rootColuna.join(RegraAcesso_.acesso);

            criteria.where(cb.equal(joinGrupo.get(Grupo_.id), grupo_id));
            criteria.select(rootColuna);
            TypedQuery<RegraAcesso> myQuery = em.createQuery(criteria);
            //return myQuery.getResultList();

            return (ArrayList<RegraAcesso>) myQuery.getResultList();
//            return em.createQuery("SELECT g FROM RegraAcesso g "
//                    + "WHERE g.grupo.id LIKE :grupo_id")
//                    .setParameter("grupo_id", grupo_id)
//                    .getResultList();
        } finally {
            em.close();
        }
    }

    public String stringAcesso(Integer grupo_id) {
        StringBuilder sb = new StringBuilder();
        try {
            for (RegraAcesso regraAcesso : getListAcesso(grupo_id)) {
                sb.append(regraAcesso.getForm().getId());
                sb.append("-");
                sb.append(regraAcesso.getAcesso().getAcesso());
                sb.append(";");
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            if (sb.toString().isEmpty()) {
                sb.append("1-Ler;");
            }
        }
        return sb.toString();
    }

}
