/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prati_sgcq.audit;

import java.io.Serializable;
import java.net.UnknownHostException;
import java.util.Date;
import javax.swing.JOptionPane;
import org.hibernate.envers.EntityTrackingRevisionListener;
import org.hibernate.envers.RevisionListener;
import org.hibernate.envers.RevisionType;
import prati_sgcq.model.Usuario;

/**
 *
 * @author rafael.lopes
 */
public class AuditListener implements RevisionListener, EntityTrackingRevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {
        String computador;
        Usuario user = new Usuario(Integer.parseInt(System.getProperty("user_id")));
        String userComputador = System.getProperty("user.name");
        try {
            computador = java.net.InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException ex1) {
            computador = "not found";
        }
        AuditRevision auditRevision = (AuditRevision) revisionEntity;
        auditRevision.setUltimaModificacaoPor(user);
        auditRevision.setUltimaModificacao(new Date());
        auditRevision.setComputador(computador);
        auditRevision.setUserComputador(userComputador);
    }

    @Override
    public void entityChanged(Class entityClass, String entityName,
            Serializable entityId, RevisionType revisionType,
            Object revisionEntity) {
        String entityClassName = entityClass.getName();
        Integer modifiedType = revisionType.ordinal();
        Integer idEntity = Integer.parseInt(entityId.toString()) ;
        ((AuditRevision) revisionEntity).addModifiedEntityType(entityClassName, modifiedType, idEntity);
    }

}
