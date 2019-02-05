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
package prati_sgcq.dao;

import java.net.UnknownHostException;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.TransactionRequiredException;
import prati_sgcq.connection.ConnectionFactory;
import prati_sgcq.model.Usuario;

/**
 *
 * @author rafael
 */
public class UsuarioDAO extends GenenicoDAO<Usuario> {

    public Usuario buscaUsuarioLogin(Usuario user) throws Exception {
        EntityManager em = ConnectionFactory.em(true);
        try {
            return em.createNamedQuery("Usuario.findLogin", Usuario.class)
                    .setParameter("usuario", user.getUsuario())
                    .setParameter("pass", user.getPass())
                    .getSingleResult();
        } finally {
            em.close();
        }
    }

    public Usuario buscaUsuarioByName(Usuario user) throws EntityNotFoundException, NoResultException {
        EntityManager em = ConnectionFactory.em(true);
        try {
            return em.createNamedQuery("Usuario.findByUsuario", Usuario.class)
                    .setParameter("usuario", user.getUsuario())
                    .getSingleResult();
        } finally {
            em.close();
        }
    }

    public void salvarFalhaLogin(Usuario user, Boolean falha) throws TransactionRequiredException {
        EntityManager em = ConnectionFactory.em(true);
        try {
            em.getTransaction().begin();
            if (em.find(Usuario.class, user.getId()) == null) {
                throw new TransactionRequiredException("Erro ao Atualizar!");
            }
            String update = "UPDATE Usuario u SET u.failed_access_count = :failed_access_count WHERE u.id = :id";
            em.createQuery(update)
                    .setParameter("failed_access_count", falha
                                    ? (user.getFailed_access_count() == null ? 0
                                            : user.getFailed_access_count()) + 1 : 0)
                    .setParameter("id", user.getId())
                    .executeUpdate();
            em.getTransaction().commit();
        } catch (TransactionRequiredException ex) {
            em.getTransaction().rollback();
            throw new TransactionRequiredException("Erro ao Atualizar!");
        } finally {
            em.close();
        }
    }

    public void salvarBloqueioUsuario(Usuario user) throws TransactionRequiredException {
        EntityManager em = ConnectionFactory.em(true);
        try {
            em.getTransaction().begin();
            if (em.find(Usuario.class, user.getId()) == null) {
                throw new TransactionRequiredException("Erro ao Atualizar!");
            }
            String update = "UPDATE Usuario u SET u.lock = :lock WHERE u.id = :id";
            em.createQuery(update)
                    .setParameter("lock", true)
                    .setParameter("id", user.getId())
                    .executeUpdate();
            em.getTransaction().commit();
        } catch (TransactionRequiredException ex) {
            em.getTransaction().rollback();
            throw new TransactionRequiredException("Erro ao Atualizar!");
        } finally {
            em.close();
        }
    }

    public void atualizarLoginUsuario(Usuario user) throws TransactionRequiredException {
        EntityManager em = ConnectionFactory.em(true);
        try {
            String computador;
            try {
                computador = java.net.InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException ex1) {
                computador = null;
            }
            em.getTransaction().begin();
            if (em.find(Usuario.class, user.getId()) == null) {
                throw new TransactionRequiredException("Erro ao Atualizar!");
            }
            String update = "UPDATE Usuario u SET "
                    + "u.computador_nome = :computador_nome, "
                    + "u.computador_usuario = :computador_usuario, "
                    + "u.lastlogin = :lastlogin "
                    + "WHERE u.id = :id";
            em.createQuery(update)
                    .setParameter("computador_nome", computador)
                    .setParameter("computador_usuario", System.getProperty("user.name"))
                    .setParameter("lastlogin", new Date())
                    .setParameter("id", user.getId())
                    .executeUpdate();
            em.getTransaction().commit();
        } catch (TransactionRequiredException ex) {
            em.getTransaction().rollback();
            throw new TransactionRequiredException("Erro ao Atualizar!");
        } finally {
            em.close();
        }
    }

    public void atualizarLogoffUsuario(Usuario user) throws TransactionRequiredException {
        EntityManager em = ConnectionFactory.em(true);
        try {
            String computador;
            try {
                computador = java.net.InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException ex1) {
                computador = null;
            }
            em.getTransaction().begin();
            if (em.find(Usuario.class, user.getId()) == null) {
                throw new TransactionRequiredException("Erro ao Atualizar!");
            }
            String update = "UPDATE Usuario u SET "
                    + "u.computador_nome = :computador_nome, "
                    + "u.computador_usuario = :computador_usuario, "
                    + "u.lastlogout = :lastlogout "
                    + "WHERE u.id = :id";
            em.createQuery(update)
                    .setParameter("computador_nome", computador)
                    .setParameter("computador_usuario", System.getProperty("user.name"))
                    .setParameter("lastlogout", new Date())
                    .setParameter("id", user.getId())
                    .executeUpdate();
            em.getTransaction().commit();
        } catch (TransactionRequiredException ex) {
            em.getTransaction().rollback();
            throw new TransactionRequiredException("Erro ao Atualizar!");
        } finally {
            em.close();
        }
    }
    
    public void atualizarTrocaSenha(Usuario user) throws TransactionRequiredException {
        EntityManager em = ConnectionFactory.em(true);
        try {
            em.getTransaction().begin();
            if (em.find(Usuario.class, user.getId()) == null) {
                throw new TransactionRequiredException("Erro ao Atualizar!");
            }
            String update = "UPDATE Usuario u SET "
                    + "u.pass = :pass, "
                    + "u.change_pass = :change_pass "
                    + "WHERE u.id = :id";
            em.createQuery(update)
                    .setParameter("pass", user.getPass())
                    .setParameter("change_pass", false)
                    .setParameter("id", user.getId())
                    .executeUpdate();
            em.getTransaction().commit();
        } catch (TransactionRequiredException ex) {
            em.getTransaction().rollback();
            throw new TransactionRequiredException("Erro ao Atualizar!");
        } finally {
            em.close();
        }
    }

}
