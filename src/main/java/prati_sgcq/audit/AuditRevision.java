/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prati_sgcq.audit;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;
import prati_sgcq.model.Usuario;

/**
 *
 * @author rafael.lopes
 */
@Entity(name = "tb_audit_revinfo")
@RevisionEntity(AuditListener.class)
public class AuditRevision extends DefaultRevisionEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private int id;

    @Column(name = "ultima_modificacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaModificacao;

    @ManyToOne()
    @JoinColumn(name = "ultima_modificacao_por", referencedColumnName = "id")
    private Usuario ultimaModificacaoPor;

    @Column(name = "computador")
    private String computador;

    @Column(name = "user_computador")
    private String userComputador;

    @OneToMany(mappedBy = "revision", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<AuditEntityType> auditEntityType = new HashSet<>();

    
    public AuditRevision() {
    }

    public Date getUltimaModificacao() {
        return ultimaModificacao;
    }

    public void setUltimaModificacao(Date ultimaModificacao) {
        this.ultimaModificacao = ultimaModificacao;
    }

    public Usuario getUltimaModificacaoPor() {
        return ultimaModificacaoPor;
    }

    public void setUltimaModificacaoPor(Usuario ultimaModificacaoPor) {
        this.ultimaModificacaoPor = ultimaModificacaoPor;
    }

    public String getComputador() {
        return computador;
    }

    public void setComputador(String computador) {
        this.computador = computador;
    }

    public String getUserComputador() {
        return userComputador;
    }

    public void setUserComputador(String userComputador) {
        this.userComputador = userComputador;
    }

    public Set<AuditEntityType> getModifiedEntityTypes() {
        return auditEntityType;
    }

    public void setModifiedEntityTypes(Set<AuditEntityType> auditEntityType) {
        this.auditEntityType = auditEntityType;
    }
    
    public void addModifiedEntityType(String entityClassName, Integer modifiedType, Integer idEntity) {
        auditEntityType.add(new AuditEntityType(this, entityClassName, modifiedType, idEntity));
    }
}
