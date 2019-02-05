package prati_sgcq.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import prati_sgcq.audit.AuditListener;
import prati_sgcq.interfaces.EntidadeBase;

/**
 *
 * @author rafael.lopes
 */
@Entity
@Table(name = "tb_padroes_config")
@DynamicInsert(true)
@DynamicUpdate(true)
@Audited(withModifiedFlag = true)
@AuditTable(value = "tb_padroes_config_auditoria")
@EntityListeners(AuditListener.class)
public class PadroesConfig implements EntidadeBase, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "codigo_padrao")
    private Integer codigoPadrao;

    @Column(name = "nome_padrao")
    private String nomePadrao;

    @Column(name = "codigo_sap")
    private Integer codigoSap;

    @Column(name = "cas_number")
    private String casNumber;

    @Column(name = "forma_farmaceutica")
    private String formaFarmaceutica;

    @Column(name = "controle_especial")
    private Boolean controleEspecial;

    @Column(name = "lista_controle_especial")
    private String listaControleEspecial;

    @Column(name = "catalogo")
    private String catalogo;

    @Column(name = "obs")
    private String obs;

    @Version
    private Long version;

    public PadroesConfig() {
    }

    public PadroesConfig(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigoPadrao() {
        return codigoPadrao;
    }

    public void setCodigoPadrao(Integer codigoPadrao) {
        this.codigoPadrao = codigoPadrao;
    }

    public Integer getCodigoSap() {
        return codigoSap;
    }

    public void setCodigoSap(Integer codigoSap) {
        this.codigoSap = codigoSap;
    }

    public String getNomePadrao() {
        return nomePadrao;
    }

    public void setNomePadrao(String nomePadrao) {
        this.nomePadrao = nomePadrao;
    }

    public String getCasNumber() {
        return casNumber;
    }

    public void setCasNumber(String casNumber) {
        this.casNumber = casNumber;
    }

    public String getFormaFarmaceutica() {
        return formaFarmaceutica;
    }

    public void setFormaFarmaceutica(String formaFarmaceutica) {
        this.formaFarmaceutica = formaFarmaceutica;
    }

    public Boolean getControleEspecial() {
        return controleEspecial;
    }

    public void setControleEspecial(Boolean controleEspecial) {
        this.controleEspecial = controleEspecial;
    }

    public String getListaControleEspecial() {
        return listaControleEspecial;
    }

    public void setListaControleEspecial(String listaControleEspecial) {
        this.listaControleEspecial = listaControleEspecial;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(String catalogo) {
        this.catalogo = catalogo;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.id);
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
        final PadroesConfig other = (PadroesConfig) obj;
        return Objects.equals(this.id, other.id);
    }


}
