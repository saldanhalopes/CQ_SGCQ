package prati_sgcq.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import prati_sgcq.interfaces.EntidadeBase;

/**
 *
 * @author rafael.lopes
 */
@Entity
@Table(name = "tb_coluna")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Coluna implements EntidadeBase, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "codigo_sap_coluna")
    private String codigoSapColuna;

    @ManyToOne()
    @JoinColumn(name = "setor_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_setor_coluna"))
    private Setor setor;

    @ManyToOne()
    @JoinColumn(name = "metodologia_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_metodologia_coluna"))
    private Metodologia metodologia;

    @ManyToOne()
    @JoinColumn(name = "analise_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_analise_coluna"))
    private Analise analise;

    @ManyToOne()
    @JoinColumn(name = "analise_finalidade_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_analise_finalidade_coluna"))
    private AnaliseFinalidade analiseFinalidade;

    @Column(name = "cod_coluna")
    private Integer codColuna;

    @Column(name = "tipo_coluna")
    private String tipoColuna;

    @Column(name = "fabricante_coluna")
    private String fabricanteColuna;

    @Column(name = "marca_coluna")
    private String marcaColuna;

    @Column(name = "fase_coluna")
    private String faseColuna;

    @Column(name = "tamanho_coluna")
    private String tamanhoColuna;

    @Column(name = "diametro_coluna")
    private String diametroColuna;

    @Column(name = "particula_coluna")
    private String particulaColuna;

    @Column(name = "part_number_coluna")
    private String partNumberColuna;

    @Column(name = "serial_number_coluna")
    private String serialNumberColuna;

    @Column(name = "data_ativacao_coluna")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtivacaoColuna;

    @Column(name = "data_descarte_coluna")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDescarteColuna;

    @Column(name = "data_performance")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPerformance;

    @Column(name = "obs_coluna")
    private String obsColuna;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vaga_coluna_id")
    private VagaColuna vagaColuna;

    @Column(name = "metodo_versao")
    private Integer metodoVersao;

    @Column(name = "data_verificacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVerificacao;

    @Column(name = "obs_verificacao")
    private String obsVerificacao;

    @ManyToOne()
    @JoinColumn(name = "user_verificacao", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_user_verificacao_coluna"))
    private Usuario userVerificacao;

    @ManyToOne()
    @JoinColumn(name = "user_name_descarte", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_user_name_descarte_coluna"))
    private Usuario userNameDescarte;

    @ManyToOne()
    @JoinColumn(name = "user_name_performance", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_user_name_performance_coluna"))
    private Usuario userNamePerformance;

    @ManyToOne()
    @JoinColumn(name = "user_name_ativacao", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_user_name_ativacao_coluna"))
    private Usuario userNameAtivacao;

    public Coluna() {
    }

    public Coluna(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoSapColuna() {
        return codigoSapColuna;
    }

    public void setCodigoSapColuna(String codigoSapColuna) {
        this.codigoSapColuna = codigoSapColuna;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public Metodologia getMetodologia() {
        return metodologia;
    }

    public void setMetodologia(Metodologia metodologia) {
        this.metodologia = metodologia;
    }

    public Analise getAnalise() {
        return analise;
    }

    public void setAnalise(Analise analise) {
        this.analise = analise;
    }

    public AnaliseFinalidade getAnaliseFinalidade() {
        return analiseFinalidade;
    }

    public void setAnaliseFinalidade(AnaliseFinalidade analiseFinalidade) {
        this.analiseFinalidade = analiseFinalidade;
    }

    public Integer getCodColuna() {
        return codColuna;
    }

    public void setCodColuna(Integer codColuna) {
        this.codColuna = codColuna;
    }

    public String getTipoColuna() {
        return tipoColuna;
    }

    public void setTipoColuna(String tipoColuna) {
        this.tipoColuna = tipoColuna;
    }

    public String getFabricanteColuna() {
        return fabricanteColuna;
    }

    public void setFabricanteColuna(String fabricanteColuna) {
        this.fabricanteColuna = fabricanteColuna;
    }

    public String getMarcaColuna() {
        return marcaColuna;
    }

    public void setMarcaColuna(String marcaColuna) {
        this.marcaColuna = marcaColuna;
    }

    public String getFaseColuna() {
        return faseColuna;
    }

    public void setFaseColuna(String faseColuna) {
        this.faseColuna = faseColuna;
    }

    public String getTamanhoColuna() {
        return tamanhoColuna;
    }

    public void setTamanhoColuna(String tamanhoColuna) {
        this.tamanhoColuna = tamanhoColuna;
    }

    public String getDiametroColuna() {
        return diametroColuna;
    }

    public void setDiametroColuna(String diametroColuna) {
        this.diametroColuna = diametroColuna;
    }

    public String getParticulaColuna() {
        return particulaColuna;
    }

    public void setParticulaColuna(String particulaColuna) {
        this.particulaColuna = particulaColuna;
    }

    public String getPartNumberColuna() {
        return partNumberColuna;
    }

    public void setPartNumberColuna(String partNumberColuna) {
        this.partNumberColuna = partNumberColuna;
    }

    public String getSerialNumberColuna() {
        return serialNumberColuna;
    }

    public void setSerialNumberColuna(String serialNumberColuna) {
        this.serialNumberColuna = serialNumberColuna;
    }

    public Date getDataAtivacaoColuna() {
        return dataAtivacaoColuna;
    }

    public void setDataAtivacaoColuna(Date dataAtivacaoColuna) {
        this.dataAtivacaoColuna = dataAtivacaoColuna;
    }

    public Date getDataDescarteColuna() {
        return dataDescarteColuna;
    }

    public void setDataDescarteColuna(Date dataDescarteColuna) {
        this.dataDescarteColuna = dataDescarteColuna;
    }

    public Date getDataPerformance() {
        return dataPerformance;
    }

    public void setDataPerformance(Date dataPerformance) {
        this.dataPerformance = dataPerformance;
    }

    public String getObsColuna() {
        return obsColuna;
    }

    public void setObsColuna(String obsColuna) {
        this.obsColuna = obsColuna;
    }

    public VagaColuna getVagaColuna() {
        return vagaColuna;
    }

    public void setVagaColuna(VagaColuna vagaColuna) {
        this.vagaColuna = vagaColuna;
    }

    public Integer getMetodoVersao() {
        return metodoVersao;
    }

    public void setMetodoVersao(Integer metodoVersao) {
        this.metodoVersao = metodoVersao;
    }

    public Date getDataVerificacao() {
        return dataVerificacao;
    }

    public void setDataVerificacao(Date dataVerificacao) {
        this.dataVerificacao = dataVerificacao;
    }

    public String getObsVerificacao() {
        return obsVerificacao;
    }

    public void setObsVerificacao(String obsVerificacao) {
        this.obsVerificacao = obsVerificacao;
    }

    public Usuario getUserVerificacao() {
        return userVerificacao;
    }

    public void setUserVerificacao(Usuario userVerificacao) {
        this.userVerificacao = userVerificacao;
    }

    public Usuario getUserNameDescarte() {
        return userNameDescarte;
    }

    public void setUserNameDescarte(Usuario userNameDescarte) {
        this.userNameDescarte = userNameDescarte;
    }

    public Usuario getUserNamePerformance() {
        return userNamePerformance;
    }

    public void setUserNamePerformance(Usuario userNamePerformance) {
        this.userNamePerformance = userNamePerformance;
    }

    public Usuario getUserNameAtivacao() {
        return userNameAtivacao;
    }

    public void setUserNameAtivacao(Usuario userNameAtivacao) {
        this.userNameAtivacao = userNameAtivacao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Coluna other = (Coluna) obj;
        return Objects.equals(this.id, other.id);
    }

}
