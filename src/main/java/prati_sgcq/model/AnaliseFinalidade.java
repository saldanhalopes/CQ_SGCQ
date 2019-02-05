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
@Table(name = "tb_analise_finalidade")
public class AnaliseFinalidade implements EntidadeBase, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "analise_finalidade")
    private String analiseFinalidade;

    @Column(name = "sigla_analise_finalidade")
    private String siglaAnaliseFinalidade;

    @Column(name = "descricao_analise_finalidade")
    private String descricaoAnaliseFinalidade;

    public AnaliseFinalidade() {
    }

    public AnaliseFinalidade(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnaliseFinalidade() {
        return analiseFinalidade;
    }

    public void setAnaliseFinalidade(String analiseFinalidade) {
        this.analiseFinalidade = analiseFinalidade;
    }

    public String getSiglaAnaliseFinalidade() {
        return siglaAnaliseFinalidade;
    }

    public void setSiglaAnaliseFinalidade(String siglaAnaliseFinalidade) {
        this.siglaAnaliseFinalidade = siglaAnaliseFinalidade;
    }

    public String getDescricaoAnaliseFinalidade() {
        return descricaoAnaliseFinalidade;
    }

    public void setDescricaoAnaliseFinalidade(String descricaoAnaliseFinalidade) {
        this.descricaoAnaliseFinalidade = descricaoAnaliseFinalidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final AnaliseFinalidade other = (AnaliseFinalidade) obj;
        return Objects.equals(this.id, other.id);
    }

}
