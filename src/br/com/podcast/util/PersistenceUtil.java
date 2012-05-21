/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podcast.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author vpaz
 */
public class PersistenceUtil {

    private EntityManagerFactory emf;
    private static PersistenceUtil pu;

    public EntityManagerFactory obter() {

        if (emf == null) {

            emf = Persistence.createEntityManagerFactory("PodCastPU");

        }
        return emf;
    }

    public static PersistenceUtil getUtil() {

        if (pu == null) {
            pu = new PersistenceUtil();
        }
        return pu;

    }
}
