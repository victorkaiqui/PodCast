/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podcast.persistencia;

import br.com.podcast.reader.PodCast;
import br.com.podcast.util.PersistenceUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author vpaz
 */
public class PodCastDAO {

    public List<PodCast> selecionarPodCast() {

        EntityManager em = PersistenceUtil.getUtil().obter().createEntityManager();

        String sql = "SELECT pc FROM PodCast AS pc";

        Query q = em.createQuery(sql);

        return q.getResultList();
    }

    public void alterarPodCast(PodCast podcast) {

        EntityManager em = PersistenceUtil.getUtil().obter().createEntityManager();

        em.getTransaction().begin();
        em.merge(podcast);
        em.getTransaction().commit();

    }
}
