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
@Table(name = "tb_grupo")
@NamedQueries({
    @NamedQuery(name = "Groups.findAll", query = "SELECT g FROM Grupo g"),
    @NamedQuery(name = "Groups.findId", query = "SELECT g FROM Grupo g WHERE g.id = :id"),
    @NamedQuery(name = "Groups.findByGrupoNome", query = "SELECT g FROM Grupo g WHERE g.grupoNome = :grupoNome"),
    @NamedQuery(name = "Groups.findByGrupoTipo", query = "SELECT g FROM Grupo g WHERE g.grupoTipo = :grupoTipo")})
@DynamicInsert(true)
@DynamicUpdate(true)
@Audited(withModifiedFlag = true)
@AuditTable(value = "tb_grupo_auditoria")
@EntityListeners(AuditListener.class)
public class Grupo implements EntidadeBase, Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "grupo_nome", nullable = false, length = 250)
    private String grupoNome;
    
    @Column(name = "grupo_tipo", nullable = false, length = 250)
    private String grupoTipo;

    public Grupo() {
    }

    public Grupo(Integer id) {
        this.id = id;
    }

    public Grupo(String grupoNome, String grupoTipo) {
        this.grupoNome = grupoNome;
        this.grupoTipo = grupoTipo;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGrupoNome() {
        return grupoNome;
    }

    public void setGrupoNome(String grupoNome) {
        this.grupoNome = grupoNome;
    }

    public String getGrupoTipo() {
        return grupoTipo;
    }

    public void setGrupoTipo(String grupoTipo) {
        this.grupoTipo = grupoTipo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Grupo other = (Grupo) obj;
        return Objects.equals(this.id, other.id);
    }
   
}
