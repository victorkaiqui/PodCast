/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podcast.util;

import br.com.podcast.reader.PodCast;
import java.util.Comparator;

/**
 *
 * @author vpaz
 */
public class PodCastComparator implements Comparator<PodCast> {

    @Override
    public int compare(PodCast t, PodCast t1) {
        return t1.getDataPublicacao().compareTo(t.getDataPublicacao());
    }
}
