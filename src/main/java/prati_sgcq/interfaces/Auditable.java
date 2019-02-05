/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prati_sgcq.interfaces;

import prati_sgcq.audit.Audit;

/**
 *
 * @author rafael.lopes
 */
public interface Auditable {

    public Audit getAudit();

    public void setAudit(Audit audit);
}
