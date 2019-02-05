package prati_sgcq.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import prati_sgcq.interfaces.EntidadeBase;

/**
 *
 * @author rafael.lopes
 */
@Entity
@Table(name = "tb_analise")
public class Analise implements EntidadeBase, Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "analise")
    private String analise;
    
    @Column(name = "sigla_analise")
    private String siglaAnalise;
    
    @Column(name = "descricao_analise")
    private String descricaoAnalise;

    public Analise() {
    }

    public Analise(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnalise() {
        return analise;
    }

    public void setAnalise(String analise) {
        this.analise = analise;
    }

    public String getSiglaAnalise() {
        return siglaAnalise;
    }

    public void setSiglaAnalise(String siglaAnalise) {
        this.siglaAnalise = siglaAnalise;
    }

    public String getDescricaoAnalise() {
        return descricaoAnalise;
    }

    public void setDescricaoAnalise(String descricaoAnalise) {
        this.descricaoAnalise = descricaoAnalise;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Analise other = (Analise) obj;
        return Objects.equals(this.id, other.id);
    }
    
}
