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
package prati_sgcq.model;

import prati_sgcq.interfaces.EntidadeBase;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import prati_sgcq.audit.AuditListener;

/**
 *
 * @author rafael
 */
@Entity
@Table(name = "tb_setor")
@NamedQueries({
    @NamedQuery(name = "Setor.findAll", query = "SELECT s FROM Setor s"),
    @NamedQuery(name = "Setor.findBySetorId", query = "SELECT s FROM Setor s WHERE s.id = :id"),
    @NamedQuery(name = "Setor.findBySetor", query = "SELECT s FROM Setor s WHERE s.setor = :setor"),
    @NamedQuery(name = "Setor.findBySiglaSetor", query = "SELECT s FROM Setor s WHERE s.siglaSetor = :siglaSetor"),
    @NamedQuery(name = "Setor.findByDescricaoSetor", query = "SELECT s FROM Setor s WHERE s.descricaoSetor = :descricaoSetor")})
@DynamicInsert(true)
@DynamicUpdate(true)
@Audited(withModifiedFlag = true)
@AuditTable(value = "tb_setor_auditoria")
@EntityListeners(AuditListener.class)
public class Setor implements EntidadeBase, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "setor", nullable = false, length = 250)
    private String setor;

    @Column(name = "sigla_setor", nullable = false, length = 250)
    private String siglaSetor;

    @Column(name = "descricao_setor", nullable = true, length = 250)
    private String descricaoSetor;

    public Setor() {
    }
    
    public Setor(String setor, String siglaSetor, String descricaoSetor) {
        this.setor = setor;
        this.siglaSetor = siglaSetor;
        this.descricaoSetor = descricaoSetor;
    }

    public Setor(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getSiglaSetor() {
        return siglaSetor;
    }

    public void setSiglaSetor(String siglaSetor) {
        this.siglaSetor = siglaSetor;
    }

    public String getDescricaoSetor() {
        return descricaoSetor;
    }

    public void setDescricaoSetor(String descricaoSetor) {
        this.descricaoSetor = descricaoSetor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Setor other = (Setor) obj;
        return Objects.equals(this.id, other.id);
    }


}
