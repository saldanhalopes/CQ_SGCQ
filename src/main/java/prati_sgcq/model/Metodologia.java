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
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import prati_sgcq.interfaces.EntidadeBase;

/**
 *
 * @author rafael.lopes
 */
@Entity
@Table(name = "tb_metodologia")
public class Metodologia implements EntidadeBase, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cod_metodo", nullable = false, unique = true, length = 25)
    private String codMetodo;

    @Column(name = "metodo", nullable = false, length = 250)
    private String metodo;

    @Column(name = "versao", nullable = false)
    private Integer versao;

    @Column(name = "categoria", nullable = false, length = 250)
    private String categoria;

    @Column(name = "link", length = 250)
    private String link;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tb_metodologia_material",
            joinColumns = @JoinColumn(name = "metodologia_id"),
            inverseJoinColumns = @JoinColumn(name = "material_id"))
    private Set<Material> material = new HashSet<>();

    public Metodologia() {
    }

    public Metodologia(Integer id) {
        this.id = id;
    }

    public Metodologia(String codMetodo, String metodo, Integer versao, String categoria, String link) {
        this.codMetodo = codMetodo;
        this.metodo = metodo;
        this.versao = versao;
        this.categoria = categoria;
        this.link = link;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getCodMetodo() {
        return codMetodo;
    }

    public void setCodMetodo(String codMetodo) {
        this.codMetodo = codMetodo;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public Integer getVersao() {
        return versao;
    }

    public void setVersao(Integer versao) {
        this.versao = versao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

//    public Set<Material> getMaterial() {
//        return material;
//    }
//
//    public void setMaterial(Set<Material> material) {
//        this.material = material;
//    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.id);
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
        final Metodologia other = (Metodologia) obj;
        return Objects.equals(this.id, other.id);
    }

}
