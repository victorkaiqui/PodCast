/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podcast.persistencia;

import br.com.podcast.reader.PodCast;
import br.com.podcast.reader.PodCastChannel;
import br.com.podcast.util.PersistenceUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author vpaz
 */
public class PodCastChannelDAO {

    public void salvarPodCastChannel(PodCastChannel podCastChannel) throws Exception {

        EntityManager em = PersistenceUtil.getUtil().obter().createEntityManager();

        try {

            for (PodCast object : podCastChannel.getItens()) {

                object.setPodCastChannel(podCastChannel);
                object.getEnclosure().setPodCast(object);

            }

            em.getTransaction().begin();
            em.merge(podCastChannel);
            em.getTransaction().commit();


        } catch (Exception e) {
            throw new Exception();
        } finally {

            em.close();

        }
    }

    public List<PodCastChannel> selecionarPodCastChannel() {

        EntityManager em = PersistenceUtil.getUtil().obter().createEntityManager();

        String sql = "SELECT pcc FROM PodCastChannel AS pcc";

        Query q = em.createQuery(sql);

        return q.getResultList();
    }

    public boolean existePodCastChannelComUrl(String url) {

        EntityManager em = PersistenceUtil.getUtil().obter().createEntityManager();

        String sql = "SELECT pcc FROM PodCastChannel AS pcc WHERE pcc.url = :url";

        Query q = em.createQuery(sql);
        q.setParameter("url", url);

        if (q.getResultList() != null && !q.getResultList().isEmpty()) {
            return true;
        }
        return false;
    }

    public PodCastChannel buscaPodCastChannelComUrl(String url) {

        EntityManager em = PersistenceUtil.getUtil().obter().createEntityManager();

        String sql = "SELECT pcc FROM PodCastChannel AS pcc WHERE pcc.url = :url";

        Query q = em.createQuery(sql);
        q.setParameter("url", url);



        try {
            return (PodCastChannel) q.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }

    }
}
