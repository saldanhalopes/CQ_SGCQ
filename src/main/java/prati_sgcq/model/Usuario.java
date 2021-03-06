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

import prati_sgcq.interfaces.EntidadeBase;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import prati_sgcq.audit.AuditListener;

/**
 *
 * @author rafael
 */
@Entity
@Table(name = "tb_usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id"),
    @NamedQuery(name = "Usuario.findByUsuario", query = "SELECT u FROM Usuario u WHERE u.usuario = :usuario"),
    @NamedQuery(name = "Usuario.findByNome", query = "SELECT u FROM Usuario u WHERE u.nome = :nome"),
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email"),
    @NamedQuery(name = "Usuario.findLogin", query = "Select u FROM Usuario u WHERE u.usuario = :usuario AND u.pass = :pass")})
@DynamicInsert(true)
@DynamicUpdate(true)
@Audited(withModifiedFlag = true)
@AuditTable(value = "tb_usuario_auditoria")
@EntityListeners(AuditListener.class)
public class Usuario implements EntidadeBase, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "usuario", nullable = false, length = 250, unique = true)
    private String usuario;

    @Column(name = "nome", nullable = false, length = 250)
    private String nome;

    @Column(name = "pass", nullable = false, length = 250)
    private String pass;
    
    @Column(name = "change_pass", nullable = true )
    private Boolean change_pass;

    @Column(name = "lock", nullable = true, insertable = false)
    private Boolean lock;

    @Column(name = "email", nullable = false, length = 250)
    private String email;

    @Column(name = "cracha", nullable = true, length = 8)
    private String cracha;

    @Column(name = "computador_nome", nullable = true, length = 250)
    private String computador_nome;

    @Column(name = "computador_usuario", nullable = true, length = 250)
    private String computador_usuario;

    @Column(name = "failed_access_count", nullable = true, insertable = false)
    private Integer failed_access_count;

    @Column(name = "turno", nullable = false, length = 25)
    private String turno;

    @Column(name = "created", nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date created;

    @Column(name = "lastlogin", nullable = true, insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastlogin;

    @Column(name = "lastlogout", nullable = true, insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastlogout;

    @ManyToOne()
    @JoinColumn(name = "setor_id", referencedColumnName = "id", foreignKey = @ForeignKey(name="fk_setor_usuario"))
    private Setor setor;
    
    @ManyToOne()
    @JoinColumn(name = "grupo_id", referencedColumnName = "id", foreignKey = @ForeignKey(name="fk_grupo_usuario"))
    private Grupo grupo;


    public Usuario() {
    }
    
    public Usuario(Integer id) {
        this.id = id;
    }
    
    public Usuario(String nome, String pass) {
        this.nome = nome;
        this.pass = pass;
    }

    public Usuario(String usuario, String nome, String pass, String email, String cracha, 
            String turno, Date created, Setor setor, Grupo grupo) {
        this.usuario = usuario;
        this.nome = nome;
        this.pass = pass;
        this.email = email;
        this.cracha = cracha;
        this.turno = turno;
        this.created = created;
        this.setor = setor;
        this.grupo = grupo;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Boolean getChange_pass() {
        return change_pass;
    }

    public void setChange_pass(Boolean change_pass) {
        this.change_pass = change_pass;
    }

    public Boolean getLock() {
        return lock;
    }

    public void setLock(Boolean lock) {
        this.lock = lock;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCracha() {
        return cracha;
    }

    public void setCracha(String cracha) {
        this.cracha = cracha;
    }

    public String getComputador_nome() {
        return computador_nome;
    }

    public void setComputador_nome(String computador_nome) {
        this.computador_nome = computador_nome;
    }

    public String getComputador_usuario() {
        return computador_usuario;
    }

    public void setComputador_usuario(String computador_usuario) {
        this.computador_usuario = computador_usuario;
    }

    public Integer getFailed_access_count() {
        return failed_access_count;
    }

    public void setFailed_access_count(Integer failed_access_count) {
        this.failed_access_count = failed_access_count;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(Date lastlogin) {
        this.lastlogin = lastlogin;
    }

    public Date getLastlogout() {
        return lastlogout;
    }

    public void setLastlogout(Date lastlogout) {
        this.lastlogout = lastlogout;
    }
   
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", usuario=" + usuario + ", "
                + "nome=" + nome + ", pass=" + pass + ", change_pass=" + change_pass + ", "
                + "lock=" + lock + ", email=" + email + ", cracha=" + cracha + ", "
                + "computador_nome=" + computador_nome + ", computador_usuario=" + computador_usuario + ", "
                + "failed_access_count=" + failed_access_count + ", turno=" + turno + ", "
                + "created=" + created + ", lastlogin=" + lastlogin + ", lastlogout=" + lastlogout + ", "
                + "setor=" + setor.getId() + ", grupo=" + grupo.getId() + '}';
    }

    
}
