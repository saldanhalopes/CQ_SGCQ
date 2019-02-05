package prati_sgcq.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import prati_sgcq.interfaces.EntidadeBase;

/**
 *
 * @author rafael.lopes
 */
@Entity
@Table(name = "tb_coluna_config")
public class ColunaConfig implements EntidadeBase, Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tipo_coluna_config")
    private String tipoColunaConfig;
    
    @Column(name = "coluna_config")
    private String colunaConfig;
    
    @Column(name = "descricao_coluna_config")
    private String descricaoColunaConfig;

    public ColunaConfig() {
    }

    public ColunaConfig(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoColunaConfig() {
        return tipoColunaConfig;
    }

    public void setTipoColunaConfig(String tipoColunaConfig) {
        this.tipoColunaConfig = tipoColunaConfig;
    }

    public String getColunaConfig() {
        return colunaConfig;
    }

    public void setColunaConfig(String colunaConfig) {
        this.colunaConfig = colunaConfig;
    }

    public String getDescricaoColunaConfig() {
        return descricaoColunaConfig;
    }

    public void setDescricaoColunaConfig(String descricaoColunaConfig) {
        this.descricaoColunaConfig = descricaoColunaConfig;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
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
        final ColunaConfig other = (ColunaConfig) obj;
        return Objects.equals(this.id, other.id);
    }

    
    
}
