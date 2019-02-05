/*
 * Copyright (C) 2019 rafael.lopes
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
@Table(name = "tb_analise_produtividade")
public class AnaliseProdutividade implements EntidadeBase, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "analise_produtividade")
    private String analiseProdutividade;
    
    @Column(name = "sigla_analise_produtividade")
    private String siglaAnaliseProdutividade;
    
    @Column(name = "descricao_analise_produtividade")
    private String descricaoAnaliseProdutividade;
    
    @Column(name = "cor")
    private String cor;

    public AnaliseProdutividade() {
    }

    public AnaliseProdutividade(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnaliseProdutividade() {
        return analiseProdutividade;
    }

    public void setAnaliseProdutividade(String analiseProdutividade) {
        this.analiseProdutividade = analiseProdutividade;
    }

    public String getSiglaAnaliseProdutividade() {
        return siglaAnaliseProdutividade;
    }

    public void setSiglaAnaliseProdutividade(String siglaAnaliseProdutividade) {
        this.siglaAnaliseProdutividade = siglaAnaliseProdutividade;
    }

    public String getDescricaoAnaliseProdutividade() {
        return descricaoAnaliseProdutividade;
    }

    public void setDescricaoAnaliseProdutividade(String descricaoAnaliseProdutividade) {
        this.descricaoAnaliseProdutividade = descricaoAnaliseProdutividade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final AnaliseProdutividade other = (AnaliseProdutividade) obj;
        return Objects.equals(this.id, other.id);
    }
    
}
