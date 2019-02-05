/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prati_sgcq.audit;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author rafael.lopes
 */
@Entity
@Table(name = "tb_audit_entity_type")
public class AuditEntityType implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private AuditRevision revision;

    @Column(name = "entity_class_name")
    private String entityClassName;

    @Column(name = "modified_type")
    private Integer modifiedType;
    
    @Column(name = "id_entity")
    private Integer idEntity;

    public AuditEntityType() {
    }

    public AuditEntityType(AuditRevision revision, String entityClassName, 
            Integer modifiedType, Integer idEntity) {
        this.revision = revision;
        this.entityClassName = entityClassName;
        this.modifiedType = modifiedType;
        this.idEntity = idEntity;
    }

    public Integer getModifiedType() {
        return modifiedType;
    }

    public void setModifiedType(Integer modifiedType) {
        this.modifiedType = modifiedType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AuditRevision getRevision() {
        return revision;
    }

    public void setRevision(AuditRevision revision) {
        this.revision = revision;
    }

    public String getEntityClassName() {
        return entityClassName;
    }

    public void setEntityClassName(String entityClassName) {
        this.entityClassName = entityClassName;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    public Integer getIdEntity() {
        return idEntity;
    }

    public void setIdEntity(Integer idEntity) {
        this.idEntity = idEntity;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AuditEntityType other = (AuditEntityType) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
    
}
