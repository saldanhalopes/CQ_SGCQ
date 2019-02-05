package prati_sgcq.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import prati_sgcq.interfaces.EntidadeBase;

/**
 *
 * @author rafael.lopes
 */
@Entity
@Table(name = "tb_vaga_coluna")
public class VagaColuna implements EntidadeBase, Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "vaga_coluna", nullable = false)
    private Integer vagaColuna;
    
    @Column(name = "gaveta_coluna")
    private String gavetaColuna;

    public VagaColuna() {
    }

    public VagaColuna(Integer vagaColunaId) {
        this.vagaColuna = vagaColunaId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVagaColunaId() {
        return vagaColuna;
    }

    public void setVagaColunaId(Integer vagaColunaId) {
        this.vagaColuna = vagaColunaId;
    }

    public String getGavetaColuna() {
        return gavetaColuna;
    }

    public void setGavetaColuna(String gavetaColuna) {
        this.gavetaColuna = gavetaColuna;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final VagaColuna other = (VagaColuna) obj;
        return Objects.equals(this.id, other.id);
    }

}
