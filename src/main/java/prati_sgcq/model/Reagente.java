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

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import javax.persistence.Version;
//import prati_stock.interfaces.EntidadeBase;

/**
 *
 * @author rafael.lopes
 */
//@Entity
//@Table(name = "tb_reagente_2")
public class Reagente implements Serializable {

    private static final long serialVersionUID = 1L;

//    @Id
//    @Column(name = "id", updatable = false, nullable = false)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @Column(name = "cod_reagente", nullable = false, unique = true, updatable = false)
//    private Integer codReagente;
//
//    @Column(name = "nome_reagente", length = 250)
//    private String nomeReagente;
//
//    @Column(name = "lote_reagente", length = 20)
//    private String loteReagente;
//
//    @Column(name = "validade_reagente")
//    @Temporal(TemporalType.DATE)
//    private Date validadeReagente;
//
//    @OneToOne(mappedBy = "reagente", 
//            cascade = CascadeType.ALL, 
//            orphanRemoval = true)
//    private ReagenteConfig reagenteConfig;
//
//    @Version
//    private int version;
//
//    public Reagente() {
//    }
//
//    public Reagente(Integer id) {
//        this.id = id;
//    }
//
//    @Override
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Integer getCodReagente() {
//        return codReagente;
//    }
//
//    public void setCodReagente(Integer codReagente) {
//        this.codReagente = codReagente;
//    }
//
//    public String getNomeReagente() {
//        return nomeReagente;
//    }
//
//    public void setNomeReagente(String nomeReagente) {
//        this.nomeReagente = nomeReagente;
//    }
//
//    public String getLoteReagente() {
//        return loteReagente;
//    }
//
//    public void setLoteReagente(String loteReagente) {
//        this.loteReagente = loteReagente;
//    }
//
//    public Date getValidadeReagente() {
//        return validadeReagente;
//    }
//
//    public void setValidadeReagente(Date validadeReagente) {
//        this.validadeReagente = validadeReagente;
//    }
//
//    public ReagenteConfig getReagenteConfig() {
//        return reagenteConfig;
//    }
//
//    public void setReagenteConfig(ReagenteConfig reagenteConfig) {
//        this.reagenteConfig = reagenteConfig;
//    }
//    
////    public void setReagenteConfig(ReagenteConfig reagenteConfig) {
////        if (reagenteConfig == null) {
////            if (this.reagenteConfig != null) {
////                reagenteConfig.setReagente(null);
////            }
////        } else {
////            reagenteConfig.setReagente(this);
////        }
////        this.reagenteConfig = reagenteConfig;
////    }
//
//    public int getVersion() {
//        return version;
//    }
//
//    public void setVersion(int version) {
//        this.version = version;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 5;
//        hash = 97 * hash + Objects.hashCode(this.id);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Reagente other = (Reagente) obj;
//        return Objects.equals(this.id, other.id);
//    }

}
