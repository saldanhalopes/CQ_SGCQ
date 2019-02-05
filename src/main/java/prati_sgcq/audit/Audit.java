/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prati_sgcq.audit;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import prati_sgcq.model.Usuario;

/**
 *
 * @author rafael.lopes
 */

@Embeddable 
public class Audit implements Serializable {

    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @ManyToOne()
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    private Usuario createdBy;

    @Column(name = "updated_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;

    @ManyToOne()
    @JoinColumn(name = "updated_by", referencedColumnName = "id")
    private Usuario updatedBy;

    @Column(name = "computador")
    private String computador;

    @Column(name = "user_computador")
    private String userComputador;

    public Audit() {
    }
    
    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Usuario getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Usuario createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Usuario getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Usuario updatedBy) {
        this.updatedBy = updatedBy;
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

    @Override
    public String toString() {
        return "Audit{" + "createdOn=" + createdOn + ", createdBy=" + createdBy.getId() + ", updatedOn=" + updatedOn + ", updatedBy=" + updatedBy.getId() + ", computador=" + computador + ", userComputador=" + userComputador + '}';
    }
    
//    @PrePersist
//    public void setCreatedOn(Auditable auditable) {
//        String computador;
//        Usuario user = new Usuario(Integer.parseInt(System.getProperty("user_id")));
//        String userComputador = System.getProperty("user.name");
//        try {
//            computador = java.net.InetAddress.getLocalHost().getHostName();
//        } catch (UnknownHostException ex1) {
//            computador = "not found";
//        }
//        Audit audit = auditable.getAudit();
//        if (audit == null) {
//            audit = new Audit();
//            auditable.setAudit(audit);
//        }
//        audit.setCreatedOn(new Date());
//        audit.setCreatedBy(user);
//        audit.setComputador(computador);
//        audit.setUserComputador(userComputador);
//    }
//
//    @PreUpdate
//    public void setUpdatedOn(Auditable auditable) {
//        String computador;
//        Usuario user = new Usuario(Integer.parseInt(System.getProperty("user_id")));
//        String userComputador = System.getProperty("user.name");
//        try {
//            computador = java.net.InetAddress.getLocalHost().getHostName();
//        } catch (UnknownHostException ex1) {
//            computador = "not found";
//        }
//        Audit audit = auditable.getAudit();
//        audit.setUpdatedOn(new Date());
//        audit.setUpdatedBy(user);
//        audit.setComputador(computador);
//        audit.setUserComputador(userComputador);
//    }

}
