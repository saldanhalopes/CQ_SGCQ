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
import prati_sgcq.connection.ConnectionFactory;
import prati_sgcq.model.RegraAcesso;
import prati_sgcq.model.Setor;

/**
 *
 * @author rafael
 */
public class AcessoDAO extends GenenicoDAO<Setor> {

    private List<RegraAcesso> getListAcesso(Integer grupo_id) {
        EntityManager em = ConnectionFactory.em(true);
        try {
            return (ArrayList<RegraAcesso>) em.createQuery("SELECT g FROM RegraAcesso g "
                    + "WHERE g.grupo.id LIKE :grupo_id")
                    .setParameter("grupo_id", grupo_id)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public String stringAcesso(Integer grupo_id) {
        StringBuilder sb = new StringBuilder();
        try {
            System.out.println(getListAcesso(grupo_id));
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
